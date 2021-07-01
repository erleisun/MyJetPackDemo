package com.qinggan.myjetpackdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getLayoutId()?.let { setContentView(it) }
        init(savedInstanceState)
    }

    abstract fun getLayoutId(): Int;

    abstract fun init(savedInstanceState: Bundle?)

}