package com.qinggan.myjetpackdemo.utils;

import android.util.Log;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：2015/10/12
 * 描    述：日志的工具类
 * 修订历史：
 * ================================================
 */
public class KLog {
    private static boolean isLogEnable = true;

    private static String TAG = "MyJetPack";

    public static void debug(boolean isEnable) {
        debug(TAG, isEnable);
    }

    public static void debug(String logTag, boolean isEnable) {
        TAG += "[ " + logTag + " ] : ";
        isLogEnable = isEnable;
    }

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void v(String tag, String msg) {
        if (isLogEnable) Log.v(TAG, "[ " + tag + " ] : " + msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (isLogEnable) Log.d(TAG, "[ " + tag + " ] : " + msg);
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (isLogEnable) Log.i(TAG, "[ " + tag + " ] : " + msg);
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void w(String tag, String msg) {
        if (isLogEnable) Log.w(TAG, "[ " + tag + " ] : " + msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (isLogEnable) Log.e(TAG, "[ " + tag + " ] : " + msg);
    }

    public static void printStackTrace(Throwable t) {
        if (isLogEnable && t != null) t.printStackTrace();
    }
}
