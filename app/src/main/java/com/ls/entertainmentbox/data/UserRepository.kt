package com.ls.entertainmentbox.data


import android.provider.MediaStore
import com.ls.entertainmentbox.app.api.NetUrl
import com.ls.entertainmentbox.data.response.ApiResponse
import com.ls.entertainmentbox.data.response.BaseListResponse
import com.ls.entertainmentbox.ui.entity.Comic
import com.ls.entertainmentbox.ui.entity.Movie
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
    fun getList(title: String, pageIndex: Int, pageSize: Int): Await<BaseListResponse<Video>> {
        return RxHttp.get(NetUrl.HOME_LIST, title, pageIndex, pageSize).toAwait()

    }

    fun getMovie(videoId: String): Await<ApiResponse<Movie>> {
        return RxHttp.get(NetUrl.MOVIE_DETAIL, videoId).toAwait()

    }


    /**
     * 获取漫画列表
     */
    fun getComicList(title: String, pageIndex: Int, pageSize: Int): Await<BaseListResponse<Comic>> {
        return RxHttp.get(NetUrl.COMICS_LIST, title, pageIndex, pageSize).toAwait()

    }
}

