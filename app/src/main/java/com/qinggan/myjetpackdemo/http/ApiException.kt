package com.qinggan.myjetpackdemo.http

class ApiException(var errorCode: Int, var errorMessage: String) : Throwable()