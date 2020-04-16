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
#include <stdio.h>
#include <string.h>
#include "NVIC.h"
#include "delay.h"

//声明接收DMA数据的数组
#define RX_MAX_LEN 1024
volatile u8 U1RxBuffer[RX_MAX_LEN] = {0};

//接收标记量
volatile u8 U1RxFlag = 0;

//复用Fputc函数，使工程支持printf输出
//关闭半主机模式

#pragma import( __use_no_semihosting)

struct __FILE{
    int out;
};

FILE __stdout;
//FILE __stdin;

void _sys_exit( int x){ x = x;}

//重定向标准输出函数fputc
int fputc( int ch ,FILE *f)
{
    DMA1_Channel4->CCR &= ~(1<<0);
    DMA1_Channel4->CNDTR = 1;
    DMA1_Channel4->CMAR = (u32)&ch;
    DMA1_Channel4->CCR |= 1<<0;
//    //通过串口发送一字节数据
//    while(!(USART1->SR & (1 << 7)));
//    USART1->DR = ch;
    return ch;
}

//int fgetc(FILE *f)
//{
//    while(!(USART1->SR & (1 << 5)));
//    return USART1 -> DR;
//}

//串口1的中断服务程序
void USART1_IRQHandler(void)
{
    u8 temp;
    if(USART1->SR & (1<<4))
    {
        temp = USART1->DR;
        U1RxFlag = temp;
        U1RxFlag = 1;
    }
}

//串口初始化函数接口
// input: u8 sclk    ,  u32 baud
//        时钟频率      要设置的波特率

void Usart1Init(u8 sclk, u32 baud)
{
    //1.计算分频因子USARTDIV
    double div = (sclk * 1000000.0) / (16.0 * baud);
    u16 mant = (u16)div;
    u16 frac = (u16)(div - mant) * 16;
    
    //要设置BRR寄存器的值
    mant = mant << 4 | frac;
    
    
    //2.硬件初始化配置部分
    //时钟位    USART 14    GPIOA  2
    RCC->APB2ENR |= 1 << 14 | 1 << 2;
    //开启DMA1时钟
    RCC->AHBENR |= 1<<0;
  
    //配置PA9为推挽复用输出   PA10为上拉输入
    GPIOA->CRH &= 0xFFFFF00F;
    GPIOA->CRH |= 0x000008BD;
    GPIOA->ODR |= 1<<10;
    
    
    //配置波特率寄存器
    USART1->BRR = mant;
    //打开串口 使能接受 使能发送 开启串口空闲中断
    USART1->CR1 = 1<<13 | 1<<3 | 1<<2 | 1 << 4;
    //使能USART1的DNA发送和接收
    USART1->CR3 = 1 << 7 | 1 << 6;
    
    //USART1_Tx -> DMA1_Channel4
    // mem->per 8bit  中等优先级
    DMA1_Channel4->CCR = 0;
    DMA1_Channel4->CCR |= 1<<12 | 1 << 7 |1 << 4;
    DMA1_Channel4->CPAR =(u32)&USART1->DR;
    DMA1_Channel4->CMAR = 0;
    DMA1_Channel4->CNDTR = 0;
          
    //USART!_Rx -> DMA1_Channel5
    DMA1_Channel5->CCR = 0;
    DMA1_Channel5->CNDTR =RX_MAX_LEN;
    DMA1_Channel5->CPAR = (u32)&USART1->DR;
    DMA1_Channel5->CMAR = (u32)U1RxBuffer;
    DMA1_Channel5->CCR |= 1<<13 | 1<<7 | 1<<0;
    
    
    //抢占优先级 2  响应优先级 2
    NVICPriorityConfig(2,2,USART1_IRQn);
    
}

//发送一个字节的数据
void sendChar(u8 ch)
{
    DMA1_Channel4->CCR &= ~(1<<0);
    DMA1_Channel4->CNDTR = 1;
    DMA1_Channel4->CMAR = (u32)&ch;
    DMA1_Channel4->CCR |= 1<<0;
//    //1.等待前一个数据发送完成
//    while( !(USART1->SR & (1 << 7)));
//    
//    //2.将要发送的数据存到DR中
//    USART1->DR = ch;

}

//发送一个字符串
void sendStr(char * str){
    u16 len = strlen(str);
    DMA1_Channel4->CCR &= ~(1<<0);
    DMA1_Channel4->CNDTR = len;
    DMA1_Channel4->CMAR = (u32)str;
    DMA1_Channel4->CCR |= 1<<0;
    delayMs(10);
//    while(*str != '\0')
//    {
//        sendChar(*str);
//        str++;
//    }
}

//发送一个数组
void sendBuffer(u16 len, u8 *buf)
{
    
    DMA1_Channel4->CCR &= ~(1<<0);
    DMA1_Channel4->CNDTR = len;
    DMA1_Channel4->CMAR = (u32)buf;
    DMA1_Channel4->CCR |= 1<<0;
    delayMs(10);
//    u16 i;
//    for(i = 0; i < len; i++)
//    {
//        sendChar(*buf);
//        buf++;
//    }
}

////接收一个字节的数据
//u8 getChar(void)
//{
//    //1.等待接收数据寄存器中有数据
//    while(!(USART1->SR & (1<<5)));
//    //2.将RDR的数据返回
//    return USART1->DR;
//}

//接收一串数据
u16 getBuffer( u16 len, u8 * buf)
{
    u16 i, getLen = 0;
    if(U1RxFlag == 0)
        return 0;
    U1RxFlag = 0;
    DMA1_Channel5->CCR &= ~(1<<0);
    getLen = RX_MAX_LEN -DMA1_Channel5->CNDTR;
    
    for( i = 0; i < (getLen > len?len:getLen); i++)
    {
        buf[i] = U1RxBuffer[i];
          
    }
    DMA1_Channel5->CMAR = (u32)U1RxBuffer;
    DMA1_Channel5->CNDTR = RX_MAX_LEN;
    DMA1_Channel5->CCR |= 1<<0;
    return i;
    

}


//接收一个字符串
u16 getStr(char * buf)
{
    u16 i, getLen = 0;
    if( U1RxFlag == 0)
        return 0;
    U1RxFlag = 0;
    
    DMA1_Channel5->CCR &= ~(1<<0);
    getLen = RX_MAX_LEN - DMA1_Channel5 ->CNDTR;
    for( i= 0; i< getLen; i++ )
    {
        buf[i] = U1RxBuffer[i];
        if( buf[i] == '\0' || buf[i] =='\n' || buf[i] =='\r')
        {
            buf[i] = 0;
            break;
        }
    }
    DMA1_Channel5->CMAR = (u32)U1RxBuffer;
    DMA1_Channel5->CNDTR = RX_MAX_LEN;
    DMA1_Channel5->CCR |= 1<<0;
    return i;
//    u8 ch;
//    u16 len = 0;
//    do
//    {
//        ch = getChar();
//        *buf =ch;
//        buf++;
//        len++;
//    }while(ch != '\0');
//    return len;
}

//发送数据的函数接口
//   input:  
//         numType -数据类型，0表示整数，1表示小数
//         number-   发送的具体数据
void sendNumber( u8 numType, double number){
    u8 len, i;
    u8 buf[16];
    u32 temp;
    if( numType == 0)      //发送整数
    {
        temp = (u32) number;        //将浮点数强转为整数
        for( len = 0; temp > 0; len++)
            temp = temp /10;         //计算数据位数
        temp = (u32) number;
        if( temp == 0)
        {
            buf[0]='0';
            len = 1;
        }
        else
        {
            for( i = 0; i < len; i++)       //将数据存入数组
            {
                buf[len-i-1] = temp % 10 + '0';
                temp = temp /10;
            }
        }
        
        sendBuffer( len, buf);          //发送数据
    }
    else if( numType == 1)      //发送小数
    {
        temp = (u32) (number * 1000);        //将浮点数强转为整数
        for( len = 0; temp > 0; len++)
            temp = temp /10;         //计算数据位数
        temp = (u32) (number * 1000);
        if( len < 4)
        {
            buf[0] = '0';
            len++;
        }
        for( i = 0; i <= len; i++)       //将数据存入数组
        {
            if( i == 3)
                buf[len-i] = '.';
            else
            {
                buf[len-i] = temp % 10 + '0';
                temp = temp / 10;
            }
        }
        sendBuffer( len+1, buf);          //发送数据
    
    }

}
