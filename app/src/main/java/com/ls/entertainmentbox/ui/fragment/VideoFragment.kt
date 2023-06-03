package com.ls.entertainmentbox.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.Toast
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


/**
 * All Rights Reserved , Designed By xs Company
 * @version
 * @description:
 * @author: 罗帅
 * @create: 2023-05-27
 */
class VideoFragment : BaseFragment<VideoViewModel, FragmentVideoBinding>(), OnItemClickListener {
    var isRefresh = false
    private var searchContent = "斗破苍穹"
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

        //搜索框展开时后面叉叉按钮的点击事件
        mBind.searchView.setOnCloseListener(object : SearchView.OnCloseListener,
            androidx.appcompat.widget.SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                Toast.makeText(activity, "Close", Toast.LENGTH_SHORT).show()
                return false
            }
        })

        //搜索图标按钮(打开搜索框的按钮)的点击事件
        mBind.searchView.setOnSearchClickListener(View.OnClickListener {
            Toast.makeText(
                activity, "Open", Toast.LENGTH_SHORT
            ).show()
        })
        //搜索框文字变化监听
        mBind.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                Log.e("CSDN_LQR", "TextSubmit : $s")
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                Log.e("CSDN_LQR", "TextChange --> $s")
                searchContent = s
                return false
            }
        })
        mBind.tvSearch.setOnClickListener {
            mViewModel.getList(isRefresh = true, title = searchContent, loadingXml = true)
        }
        mViewModel.getList(isRefresh = true, title = searchContent, loadingXml = true)
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
            Intent(context, MovieActivity::class.java).putExtra("videoId", data.videoId)
        )
    }
}