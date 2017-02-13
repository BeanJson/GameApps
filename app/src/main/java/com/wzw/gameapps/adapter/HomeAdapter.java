package com.wzw.gameapps.adapter;

import com.wzw.gameapps.bean.AppInfoBean;
import com.wzw.gameapps.holder.BaseHolder;
import com.wzw.gameapps.holder.HomeHolder;

import java.util.ArrayList;

/**
 * Created by wuzhongwei on 2017/2/13.
 */

public class HomeAdapter extends BasicAdapter<AppInfoBean> {

    public HomeAdapter(ArrayList<AppInfoBean> list) {
        super(list);
    }

    @Override
    protected BaseHolder<AppInfoBean> getHolder(int position) {
        return new HomeHolder();
    }
}
