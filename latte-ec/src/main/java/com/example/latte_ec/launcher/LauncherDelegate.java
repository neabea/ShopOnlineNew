package com.example.latte_ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.latte_core.app.AccountManager;
import com.example.latte_core.app.IUserChecker;
import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.ui.launcher.ILauncherListener;
import com.example.latte_core.ui.launcher.ScrollLauncherTag;
import com.example.latte_core.ui.launcher.onLauncherFinishTag;
import com.example.latte_core.util.storage.LattePreference;
import com.example.latte_core.util.timer.BaseTimerTask;
import com.example.latte_core.util.timer.ITimeListener;
import com.example.latte_ec.R;
import com.example.latte_ec.R2;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

public class LauncherDelegate extends LatteDelegate implements ITimeListener{

    @BindView(R2.id.tv_launcher_timer)
    TextView mTvTimer = null;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView(){
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }

    private Timer mTimer = null;
    private int mCount = 5;
    private ILauncherListener mILauncherListener = null;

    private void initTimer(){
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task,0,1000);//任务，马上开始，每隔1秒
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof ILauncherListener){
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mTvTimer != null){
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
            }
            }
        });
    }

    //判断是否显示滑动启动页
    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            //检查用户是否登录了APP
            AccountManager.checkAccout(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if(mILauncherListener!=null){
                        mILauncherListener.onLauncherFinish(onLauncherFinishTag.SIGNED);
                    }
                }

                @Override
                public void onNotSignIn() {
                    if(mILauncherListener!=null){
                        mILauncherListener.onLauncherFinish(onLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });

        }
    }

}
