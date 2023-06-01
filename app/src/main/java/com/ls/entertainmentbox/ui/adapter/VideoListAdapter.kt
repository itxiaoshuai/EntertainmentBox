package com.ls.entertainmentbox.ui.adapter

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ls.entertainmentbox.R
import com.ls.entertainmentbox.ui.entity.Video
import java.text.MessageFormat

/**
 * 历史记录
 */
class VideoListAdapter :
    BaseQuickAdapter<Video, BaseViewHolder>(R.layout.item_video),
    LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: Video) {
        Glide.with(context).load(item.cover).into(holder.getView(R.id.image))
        holder.setText(R.id.tv_title, item.title)
        holder.setText(R.id.tv_director, item.director)
        holder.setText(R.id.tvDes, item.descs)
    }

}