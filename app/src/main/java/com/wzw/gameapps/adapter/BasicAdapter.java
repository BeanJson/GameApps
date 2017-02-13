package com.wzw.gameapps.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.wzw.gameapps.holder.BaseHolder;

import java.util.ArrayList;

/**
 * Created by wuzhongwei on 2017/2/13.
 */

public abstract class BasicAdapter<T> extends BaseAdapter {

    protected ArrayList<T> list;

    public BasicAdapter(ArrayList<T> list) {
        super();
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseHolder<T> baseHolder = null;
        if (convertView == null) {
            baseHolder = getHolder(position);
        } else {
            baseHolder = (BaseHolder<T>) convertView.getTag();
        }
        baseHolder.bindData(list.get(position));

        return baseHolder.getViewHolder();
    }

    protected abstract BaseHolder<T> getHolder(int position);

}
