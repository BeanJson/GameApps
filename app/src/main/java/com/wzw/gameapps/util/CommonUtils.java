package com.wzw.gameapps.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

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
    /**
     * 移除子View
     * @param child
     */
    public static void removeSelfFromParent(View child){
        if(child!=null){
            ViewParent parent = child.getParent();
            if(parent!=null && parent instanceof ViewGroup){
                ViewGroup group = (ViewGroup) parent;
                group.removeView(child);//移除子View
            }
        }
    }
}
