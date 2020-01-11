
/* Includes ------------------------------------------------------------------*/
#include <stm32f10x.h>
#include <stdio.h>

#include "delay.h"
#include "led.h"


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
	
}


/**
*
*程序主入口
*
*/
int main(void){
	// 初始化设备
	init();
	
	while(1){
		openLed(LED_ALL);
		delaySec(8);
		closeLed(LED_ALL);
		delaySec(1);
		openLed(LED_S3);
		delaySec(3);
		closeLed(LED_S3);
	}
}
