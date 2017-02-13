package com.wzw.gameapps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.wzw.gameapps.R;
import com.wzw.gameapps.adapter.HomeAdapter;
import com.wzw.gameapps.api.Api;
import com.wzw.gameapps.api.HttpUtils;
import com.wzw.gameapps.bean.AppInfoBean;
import com.wzw.gameapps.bean.HomeBean;
import com.wzw.gameapps.global.LoadingPager;
import com.wzw.gameapps.util.CommonUtils;
import com.wzw.gameapps.util.JsonUtils;
import com.wzw.gameapps.util.LogUtils;

import java.util.ArrayList;

/**
 * Created by wuzhongwei on 2017/2/9.
 */

public class HomeFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";
    // 得到的集合数据
    private ArrayList<AppInfoBean> list = new ArrayList<AppInfoBean>();
    private ListView listView;
    private HomeAdapter adapter;


    //视图加载
    @Override
    protected View getSuccessView() {
        listView = (ListView) View.inflate(getActivity(), R.layout.test_list, null);
        // 设置分割线高度为0
        listView.setDividerHeight(0);
        // 设置ListView的背景透明化
        listView.setSelector(android.R.color.transparent);
        // 设置当前的适配器
        adapter = new HomeAdapter(list);
        // 设置当前的适配器
        listView.setAdapter(adapter);
        return listView;

    }

    @Override
    protected Object requestData() {
        // 得到当前的数据
        String result = HttpUtils.get(Api.Home);
        // -------
        // 直接解析当前的结果
        HomeBean homeBean = JsonUtils.parseJsonToBean(result, HomeBean.class);
        // 设置当前的数据
        list.addAll(homeBean.getList());
        // 更新当前数据
        CommonUtils.runOnUIThread(new Runnable() {

            public void run() {
                // 刷新当前的适配器数据
                adapter.notifyDataSetChanged();
            }
        });
        return homeBean;

    }

}
