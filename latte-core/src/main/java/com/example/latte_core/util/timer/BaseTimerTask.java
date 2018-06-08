package com.example.latte_core.util.timer;

import java.util.TimerTask;

//用于实现启动页时间
public class BaseTimerTask extends TimerTask {

    private ITimeListener mITimerListener = null;

    public BaseTimerTask(ITimeListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if(mITimerListener != null){
            mITimerListener.onTimer();
        }
    }
}
