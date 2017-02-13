package com.wzw.gameapps.api;

/**
 * Created by wuzhongwei on 2017/2/13.
 */

public interface Api {
    //服务器主机
    String SERVER_HOST = "http://58.49.122.226:8090/";
    //首页

    String Home = SERVER_HOST + "home?index=";

    String IMAGE_PREFIX = SERVER_HOST + "image?name=";

    //App页的url地址
    String App = SERVER_HOST + "app?index=";

    //Game
    String Game = SERVER_HOST + "game?index=";

    //Subject页的url地址
    String Subject = SERVER_HOST + "subject?index=";

    // 得到当前的Recommend的地址   没有下拉刷新可以index=0写固定
    String Recommend = SERVER_HOST + "recommend?index=0";

    // 得到当前的Category的地址   没有下拉刷新可以index=0写固定
    String Category = SERVER_HOST + "category?index=0";

    // 得到当前的Hot的地址   没有下拉刷新可以index=0写固定
    String Hot = SERVER_HOST + "hot?index=0";

    // 详情detail界面的URL
    String Detail = SERVER_HOST + "detail?packageName=%s";

    // APK下载的接口
    String Download = SERVER_HOST + "download?name=%s";

    // APK断点下载的接口数据
    String Break_Download = SERVER_HOST + "download?name=%s&range=%d";
}
