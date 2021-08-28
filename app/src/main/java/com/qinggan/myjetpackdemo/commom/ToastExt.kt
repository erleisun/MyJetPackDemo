package com.qinggan.myjetpackdemo.commom

import android.widget.Toast
import com.qinggan.myjetpackdemo.BaseApp

fun toast(toast: String) {
    Toast.makeText(BaseApp.getContext(), toast, Toast.LENGTH_LONG).show()
}
