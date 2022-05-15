package com.qinggan.myjetpackdemo.http

import com.qinggan.myjetpackdemo.bean.ArticleBean
import com.qinggan.myjetpackdemo.bean.ArticleListBean
import com.qinggan.myjetpackdemo.bean.BannerBean
import com.qinggan.myjetpackdemo.bean.BannerJsonBean
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /**
     * banner 图片数据
     */
    @GET("/banner/json")
    suspend fun getBanner(): ApiResponse<MutableList<BannerBean>>

    @GET("/article/list/{page}/json")
    suspend fun getHomeList(@Path("page") pageNo: Int): ApiResponse<ArticleBean>

    @GET("/article/top/json")
    suspend fun getTopArticles(): ApiResponse<MutableList<ArticleBean.DataBean>>

}