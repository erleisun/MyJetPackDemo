package com.qinggan.myjetpackdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.qinggan.myjetpackdemo.utils.KLog
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class SplashActivity : BaseActivity() {

    companion object {
        var TAG = "SplashActivity"
    }

    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        startIntent()
    }

    private fun startIntent() {
        disposable = Observable.timer(1000, TimeUnit.MILLISECONDS)
            .subscribe() {
                KLog.d(TAG, "startActivity")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun init(savedInstanceState: Bundle?) {
        KLog.d(TAG, "init")
    }

}