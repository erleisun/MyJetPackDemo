package com.qinggan.myjetpackdemo.http

import com.qinggan.myjetpackdemo.BaseApp.Companion.getContext
import com.qinggan.myjetpackdemo.Constants
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import java.util.logging.Level

object RetrofitFactory {

    private val mOkHttpClientBuilder: OkHttpClient.Builder
        get() {
            return OkHttpClient.Builder()
                .readTimeout(10 * 1000L, TimeUnit.MILLISECONDS)
                .writeTimeout(10 * 1000L, TimeUnit.MILLISECONDS)
                .connectTimeout(5 * 1000L, TimeUnit.MILLISECONDS)
                .addInterceptor(getLogInterceptor())
//                .cookieJar(getCookie())
                .cache(getCache())
        }

    fun factory(): Retrofit {
        val okHttpClient = mOkHttpClientBuilder.build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    private fun getLogInterceptor(): Interceptor {
        return HttpLoggingInterceptor("zsOkhttp").apply {
            setPrintLevel(HttpLoggingInterceptor.Level.BODY)
            setColorLevel(Level.INFO)
        }
    }

    /**
     * 获取cookie持久化
     */
//    private fun getCookie():ClearableCookieJar{
//        return PersistentCookieJar(
//            SetCookieCache(),
//            SharedPrefsCookiePersistor(getContext())
//        )
//    }

    /**
     * 获取缓存方式
     */
    private fun getCache(): Cache {
        //缓存100Mb
        return Cache(File(getContext().cacheDir, "cache"), 1024 * 1024 * 100)
    }


}