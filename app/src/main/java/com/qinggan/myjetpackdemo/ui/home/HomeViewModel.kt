package com.qinggan.myjetpackdemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val textTitle = MutableLiveData<String>().apply {
        value = "首頁"
    }
    val text: LiveData<String> = textTitle
}