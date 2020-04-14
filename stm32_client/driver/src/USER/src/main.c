
/* Includes ------------------------------------------------------------------*/
#include <stm32f10x.h>
#include <stdio.h>
#include <string.h>

#include "delay.h"
#include "led.h"
#include "key.h"
#include "usart1.h"
#include "NVIC.h"


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
	NVICGroupInit(2);
	delayInit();	    //延时函数初始化	  
	ledInit();		  	//初始化与LED连接的硬件接口
	keyInit();
//	NVIC_PriorityGroupConfig(NVIC_PriorityGroup_2);
    
	Usart1Init(72,57600);
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
        
        sendStr("测试串口工作\r\n");
        delayMs(200);
        openLed(LED_S1);
        delaySec(1);
        closeLed(LED_S1);
        openLed(LED_S2);
        delaySec(1);
        closeLed(LED_S2);
        openLed(LED_S3);
        delaySec(1);
        closeLed(LED_S3);
    }
}
