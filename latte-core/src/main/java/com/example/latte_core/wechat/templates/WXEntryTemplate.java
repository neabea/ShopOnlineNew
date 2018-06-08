package com.example.latte_core.wechat.templates;

import com.example.latte_core.acitivities.ProxyActivity;
import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.wechat.BaseWXEntryActivity;
import com.example.latte_core.wechat.LatteWeChat;

//实际微信返回的activity 需要设置成透明的，在Manifest操作 ,导入自动生成的WXEntryTemplate
public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0,0); //  取消动画
    }
}
