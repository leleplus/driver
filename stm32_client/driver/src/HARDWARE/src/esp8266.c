/**************************************************************************
*FileName:        esp8266.h
*CreateDate:      2020-04-15
*Author:          lele
*Description:     ESP8266配置连接发送AT指令集实现
*Update:            date            coder                   Content
*
***************************************************************************/

#include <stdio.h>
//#include <stdbool.h>
#include <stdlib.h>
#include "esp8266.h"
#include "usart2.h"
#include "delay.h"
#include <string.h>
#include "usart1.h"


extern  u8 RX_buffer[tbuf];
// 接收计数变量
extern 	u8 RX_num;

// 循环标志
int flag = 1;

// 回调停止标志
long call = 0;

/*******************************************    ESP8266AT指令集   ***********************************************/
// 发送 AT  返回OK
u8 esp_at[]="AT\r\n";
// 设置为AP兼Station模式 返回 OK
u8 esp_cwmode[]="AT+CWMODE=1\r\n";
// 设置连接wifi的 [SSID] 和 [PASSWORD] 返回 OK
u8 esp_wifi[]="AT+CWJAP=\"home\",\"198@qq.com\"\r\n";
// 查看是否获得IP 返回设备IP等信息
u8 esp_ip[]="AT+CIFSR\r\n";
// 设置连接模式为单一连接
u8 esp_mode[] = "AT+CIPMUX=0\r\n";
// 查看连接状态和连接参数
u8 esp_status[] ="AT+CIPSTATUS\r\n";
// 建立远程TCP连接(连接服务器) 返回OK
//u8 esp_tcp[] = "AT+CIPSTART=\"TCP\",\"47.103.215.243\",9999\r\n";//CONNECT
u8 esp_tcp[] = "AT+CIPSTART=\"TCP\",\"192.168.31.198\",8080\r\n";
// 发送数据，多少个字节 返回SEND OK
//    u8 esp_cipsend[]="AT+CIPSEND=32\r\n";
//    u8 esp_test[]="sunny\r\n";
//u8 esp_cipserver[]="AT+CIPSERVER=1,5000\r\n";
// u8 esp_cipmux[]="AT+CIPMUX=1\r\n";
// 重启指令，响应OK
u8 esp_reset[]="AT+RST\r\n";
// 服务器超时时间
u8 esp_timeOut[]="AT+CIPSTO=3\r\n";

/**
 * esp8266AT指令开启
 * 
 */
void esp8266AT(void){
    // 串口发送AT指令初始化ESP8266
    clearCache();
    Uart2SendStr(esp_at);
    delayMs(100);
}

/**
 * esp8266初始化
 *
 *
 */
void esp8266_init(void){
    clearCache();
    // 发送AT指令
	while(1){
        esp8266AT();
        if(strCompare("OK"))
            break;
        else{
            flag ++;
            if(flag >= 3) break;
            clearCache();
            sendStr("Send AT  again ... \r\n");
        }
        delaySec(2);
    }

    sendStr("ESP8266 init successful ! \r\n");
	clearCache();

    flag = 0;
    // 设置工作模式
    while(1){
        Uart2SendStr(esp_cwmode);
        delayMs(50);
        if(strCompare("OK")){
            // 修改了工作模式，理论上重启ESP8266才能生效
            sendStr("Change model successful.\r\n");
            reStartEsp8266();
            break;
        }else if(strCompare("no change")){
            break;
        }else{
            flag ++;
            
            if(flag >= 3){
                // 三次修改失败
                break;
            }
            sendStr("change mode again. \r\n");
        }
        delayMs(600);
    }
    sendStr("Setting mode finished. \r\n");
    clearCache();

    delaySec(1);

    flag = 0;
    // 连接WiFi(15秒连接一次WiFi)
    sendStr("\r\nESP8266 connect WIFI begin \r\n");
    while(1){
        clearCache();
        Uart2SendStr(esp_wifi);
        delaySec(15);
        sendBuffer(tbuf,RX_buffer);
        if(strCompare("OK") || strCompare("CONNECTED")){
            delayMs(5);
            break;
        }else{
            ++ flag;
            // 5次未连接成功，重启ESP8266,再次尝试连接
            if(flag >= 5){
                reStartEsp8266();
                //flag = 0;
                break;
            }
            sendStr("Connect WIFI again .\r\n");
        }
        delayMs(600);
    }

    sendStr("Connect wifi successful. \r\n");
    clearCache();

    // 查看已经连接的IP地址
    Uart2SendStr(esp_ip);
    delayMs(400);
    sendStr("\r\n Internet Connected info  \r\n ");
    sendStr("-----------------------------------\r\n");
    sendBuffer(tbuf,RX_buffer);
    sendStr("-----------------------------------\r\n");

    clearCache();

    // 查看连接状态
//    Uart2SendStr(esp_status);
//    delayMs(4000);
//    sendStr("Connected STATUS : ");
//    sendBuffer(tbuf,RX_buffer);
//    sendStr("\r\n");
//    clearCache();

    sendStr("\r\n\r\n ----------------------------------- \r\n");
    sendStr("  ESP8266 Ready !! \r\n");
    sendStr(" ----------------------------------- \r\n\r\n");
}

// 设置单连接模式
void setSingleLinkMode(void){
    clearCache();
    Uart2SendStr(esp_mode);
    delayMs(400);
    clearCache();
    sendStr("\r\n Set signle mode \r\n ");
    sendBuffer(tbuf,RX_buffer);
    sendStr("\r\n");
    clearCache();
}

/**
 * ESP8266连接服务器函数
 *
 */
void espConnectServer(void){
    int i = 0;
    clearCache();
    setSingleLinkMode();
    sendStr("\r\n\r\n -------- Begin Connect To Server ---------- \r\n\r\n");
    
    do{
        clearCache();
        Uart2SendStr(esp_tcp);
        delaySec(2);
        sendBuffer(tbuf,RX_buffer);
        if(strCompare("ALREAY CONNECT") || strCompare("OK")){
            break;
        }else if(strCompare("ERROR")){
            delayMs(200);
            espConnectServer();
            return;
        }else {
            i ++;
            clearCache();
            sendStr("\r\n Connected Server fail !  again ... \r\n");
            // 失败次数过多，跳出，证明已经连接
            if(i >= 3) break;
        }
        delayMs(600);
    }while(1);
    clearCache();
    sendStr("\r\n\r\n -------- Connected Server Ready !! ---------- \r\n\r\n");
}

// 开启透传模式
void openTansparentMode(void){
    clearCache();
    Uart2SendStr("AT+CIPMODE=1\r\n");
    delayMs(50);
    sendStr("\r\n Open Transparent mode ! \r\n ");
    clearCache();
}
/**
 * esp8266 退出透传模式
 * 调用该方法前，flag 质1
 */
void closeTansparentMode(void){
    // 三次未退出透传模式，结束方法，没救了
    if(flag > 3) {
        return;
    }
    clearCache();
    Uart2SendStr("+++");
    delayMs(40);
    sendStr("\r\n Close Transparent mode ! \r\n ");
    clearCache();
    esp8266AT();
    delayMs(20);
    if(strCompare("OK")){
        return;
    }else
        flag++;
    // 递归再来一次
    closeTansparentMode();
}

/**
* esp8266 关闭TCP/UDP连接
 */
void closeIPConnection(void){
    clearCache();
    Uart2SendStr("AT+CIPCLOSE\r\n");
    delaySec(3);
    sendStr("\r\n close TCP & UDP connect .. \r\n ");
    sendBuffer(tbuf,RX_buffer);
    clearCache();
}


/**
 * 重启ESP8266
 */
void reStartEsp8266(void){
    clearCache();
    sendStr("\r\n--------------------    Run ESP8266 restart ----------------- \r\n");
    Uart2SendStr(esp_reset);
    delaySec(5);
    sendStr("\r\n--------------------    restart ESP8266 finished!   ----------------- \r\n");
    clearCache();
}

/**
 * ESP8266发送get请求
 * @param  cardId 卡号，拼接在URL后的参数
 * @return 1 刷卡成功 0 刷卡失败 （预计还有其它返回值）
 */
u8 esp8266SendGet(char * cardId){
    u8 get[100];
    int response;
    
    // 实例请求http://127.0.0.1:8080/rfid/swipe/1/1
    
    // 封装get请求http协议格式（此格式为最小格式）
    //sprintf(get,"GET /rfid/swipe/%s/%s HTTP/1.1\r\nHost:47.103.215.243\r\n\r\n","register",cardId);
    sprintf(get,"GET /rfid/swipe/%s/%s HTTP/1.1\r\nHost:192.168.31.198\r\n\r\n","register",cardId);
    // 发送内容大小
//    u8 esp_content_size[sizeof(get)];

//    sprintf(esp_content_size,"AT+CIPSEND=%02X\r\n",sizeof(get));
    
    clearCache();
    
    openTansparentMode();
    delayMs(20);
    clearCache();
    // 将要发送的字节数
    Uart2SendStr("AT+CIPSEND\r\n");
    delayMs(20);
    if(strCompare("ERROR")){
        // 出现ERROR，服务器掉线
        espConnectServer();
        return 0;
    }
    
    // 发送请求去刷卡
    clearCache();
    // 发请求
    Uart2SendStr(get);
    delayMs(800);
    // 交给回调处理结果
    call = 0;
    response = esp8266CallBack();
    flag = 1;
    closeTansparentMode();
    clearCache();
    return response;
}

/**
 *
 * 请求完成的回调函数
 */
int esp8266CallBack(void){
    
    if(strCompare("es: 0")){
        // 请求回来了
        sendBuffer(tbuf,RX_buffer);
        if(strCompare("\"code\":200")){
            // 请求成功，正正意义的请求成功
            return 1;
        }else{
            // 请求确实回来了，但是不是200 同时刷卡失败,业务失败
            return 0;
        }
    }
    // 请求未回来
    // 等了10S 请求还回不来 娃，没刷成功
    if(call >= (50 * 10)) {
        return -1;
    }
    // 延时20ms 再看回来没有
    delayMs(20);
    call ++;
    esp8266CallBack();
    
}
/**
 *  防止连接掉线，需要保持连接
 *  
 */
void keepConnected(void){
    clearCache();
    Uart2SendStr(esp_status);
    delayMs(20);
    // 失去连接
    if(strCompare("STATUS:4")){
        espConnectServer();
        keepConnected();
    }
}


/**
 * 字符串比较(ESP8266发送指令后接收到的内容与参数字符串作比较，看包含关系)
 * @param  p 要比较的字符串的指针
 * @return 1 包含此字符串 0 不包含此字符串
 */
u8 strCompare(u8 *p){
	if(strstr(RX_buffer,p) != NULL)
	    return 1;
	else
		return 0;
}

/**
 * 清理缓存计数
 */
void clearCache(void){
	memset(RX_buffer, 0, tbuf);
    RX_num = 0;
}

