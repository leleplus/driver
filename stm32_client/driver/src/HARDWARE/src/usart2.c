/**************************************************************************
*FileName:        Usart2.c
*CreateDate:      2020-04-15
*Aythor:          lele
*Description:     实现串口2的初始化和数据收发函数接口
*Update:    date      coder       Content
*
***************************************************************************/

#include "usart2.h"
#include "NVIC.h"
#include "delay.h"
#include <string.h>


u8  RX_buffer[tbuf];

u8 RX_num=0;   //接收计数变量

void Usart2Init(u32 bound){

	//GPIO端口设置
	////IO口配置结构体
    GPIO_InitTypeDef GPIO_InitStructure;
    //串口配置结构体
    USART_InitTypeDef USART_InitStructure;
    //中断配置结构体
    NVIC_InitTypeDef NVIC_InitStructure;

    RCC_APB2PeriphClockCmd(RCC_APB2Periph_GPIOA, ENABLE);//使能GPIOA,G时钟
	RCC_APB1PeriphClockCmd(RCC_APB1Periph_USART2,ENABLE);//使能USART2时钟
 	//USART_DeInit(USART2);          //复位串口2  在开启外设前 最好都要复位一下外设
	 //USART1_TX   PA.2
 	GPIO_InitStructure.GPIO_Pin = GPIO_Pin_2;	//PA2
    GPIO_InitStructure.GPIO_Mode = GPIO_Mode_AF_PP;	//复用推挽
	GPIO_InitStructure.GPIO_Speed = GPIO_Speed_50MHz;
    GPIO_Init(GPIOA, &GPIO_InitStructure);

    RCC_APB1PeriphResetCmd(RCC_APB1Periph_USART2,ENABLE);//复位串口2
	RCC_APB1PeriphResetCmd(RCC_APB1Periph_USART2,DISABLE);//停止复位

	//USART 初始化设置

	USART_InitStructure.USART_BaudRate = bound;                //波特率设置 一般设置为9600;
	USART_InitStructure.USART_WordLength = USART_WordLength_8b;//字长为8位数据格式
	USART_InitStructure.USART_StopBits = USART_StopBits_1;     //一个停止位
	USART_InitStructure.USART_Parity = USART_Parity_No;        //无奇偶校验位
	USART_InitStructure.USART_HardwareFlowControl = USART_HardwareFlowControl_None;//无硬件数据流控制
	USART_InitStructure.USART_Mode = USART_Mode_Rx | USART_Mode_Tx;	   //收发模式   这里可以配置仅发 或仅收

	USART_Init(USART2, &USART_InitStructure); //初始化串口

	//#if EN_USART2_RX		  //如果使能了接收
   //Usart1 NVIC 配置
    NVIC_InitStructure.NVIC_IRQChannel = USART2_IRQn;
	NVIC_InitStructure.NVIC_IRQChannelPreemptionPriority=3 ;//抢占优先级3
	NVIC_InitStructure.NVIC_IRQChannelSubPriority = 3;		//子优先级3
	NVIC_InitStructure.NVIC_IRQChannelCmd = ENABLE;			//IRQ通道使能
	NVIC_Init(&NVIC_InitStructure);	//根据指定的参数初始化VIC寄存器

//    NVICPriorityConfig(3,3,USART2_IRQn);

    USART_ITConfig(USART2, USART_IT_RXNE, ENABLE);//开启中断	 接收到数据进入中断
//#endif

	USART_Cmd(USART2, ENABLE);                    //使能串口
}


/**
 * 串口2发送字符串
 * @param str [description]
 */
void Uart2SendStr(u8 *str){
	//检测字符串结束标志
	while (*str){
		while(USART_GetFlagStatus(USART2, USART_FLAG_TC) == RESET);
		USART_SendData(USART2,*str++);
    }
}

void USART2_IRQHandler(void){

 	//接收到数据
 	if(USART_GetITStatus(USART2, USART_IT_RXNE) != RESET){

		RX_buffer[RX_num] = USART_ReceiveData(USART2); 	//读取接收到的数据
		RX_num ++;
		if(RX_num > tbuf) RX_num = 0;
	}
}

