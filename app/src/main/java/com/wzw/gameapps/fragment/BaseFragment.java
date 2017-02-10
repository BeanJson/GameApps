package com.wzw.gameapps.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wzw.gameapps.global.LoadingPager;

/**
 * Created by wuzhongwei on 2017/2/10.
 */

public abstract class BaseFragment extends Fragment {

    private LoadingPager loadingPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loadingPager = new LoadingPager(getActivity()) {
            @Override
            public View createSuccessView() {
                return getSuccessView();
            }

            @Override
            protected Object loadData() {
                return getLoadData();
            }
        };
        return loadingPager;
    }


    protected abstract Object getLoadData();

    protected abstract View getSuccessView();
}
