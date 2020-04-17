/**************************************************************************
*FileName:        key.h
*CreateDate:      2020-01-11
*Author:          lele
*Description:     程序函数封装
*Update:            date            coder                   Content
*
***************************************************************************/


#ifndef __MAIN_H
#define __MAIN_H

#include <stm32f10x.h>

/**
 *
 * 从RC522读取物理卡号
 *
 */
int readPhyNumber(void);

// 管理员模式
void adminMode(void);

void normalMode(void);

void swipe(char * type);

#endif


