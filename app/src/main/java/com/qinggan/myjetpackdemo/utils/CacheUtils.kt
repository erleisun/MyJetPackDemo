package com.qinggan.myjetpackdemo.utils

import com.qinggan.myjetpackdemo.Constants

/**
 * cache utils
 */
class CacheUtils {

    companion object {

        fun isLogin(): Boolean {
            return PrefUtils.getBoolean(Constants.Login, true)
        }
    }

}