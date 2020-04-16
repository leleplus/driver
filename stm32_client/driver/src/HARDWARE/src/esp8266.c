/**************************************************************************
*FileName:        esp8266.h
*CreateDate:      2020-04-15
*Author:          lele
*Description:     ESP8266配置连接发送AT指令集实现
*Update:            date            coder                   Content
*
***************************************************************************/

#include "esp8266.h"
#include "usart2.h"
#include "delay.h"
#include <string.h>
#include "usart1.h"


extern  u8 RX_buffer[tbuf];
// 接收计数变量
extern 	u8 RX_num;

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

/**
 * esp8266初始化
 *
 *
 */
void esp8266_init(void){
    int flag = 1;

    clearCache();
    // 发送AT指令
	while(1){
        // 串口发送AT指令初始化ESP8266
        clearCache();
        Uart2SendStr(esp_at);
        delaySec(2);
        sendStr("\r\n ESP8266 AT :");
        sendBuffer(tbuf,RX_buffer);
        sendStr("\r\n");
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
    sendStr(" ESP8266 connect WIFI -> \r\n");
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
    delaySec(3);
    sendStr("\r\n Transparent mode begin... \r\n ");
    sendBuffer(tbuf,RX_buffer);
    clearCache();
}
/**
* esp8266 退出透传模式
 */
void closeTansparentMode(void){
    clearCache();
    Uart2SendStr("+++");
    delaySec(3);
    sendStr("\r\n Transparent mode end... \r\n ");
    sendBuffer(tbuf,RX_buffer);
    clearCache();
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
    sendStr("\r\n\r\n");
    Uart2SendStr(esp_reset);
    sendBuffer(tbuf,RX_buffer);
    delaySec(10);
    sendStr("\r\n\r\n");
    sendStr("\r\n----------------------------------------------------\r\n");
    sendStr("\r\n\r\n\r\n");
    sendStr("\r\n--------------------    restart ESP8266 finished!      -----------------\r\n");
    clearCache();
}

// 发送get请求
void esp8266SendGet(void){
    int i ;
    // get请求内容
//    u8 get[]="GET http://47.103.215.243:9999/captchaImage HTTP/1.0\r\n";
    //u8 get[]="GET /captchaImage HTTP/1.1\r\nHost:47.103.215.243\r\n\r\n";
    u8 get[]="GET /captchaImage HTTP/1.1\r\nHost:192.168.31.198\r\n\r\n";
    // 发送内容
//    u8 esp_content_size[sizeof(get)];

//    sprintf(esp_content_size,"AT+CIPSEND=%02X\r\n",sizeof(get));
    
    clearCache();
    
    openTansparentMode();
    
    clearCache();
    // 将要发送的字节数
    Uart2SendStr("AT+CIPSEND\r\n");
    delayMs(200);
    sendStr("\r\n send size -----> \r\n ");
    sendBuffer(tbuf,RX_buffer);
    
    clearCache();
    // 发送内容
    Uart2SendStr(get);
    sendBuffer(tbuf,RX_buffer);
    delaySec(2);
    sendStr("\r\n send get -----> \r\n ");
    sendBuffer(tbuf,RX_buffer);
    
    
    closeTansparentMode();
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

