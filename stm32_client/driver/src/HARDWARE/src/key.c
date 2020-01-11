/**************************************************************************
*FileName:        key.c
*CreateDate:      2020-01-11
*Author:          lele
*Description:     按键的初始化和实现
*Update:            date            coder                   Content
*
***************************************************************************/


#include "key.h"
#include "delay.h"


// 按键初始化
void keyInit(void)
{
	
	//结构体定义
	GPIO_InitTypeDef GPIO_InitStructure;
	//开启GPIOA GPIOD时钟
	RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOG | RCC_APB2Periph_GPIOA,ENABLE);	
	
	/*************** GPIOG设置  *******************/
	
	//IO设置
	GPIO_InitStructure.GPIO_Pin =GPIO_Pin_4|GPIO_Pin_5;
	//设置成上拉输入
	GPIO_InitStructure.GPIO_Mode = GPIO_Mode_IPU;
	//初始化
	GPIO_Init(GPIOG,&GPIO_InitStructure);	           


	/*************** GPIOA设置  *******************/
	
	// GPIOA0 初始化 WK_UP-->GPIOA.0	  下拉输入
	GPIO_InitStructure.GPIO_Pin = GPIO_Pin_0;
	
	//设置成输入，默认下拉
	GPIO_InitStructure.GPIO_Mode = GPIO_Mode_IPD;
	
	//初始化
	GPIO_Init(GPIOA, &GPIO_InitStructure);
}



/**
* 检测按键的值
* @param mode->0 表示不支持按键长按  mode->1 支持按键长按
* @return 按键值
* 
*/
int getKeyValue(u8 mode){
	// 按键谈起的标志，默认不支持长按
	static u8 flag = 1;
	
	// 判断是不是支持按键长按
	if(mode){
		flag = 1;
	}
	
	// 检测按键按下
	if(flag && (KEY_S1 || !KEY_S2 || !KEY_S3)){
		// 延时10ms消抖
		delayMs(10);
		flag = 0;
		
		// 返回按键值
		if(KEY_S1){
			return KEY_S1_PRESS;
		}else if(!KEY_S2){
			return KEY_S2_PRESS;
		}else if(!KEY_S3){
			return KEY_S3_PRESS;
		}

	}else if(!KEY_S1 && KEY_S2 && KEY_S3){
		flag = 1;
	}

	return 0;
}








