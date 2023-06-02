package com.ls.entertainmentbox.vm

import androidx.lifecycle.MutableLiveData
import com.ls.entertainmentbox.app.api.NetUrl
import com.ls.entertainmentbox.data.UserRepository
import com.ls.entertainmentbox.data.response.ApiResponse
import com.ls.entertainmentbox.ui.entity.Movie
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
    var movie = MutableLiveData<ApiResponse<Movie>>()
    fun getMovieDetail(videoId: String,loadingXml: Boolean = false) {
        rxHttpRequest {
            onRequest = {
                movie.value = UserRepository.getMovie(videoId).await()
            }
            loadingType = if (loadingXml) LoadingType.LOADING_XML else LoadingType.LOADING_NULL
            loadingMessage = "正在拉取网络中..."
            requestCode = NetUrl.MOVIE_DETAIL
        }
    }
}