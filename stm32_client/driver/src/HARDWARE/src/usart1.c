/**************************************************************************
*FileName:        usart1.c
*CreateDate:      2020-01-20
*Author:          lele
*Description:     串口1 函数的实现,配置PA9 PA10配置及中断相应函数
*                 基于库版本  ：ST_v3.5						
*Update:            date            coder                   Content
*
***************************************************************************/
#include <string.h>
#include "usart1.h"



// 声明接收数据的最大字节数
#define USART_REC_LEN 256

// 接收数组缓冲，最大为 USART_REC_LEN 末字节为换行符
volatile u8 U1_Rx_Buf[USART_REC_LEN] = {0};

// 接收状态的标记
volatile u8 U1_Rx_STA = 0;



//加入以下代码,支持printf函数,关闭半主机模式，而不需要选择use MicroLIB	  

#pragma import(__use_no_semihosting) 
//标准库需要的支持函数                 
struct __FILE 
{ 
	int handle; 

}; 

FILE __stdout;       
//定义_sys_exit()以避免使用半主机模式    
void _sys_exit(int x) 
{ 
	x = x; 
} 

//重定义标准输出fputc函数 
int fputc(int ch, FILE *f)
{      
	while(USART_GetFlagStatus(USART1,USART_FLAG_TC) == RESET);
	USART_SendData(USART1,(uint8_t)ch);
	return ch;
}



//如果使能了接收
//#if EN_USART1_RX

//串口1中断服务程序
//注意,读取USARTx->SR能避免莫名其妙的错误   	
//u8 USART_RX_BUF[USART_REC_LEN];//接收缓冲,最大USART_REC_LEN个字节.
//接收状态
//bit15，	接收完成标志
//bit14，	接收到0x0d
//bit13~0，	接收到的有效字节数目
//u16 USART_RX_STA=0;       //接收状态标记	  


//这里 定义了一个16位数据USART_RX_STA 来表示 采集的数据长度  数据状态等 相当于一个寄存器
//USART_RX_STA     15		    14	         13-0
//				 接收完成	接收到0x0d	  接收的数据长度  没接收加1 表示多了一个字节
//USART_RX_STA=0 则为接收数据做准备

//串口进入中断的前提是 数据的最后以回车为准  即  0x0d 0x0a  

//串口1中断响应程序		 其名字不能随便定义
void USART1_IRQHandler(void){
	//当串口接收到数据  RXNE将被置1 
	u8 Res;													
	if(USART_GetITStatus(USART1, USART_IT_RXNE) != RESET) { 
		//接收中断(接收到的数据必须是0x0d 0x0a结尾)
		
		//(USART1->DR);	//读取接收到的数据
		Res =USART_ReceiveData(USART1);
		
		//接收未完成
		if((U1_Rx_STA & 0x8000)==0){
			//接收到了0x0d
			if(U1_Rx_STA&0x4000){
				if(Res!=0x0a){
					//接收错误,重新开始
					U1_Rx_STA=0;
				}else{ 
					//接收完成了 			  //接收到回车的后字节  置位状态寄存器 
					U1_Rx_STA|=0x8000;	
				}
			}else {
				//还没收到0X0D
				if(Res==0x0d) U1_Rx_STA|=0x4000;					 //接收到回车的前一字节  置位状态寄存器
				else{
					U1_Rx_Buf[U1_Rx_STA&0X3FFF] = Res ;			//将接收的数据 存入数组中
					U1_Rx_STA ++ ;									//长度+1 为下一次做准备
					if(U1_Rx_STA > (USART_REC_LEN-1))
						U1_Rx_STA=0;//接收数据错误,重新开始接收	  
					}
			}
		}
	} 
} 




//初始化IO 串口1 
//bound:波特率
void usart1Init(u32 bound){
  //GPIO端口设置
	
	//IO口配置结构体
	GPIO_InitTypeDef GPIO_InitStructure;
	//串口配置结构体	
	USART_InitTypeDef USART_InitStructure;
	//中断配置结构体	
	NVIC_InitTypeDef NVIC_InitStructure;
	
	//使能USART1，GPIOA时钟
	RCC_APB2PeriphClockCmd(RCC_APB2Periph_USART1 | RCC_APB2Periph_GPIOA, ENABLE);
	//复位串口1  在开启外设前 最好都要复位一下外设	
 	USART_DeInit(USART1);
	 //USART1_TX   PA.9
	GPIO_InitStructure.GPIO_Pin = GPIO_Pin_9; //PA.9
  GPIO_InitStructure.GPIO_Speed = GPIO_Speed_50MHz;
	//复用推挽输出	 PA.9选择复用状态才能进入串口模式
  GPIO_InitStructure.GPIO_Mode = GPIO_Mode_AF_PP;	
	//初始化PA9
  GPIO_Init(GPIOA, &GPIO_InitStructure); 
   
    //USART1_RX	  PA.10
  GPIO_InitStructure.GPIO_Pin = GPIO_Pin_10;
  GPIO_InitStructure.GPIO_Mode = GPIO_Mode_IN_FLOATING;//浮空输入
  GPIO_Init(GPIOA, &GPIO_InitStructure);  //初始化PA10


  //USART 初始化设置

	USART_InitStructure.USART_BaudRate = bound;                //波特率设置 一般设置为9600;
	//字长为8位数据格式
	USART_InitStructure.USART_WordLength = USART_WordLength_8b;
	//一个停止位
	USART_InitStructure.USART_StopBits = USART_StopBits_1;
	//无奇偶校验位	
	USART_InitStructure.USART_Parity = USART_Parity_No;        
	//无硬件数据流控制
	USART_InitStructure.USART_HardwareFlowControl = USART_HardwareFlowControl_None;
	//收发模式   这里可以配置仅发 或仅收
	USART_InitStructure.USART_Mode = USART_Mode_Rx | USART_Mode_Tx;	   

  USART_Init(USART1, &USART_InitStructure); //初始化串口

#if EN_USART1_RX		  //如果使能了接收  
  //Usart1 NVIC 配置
  NVIC_InitStructure.NVIC_IRQChannel = USART1_IRQn;
	NVIC_InitStructure.NVIC_IRQChannelPreemptionPriority=3 ;//抢占优先级3
	NVIC_InitStructure.NVIC_IRQChannelSubPriority = 3;		//子优先级3
	NVIC_InitStructure.NVIC_IRQChannelCmd = ENABLE;			//IRQ通道使能
	//根据指定的参数初始化VIC寄存器
	NVIC_Init(&NVIC_InitStructure);	
   
  USART_ITConfig(USART1, USART_IT_RXNE, ENABLE);//开启中断	 接收到数据进入中断
	
#endif

		//使能串口 
    USART_Cmd(USART1, ENABLE);                    

}

//发送一个字符串
void sendStr(char * str){
	u16 len = strlen(str);
	USART_SendData(USART1, *str);
	
	printf("\r\n 字符串数据发送成功 \r\n");//插入换行
}

