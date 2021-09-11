package com.qinggan.myjetpackdemo.http

class ApiException(var errorMessage: String, var errorCode: Int) : Throwable()