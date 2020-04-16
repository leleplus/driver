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
//    u8 esp_mode[] = "AT+CIPMUX=0\r\n";
// 查看连接状态和连接参数
//    u8 esp_status[] ="AT+CIPSTATUS\r\n";
// 建立远程TCP连接(连接服务器) 返回OK
u8 esp_tcp[] = "AT+CIPSTART=\"TCP\",\"47.103.215.243\",9999\r\n";//CONNECT
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
        Uart2SendStr(esp_at);
        delaySec(1);
        if(strCompare("OK"))
            break;
        else
            sendStr("Send AT  again ... \r\n");
        delayMs(600);
    }

    sendStr("Esp8266 init successful ! \r\n");
	clearCache();

    // 设置工作模式
    while(flag){
        Uart2SendStr(esp_cwmode);
        delaySec(1);
        if(strCompare("OK")){
            sendStr("change model successful.\r\n");
            while(1){
               clearCache();
               // 重启
               Uart2SendStr(esp_reset);
               // 重启完成，跳出循环
               delayUs(30);
               if(strCompare("")){
                   sendStr("ESP8266 restart ing ....\r\n");
                   flag = 0;
                   delaySec(5);
                   break;
               }else{
                   sendStr("restart again \r\n");
               }
               delaySec(2);
           }
        }else if(strCompare("no change")){
            break;
        }else{
            sendStr("change mode again. \r\n");
        }
        delayMs(600);
    }
    sendStr("setting mode finished. \r\n");
    clearCache();

    delaySec(1);

    // 连接WiFi
    sendStr(" ESP8266 connect WIFI -> \r\n");
    while(1){
        Uart2SendStr(esp_wifi);
        delaySec(15);
        if(strCompare("OK")){
            break;
        }else{
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
    sendStr("<--------\r\n");

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

/**
 * ESP8266连接服务器函数
 *
 */
void espConnectServer(void){
    sendStr("\r\n\r\n -------- Connect To Server ---------- \r\n\r\n");
    clearCache();
    while(1){
        Uart2SendStr(esp_tcp);
        delaySec(10);
        if(strCompare("OK")){
            break;
        }else{
            sendStr("\r\n Connected Server fail !  again ... \r\n");
            delaySec(1);
        }
    }
    
    clearCache();
    sendStr("\r\n\r\n -------- Connected Server Ready !!---------- \r\n\r\n");
}


void esp8266SendGet(void){

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

