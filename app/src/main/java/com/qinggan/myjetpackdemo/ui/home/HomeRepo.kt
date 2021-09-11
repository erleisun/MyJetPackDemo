package com.qinggan.myjetpackdemo.ui.home

import com.qinggan.myjetpackdemo.http.ApiService
import com.qinggan.myjetpackdemo.http.BaseRepository
import com.qinggan.myjetpackdemo.http.RetrofitManager
import com.qinggan.myjetpackdemo.utils.KLog

class HomeRepo : BaseRepository() {

    suspend fun getBanner() = withIO {
        RetrofitManager.getApiService(ApiService::class.java)
            .getBanner()
            .data()
    }

}