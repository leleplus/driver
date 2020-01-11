/**************************************************************************
*FileName:        led.h
*CreateDate:      2020-01-11
*Author:          lele
*Description:     Led灯的宏定义和操作函数声明
*Update:            date            coder                   Content
*
***************************************************************************/

#ifndef	__LED_H
#define __LED_H


#include <stm32f10x.h>

// 预定于值，开启不同灯
#define LED_S1 (1<<0)
#define LED_S2 (1<<1)
#define LED_S3 (1<<2)
#define LED_ALL 0x07

//初始化
void ledInit(void);

//打开LED灯
void openLed(u8 led);

// 关闭LED灯
void closeLed(u8 led);


#endif



