package com.ls.entertainmentbox.ui.adapter

import android.util.SparseArray
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ls.entertainmentbox.ui.fragment.ComicsFragment
import com.ls.entertainmentbox.ui.fragment.VideoFragment


class MainAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    companion object {
        const val PAGE_ONE = 0
        const val PAGE_TWO = 1
        const val PAGE_THREE = 2
        const val PAGE_FOUR = 3
        const val PAGE_FIVE = 4
    }

    private val fragments: SparseArray<Fragment> = SparseArray()

    init {
        fragments.put(PAGE_ONE, VideoFragment())
        fragments.put(PAGE_TWO, ComicsFragment())
//        fragments.put(PAGE_THREE, VideoFragment())
//        fragments.put(PAGE_FOUR, UIFragment())
//        fragments.put(PAGE_FIVE, BarFragment())
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size()
    }
}