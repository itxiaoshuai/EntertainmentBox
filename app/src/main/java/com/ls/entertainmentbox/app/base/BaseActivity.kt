package com.ls.entertainmentbox.app.base

import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.gyf.immersionbar.ImmersionBar
import com.ls.entertainmentbox.R
import com.ls.entertainmentbox.app.widget.CustomToolBar
import me.hgj.mvvmhelper.base.BaseVBActivity
import me.hgj.mvvmhelper.base.BaseViewModel

/**
 * @author 小帅
 * @date 2022/4/30.
 * description：
 */
abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : BaseVBActivity<VM, VB>() {

    lateinit var mToolbar: CustomToolBar

    override fun getTitleBarView(): View? {
        val titleBarView = LayoutInflater.from(this).inflate(R.layout.layout_titlebar_view, null)
        mToolbar = titleBarView.findViewById(R.id.customToolBar)
        return titleBarView
    }

    override fun initImmersionBar() {
        //设置共同沉浸式样式
        if (showToolBar()) {
            mToolbar.setBackgroundResource(R.color.colorPrimary)
            ImmersionBar.with(this).titleBar(mToolbar).init()
        }
    }


}