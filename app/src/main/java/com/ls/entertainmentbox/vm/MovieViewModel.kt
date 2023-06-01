package com.ls.entertainmentbox.vm

import androidx.lifecycle.MutableLiveData
import com.ls.entertainmentbox.app.api.NetUrl
import com.ls.entertainmentbox.data.UserRepository
import me.hgj.mvvmhelper.base.BaseViewModel
import me.hgj.mvvmhelper.ext.rxHttpRequest
import me.hgj.mvvmhelper.net.LoadingType

/**
 * All Rights Reserved , Designed By xs Company
 * @version
 * @description:
 * @author: 罗帅
 * @create: 2023-06-01
 */
class MovieViewModel : BaseViewModel() {
    var movie = MutableLiveData<Any>()
    fun getMovieDetail(videoId: String,loadingXml: Boolean = false) {
        rxHttpRequest {
            onRequest = {
//                listData.value = UserRepository.getMovie(videoId).await()
//                //请求成功 页码+1
//                pageIndex++
            }
            loadingType = if (loadingXml) LoadingType.LOADING_XML else LoadingType.LOADING_NULL
            loadingMessage = "正在拉取网络中..."
            requestCode = NetUrl.HOME_LIST
        }
    }
}