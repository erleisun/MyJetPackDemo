package com.qinggan.myjetpackdemo.ui.home

import com.qinggan.myjetpackdemo.http.ApiService
import com.qinggan.myjetpackdemo.http.BaseRepository
import com.qinggan.myjetpackdemo.http.RetrofitManager
import com.qinggan.myjetpackdemo.utils.KLog

class HomeRepo : BaseRepository() {

    //切换到子线程
    suspend fun getBanner() = withIO {
        KLog.d("HomeRepo","getApiService")
        RetrofitManager.getApiService(ApiService::class.java)
            .getBanner()
//            .onData()
    }

}