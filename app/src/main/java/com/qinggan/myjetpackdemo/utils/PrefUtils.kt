package com.qinggan.myjetpackdemo.utils

import android.content.Context
import com.qinggan.myjetpackdemo.BaseApp

object PrefUtils {

    private const val PREF_NAME: String = "config"

    fun getBoolean(
        key: String,
        defaultValue: Boolean,
    ): Boolean {
        val sp = BaseApp.getContext().getSharedPreferences(
            PREF_NAME, Context.MODE_PRIVATE)

        return sp.getBoolean(key, defaultValue)
    }

    fun setBoolean(
        key: String, defaultValue: Boolean,
    ) {
        val sp = BaseApp.getContext().getSharedPreferences(
            PREF_NAME, Context.MODE_PRIVATE)
        sp.edit().putBoolean(key, defaultValue).apply()

    }

}