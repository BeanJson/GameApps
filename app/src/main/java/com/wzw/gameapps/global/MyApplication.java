package com.wzw.gameapps.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by wuzhongwei on 2017/2/10.
 * 全局类，初始化各类工具类
 */

public class MyApplication extends Application {

    private static Context context;
    private static Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mHandler = new Handler();
        initIamgeLoader(getApplicationContext());
    }

    //全局初始化图片加载
    private void initIamgeLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());

    }

    public static Handler getmainHandler() {
        return mHandler;
    }

    public static Context getContext() {
        return context;
    }
}
