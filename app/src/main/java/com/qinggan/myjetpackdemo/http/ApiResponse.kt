package com.qinggan.myjetpackdemo.http

import java.io.Serializable

class ApiResponse<T> : Serializable {

    var data: T? = null


    fun onData(): T {

    }

}