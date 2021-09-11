package com.qinggan.myjetpackdemo.http

import com.qinggan.myjetpackdemo.bean.BannerBean
import com.qinggan.myjetpackdemo.bean.BannerJsonBean
import retrofit2.http.GET

interface ApiService {

    /**
     * banner
     */
    @GET("/banner/json")
    suspend fun getBanner(): ApiResponse<MutableList<BannerBean>>


}