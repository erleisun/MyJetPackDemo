package com.qinggan.myjetpackdemo.http

import com.qinggan.myjetpackdemo.utils.KLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository {

    init {
        KLog.d("BaseRepository", "BaseRepository init")
    }

    /**
     * 在协程作用域中切换至IO线程
     */
    suspend fun <T> withIO(block: suspend () -> T): T {
        KLog.d("BaseRepository", "withContext")
        return withContext(Dispatchers.IO) {
            KLog.d("BaseRepository", "withContext")
            block.invoke()
        }
    }
}