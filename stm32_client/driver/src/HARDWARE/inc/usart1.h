/**************************************************************************
*FileName:        usart1.c
*CreateDate:      2020-01-20
*Author:          lele
*Description:     串口1 函数的实现,配置PA9 PA10配置及中断相应函数
*                 基于库版本  ：ST_v3.5						
*Update:            date            coder                   Content
*
***************************************************************************/


#ifndef __USART1_H__
#define __USART1_H__

#include <stm32f10x.h>

//串口初始化函数接口
// input: u8 sclk    ,  u32 baud
//        时钟频率      要设置的波特率

void Usart1Init(u8 sclk, u32 baud);

//发送一个字节的数据
void sendChar(u8 ch);

//发送一个字符串
void sendStr(char * str);

//发送一个数组
void sendBuffer(u16 len, u8 *buf);

////接受一个字节的数据
//u8 getChar(void);
//接收一串数据
u16 getBuffer( u16 len, u8 * buf);

//接受一个字符串
u16 getStr(char * buf);


//发送数据的函数接口
//   input:  
//         numType -数据类型，0表示整数，1表示小数
//         number-   发送的具体数据
void sendNumber( u8 numType, double number);


#endif
