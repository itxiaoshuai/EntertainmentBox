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
import com.ls.entertainmentbox.databinding.FragmentComicsBinding
import com.ls.entertainmentbox.databinding.FragmentVideoBinding
import com.ls.entertainmentbox.ui.activity.MovieActivity
import com.ls.entertainmentbox.ui.adapter.ComicListAdapter
import com.ls.entertainmentbox.ui.adapter.VideoListAdapter
import com.ls.entertainmentbox.vm.ComicsViewModel
import com.ls.entertainmentbox.vm.VideoViewModel
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener

/**
 * All Rights Reserved , Designed By xs Company
 * @version
 * @description: 漫画
 * @author: 罗帅
 * @create: 2023-06-03
 */
class ComicsFragment : BaseFragment<ComicsViewModel, FragmentComicsBinding>(), OnItemClickListener {
    var isRefresh = false
    private var searchContent = "斗破苍穹"
    private val comicListAdapter: ComicListAdapter by lazy {
        ComicListAdapter().apply {
            setOnItemClickListener(this@ComicsFragment)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        mBind.recyclerView.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = comicListAdapter
            itemAnimator = DefaultItemAnimator()
        }

        mBind.listSmartRefresh.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
            override fun onRefresh(refreshLayout: RefreshLayout) {
                isRefresh = true
                mViewModel.getList(isRefresh = isRefresh, title = "校园", loadingXml = true)
            }

            override fun onLoadMore(refreshLayout: RefreshLayout) {
                isRefresh = false
            }

        })

        mViewModel.getList(isRefresh = true, title = "校园", loadingXml = true)
    }

    override fun onRequestSuccess() {
        mViewModel.listData.observe(this, Observer {
            //请求到列表数据
//            videoListAdapter.loadListSuccess(it, mBind.listSmartRefresh)
            Log.d("TAG", Gson().toJson(it))
            comicListAdapter.setNewInstance(it.data)
        })
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        val data = comicListAdapter.data[position]
        startActivity(
            Intent(context, MovieActivity::class.java).putExtra("comicId", data.comicId)
        )
    }
}