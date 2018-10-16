package com.vacuum.soleeklab.ui.splash;

import android.os.Handler;

import com.vacuum.soleeklab.data.DataManager;

public class SplashPresenter implements SplashMvpPresenter {
    SplashMvpView mvpView;
    DataManager manager;
    public SplashPresenter(SplashMvpView mvpView) {
        this.mvpView = mvpView;
        this.manager = manager;
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
