package com.wzw.gameapps.global;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.wzw.gameapps.R;
import com.wzw.gameapps.util.CommonUtils;

/**
 * Created by wuzhongwei on 2017/2/10.
 */

public abstract class LoadingPager extends FrameLayout {

    //定义3种状态常量
    enum PageState {
        STATE_LOADING,//加载中的状态
        STATE_ERROR,//加载失败的状态
        STATE_SUCCESS;//加载成功的状态
    }

    private PageState mState = PageState.STATE_LOADING;//表示界面当前的state，默认是加载中
    private View loadingView;
    private View errorView;
    private View successView;


    public LoadingPager(Context context) {
        super(context);
        initLoadingPage();
    }

    public LoadingPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLoadingPage();
    }

    public LoadingPager(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLoadingPage();
    }

    /**
     * 天然地往LoadingPage中添加3个view
     */
    private void initLoadingPage() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        //1.依次添加3个view对象
        if (loadingView == null) {
            loadingView = View.inflate(getContext(), R.layout.page_loading, null);
        }
        addView(loadingView, params);

        if (errorView == null) {
            errorView = View.inflate(getContext(), R.layout.page_error, null);
            Button btn = (Button) errorView.findViewById(R.id.btn_reload);

            btn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //1、先显示loadingView，请求数据
                    mState = PageState.STATE_LOADING;
                    showPage();
                    //2、错误页面点击按钮刷新数据
                    loadDataAndRefreshPage();
                }
            });
        }
        addView(errorView, params);

        if (successView == null) {
            successView = createSuccessView();//需要不固定的successView
        }
        if (successView == null) {
            throw new IllegalArgumentException("The method createSuccessView() can not return null!");
        } else {
            addView(successView, params);
        }
        //2.显示默认的loadingView
        showPage();
        //3.去请求数据然后刷新page
        loadDataAndRefreshPage();
    }

    /**
     * 根据当前的mState显示对应的View
     */
    private void showPage() {
        //1.先隐藏所有的view
        loadingView.setVisibility(View.INVISIBLE);
        errorView.setVisibility(View.INVISIBLE);
        successView.setVisibility(View.INVISIBLE);
        //2.谁的状态谁显示
        switch (mState) {
            case STATE_LOADING://加载中的状态
                loadingView.setVisibility(View.VISIBLE);
                break;
            case STATE_ERROR://加载失败的状态
                errorView.setVisibility(View.VISIBLE);
                break;
            case STATE_SUCCESS://加载成功的状态
                successView.setVisibility(View.VISIBLE);
                break;
        }
    }
    //多种行视图
    //求情数据，根据请求的数据刷新界面
    public void loadDataAndRefreshPage() {
        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                Object data = loadData();//驱使loadData方法的回调
                //当前状态是否为空 ，空位error 有值success
                mState = (data == null ? PageState.STATE_ERROR : PageState.STATE_SUCCESS);
                CommonUtils.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        showPage();//更新UI在子线程的主线程方法里面执行
                    }
                });
            }
        }.start();
    }

    //加载的数据
    protected abstract Object loadData();

    //获取SuccessView，因为每个请求成功的界面的数据都不一样，所以由每个页面自己获取对应的数据
    public abstract View createSuccessView();
}



