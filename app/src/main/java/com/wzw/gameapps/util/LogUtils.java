package com.wzw.gameapps.util;

import android.util.Log;


/**
 * Created by wuzhongwei on 2017/2/10.
 */

public class LogUtils {

    public static void d(String TAG, String text) {
        Log.d(TAG, text);
    }

    public static void e(String TAG, String text) {
        Log.d(TAG, text);
    }

    public static void d(Object object, String text) {
        Log.d(object.getClass().getSimpleName(), text);
    }

    public static void e(Object object, String text) {
        Log.d(object.getClass().getSimpleName(), text);
    }
}
