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
#include <stdbool.h>
#include "usart2.h"
#include "usart1.h"


/**
 * esp8266AT指令开启
 * 
 */
void esp8266AT(void);

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
* esp8266 设置单链接模式
 */
void setSingleLinkMode(void);

/**
* esp8266 设置透传模式
 */
void openTansparentMode(void);

/**
* esp8266 退出透传模式
 */
void closeTansparentMode(void);

/**
* esp8266 关闭TCP/UDP连接
 */
void closeIPConnection(void);

/**
 * esp8266发送get
 */
int esp8266SendGet(char * type,char * cardId);

/**
 * 重启ESP8266
 */
void reStartEsp8266(void);

/**
 *
 * 请求完成的回调函数
 */
int esp8266CallBack(void);

/**
 * 字符串比较
 * @param  p 字符串指针
 * @return   [description]
 */
u8 strCompare(u8 *p);

/**
 *  防止连接掉线，需要保持连接
 *  
 */
void keepConnected(void);

/**
 *  清理缓存
 *  清理计数
 */
void clearCache(void);

#endif

