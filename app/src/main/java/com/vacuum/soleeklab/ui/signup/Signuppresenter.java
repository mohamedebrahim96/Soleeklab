package com.vacuum.soleeklab.ui.signup;

public class Signuppresenter implements SignupMvpPresenter {
    private SignupMvpView loginMvpView;


    public Signuppresenter(SignupMvpView loginMvpView) {
        this.loginMvpView = loginMvpView;
    }
    @Override
    public void input(String name,String email ,String password,String phone) {
        /*if(TextUtils.isEmpty(email) || (password.length() < 8) || TextUtils.isEmpty(phone)){
            loginMvpView.showValidationError();
        }
        else {*/
            loginMvpView.login_server();


    }
}
