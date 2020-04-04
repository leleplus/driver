import request from '@/utils/request'
import { praseStrEmpty } from "@/utils/ruoyi";


// 绑定RFID卡
export function userBindRFID(id) {
    return request({
        url: '/system/rfid/bindRFID' + praseStrEmpty(id),
        method: 'get',
    })
}
