package com.wzw.gameapps.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.wzw.gameapps.R;
import com.wzw.gameapps.fragment.FragmentFactory;
import com.wzw.gameapps.util.CommonUtils;

/**
 * Created by wuzhongwei on 2017/2/10.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private String[] tabs;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        tabs = CommonUtils.getStringArray(R.array.tab_name);
    }


    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
