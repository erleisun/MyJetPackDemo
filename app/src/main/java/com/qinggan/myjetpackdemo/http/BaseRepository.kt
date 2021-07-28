package com.qinggan.myjetpackdemo.http

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository {


    /**
     * 在协程作用域中切换至IO线程
     */
    suspend fun <T> withIO(block: () -> T): T {
        return withContext(Dispatchers.IO) {
            block.invoke()
        }
    }

}