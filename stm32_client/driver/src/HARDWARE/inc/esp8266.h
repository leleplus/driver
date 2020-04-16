/**************************************************************************
*FileName:        esp8266.h
*CreateDate:      2020-04-15
*Author:          lele
*Description:
*Update:            date            coder                   Content
*
***************************************************************************/

#ifndef __ESP8266_H__
#define __ESP8266_H__

#include <stm32f10x.h>
#include <stdio.h>
#include "usart2.h"
#include "usart1.h"


/**
 * esp8266初始化连接
 * 
 */
void esp8266_init(void);

/**
* esp8266 连接服务器
 */
void espConnectServer(void);

/**
 * esp8266发送get
 */
void esp8266SendGet(void);


/**
 * 字符串比较
 * @param  p 字符串指针
 * @return   [description]
 */
u8 strCompare(u8 *p);


/**
 *  清理缓存
 *  清理计数
 */
void clearCache(void);


void uart2_send_char(u8 temp);

char tostr(u16 len, u8 *buf);

#endif

