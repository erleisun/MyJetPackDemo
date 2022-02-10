package com.qinggan.myjetpackdemo.commom

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

//ImageView扩展类

fun ImageView.loadUrl(context: Context,url:String){
    Glide.with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)

}