
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





// 读取到的结果，转为字符串
char phyNumber [ 30 ];




/**
*
* 设备初始化函数
*
*/

void init(void){
	NVICGroupInit(2);
    //延时函数初始化
	delayInit();	    	
    //初始化与LED连接的硬件接口
	ledInit();
    // 按键初始化
	keyInit();

    // 串口1初始化
	Usart1Init(72,115200);
    Usart2Init(115200);
    //RC522模块所需外设的初始化配置
    RC522_Init ();     
    
    // 延时保证初始化结束
    delayMs(200);
}




/**
 * 读到的数据存放在全局变量phyNumber中，已经转换为字符串存储
 *
 *
 * @return 返回值为1时，读取到数据。
 */
u8 readPhyNumber ( void ){

    //先后存放IC卡的类型和UID(IC卡序列号)
    u8 ucArray_ID [ 4 ];    
    //返回状态    
    u8 ucStatusReturn;                                                                                               

    //寻卡(未找到卡，再次寻卡)
    if ((ucStatusReturn = PcdRequest (PICC_REQALL, ucArray_ID)) != MI_OK){
            ucStatusReturn = PcdRequest ( PICC_REQALL, ucArray_ID );		                                                 //若失败再次寻卡
    }
    // 寻找到卡
    if (ucStatusReturn == MI_OK){
        //防冲撞（当有多张卡进入读写器操作范围时，防冲突机制会从其中选择一张进行操作）
        if (PcdAnticoll(ucArray_ID) == MI_OK){
            // 将读到的卡号数组格式化转为字符串result
            sprintf ( phyNumber, "%02X%02X%02X%02X", ucArray_ID [0], ucArray_ID [1], ucArray_ID [2], ucArray_ID [3] );
            return 1;            
        }
    }
    return 0;
}





/**
*
*程序主入口
*
*/
int main(void){
    int key = -1; 
    init();

    sendStr("test ....\r\n");
    PcdReset ();
    //设置Rc522工作方式
	M500PcdConfigISOType ( 'A' );
    

    
 
    while (1){
        key  = getKeyValue(0);
//        if(readPhyNumber() == 1){
//           openLed(LED_S2);
//            sendStr("读取到卡号 ");
//            sendStr(phyNumber);
//            sendStr("\r\n");
//           closeLed(LED_S2);
//        }
        
        if(key == 1){
            openLed(LED_S1);
        }else if(key == 3){
            closeLed(LED_ALL);
        }else if(key == 2){
            sendStr("按键2\r\n");
            openLed(LED_S2);
            esp8266_init();

        }
        
    }
}


