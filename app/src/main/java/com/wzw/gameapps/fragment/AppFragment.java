package com.wzw.gameapps.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wuzhongwei on 2017/2/10.
 */
public class AppFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TextView textView=new TextView(getActivity());
        textView.setText(this.getClass().getSimpleName());
        return textView;
    }
}
