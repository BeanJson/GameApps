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

    private Button btn_reload;

    // 需要使用的枚举类型
    enum PageState {
        STATE_LOADING, // 加载中
        STATE_ERROR, // 加载失败
        STATE_SUCCESS// 加载成功
    }

    // 定义当前的默认状态
    private PageState mstate = PageState.STATE_LOADING;

    // 需要使用的三个视图的操作
    private View loadingView;
    private View errorView;
    private View successView;

    // ====【构造方法】======
    public LoadingPager(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // 每一个构造方法当中,都去实现的方法
        initLoadingPage();
    }

    public LoadingPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 每一个构造方法当中,都去实现的方法
        initLoadingPage();
    }

    public LoadingPager(Context context) {
        super(context);
        // 每一个构造方法当中,都去实现的方法
        initLoadingPage();
    }

    /***
     * 初始化当前的视图操作
     */
    private void initLoadingPage() {
        // 定义当前的LayoutParams的状态
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        // 定义当前的进度条的View.视图填充器
        // 判断上面是否是空值
        if (loadingView == null) {
            loadingView = View.inflate(getContext(), R.layout.page_loading,null);
            // 添加到帧布局当中
            addView(loadingView, params);
        }
        // 判断上面的是否是空值
        if (errorView == null) {
            // 创建视图
            errorView = View.inflate(getContext(), R.layout.page_error, null);
            btn_reload = (Button) errorView.findViewById(R.id.btn_reload);
            btn_reload.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mstate = PageState.STATE_LOADING;
                    showPage();
                    //重新调用当前的加载数据刷新的操作
                    LoadDataAndRefreshPage();
                }
            });
        }
        addView(errorView, params);
        if (successView == null) {
            // 需要自己去动态的添加显示的视图操作
            successView = createSuccessView();
        }
        // 判断当前的是否实现了当前的视图
        if (successView == null) {
            throw new IllegalArgumentException(     // 抛出非法参数的异常
                    "The method createSuccessView() can not null");
        } else {
            addView(successView, params);
        }
        showPage();
        LoadDataAndRefreshPage();
    }

    private void showPage() {
        loadingView.setVisibility(View.INVISIBLE);
        errorView.setVisibility(View.INVISIBLE);
        successView.setVisibility(View.INVISIBLE);
        // 分支选择当前的状态
        switch (mstate) {
            case STATE_LOADING:
                loadingView.setVisibility(View.VISIBLE);
                break;
            case STATE_ERROR:
                errorView.setVisibility(View.VISIBLE);
                break;
            case STATE_SUCCESS:
                successView.setVisibility(View.VISIBLE);
                break;
        }
    }

    // 等待着继承的实现构造方法.子类分别去实现各自的视图操作
    public abstract View createSuccessView();

    /***
     * 去服务加载按数据.并且刷新当前的页面
     */
    private void LoadDataAndRefreshPage() {
        // 开启子线程去加载数据
        new Thread() {
            public void run() {
                //测试耗时的操作
                SystemClock.sleep(1500);
                // 加载数据的操作
                Object data = loadData();
                // 得到加载的数据.判断当前的数据是否是空值.根据当前的值去判断是否加载成功
                // 如果当前的结果是空值.那么就是加载失败.
                // 如果当前的结果不是空值.那么就是加载成功.
                mstate = (data == null ? PageState.STATE_ERROR
                        : PageState.STATE_SUCCESS);
                // 得到当前的状态之后.提交当前的数据.在主线程当中,实现界面刷新的操作
                CommonUtils.runOnUIThread(new Runnable() {
                    public void run() {
                        //提交数据到主线程
                        showPage();
                    }
                });
            }
        }.start();
    }
    //加载过程当中实现的方法
    protected abstract Object loadData();


}


