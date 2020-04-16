/**************************************************************************
*FileName:        usart2.h
*CreateDate:      2020-04-15
*Author:          lele
*Description:     串口2函数的实现
*                 ?????  :ST_v3.5						
*Update:            date            coder                   Content
*
***************************************************************************/


#ifndef __USART2_H__
#define __USART2_H__

#include <stm32f10x.h>
#include <stdio.h>


#define USART_REC_LEN  			1024  	//定义最大接收字节数 200
//#define EN_USART1_RX 			1		//使能（1）/禁止（0）串口1接收
//#define EN_USART2_RX 			1		//使能（1）/禁止（0）串口2接收

#define tbuf 200
	  	
extern u8  USART_RX_BUF[USART_REC_LEN]; //接收缓冲,最大USART_REC_LEN个字节.末字节为换行符 
extern u16 USART_RX_STA;         		//接收状态标记	

//如果想串口中断接收，请不要注释以下宏定义
void Usart2Init(u32 bound);


void Uart2SendStr(u8 *str);

#endif
