package com.qinggan.myjetpackdemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.qinggan.myjetpackdemo.bean.ArticleListBean
import com.qinggan.myjetpackdemo.bean.BannerBean
import com.qinggan.myjetpackdemo.ui.BaseViewMode
import com.qinggan.myjetpackdemo.ui.common.CollectRequest
import com.qinggan.myjetpackdemo.utils.KLog
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewMode() {

    private val repo by lazy { HomeRepo() }
    private val collectRequest by lazy { CollectRequest(articles) }

    private val textTitle = MutableLiveData<String>().apply {
        value = "首頁"
    }
    val text: LiveData<String> = textTitle

    /**
     * 滚动的liveData数据
     */
    var banner: MutableLiveData<MutableList<BannerBean>> =
        MutableLiveData<MutableList<BannerBean>>()


    var articles: MutableLiveData<MutableList<ArticleListBean>> = MutableLiveData()

    /**
     * 获取Banner数据
     */
    fun getBanner() {
        launch {
            KLog.d("HomeViewModel", "launch getBanner")
            banner.postValue(repo.getBanner())
        }
    }

    /**
     * 获取首页文章列表
     */
    fun getArticle() {
        launch {
            val list = mutableListOf<ArticleListBean>()
            //文章列表
            val articles = viewModelScope.async {
                repo.getArticles()
            }

            //top articles
            val topArticles = viewModelScope.async {
                repo.getTopArticles()
            }

            list.addAll(topArticles.await())
            list.addAll(articles.await())

            this.articles.postValue(list)
        }
    }

    fun collect(articleID: Int) {
        launch {
            collectRequest.collect(articleID)
        }
    }

    fun unCollect(articleID: Int) {
        viewModelScope.launch {
            collectRequest.unCollect(articleID)
        }
    }

}