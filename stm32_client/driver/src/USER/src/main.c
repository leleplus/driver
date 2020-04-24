
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
char phyNumber [1];
int mflag = 1;
int keepCount = 0;
int i = 1;
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
    // ����2��ʼ��Ϊ115200�����ʣ�esp8266��115200
    Usart2Init(115200);
    //RC522ģ����������ĳ�ʼ������
    RC522_Init ();     
    
    // ��ʱ��֤��ʼ������
    delayMs(200);
    // ��һ�ϴ�û�˳�͸�����������Է���һ
    closeTansparentMode();
    // ��ʼ��ESP8266
    esp8266_init();
    // ���ӷ�����
    espConnectServer();
}




/**
 * ���������ݴ����ȫ�ֱ���phyNumber�У��Ѿ�ת��Ϊ�ַ����洢
 *
 *
 * @return ����ֵΪ1ʱ����ȡ�����ݡ����� 0��û�ж�ȡ�����ݣ�����-1 δ�ҵ���
 */
int readPhyNumber ( void ){

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
            sprintf ( phyNumber, "%02X%02X%02X%02X", ucArray_ID[0], ucArray_ID[1], ucArray_ID[2], ucArray_ID[3] );
            return 1;            
        }
        return 0;
    }
    return -1;
}



/**
 *
 * ����Աģʽ
 *
 */
void adminMode(void){
    while(mflag){
        if(getKeyValue(0) == 3) break;
        openLed(LED_S1);
        delayMs(400);
        if(mflag == 1){
            closeLed(LED_ALL);
            sendStr("\r\n  ------------- ����Աģʽ ----------------  \r\n");
            sendStr("\r\n  �л�ģʽ������S3  \r\n\r\n");
            mflag ++;
        }
        swipe("register");
        closeLed(LED_S1);
        delayMs(400);
    }
}

/**
 *
 * ��ͨģʽ(ˢ������ģʽ)
 *
 */
void normalMode(void){
    while(mflag){
        if(getKeyValue(0) == 3) break;
        openLed(LED_S2);
        delayMs(400);
        if(mflag == 1){
            closeLed(LED_ALL);
            delayMs(200);
            sendStr("\r\n  ------------- Swipeģʽ ----------------  \r\n");
            sendStr("\r\n  �л�ģʽ������S3  \r\n\r\n");
            mflag ++;
        }
        swipe("normal");
        closeLed(LED_S2);
        delayMs(400);
    }
}

/**
 *
 * ˢ������
 *
 */
void swipe(char * type){
    int response;
    int value = readPhyNumber();
    if(i == 1){
        sendStr("����ÿ�Ƭ��\r\n");
        i ++;
    }
    if(value == 1){
        openLed(LED_S3);
        delayMs(200);
        sendStr("debug card : ");
        sendStr(phyNumber);
        sendStr("\r\n");

        // ����get����
        response = esp8266SendGet(type,phyNumber);
        if(response == 1) {
            sendStr("ˢ���ɹ���\r\n");
            delayMs(100);
            i = 1;
        }else if(response == -1){
            sendStr("�˿�δע�ᣡ\r\n");
            delayMs(100);
            i = 1;
        }else{
            sendStr("ˢ��ʧ�ܣ�\r\n");
            delayMs(100);
            i = 1;
        }
    }else if(value == 0){
        sendStr("debug ������������ˢ�� \r\n");
    }
    keepCount ++;
    // ÿʮ������ ����һ������
    if(keepCount >= 10){
        keepConnected();
        keepCount = 0;
    }
    closeLed(LED_S3);
}
/**
*
*���������
*
*/
int main(void){
    int key;
    // ��ʼ���豸
    init();
    PcdReset ();
    //����Rc522������ʽ
	M500PcdConfigISOType ( 'A' );
    sendStr("��������....\r\n");
    delaySec(2);
    sendStr("\r\n\r\n\r\n");
    while (1){
        openLed(LED_ALL);
        key = getKeyValue(0);
        delayMs(200);
        if(mflag == 1){
            sendStr("\r\n  Welcome to the driving school management system !  \r\n");
            sendStr("\r\n------------- ��ѡ��ģʽ----------------  \r\n");
            sendStr("\r\n----   ���� 1  --->  ����Աģʽ     ----  \r\n");
            sendStr("\r\n----   ���� 2  --->  Swipe ģʽ     ----  \r\n");
            sendStr("\r\n----------------------------------------  \r\n");
            mflag++;
        }
        if(key == 1){
            mflag = 1;
            i = 1;
            adminMode();
            mflag = 1;
        }else if(key == 2){
            mflag = 1;
            i = 1;
            normalMode();
            mflag = 1;
            break;
        }else if(key == 3){
            sendStr("��Ч������\r\n");
        }
        closeLed(LED_ALL);
        delayMs(200);
    }
}


