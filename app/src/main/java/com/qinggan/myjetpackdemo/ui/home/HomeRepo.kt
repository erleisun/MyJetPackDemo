package com.qinggan.myjetpackdemo.ui.home

import com.qinggan.myjetpackdemo.http.ApiService
import com.qinggan.myjetpackdemo.http.BaseRepository
import com.qinggan.myjetpackdemo.http.RetrofitManager

class HomeRepo : BaseRepository() {

    //切换到子线程
    suspend fun getBanner() = withIO {
        RetrofitManager.getApiService(ApiService::class.java)
            .getBanner()
            .onData()
    }
}