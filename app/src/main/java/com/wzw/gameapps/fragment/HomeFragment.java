package com.wzw.gameapps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wzw.gameapps.global.LoadingPager;

/**
 * Created by wuzhongwei on 2017/2/9.
 */

public class HomeFragment extends BaseFragment {

    //视图加载
    @Override
    protected View getSuccessView() {
        TextView mTextView = new TextView(getActivity());
        mTextView.setText("哟哟切克闹!");
        return mTextView;
    }

    //数据加载
    @Override
    protected Object getLoadData() {
        return null;
    }

}
