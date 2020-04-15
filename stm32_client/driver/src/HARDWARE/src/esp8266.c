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


    u8  esp_at[]="AT\r\n";
    u8  esp_cwmode[]="AT+CWMODE=3\r\n";
    u8  esp_cifsr[]="AT+CIFSR\r\n";
    u8  esp_cipsend[]="AT+CIPSEND=6\r\n";
    u8  esp_test[]="sunny\r\n";
    u8  esp_cipserver[]="AT+CIPSERVER=1,5000\r\n";
    u8  esp_cipmux[]="AT+CIPMUX=1\r\n";
    u8  esp_rst[]="AT+RST\r\n";





	while(1){
        // 串口发送AT指令初始化ESP8266
        Uart2SendStr(esp_at);
        delayUs(10);
        if(strCompare("OK"))
            break;
        else  sendStr("ERROR1 \r\n");
        delayMs(600);
    }

    sendStr("OK,mcu connection success with ESP8266! \r\n");
	clearCache();


    // 设置工作模式
    while(1){
        Uart2SendStr(esp_cwmode);
        delayUs(10);
        if(strCompare("OK") || strCompare("no change"))
            break;
        else  sendStr("ERROR2 \r\n");
        delayMs(600);
    }
    sendStr("OK,set mode as AP+Station with ESP8266! \r\n");
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

