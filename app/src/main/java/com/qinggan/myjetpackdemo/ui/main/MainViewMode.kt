package com.qinggan.myjetpackdemo.ui.main

import androidx.lifecycle.MutableLiveData
import com.qinggan.myjetpackdemo.ui.BaseViewMode

class MainViewMode : BaseViewMode() {

    var data: MutableLiveData<String> = MutableLiveData()

}