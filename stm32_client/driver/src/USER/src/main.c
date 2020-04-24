
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
char phyNumber [1];
int mflag = 1;
int keepCount = 0;
int i = 1;
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
    // 串口2初始化为115200波特率，esp8266是115200
    Usart2Init(115200);
    //RC522模块所需外设的初始化配置
    RC522_Init ();     
    
    // 延时保证初始化结束
    delayMs(200);
    // 万一上次没退出透传，凉凉，以防万一
    closeTansparentMode();
    // 初始化ESP8266
    esp8266_init();
    // 连接服务器
    espConnectServer();
}




/**
 * 读到的数据存放在全局变量phyNumber中，已经转换为字符串存储
 *
 *
 * @return 返回值为1时，读取到数据。返回 0，没有读取到数据，返回-1 未找到卡
 */
int readPhyNumber ( void ){

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
            sprintf ( phyNumber, "%02X%02X%02X%02X", ucArray_ID[0], ucArray_ID[1], ucArray_ID[2], ucArray_ID[3] );
            return 1;            
        }
        return 0;
    }
    return -1;
}



/**
 *
 * 管理员模式
 *
 */
void adminMode(void){
    while(mflag){
        if(getKeyValue(0) == 3) break;
        openLed(LED_S1);
        delayMs(400);
        if(mflag == 1){
            closeLed(LED_ALL);
            sendStr("\r\n  ------------- 管理员模式 ----------------  \r\n");
            sendStr("\r\n  切换模式，请摁S3  \r\n\r\n");
            mflag ++;
        }
        swipe("register");
        closeLed(LED_S1);
        delayMs(400);
    }
}

/**
 *
 * 普通模式(刷卡待机模式)
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
            sendStr("\r\n  ------------- Swipe模式 ----------------  \r\n");
            sendStr("\r\n  切换模式，请摁S3  \r\n\r\n");
            mflag ++;
        }
        swipe("normal");
        closeLed(LED_S2);
        delayMs(400);
    }
}

/**
 *
 * 刷卡方法
 *
 */
void swipe(char * type){
    int response;
    int value = readPhyNumber();
    if(i == 1){
        sendStr("请放置卡片！\r\n");
        i ++;
    }
    if(value == 1){
        openLed(LED_S3);
        delayMs(200);
        sendStr("debug card : ");
        sendStr(phyNumber);
        sendStr("\r\n");

        // 发送get请求
        response = esp8266SendGet(type,phyNumber);
        if(response == 1) {
            sendStr("刷卡成功！\r\n");
            delayMs(100);
            i = 1;
        }else if(response == -1){
            sendStr("此卡未注册！\r\n");
            delayMs(100);
            i = 1;
        }else{
            sendStr("刷卡失败！\r\n");
            delayMs(100);
            i = 1;
        }
    }else if(value == 0){
        sendStr("debug 读卡错误！请重刷！ \r\n");
    }
    keepCount ++;
    // 每十秒左右 保持一次连接
    if(keepCount >= 10){
        keepConnected();
        keepCount = 0;
    }
    closeLed(LED_S3);
}
/**
*
*程序主入口
*
*/
int main(void){
    int key;
    // 初始化设备
    init();
    PcdReset ();
    //设置Rc522工作方式
	M500PcdConfigISOType ( 'A' );
    sendStr("正在启动....\r\n");
    delaySec(2);
    sendStr("\r\n\r\n\r\n");
    while (1){
        openLed(LED_ALL);
        key = getKeyValue(0);
        delayMs(200);
        if(mflag == 1){
            sendStr("\r\n  Welcome to the driving school management system !  \r\n");
            sendStr("\r\n------------- 请选择模式----------------  \r\n");
            sendStr("\r\n----   按键 1  --->  管理员模式     ----  \r\n");
            sendStr("\r\n----   按键 2  --->  Swipe 模式     ----  \r\n");
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
            sendStr("无效按键！\r\n");
        }
        closeLed(LED_ALL);
        delayMs(200);
    }
}


