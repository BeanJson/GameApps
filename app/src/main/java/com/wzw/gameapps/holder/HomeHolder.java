package com.wzw.gameapps.holder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.wzw.gameapps.R;
import com.wzw.gameapps.bean.AppInfoBean;
import com.wzw.gameapps.global.MyApplication;

/**
 * Created by wuzhongwei on 2017/2/13.
 */

public class HomeHolder extends BaseHolder<AppInfoBean> {
    // 定义需要加载的TextView
    private View holderView;
    private TextView tv_size, tv_des, tv_name;
    private ImageView iv_icon;
    private RatingBar rb_star;


    @Override
    protected View initViewHolder() {
        // 得到当前的加载视图
        holderView = View.inflate(MyApplication.getContext(),
                R.layout.fragment_home_list, null);
        // 初始化当前需要加载的视图
        tv_des = (TextView) holderView.findViewById(R.id.tv_des);
        tv_size = (TextView) holderView.findViewById(R.id.tv_size);
        tv_name = (TextView) holderView.findViewById(R.id.tv_name);
        iv_icon = (ImageView) holderView.findViewById(R.id.iv_icon);
        rb_star = (RatingBar) holderView.findViewById(R.id.rb_star);

        return holderView;

    }

    @Override
    public void bindData(AppInfoBean bean) {
        // 设置当前的数据
        tv_name.setText(bean.getName());
        tv_size.setText(Formatter.formatFileSize(
                MyApplication.getContext(), bean.getSize()));
        tv_des.setText(bean.getDes());
        rb_star.setRating(bean.getStars());

    }
}
