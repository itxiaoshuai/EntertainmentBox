package com.ls.entertainmentbox.data

data class ApiPagerResponse<T>(
    var data: ArrayList<T>,
    var msg: String,
    var code: Int,
    var count: Int
)