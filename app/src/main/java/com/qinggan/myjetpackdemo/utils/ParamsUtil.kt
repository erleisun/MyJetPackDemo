package com.qinggan.myjetpackdemo.utils

import android.os.Bundle
import androidx.fragment.app.Fragment

object ParamsUtil {

    /**
     * apply函数的返回的是传入对象的本身。
     */
    fun initParams(fragment: Fragment) {
        fragment.arguments.apply {
            setParams(fragment, this)
        }
    }

    /**
     * 检查当前Fragment中 哪些参数添加了注解.  从Bundle中匹配类型复杂给注解的变量
     */
    private fun setParams(obj: Any, bundle: Bundle?) {


    }

}