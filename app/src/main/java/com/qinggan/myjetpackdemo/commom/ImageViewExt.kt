package com.qinggan.myjetpackdemo.commom

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.qinggan.myjetpackdemo.R

//ImageView扩展类

@SuppressLint("UseCompatLoadingForDrawables")
fun ImageView.loadUrl(context: Context, url: String) {
    Glide.with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(context.getDrawable(R.drawable.selector_play_pic))
        .into(this)

}