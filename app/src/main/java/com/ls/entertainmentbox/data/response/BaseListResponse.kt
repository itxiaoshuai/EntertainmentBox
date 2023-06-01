package com.ls.entertainmentbox.data.response

import me.hgj.mvvmhelper.entity.BasePage


data class BaseListResponse<T>(
    var data: ArrayList<T>,
    var pageNum: Int,
    var pageSize: Int,
    var totalPage: Int,
    var count: Int,
    ) : BasePage<T>() {
    override fun getPageData() = data
    override fun isRefresh() = pageNum == 1
    override fun isEmpty() = false
    override fun hasMore() = totalPage > pageNum
}




