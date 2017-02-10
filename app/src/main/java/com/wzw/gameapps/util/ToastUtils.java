package com.wzw.gameapps.util;

import android.widget.Toast;

import com.wzw.gameapps.global.MyApplication;

/**
 * Created by wuzhongwei on 2017/2/10.
 */

public class ToastUtils {

    public static Toast toast = null;
    public static void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getContext(), text, 0);
        } else {
            toast.setText(text);
        }
       toast.show();
    }
}
