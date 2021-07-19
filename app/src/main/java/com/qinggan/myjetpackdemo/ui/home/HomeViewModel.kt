package com.qinggan.myjetpackdemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qinggan.myjetpackdemo.bean.BannerBean
import com.qinggan.myjetpackdemo.ui.BaseViewMode

class HomeViewModel : BaseViewMode() {

    private val repo by lazy { HomeRepo() }

    private val textTitle = MutableLiveData<String>().apply {
        value = "首頁"
    }
    val text: LiveData<String> = textTitle

    /**
     * 滚动的liveData数据
     */
    var banner: MutableLiveData<MutableList<BannerBean>>? = null

    /**
     * 获取Banner数据
     */
    fun getBanner() {
        launch {
//            banner?.value = repo.getBanner()
        }
    }

}