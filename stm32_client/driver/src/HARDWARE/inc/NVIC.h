/**************************************************************************
*FileName:        NVIC.h
*CreateDate:      2020-04-10
*Author:          lele
*Description:     NVIC中断分组配置和外部中断配置
*Includes:
					-NVIC中断分组配置
					-NVIC中断向量优先级配置
					-外部中断配置
*Update:            date            coder                   Content
*
***************************************************************************/
#ifndef __NVIC_H__
#define __NVIC_H__

#include <stm32f10x.h>

typedef enum{
	GPIO_A,
	GPIO_B,
	GPIO_C,
	GPIO_D,
	GPIO_E,
	GPIO_F,
	GPIO_G
}GPIO_x;

//NVIC中断分组初始化 !!注意！该函数只能执行一次！
void NVICGroupInit(u8 group);

//NVIC外设优先级设置
void NVICPriorityConfig( u8 preemptionPriority, u8 subPriority, u8 channel);

//GPIO外部中断引脚配置
//						端口		位		边沿
void ExNVICInit( u8 GPIOx, u8 Bitx, u8 TRIM);

#endif
