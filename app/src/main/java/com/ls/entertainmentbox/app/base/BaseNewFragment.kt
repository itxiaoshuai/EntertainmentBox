package com.shop.tai.app.base

import androidx.viewbinding.ViewBinding
import me.hgj.mvvmhelper.base.BaseVbFragment
import me.hgj.mvvmhelper.base.BaseViewModel
import me.hgj.mvvmhelper.ext.toast
import me.hgj.mvvmhelper.net.LoadStatusEntity

abstract class BaseNewFragment<VM : BaseViewModel,DB: ViewBinding> : BaseVbFragment<VM, DB>(){

    //需要自定义修改什么就重写什么 具体方法可以 搜索 BaseIView 查看
    override fun onRequestError(loadStatus: LoadStatusEntity) {
        loadStatus.errorMessage.toast()
        if (loadStatus.errorCode == 201) {
//            startActivity(Intent(activity, LoginActivity::class.java))
        }
    }
}