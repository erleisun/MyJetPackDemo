package com.qinggan.myjetpackdemo.commom

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object CustomBinderAdapter {


    @BindingAdapter(value = ["imageUrl"])
    @JvmStatic
    fun imageUrl(view: ImageView, url: String) {
        view.loadUrl(view.context.applicationContext, url)
    }


}