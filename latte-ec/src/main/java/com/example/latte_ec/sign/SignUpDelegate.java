package com.example.latte_ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.latte_core.delegates.LatteDelegate;
import com.example.latte_core.net.RestClient;
import com.example.latte_core.net.callback.ISuccess;
import com.example.latte_core.util.log.LatteLogger;
import com.example.latte_ec.R;
import com.example.latte_ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText mRePassword = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink() {
        start(new SignInDelegate());
    }

    @OnClick(R2.id.btn_sign_up)
    void onClickSignUp() {
        if(checkForm()){
            RestClient.builder()
                    .url("http://192.168.3.3:8000/RestServer/api/user_profile.php")
                    .params("name", mName.getText().toString())
                    .params("email", mEmail.getText().toString())
                    .params("phone", mPhone.getText().toString())
                    .params("password", mPassword.getText().toString())
                      .success(new ISuccess() {
                          @Override
                          public void onSucess(String response) {
                              LatteLogger.json("USER_PROFILE", response);
                              SignHandler.onSignUp(response);
                          }
                      })
                    .build()
                    .post();
            Toast.makeText(getContext(),"格式全对",Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkForm(){//用于校验BindView值
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String password = mPassword.getText().toString();
        final String repassword = mRePassword.getText().toString();

        boolean isPass = true;

        if(name.isEmpty()){
            mName.setError("请输入姓名");
            isPass = false;
        }else {
            mName.setError(null);
        }

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("错误邮箱格式");
            isPass = false;
        }else {
            mEmail.setError(null);
        }

        if(phone.isEmpty()||phone.length()!=11){
            mPhone.setError("电话号码错误");
            isPass = false;
        }else {
            mPhone.setError(null);
        }

        if(password.isEmpty()||password.length()<6){
            mPassword.setError("密码错误");
            isPass = false;
        }else {
            mPassword.setError(null);
        }

        if(repassword.isEmpty()||repassword.length()<6 || !(repassword.equals(password))){
            mRePassword.setError(" 密码验证错误");
            isPass = false;
        }else {
            mRePassword.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
