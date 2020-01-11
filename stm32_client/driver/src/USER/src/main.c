
/* Includes ------------------------------------------------------------------*/
#include <stm32f10x.h>
#include <stdio.h>

#include "delay.h"
#include "led.h"
#include "key.h"


/**
*
* 设备初始化函数
*
*/

void init(void){
	// 延时函数初始化 
//	delayInit(72);
	// led设备初始化
//	ledInit();
	
	delayInit();	    	 //延时函数初始化	  
	ledInit();		  	//初始化与LED连接的硬件接口
	keyInit();
	
}


/**
*
*程序主入口
*
*/
int main(void){
	int key = 0;
	
	// 初始化设备
	init();
	
	
	while(1){
		
		closeLed(LED_ALL);
		key = getKeyValue(0);
		
		switch(key){
			case 1:
				openLed(LED_S1);
				break;
			case 2:
				openLed(LED_S2);
				break;
			case 3:
				openLed(LED_S3);
				break;
			default:break;
		}
		
		delayMs(600);
		
	}
}
