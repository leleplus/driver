import request from '@/utils/request';


// 查询用户详细
export function getAllDriverLicense() {
    return request({
        url: '/driverLicense',
        method: 'get'
    })
}
