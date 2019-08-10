package com.zhan.mvp.http

import com.zhan.mvp.KtArmor
import com.zhan.mvp.config.Setting
import com.zhan.mvp.http.intercept.LoggingIntercept
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
object BaseOkHttpClient {

    // 初始化 okHttp
    fun init(vararg interceptors: Interceptor): OkHttpClient {

        val builder = OkHttpClient.Builder()

        interceptors.forEach {
            builder.addInterceptor(it)
        }

        builder.addInterceptor(LoggingIntercept.init())
            .readTimeout(KtArmor.retrofit.readTimeOut, TimeUnit.SECONDS)
            .writeTimeout(KtArmor.retrofit.writeTimeOut, TimeUnit.SECONDS)
            .connectTimeout(KtArmor.retrofit.connectTimeOut, TimeUnit.SECONDS)

        return builder.build()
    }
}