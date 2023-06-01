package com.ls.entertainmentbox.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.google.gson.Gson
import com.ls.entertainmentbox.app.base.BaseFragment
import com.ls.entertainmentbox.databinding.FragmentVideoBinding
import com.ls.entertainmentbox.ui.activity.MovieActivity
import com.ls.entertainmentbox.ui.adapter.VideoListAdapter
import com.ls.entertainmentbox.vm.VideoViewModel
import me.hgj.mvvmhelper.ext.loadListSuccess

/**
 * All Rights Reserved , Designed By xs Company
 * @version
 * @description:
 * @author: 罗帅
 * @create: 2023-05-27
 */
class VideoFragment : BaseFragment<VideoViewModel, FragmentVideoBinding>(), OnItemClickListener {
    var isRefresh = false
    private val videoListAdapter: VideoListAdapter by lazy {
        VideoListAdapter().apply {
            setOnItemClickListener(this@VideoFragment)
        }
    }


    override fun initView(savedInstanceState: Bundle?) {
        mBind.recyclerView.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = videoListAdapter
            itemAnimator = DefaultItemAnimator()
        }

        videoListAdapter.onAttachedToRecyclerView(mBind.recyclerView)



        mViewModel.getList(isRefresh = true, loadingXml = true)
    }

    override fun onRequestSuccess() {
        mViewModel.listData.observe(this, Observer {
            //请求到列表数据
//            videoListAdapter.loadListSuccess(it, mBind.listSmartRefresh)
            Log.d("TAG", Gson().toJson(it))
            videoListAdapter.setNewInstance(it.data)
        })
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        val data = videoListAdapter.data[position]
        startActivity(
            Intent(context, MovieActivity::class.java)
                .putExtra("videoId", data.videoId)
        )
    }
}