
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
* �豸��ʼ������
*
*/

void init(void){
// ��ʱ������ʼ�� 
//	delayInit(72);
// led�豸��ʼ��
//	ledInit();
	NVICGroupInit(2);
	delayInit();	    //��ʱ������ʼ��	  
	ledInit();		  	//��ʼ����LED���ӵ�Ӳ���ӿ�
	keyInit();
//	NVIC_PriorityGroupConfig(NVIC_PriorityGroup_2);
    
	Usart1Init(72,57600);
}


/**
*
*���������
*
*/
int main(void){

	// ��ʼ���豸
	init();
    
	
	
	while(1){
        
        sendStr("���Դ��ڹ���\r\n");
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
