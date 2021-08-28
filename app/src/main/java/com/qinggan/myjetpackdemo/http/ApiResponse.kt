package com.qinggan.myjetpackdemo.http

import android.util.Log
import com.qinggan.myjetpackdemo.utils.KLog
import java.io.Serializable

class ApiResponse<T> : Serializable {

    companion object {
        var TAG = ApiException::class.java.simpleName
    }

    var data: T? = null

    /**
     * 业务信息
     */
    private var errorMsg = ""

    /**
     * 业务code
     */
    private var errorCode = 0

    fun onData(): T? {
        KLog.d(TAG, "errorCode = $errorCode  errorMsg = $errorMsg")
        when (errorCode) {
            0, 200 -> {
                return data
            }
            -1 -> {
                throw ApiException(errorCode, errorMsg)
            }
        }

        throw ApiException(errorCode, errorMsg)
    }

    /**
     * 如果某些接口存在data为null的情况,需传入class对象
     * 生成空对象。避免后面做一系列空判断
     */
    fun data(clazz: Class<T>): T {
        when (errorCode) {
            //请求成功
            0, 200 -> {
                //避免业务层做null判断,通过反射将null替换为T类型空对象
                if (data == null) {
                    data = clazz.newInstance()
                }
                return data!!
            }
            //未登陆请求需要用户信息的接口
            -1001 -> {
                throw ApiException(errorCode, errorMsg)
            }
            //登录失败
            -1 -> {
                throw ApiException(errorCode, errorMsg)
            }
        }
        //其他错误
        throw ApiException(errorCode, errorMsg)
    }

}