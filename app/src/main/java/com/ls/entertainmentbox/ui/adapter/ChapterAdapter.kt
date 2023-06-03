package com.ls.entertainmentbox.ui.adapter

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ls.entertainmentbox.R
import com.ls.entertainmentbox.ui.entity.Comic
import com.ls.entertainmentbox.ui.entity.MovieChapter

/**
 * All Rights Reserved , Designed By xs Company
 * @version
 * @description:
 * @author: 罗帅
 * @create: 2023-06-03
 */

class ChapterAdapter :
    BaseQuickAdapter<MovieChapter, BaseViewHolder>(R.layout.item_movie_chapter),
    LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: MovieChapter) {
        holder.setText(R.id.tv_chapter,item.title)
    }

}