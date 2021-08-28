package com.qinggan.myjetpackdemo.http

import com.qinggan.myjetpackdemo.bean.BannerJsonBean
import retrofit2.http.GET

interface ApiService {

    /**
     * banner
     */
//    @GET("/banner/json")
//    fun getBanner(): ApiResponse<MutableList<BannerBean>>

    @GET("/banner/json")
    fun getBanner(): BannerJsonBean


}