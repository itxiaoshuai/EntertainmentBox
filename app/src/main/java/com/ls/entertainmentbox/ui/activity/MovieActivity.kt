package com.ls.entertainmentbox.ui.activity


import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.media.ThumbnailUtils
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.ls.entertainmentbox.R
import com.ls.entertainmentbox.app.base.BaseActivity
import com.ls.entertainmentbox.databinding.ActivityMovieBinding
import com.ls.entertainmentbox.ui.adapter.ChapterAdapter
import com.ls.entertainmentbox.ui.adapter.ComicListAdapter
import com.ls.entertainmentbox.vm.MovieViewModel


class MovieActivity : BaseActivity<MovieViewModel, ActivityMovieBinding>() {

    private var videoId = ""


    private val chapterAdapter: ChapterAdapter by lazy {
        ChapterAdapter().apply {

        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        videoId = intent.getStringExtra("videoId").toString()


        mBind.recyclerChapter.run {
            layoutManager = LinearLayoutManager(this@MovieActivity)
            adapter = chapterAdapter
            itemAnimator = DefaultItemAnimator()
        }


        mViewModel.getMovieDetail(videoId)


    }

    override fun onLoadRetry() {
        super.onLoadRetry()
    }


    override fun onRequestSuccess() {
        mViewModel.movie.observe(this, Observer {
            mBind.tvTitle.text = it.data.title
            mBind.tvDirector.text =
                String.format(resources.getString(R.string.director), it.data.director)
            mBind.tvReleaseTime.text =
                String.format(resources.getString(R.string.releaseTime), it.data.releaseTime)
            mBind.tvDes.text = it.data.descs
            Glide.with(this@MovieActivity).load(it.data.cover).into(mBind.ivCover)
            if (it.data.chapterList.size > 0) {
                mBind.jzVideo.setUp(
                    it.data.chapterList[0].chapterPath, it.data.title
                )
            }
            chapterAdapter.setNewInstance(it.data.chapterList)
//            mBind.jzVideo.posterImageView.setImageBitmap(getVideoThumbnail("https://vip.lz-cdn2.com/20220402/1938_b629ffbe/index.m3u8",100,100,MINI_KIND))
//
//            Glide.with(this@MovieActivity)
//                .setDefaultRequestOptions(
//                    RequestOptions()
//                        .frame(100)
//                        .centerCrop()
//                )
//                .load("https://vip.lz-cdn2.com/20220402/1938_b629ffbe/index.m3u8")
//                .into(mBind.jzVideo.posterImageView)
//            mBind.jzVideo.posterImageView.setImageDrawable(ResourcesCompat.getDrawable(resources,R.drawable.ic_back,null));

//            val retriever = MediaMetadataRetriever()
//            retriever.setDataSource(
//                "https://vip.lz-cdn2.com/20220402/1938_b629ffbe/index.m3u8",
//                HashMap()
//            )
//            val thumbnail = retriever.getFrameAtTime(
//                1000000 * 10,
//                MediaMetadataRetriever.OPTION_CLOSEST_SYNC
//            )
//            val requestOptions = RequestOptions().frame(1000000 * 10)
//            Glide.with(this).asBitmap().load("http://vfx.mtime.cn/Video/2021/12/05/mp4/211205092838969197.mp4").apply(requestOptions)
//                .into(mBind.jzVideo.posterImageView)
        })
    }

    /**
     * 获取视频的第一帧缩略图
     * 先通过ThumbnailUtils来创建一个视频的缩略图，然后再利用ThumbnailUtils来生成指定大小的缩略图。
     * 如果想要的缩略图的宽和高都小于MICRO_KIND，则类型要使用MICRO_KIND作为kind的值，这样会节省内存。
     * @param videoPath 视频的路径
     * @param width 指定输出视频缩略图的宽度
     * @param height 指定输出视频缩略图的高度度
     * @param kind 参照MediaStore.Images(Video).Thumbnails类中的常量MINI_KIND和MICRO_KIND。
     * 其中，MINI_KIND: 512 x 384，MICRO_KIND: 96 x 96
     * @return 指定大小的视频缩略图
     */
    fun getVideoThumbnail(videoPath: String?, width: Int, height: Int, kind: Int): Bitmap? {
        var bitmap: Bitmap? = null
        // 获取视频的缩略图
        bitmap = ThumbnailUtils.createVideoThumbnail(
            videoPath!!, kind
        ) //调用ThumbnailUtils类的静态方法createVideoThumbnail获取视频的截图；
        if (bitmap != null) {
            bitmap = ThumbnailUtils.extractThumbnail(
                bitmap, width, height, ThumbnailUtils.OPTIONS_RECYCLE_INPUT
            ) //调用ThumbnailUtils类的静态方法extractThumbnail将原图片（即上方截取的图片）转化为指定大小；
        }
        return bitmap
    }

    /**
     * 获取视频文件第一帧图
     *
     * @param path 视频文件的路径
     * @return Bitmap 返回获取的Bitmap
     */
    fun getVideoThumb(path: String?): Bitmap? {
        val media = MediaMetadataRetriever()
        media.setDataSource(path)
        return media.frameAtTime
    }
}