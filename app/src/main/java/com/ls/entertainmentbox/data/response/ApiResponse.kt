package com.ls.entertainmentbox.data.response

/**
 * All Rights Reserved , Designed By xs Company
 * @version
 * @description:
 * @author: 罗帅
 * @create: 2023-05-27
 */
data class ApiResponse<T>(
    var data: T,
    var code: Int = -1,
    var msg: String = ""
)
