package com.ls.entertainmentbox.app.api

import rxhttp.wrapper.annotation.DefaultDomain

object NetUrl {

    // 服务器请求成功的 Code值
    const val SUCCESS_CODE = 200

    @DefaultDomain //设置为默认域名
    const val DEV_URL = "https://api.pingcc.cn/"

    //登录
    const val LOGIN = "user/login"

    //获取首页列表数据
    const val HOME_LIST = "video/search/title/%s/%d/%d"

    //获取电影详情
    const val MOVIE_DETAIL = "videoChapter/search/%1\$s"

    //获取漫画列表数据
    const val COMICS_LIST = "comic/search/title/%s/%d/%d"

}