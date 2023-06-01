package com.ls.entertainmentbox.vm

import androidx.lifecycle.MutableLiveData
import com.ls.entertainmentbox.app.api.NetUrl
import com.ls.entertainmentbox.data.ApiPagerResponse
import com.ls.entertainmentbox.data.UserRepository
import com.ls.entertainmentbox.data.response.BaseListResponse
import com.ls.entertainmentbox.ui.entity.Video
import me.hgj.mvvmhelper.base.BaseViewModel
import me.hgj.mvvmhelper.ext.rxHttpRequest
import me.hgj.mvvmhelper.net.LoadingType

/**
 * @author 小帅
 * @date 2022/4/30.
 * description：
 */
class VideoViewModel : BaseViewModel() {

    private var pageIndex = 1

    var listData = MutableLiveData<BaseListResponse<Video>>()

    /**
     * 获取列表数据
     * @param isRefresh Boolean 是否是刷新
     * @param loadingXml Boolean 请求时是否需要展示界面加载中loading
     */
    fun getList(isRefresh: Boolean, loadingXml: Boolean = false) {
        if (isRefresh) {
            //是刷新 玩Android的这个接口pageIndex 是0 开始
            pageIndex = 0
        }
        rxHttpRequest {
            onRequest = {
                listData.value = UserRepository.getList(pageIndex).await()
                //请求成功 页码+1
                pageIndex++
            }
            loadingType = if (loadingXml) LoadingType.LOADING_XML else LoadingType.LOADING_NULL
            loadingMessage = "正在拉取网络中..."
            requestCode = NetUrl.HOME_LIST
            isRefreshRequest = isRefresh
        }
    }

}