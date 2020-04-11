import request from '@/utils/request';


// 查询用户详细
export function getUserInfo(userInfoId) {
    return request({
        url: '/userInfo/' + userInfoId,
        method: 'get'
    })
}
