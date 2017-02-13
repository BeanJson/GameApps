package com.wzw.gameapps.bean;

import java.util.ArrayList;

/**
 * Created by wuzhongwei on 2017/2/13.
 */

public class HomeBean {
    /**
     * 在主界面当中.主要包裹了两层的JSON数据:
     * 1.picture的JSON数组
     * 2.list的JSON数组
     *
     * 我们知道当前的JSON数组,在Java当中的表示方式为 List集合
     * 因此,此时此刻创建的是 List集合(子类ArrayList集合)的对象
     */

    // home大图轮播的图片数组
    private ArrayList<String> picture;
    // 下面列表项目的APP应用信息(每一个应用信息都是一个JavaBean有着自己的图标和文本信息等)
    private ArrayList<AppInfoBean> list;

    public ArrayList<String> getPicture() {
        return picture;
    }

    public void setPicture(ArrayList<String> picture) {
        this.picture = picture;
    }

    public ArrayList<AppInfoBean> getList() {
        return list;
    }

    public void setList(ArrayList<AppInfoBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HomeBean [picture=" + picture + ", list=" + list + "]";
    }

}
