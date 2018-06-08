package com.example.latte_core.app;

import android.text.BoringLayout;

import com.example.latte_core.util.storage.LattePreference;
//用户账户信息类
public class AccountManager {
    private enum SignTag{
        SIGN_TAG
    }
    // 保存用户登录状态
    public static void setSignState(boolean state){
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(),state);
    }

    private static Boolean isSignIn(){
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccout(IUserChecker checker){
        if(isSignIn()){
            checker.onSignIn();
        }else {
            checker.onNotSignIn();
        }
    }

}
