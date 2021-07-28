package com.qinggan.myjetpackdemo.http

class RetrofitManager {

    companion object {
        var retrofit = RetrofitFactory.factory()

        fun <T : Any> getApiService(apiClass: Class<T>): T {
            return getService(apiClass)
        }

        private fun <T : Any> getService(apiClass: Class<T>): T {
            return retrofit.create(apiClass)
        }
    }

}