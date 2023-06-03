package com.ls.entertainmentbox.ui

import android.os.Bundle
import com.ls.entertainmentbox.R
import com.ls.entertainmentbox.app.base.BaseActivity
import com.ls.entertainmentbox.databinding.ActivityMainBinding
import com.ls.entertainmentbox.ui.adapter.MainAdapter
import com.ls.entertainmentbox.vm.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        //设置适配器
        mBind.mainViewPager.adapter = MainAdapter(this)
        //设置缓存页面数量
        mBind.mainViewPager.offscreenPageLimit = mBind.mainViewPager.adapter!!.itemCount
        //禁止滑动
        mBind.mainViewPager.isUserInputEnabled = false
        //设置底部导航栏选择事件
        mBind.mainNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_tab1 -> {
                    //切换到首页
                    mBind.mainViewPager.setCurrentItem(0, false)
                }
                R.id.menu_tab2 -> {
                    //切换到个人中心
                    mBind.mainViewPager.setCurrentItem(1, false)
                }
            }
            true
        }
    }

    override fun showToolBar() = false

}