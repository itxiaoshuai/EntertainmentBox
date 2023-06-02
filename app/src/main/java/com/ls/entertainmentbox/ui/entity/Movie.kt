package com.ls.entertainmentbox.ui.entity

import me.hgj.mvvmhelper.entity.BasePage

/**
 * All Rights Reserved , Designed By xs Company
 * @version
 * @description:
 * @author: 罗帅
 * @create: 2023-06-02
 */
data class Movie(

    var videoId: String,
    var title: String,
    var director: String,
    var actor: String,
    var region: String,
    var videoType: String,
    var descs: String,
    var cover: String,
    var releaseTime: String,
    var updateTime: String,


    var chapterList: ArrayList<MovieChapter>
)


