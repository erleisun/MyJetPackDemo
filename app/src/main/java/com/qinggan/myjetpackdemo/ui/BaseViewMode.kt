package com.qinggan.myjetpackdemo.ui

import androidx.lifecycle.ViewModel

open class BaseViewMode : ViewModel() {

    public fun <T> launch(block: suspend () -> T) {



    }

}