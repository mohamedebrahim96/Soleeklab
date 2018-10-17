package com.vacuum.soleeklab.ui.login;

import android.text.TextUtils;
import com.google.firebase.auth.FirebaseAuth;

public class Loginpresenter implements LoginMvpPresenter{
    private LoginMvpView loginMvpView;


    public Loginpresenter(LoginMvpView loginMvpView) {
        this.loginMvpView = loginMvpView;
    }
    @Override
    public void input(String email ,String password) {
        /*if(TextUtils.isEmpty(email) || (password.length() < 8) || TextUtils.isEmpty(phone)){
            loginMvpView.showValidationError();
        }
        else {*/
            loginMvpView.login_server();


    }
}
