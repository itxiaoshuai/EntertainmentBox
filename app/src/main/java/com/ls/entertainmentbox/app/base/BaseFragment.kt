package com.ls.entertainmentbox.app.base


import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import me.hgj.mvvmhelper.base.BaseDbFragment
import me.hgj.mvvmhelper.base.BaseVbFragment
import me.hgj.mvvmhelper.base.BaseViewModel
import me.hgj.mvvmhelper.ext.toast
import me.hgj.mvvmhelper.net.LoadStatusEntity

/**
 * @author 小帅
 * @date 2022/4/30.
 * description：使用DataBinding 需要自定义修改什么就重写什么 具体方法可以 搜索 BaseIView 查看
 */
abstract class BaseFragment<VM : BaseViewModel,VB: ViewBinding> : BaseVbFragment<VM, VB>(){


}