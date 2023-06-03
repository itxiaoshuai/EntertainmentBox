package com.ls.entertainmentbox.ui.adapter

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.ls.entertainmentbox.R
import com.ls.entertainmentbox.ui.entity.Comic
import com.ls.entertainmentbox.ui.entity.Video
import java.text.MessageFormat

/**
 * 漫画列表
 */
class ComicListAdapter :
    BaseQuickAdapter<Comic, BaseViewHolder>(R.layout.item_comic),
    LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: Comic) {
        Glide.with(context).load(item.cover).into(holder.getView(R.id.image))
        holder.setText(R.id.tv_title, item.title)
        holder.setText(R.id.tv_author, item.actor)
        holder.setText(R.id.tvDes, item.descs)
    }

}