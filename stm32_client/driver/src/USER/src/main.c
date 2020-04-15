
/* Includes ------------------------------------------------------------------*/
#include <stm32f10x.h>
#include <stdio.h>
#include <string.h>

#include "delay.h"
#include "led.h"
#include "key.h"
#include "usart1.h"
#include "NVIC.h"
#include "main.h"
#include "rc522_config.h"
#include "rc522_function.h"
#include <stdbool.h>
#include "usart2.h"
#include "esp8266.h"





// ��ȡ���Ľ����תΪ�ַ���
char phyNumber [ 30 ];




/**
*
* �豸��ʼ������
*
*/

void init(void){
	NVICGroupInit(2);
    //��ʱ������ʼ��
	delayInit();	    	
    //��ʼ����LED���ӵ�Ӳ���ӿ�
	ledInit();
    // ������ʼ��
	keyInit();

    // ����1��ʼ��
	Usart1Init(72,115200);
    Usart2Init(115200);
    //RC522ģ����������ĳ�ʼ������
    RC522_Init ();     
    
    // ��ʱ��֤��ʼ������
    delayMs(200);
}




/**
 * ���������ݴ����ȫ�ֱ���phyNumber�У��Ѿ�ת��Ϊ�ַ����洢
 *
 *
 * @return ����ֵΪ1ʱ����ȡ�����ݡ�
 */
u8 readPhyNumber ( void ){

    //�Ⱥ���IC�������ͺ�UID(IC�����к�)
    u8 ucArray_ID [ 4 ];    
    //����״̬    
    u8 ucStatusReturn;                                                                                               

    //Ѱ��(δ�ҵ������ٴ�Ѱ��)
    if ((ucStatusReturn = PcdRequest (PICC_REQALL, ucArray_ID)) != MI_OK){
            ucStatusReturn = PcdRequest ( PICC_REQALL, ucArray_ID );		                                                 //��ʧ���ٴ�Ѱ��
    }
    // Ѱ�ҵ���
    if (ucStatusReturn == MI_OK){
        //����ײ�����ж��ſ������д��������Χʱ������ͻ���ƻ������ѡ��һ�Ž��в�����
        if (PcdAnticoll(ucArray_ID) == MI_OK){
            // �������Ŀ��������ʽ��תΪ�ַ���result
            sprintf ( phyNumber, "%02X%02X%02X%02X", ucArray_ID [0], ucArray_ID [1], ucArray_ID [2], ucArray_ID [3] );
            return 1;            
        }
    }
    return 0;
}





/**
*
*���������
*
*/
int main(void){
    int key = -1; 
    init();

    sendStr("test ....\r\n");
    PcdReset ();
    //����Rc522������ʽ
	M500PcdConfigISOType ( 'A' );
    

    
 
    while (1){
        key  = getKeyValue(0);
//        if(readPhyNumber() == 1){
//           openLed(LED_S2);
//            sendStr("��ȡ������ ");
//            sendStr(phyNumber);
//            sendStr("\r\n");
//           closeLed(LED_S2);
//        }
        
        if(key == 1){
            openLed(LED_S1);
        }else if(key == 3){
            closeLed(LED_ALL);
        }else if(key == 2){
            sendStr("����2\r\n");
            openLed(LED_S2);
            esp8266_init();

        }
        
    }
}


