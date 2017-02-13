package com.wzw.gameapps.holder;

import android.view.View;

/**
 * Created by wuzhongwei on 2017/2/13.
 */

public abstract class BaseHolder<T> {

    public View viewHolder;

    public BaseHolder() {
        viewHolder = initViewHolder();
        viewHolder.setTag(this);
    }

    protected abstract View initViewHolder();

    public abstract void bindData(T data);

    public View getViewHolder() {
        return viewHolder;
    }
}
