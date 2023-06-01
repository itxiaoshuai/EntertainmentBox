package com.ls.entertainmentbox.app.api

import com.ls.entertainmentbox.app.App
import okhttp3.Interceptor
import okhttp3.Response
import okio.IOException

class HeadInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        //模拟了2个公共参数
        builder.addHeader("token", "token123456").build()
        builder.addHeader("device", "Android").build()
        return chain.proceed(builder.build())
    }

}