package com.zhan.mvp

import android.content.Context
import com.zhan.mvp.common.Preference
import com.zhan.mvp.config.Setting

/**
 *  @author: hyzhan
 *  @date:   2019/5/22
 *  @desc:   TODO
 */

object KtArmor {

    var BASE_URL: String = ""
    var CONNECT_TIME_OUT: Long = 0
    var READ_TIME_OUT: Long = 0
    var WRITE_TIME_OUT: Long = 0

    fun init(context: Context,
             baseUrl: String,
             connectTime: Long = Setting.CONNECT_TIME_OUT,
             readTime: Long = Setting.READ_TIME_OUT,
             writeTime: Long = Setting.WRITE_TIME_OUT) {

        BASE_URL = baseUrl
        CONNECT_TIME_OUT = connectTime
        READ_TIME_OUT = readTime
        WRITE_TIME_OUT = writeTime

        // 初始化 SharePreference
        Preference.init(context)
    }
}
