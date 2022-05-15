package com.qinggan.myjetpackdemo.http

import com.qinggan.myjetpackdemo.utils.KLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository {

    init {
        KLog.d("BaseRepository", "BaseRepository init")
    }

    /**
     * 在协程作用域中切换至IO线程  withContext会阻塞当前线程 最后一行为返回值
     */
    suspend fun <T> withIO(block: suspend () -> T): T {
        KLog.d("BaseRepository", "withIO")
        return withContext(Dispatchers.IO) {
            block.invoke()
        }
    }
}