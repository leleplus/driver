/**************************************************************************
*FileName:        delay.h
*CreateDate:      2020-01-11
*Author:          lele
*Description:     借助内核的SysTick定时器实现延时函数实现
*Update:            date            coder                   Content
*
***************************************************************************/


#include "delay.h"


static u8  fac_us=0;//us延时倍乘数
static u16 fac_ms=0;//ms延时倍乘数


// 初始化延时函数
void delayInit(void)
{
	//选择外部时钟  HCLK/8
  SysTick_CLKSourceConfig(SysTick_CLKSource_HCLK_Div8);	
	//为系统时钟的1/8
	fac_us= SystemCoreClock / 8000000;	

	//代表每个ms需要的systick时钟数 
	fac_ms= (u16)fac_us * 1000;

}

// 按照微妙延时
		    								   
void delay_Us(u32 us)
{		
	u32 temp = 0;
	//时间加载	  	
	SysTick->LOAD=us * fac_us;
	//清空计数器
	SysTick->VAL=0x00;
	//开始倒数
	SysTick -> CTRL |= SysTick_CTRL_ENABLE_Msk ;           
	
	do{
		temp=SysTick->CTRL;
	//等待时间到达 temp & 0x01 0x01表示是否使能 防止无意关闭时出现死循环
	}while(temp & 0x01 && !(temp & (1 << 16)));
	
	//关闭计数器
	SysTick->CTRL &= ~SysTick_CTRL_ENABLE_Msk;
	//清空计数器
	SysTick->VAL = 0X00;
}

/**
*
* 按照毫秒延时
* 
* 注意ms的范围,最大为 1864 ms
* SysTick -> LOAD为24位寄存器,所以,最大延时为:ms <= 0xffffff * 8 * 1000 / SYSCLK
* SYSCLK单位为Hz,ms单位为ms
* 对72M条件下,ms<=1864 
* 
*/
void delayMs(u16 ms)
{	 		  	  
	u32 temp = 0;	 
	//时间加载(SysTick -> LOAD为24bit)
	SysTick -> LOAD = (u32)ms * fac_ms;
	//清空计数器
	SysTick -> VAL = 0x00;
	//开始倒数  
	SysTick -> CTRL |= SysTick_CTRL_ENABLE_Msk;
	do{
		temp=SysTick->CTRL;
		//等待时间到达   
	}while(temp & 0x01 && !(temp & (1 << 16)));
	//关闭计数器
	SysTick -> CTRL &= ~SysTick_CTRL_ENABLE_Msk;       
	//清空计数器
	SysTick -> VAL = 0X00;
	
}


//按秒进行延时
void delaySec(double sec){
	u32 ms = (u32)sec * 1000;
	// 满足毫秒延迟的条件，按照毫秒延时，直到小于毫秒延时的最大值
  while(ms > 1800){
		delayMs(1795);
		ms -= 1800;
  }
  delayMs(ms);
}
