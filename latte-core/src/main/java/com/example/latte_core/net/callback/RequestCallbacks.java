package com.example.latte_core.net.callback;

import android.os.Handler;

import com.example.latte_core.ui.loader.LatteLoader;
import com.example.latte_core.ui.loader.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//给retrofit用的callback
public class RequestCallbacks implements Callback<String> {
    private final  IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    private static final Handler HANDLER = new Handler();//用于延迟测试loading

    public RequestCallbacks(IRequest REQUEST, ISuccess SUCCESS, IFailure FAILURE, IError ERROR, LoaderStyle LOADER_STYLE) {
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
        this.FAILURE = FAILURE;
        this.ERROR = ERROR;
        this.LOADER_STYLE = LOADER_STYLE;
    }
    //  retrofit的callback中方法
    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if(response.isSuccessful()){
            if(call.isExecuted()){
                if(SUCCESS != null){
                    SUCCESS.onSucess(response.body());//回调给ExampleDelegate
                }
            }
        }else {
            if(ERROR != null){
                ERROR.onError(response.code(),response.message());
            }
        }
        stopLoading();

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if(FAILURE != null){
            FAILURE.onFailure();
        }

        if(REQUEST != null){
            REQUEST.onResquestEnd();
        }

        stopLoading();
    }

    private void stopLoading(){
        if(LOADER_STYLE != null){
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            },0);
        }
    }
}
