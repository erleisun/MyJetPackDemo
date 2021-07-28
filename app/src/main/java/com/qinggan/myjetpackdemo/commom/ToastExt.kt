package com.qinggan.myjetpackdemo.commom

import android.widget.Toast

fun toast(toast: String) {
    Toast.makeText(BaseApp.getContext(), toast, Toast.LENGTH_LONG).show()
}
