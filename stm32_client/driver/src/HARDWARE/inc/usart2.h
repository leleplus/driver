/**************************************************************************
*FileName:        usart2.h
*CreateDate:      2020-04-15
*Author:          lele
*Description:     ����2������ʵ��
*                 ?????  :ST_v3.5						
*Update:            date            coder                   Content
*
***************************************************************************/


#ifndef __USART2_H__
#define __USART2_H__

#include <stm32f10x.h>
#include <stdio.h>


#define USART_REC_LEN  			1024  	//�����������ֽ��� 200
//#define EN_USART1_RX 			1		//ʹ�ܣ�1��/��ֹ��0������1����
//#define EN_USART2_RX 			1		//ʹ�ܣ�1��/��ֹ��0������2����

#define tbuf 200
	  	
extern u8  USART_RX_BUF[USART_REC_LEN]; //���ջ���,���USART_REC_LEN���ֽ�.ĩ�ֽ�Ϊ���з� 
extern u16 USART_RX_STA;         		//����״̬���	

//����봮���жϽ��գ��벻Ҫע�����º궨��
void Usart2Init(u32 bound);


void Uart2SendStr(u8 *str);

#endif
