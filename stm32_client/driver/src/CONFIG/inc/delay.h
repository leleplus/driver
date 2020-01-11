/**************************************************************************
*FileName:        delay.h
*CreateDate:      2020-01-11
*Author:          lele
*Description:     借助内核的SysTick定时器实现延时函数
*Update:            date            coder                   Content
*
***************************************************************************/

#ifndef __DELAY_H
#define __DELAY_H 

#include <stm32f10x.h>

//延时函数初始化接口
void delayInit(void);

//按微妙进行延时
void delayUs(u32 us);

//按毫秒进行延时
void delayMs(u16 ms);

//按秒进行延时
void delaySec(double sec);


#endif


