import request from '@/utils/request'
import { praseStrEmpty } from "@/utils/ruoyi";


// 绑定RFID卡
export function userBindRFID(id) {
    return request({
        url: '/system/rfid/bindRFID' + praseStrEmpty(id),
        method: 'get',
    })
}

// 查询所有的RFID卡片
export function listRFID(query) {
    return request({
        url: '/rfid/list',
        method: 'get',
        params: query
    })
}


// 查询所有的刷卡记录
export function listSwipeRecord(query) {
    return request({
        url: '/swipeRFIDRecord',
        method: 'post',
        params: query
    })
}
