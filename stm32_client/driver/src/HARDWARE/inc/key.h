/**************************************************************************
*FileName:        key.h
*CreateDate:      2020-01-11
*Author:          lele
*Description:     按键的宏定义和操作函数声明
*Update:            date            coder                   Content
*
***************************************************************************/


#ifndef __KEY_H
#define __KEY_H


#include <stm32f10x.h>

//定义按键键值
#define KEY_S1_PRESS  1
#define KEY_S2_PRESS  2
#define KEY_S3_PRESS  3


//采集按键数据
#define KEY_S1  GPIO_ReadInputDataBit(GPIOA,GPIO_Pin_0)
#define KEY_S2  GPIO_ReadInputDataBit(GPIOG,GPIO_Pin_4)			   
#define KEY_S3  GPIO_ReadInputDataBit(GPIOG,GPIO_Pin_5)


//按键的IO初始化
void keyInit(void);

//检测按下的按键
int getKeyValue(u8 mode);

#endif


