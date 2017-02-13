package com.wzw.gameapps.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wzw.gameapps.global.LoadingPager;
import com.wzw.gameapps.util.CommonUtils;

/**
 * Created by wuzhongwei on 2017/2/10.
 */

public abstract class BaseFragment extends Fragment {

    protected LoadingPager loadingPage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (loadingPage == null) {
            loadingPage = new LoadingPager(getActivity()) {
                @Override
                public Object loadData() {
                    return requestData();
                }
                @Override
                public View createSuccessView() {
                    return getSuccessView();
                }
            };
        } else {
            CommonUtils.removeSelfFromParent(loadingPage);
        }
        return loadingPage;
    }

    protected abstract View getSuccessView();

    protected abstract Object requestData();
}
