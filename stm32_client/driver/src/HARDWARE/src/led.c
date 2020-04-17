/**************************************************************************
*FileName:        led.h
*CreateDate:      2020-01-11
*Author:          lele
*Description:     Led灯的操作函数实现
*Update:            date            coder                   Content
*
***************************************************************************/


#include "led.h"

// 初始化LED
void ledInit(void){
 
	//定义GPIO结构体
	GPIO_InitTypeDef  GPIO_InitStructure;					 
 	
	//使能PA端口时钟
	RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOG, ENABLE);	
	//LED-->PG6 7 8端口配置
	GPIO_InitStructure.GPIO_Pin = GPIO_Pin_6|GPIO_Pin_7|GPIO_Pin_8;
	//推挽输出
	GPIO_InitStructure.GPIO_Mode = GPIO_Mode_Out_PP;
	//IO口速度为50MHz
	
	GPIO_InitStructure.GPIO_Speed = GPIO_Speed_50MHz;	
	//根据设定参数初始化PG6 7 8
	GPIO_Init(GPIOG, &GPIO_InitStructure);
	//设置PG 6 7 8 输出低，默认为关闭状态	
	GPIO_SetBits(GPIOG,GPIO_Pin_6|GPIO_Pin_7|GPIO_Pin_8);	 

}

//打开LED灯

// 要打开哪个灯
void openLed(u8 led){
	if(led & LED_S1)
		GPIO_ResetBits(GPIOG,GPIO_Pin_7);
	if(led & LED_S2)
		GPIO_ResetBits(GPIOG,GPIO_Pin_6);
	if(led & LED_S3)
		GPIO_ResetBits(GPIOG,GPIO_Pin_8);
	
}

// 关闭LED灯
// 要关闭哪个灯
void closeLed(u8 led){
	if(led & LED_S1)
		GPIO_SetBits(GPIOG,GPIO_Pin_7);
	if(led & LED_S2)
		GPIO_SetBits(GPIOG,GPIO_Pin_6);
	if(led & LED_S3)
		GPIO_SetBits(GPIOG,GPIO_Pin_8);
	
}
