package com.wzw.gameapps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wuzhongwei on 2017/2/9.
 */

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 创建视图的对象
        TextView mTextView = new TextView(getActivity());
        // 设置当前的视图参数
        mTextView.setText(this.getClass().getSimpleName());
        // 返回当前的视图
        return mTextView;

    }
}
