package com.qinggan.myjetpackdemo.commom

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.qinggan.myjetpackdemo.R

object ArticleBindAdapter {

    @BindingAdapter(value = ["articleCollect"])
    @JvmStatic
    fun articleCollect(imageView: ImageView, collect: Boolean) {
        if (collect) {
            imageView.setImageResource(R.mipmap.collect)
        } else {
            imageView.setImageResource(R.mipmap.un_collect)
        }
    }
}