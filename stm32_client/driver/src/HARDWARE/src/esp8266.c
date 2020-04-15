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


/**
 * esp8266初始化
 *
 *
 */
void esp8266_init(void){

    int flag = 1;


    // 发送 AT  返回OK
    u8 esp_at[]="AT\r\n";
    // 设置为AP兼Station模式。
    u8 esp_cwmode[]="AT+CWMODE=1\r\n";//OK
    // 设置连接的wifi和密码 响应OK
    u8 esp_wifi[]="AT+CWJAP=\"home\",\"198@qq.com\"\r\n";
    // 查看是否获得IP 返回设备IP
    u8 esp_ip[]="AT+CIFSR\r\n";
    // 设置连接模式为单一连接
    u8 esp_mode[] = "AT+CIPMUX=0\r\n";
    // 建立远程TCP连接(连接服务器) 返回OK
    u8 esp_tcp[] = "AT+CIPSTART=\"TCP\",\"47.103.215.243\",9999\r\n";//CONNECT
    // 发送数据，多少个字节 返回SEND OK
    u8 esp_cipsend[]="AT+CIPSEND=32\r\n";
    u8 esp_test[]="sunny\r\n";
    //u8 esp_cipserver[]="AT+CIPSERVER=1,5000\r\n";
    // u8 esp_cipmux[]="AT+CIPMUX=1\r\n";
    // 重启指令，响应OK
    u8 esp_reset[]="AT+RST\r\n";


    clearCache();
    // 发送AT指令
	while(1){
        // 串口发送AT指令初始化ESP8266
        Uart2SendStr(esp_at);
        delaySec(1);
        if(strCompare("OK"))
            break;
        else
            sendStr("again send AT \r\n");
        delayMs(600);
    }

    sendStr("esp8266_init successful ! \r\n");
	clearCache();

    // 设置工作模式
    while(flag){
        Uart2SendStr(esp_cwmode);
        delaySec(1);
        if(strCompare("OK")){
            sendStr("change model successful.\r\n");
            break;
           while(1){
               clearCache();
               // 重启
               Uart2SendStr(esp_reset);
               // 重启完成，跳出循环
               delayUs(10);
               if(strCompare("")){
                   sendStr("restart ....\r\n");
                   flag = 0;
                   delaySec(2);
                   break;
               }else{
                   sendStr("restart again \r\n");
               }
               delaySec(2);
           }
        }else if(strCompare("no change")){
            sendStr("same mode .\r\n");
            break;
        }else{
            sendStr("change mode again. \r\n");
        }
        delayMs(600);
    }
    sendStr("setting mode finished. \r\n");
    clearCache();

    delaySec(3);

    // 连接WiFi
    while(1){
        Uart2SendStr(esp_wifi);
        delaySec(10);
        if(strCompare("OK")){
            sendBuffer(tbuf,RX_buffer);
            sendStr("\r\n");
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
    delayMs(40);
    sendStr("Connected IP Address :");

    sendBuffer(tbuf,RX_buffer);
    sendStr("\r\n");

    clearCache();


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

