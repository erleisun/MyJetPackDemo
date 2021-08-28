package com.qinggan.myjetpackdemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qinggan.myjetpackdemo.commom.toast
import com.qinggan.myjetpackdemo.http.ApiException
import com.qinggan.myjetpackdemo.utils.KLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class BaseViewMode : ViewModel() {

    fun <T> launch(block: suspend () -> T) {
        viewModelScope.launch {
            runCatching {
                KLog.d("BaseViewMode", "launch")
                block()
            }.onFailure {
                KLog.d("BaseViewMode", "onFailure")
                it.printStackTrace()
                getApiException(it).apply {
                    withContext(Dispatchers.Main) {
                        toast(errorMessage)
                    }
                }
            }
        }
    }

    private fun getApiException(e: Throwable): ApiException {
        return when (e) {
            is UnknownHostException -> {
                ApiException(-1, "UnknownHostException")
            }
            is JSONException -> {
                ApiException(100, "JSONException")
            }
            is SocketTimeoutException -> {
                ApiException(101, "SocketTimeoutException")
            }
            is ConnectException -> {
                ApiException(102, "连接错误")
            }
            is HttpException -> {
                ApiException(103, "http code ${e.code()}")
            }
            is ApiException -> {
                e
            }
            else -> ApiException(104, "unKnow exception")
        }
    }

}