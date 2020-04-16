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
//    u8 esp_status[] ="AT+CIPSTATUS\r\n";
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
        delaySec(1);
        if(strCompare("OK")){
            sendStr("change model successful.\r\n");
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
    sendStr("setting mode finished. \r\n");
    clearCache();

    delaySec(1);

    flag =0;
    // 连接WiFi
    sendStr(" ESP8266 connect WIFI begin \r\n");
    while(1){
        clearCache();
        Uart2SendStr(esp_wifi);
        delaySec(15);
        sendBuffer(tbuf,RX_buffer);
        if(strCompare("OK")){
            break;
        }else{
            ++ flag;
            // 5次未连接成功，重启ESP8266,再次尝试连接
            if(flag >= 5){
                reStartEsp8266();
                //flag = 0;
                break;
            }
            sendStr("connect WIFI again .\r\n");
        }
        delayMs(600);
    }

    sendStr("connect wifi successful. \r\n");
    clearCache();

    // 查看已经连接的IP地址
    Uart2SendStr(esp_ip);
    delayMs(400);
    sendStr("\r\n Connected info -----> \r\n ");
    sendBuffer(tbuf,RX_buffer);
    sendStr("\r\n");

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
    sendStr("\r\n set signle mode -----> \r\n ");
    sendBuffer(tbuf,RX_buffer);
    sendStr("\r\n");
    clearCache();
}

/**
 * ESP8266连接服务器函数
 *
 */
void espConnectServer(void){
    int i =0;
    setSingleLinkMode();
    sendStr("\r\n\r\n -------- Connect To Server ---------- \r\n\r\n");
    clearCache();
    while(1){
        
        Uart2SendStr(esp_tcp);
        delaySec(10);
        if(strCompare("OK")){
            break;
        }else{
            i ++;
            sendStr("\r\n Connected Server fail !  again ... \r\n");
            // 失败次数过多，跳出，证明已经连接
            if(i >= 3) break;
        }
        delaySec(1);
    }
    
    clearCache();
    sendStr("\r\n\r\n -------- Connected Server Ready !!---------- \r\n\r\n");
}

// 开启透传模式
void openTansparentMode(void){
    clearCache();
    Uart2SendStr("AT+CIPMODE=1\r\n");
    delayMs(50);
    sendStr("\r\n Transparent mode begin... \r\n ");
    clearCache();
}
/**
 * esp8266 退出透传模式
 * 调用该方法前，flag 质1
 */
void closeTansparentMode(void){
    // 三次未退出透传模式，结束方法，没救了
    if(flag > 3) {
        flag++;
        return;
    }
    clearCache();
    Uart2SendStr("+++");
    delayMs(40);
    sendStr("\r\n Transparent mode end... \r\n ");
    clearCache();
    esp8266AT();
    delayMs(20);
    if(strCompare("OK")){
        return;
    }
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

void reStartEsp8266(void){
    clearCache();
    sendStr("\r\nrun restart ...\r\n");
    sendStr("\r\n----------------------------------------------------\r\n");
    sendStr("\r\n");
    Uart2SendStr(esp_reset);
    delaySec(5);
    sendStr("\r\n");
    sendStr("\r\n--------------------    restart ESP8266 finished!      -----------------\r\n");
    clearCache();
}

// 发送get请求
u8 esp8266SendGet(char * cardId){
    u8 get[100];
    flag = 1;
    // 实例请求http://127.0.0.1:8080/rfid/swipe/1/1
    // get请求内容 
//    u8 get[]="GET http://47.103.215.243:9999/rfid/swipe// HTTP/1.0\r\n";
    //u8 get[]="GET /captchaImage HTTP/1.1\r\nHost:47.103.215.243\r\n\r\n";
    
    sprintf(get,"GET /rfid/swipe/%s/%s HTTP/1.1\r\nHost:192.168.31.198\r\n\r\n","register",cardId);
    // 发送内容
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
        return 0;
    }
    sendStr("\r\n trans begin \r\n ");
    
    clearCache();
    // 发送请求去刷卡
    // 刷卡逻辑，刷一次，如果失败，请求三次，三次失败，请重刷
    while(1){
        Uart2SendStr(get);
        delayMs(600);
        //sendBuffer(tbuf,RX_buffer);
        if(strCompare("\"code\":200")){
            closeTansparentMode();
            return 1;
        }else{
            flag ++;
            if(flag >= 3){
                closeTansparentMode();
                return 0;
            }
            delayMs(99);
        }
    }
    
//    flag = 1;
//    closeTansparentMode();
    //closeIPConnection();
}


/**
 * 字符串比较
 * @param  p 要比较的字符串的指针
 * @return 1 相同字符串 0 不同字符串
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

