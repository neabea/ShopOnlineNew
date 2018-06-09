package com.example.latte_core.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import com.example.latte_core.app.Latte;

import java.util.logging.Handler;

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener{

    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //进行一些网络请求
                REFRESH_LAYOUT.setRefreshing(false);//关闭下拉动画
            }
        },2000);


    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
