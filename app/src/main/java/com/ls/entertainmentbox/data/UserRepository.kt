package com.ls.entertainmentbox.data


import android.provider.MediaStore
import com.ls.entertainmentbox.app.api.NetUrl
import com.ls.entertainmentbox.data.response.BaseListResponse
import com.ls.entertainmentbox.ui.entity.Video
import rxhttp.toAwait
import rxhttp.toAwaitList
import rxhttp.toAwaitMapString
import rxhttp.wrapper.coroutines.Await
import rxhttp.wrapper.param.RxHttp

object UserRepository {



    /**
     * 获取列表信息
     */
    fun getList(pageIndex: Int): Await<BaseListResponse<Video>> {
        return RxHttp.get(NetUrl.HOME_LIST, pageIndex).toAwait()

    }
    fun getMovie(pageIndex: Int): Await<BaseListResponse<Video>> {
        return RxHttp.get(NetUrl.MOVIE_DETAIL, pageIndex).toAwait()

    }
}

