package com.wzw.gameapps.util;

import com.wzw.gameapps.global.MyApplication;

/**
 * Created by wuzhongwei on 2017/2/10.
 */

public class CommonUtils {

    public static void runOnUIThread(Runnable runnable) {
        MyApplication.getmainHandler().post(runnable);
    }

    public static float getDimension(int resId) {
        return MyApplication.getContext().getResources().getDimension(resId);
    }

    public static String getString(int resId) {
        return MyApplication.getContext().getResources().getString(resId);

    }

    public static String[] getStringArray(int resId) {
        return MyApplication.getContext().getResources().getStringArray(resId);
    }
}
