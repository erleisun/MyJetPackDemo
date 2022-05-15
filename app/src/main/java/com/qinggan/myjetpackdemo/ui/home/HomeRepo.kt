package com.qinggan.myjetpackdemo.ui.home

import com.qinggan.myjetpackdemo.bean.ArticleListBean
import com.qinggan.myjetpackdemo.http.ApiService
import com.qinggan.myjetpackdemo.http.BaseRepository
import com.qinggan.myjetpackdemo.http.RetrofitManager
import com.qinggan.myjetpackdemo.utils.KLog

class HomeRepo : BaseRepository() {

    private var page = 0

    suspend fun getBanner() = withIO {
        KLog.d("getBanner RetrofitManager getApiService")
        RetrofitManager.getApiService(ApiService::class.java)
            .getBanner()
            .data()
    }

    /**
     * 使用withContext 将指定协程运行的线程，执行时会阻塞当前运行的线程
     */
    suspend fun getArticles() = withIO {
        page = 0 //请求第一页
        RetrofitManager.getApiService(ApiService::class.java)
            .getHomeList(page)
            .data()
            .datas?.let {
                ArticleListBean.trans(it)
            } ?: mutableListOf()
    }

    /**
     * 获取置顶文章
     */
    suspend fun getTopArticles() = withIO {
        RetrofitManager.getApiService(ApiService::class.java)
            .getTopArticles()
            .data()
            .let {
                ArticleListBean.trans(it)
            }
    }

}