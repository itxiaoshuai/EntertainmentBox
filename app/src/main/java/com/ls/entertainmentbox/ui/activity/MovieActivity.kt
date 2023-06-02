package com.ls.entertainmentbox.ui.activity

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.ls.entertainmentbox.R
import com.ls.entertainmentbox.app.base.BaseActivity
import com.ls.entertainmentbox.databinding.ActivityMovieBinding
import com.ls.entertainmentbox.vm.MovieViewModel

class MovieActivity : BaseActivity<MovieViewModel, ActivityMovieBinding>() {

    private var videoId = ""
    override fun initView(savedInstanceState: Bundle?) {
        videoId = intent.getStringExtra("videoId").toString()
        mViewModel.getMovieDetail(videoId)
    }

    override fun onLoadRetry() {
        super.onLoadRetry()
    }


    override fun onRequestSuccess() {
        mViewModel.movie.observe(this, Observer {
            mBind.tvTitle.text = it.data.title
            mBind.tvDirector.text = String.format(resources.getString(R.string.director),it.data.director)
            mBind.tvReleaseTime.text = String.format(resources.getString(R.string.releaseTime),it.data.releaseTime)
        })
    }
}