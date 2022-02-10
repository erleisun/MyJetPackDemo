package com.qinggan.myjetpackdemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qinggan.myjetpackdemo.bean.BannerBean
import com.qinggan.myjetpackdemo.http.ApiResponse
import com.qinggan.myjetpackdemo.ui.BaseViewMode
import com.qinggan.myjetpackdemo.utils.KLog

class HomeViewModel : BaseViewMode() {

    private val repo  by lazy { HomeRepo() }

    private val textTitle = MutableLiveData<String>().apply {
        value = "首頁"
    }
    val text: LiveData<String> = textTitle

    /**
     * 滚动的liveData数据
     */
    private var banner: MutableLiveData<MutableList<BannerBean>> = MutableLiveData<MutableList<BannerBean>>()
    var _banner : LiveData<MutableList<BannerBean>> = banner

    /**
     * 获取Banner数据
     */
    fun getBanner() {
        launch {
            KLog.d("HomeViewModel", "launch getBanner")
            banner.value = repo.getBanner()
//            val result: MutableList<BannerBean> = repo.getBanner()
            KLog.d("HomeViewModel", "launch getBanner end ${banner.value!!.size}")
        }
    }

}