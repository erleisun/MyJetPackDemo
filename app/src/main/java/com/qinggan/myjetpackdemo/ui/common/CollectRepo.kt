package com.qinggan.myjetpackdemo.ui.common

import com.qinggan.myjetpackdemo.http.BaseRepository
import com.qinggan.myjetpackdemo.utils.KLog

class CollectRepo : BaseRepository() {

    suspend fun collect(id: Int) {
        withIO {
            KLog.d("homeRepo collect $id")
        }
    }

    suspend fun unCollect(id: Int) {
        withIO {
            KLog.d("homeRepo unCollect $id")
        }
    }

}