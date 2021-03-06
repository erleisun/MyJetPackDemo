package com.qinggan.myjetpackdemo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qinggan.myjetpackdemo.commom.toast
import com.qinggan.myjetpackdemo.http.ApiException
import com.qinggan.myjetpackdemo.utils.KLog
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class BaseViewMode : ViewModel() {

    /**
     * 错误信息liveData
     */
    val errorLiveData = MutableLiveData<ApiException>()

    /**
     * 无更多数据
     */
    val footLiveDate = MutableLiveData<Any>()

    /**
     * 无数据
     */
    val emptyLiveDate = MutableLiveData<Any>()

    /**
     * 封装一个viewMode的协程
     */
    protected fun <T> launch(block: suspend () -> T) {
        //ViewMode中自带了一个声明周期和ViewMode一样的 ViewModeScope
        viewModelScope.launch {
            runCatching {
                KLog.d("BaseViewMode", "runCatching ")
                block()
            }.onFailure {
                KLog.e("BaseViewMode", "onFailure ${it.message}")
                it.printStackTrace()
                getApiException(it).apply {
                    withContext(Dispatchers.Main) {
                        toast(errorMessage)
                        //统一响应错误信息
//                        errorLiveData.value = this@apply
                    }
                }
            }
        }
    }

    /**
     * 捕获异常信息
     */
    private fun getApiException(e: Throwable): ApiException {
        KLog.e("BaseViewMode", "getApiException = ${e.message}")
        return when (e) {
            is UnknownHostException -> {
                ApiException("网络异常", -100)
            }
            is JSONException -> {//|| e is JsonParseException
                ApiException("数据异常", -100)
            }
            is SocketTimeoutException -> {
                ApiException("连接超时", -100)
            }
            is ConnectException -> {
                ApiException("连接错误", -100)
            }
            is HttpException -> {
                ApiException("http code ${e.code()}", -100)
            }
            is ApiException -> {
                e
            }
            /**
             * 如果协程还在运行，个别机型退出当前界面时，viewModel会通过抛出CancellationException，
             * 强行结束协程，与java中InterruptException类似，所以不必理会,只需将toast隐藏即可
             */
            is CancellationException -> {
                ApiException("", -10)
            }
            else -> {
                ApiException("http code unKnow ${e.message}", -100)
            }
        }
    }

}