package com.vacuum.soleeklab.ui.splash;

import android.os.Handler;

public class SplashPresenter implements SplashMvpPresenter {
    SplashMvpView mvpView;
    public SplashPresenter(SplashMvpView mvpView) {
        this.mvpView = mvpView;
    }



    @Override
    public void decideNextActivity() {
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                mvpView.openMainActivity();
            }
        }, 5000);

    }
}
