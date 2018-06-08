package com.example.latte_ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.latte_core.app.AccountManager;
import com.example.latte_ec.database.DatabaseManager;
import com.example.latte_ec.database.UserProfile;

//用于signup上传数据用
public class SignHandler {

    public static void onSignUp(String response, ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        //解析user_profile.jsonz中 data字段
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);

        //已经注册并登录成功
        AccountManager.setSignState(true);
        signListener.onSignUpSuccess();

    }

    public static void onSignIn(String response, ISignListener signListener){
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        //解析user_profile.jsonz中 data字段
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);

        //已经注册并登录成功
        AccountManager.setSignState(true);
        signListener.onSignInSuccess();

    }

}
