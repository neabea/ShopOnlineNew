package com.example.latte_core.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.latte_core.R;
import com.example.latte_core.util.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

public class LatteLoader {

    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;

    private static final String DEFAUT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();

    public static void showLoading(Context context,String type){
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreater.create(type,context);
        dialog.setContentView(avLoadingIndicatorView);

        int deviceHeight = DimenUtil.getScreenHeight();
        int deviceWidth = DimenUtil.getScreenWidth();

        final Window dialogWindow = dialog.getWindow();
        if(dialogWindow != null){
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;//缩8倍
            lp.height = deviceHeight / LOADER_SIZE_SCALE;
            lp.height = lp.height +  deviceHeight / LOADER_OFFSET_SCALE;//偏移量
            lp.gravity= Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();

    }
    public static void showLoading(Context context, Enum<LoaderStyle> type) {
        showLoading(context, type.name());
    }
    public  static  void showLoading(Context context){
        showLoading(context,DEFAUT_LOADER);
    }

    public static void stopLoading(){
        for(AppCompatDialog dialog : LOADERS){
            if(dialog != null){
                if(dialog.isShowing()){
                    dialog.cancel();//会执行回调 dismiss不会
                }
            }
        }
    }

}
