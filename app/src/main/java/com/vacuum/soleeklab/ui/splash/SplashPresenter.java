package com.vacuum.soleeklab.ui.splash;

import android.os.Handler;


public class SplashPresenter implements SplashMvpPresenter {
    SplashMvpView mvpView;

    public SplashPresenter(SplashMvpView mvpView) {
        this.mvpView = mvpView;
        //manager.saveEmailId("ebrahimm131@gmail.com");
    }


    @Override
    public void decideNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mvpView.openMainActivity();
            }
        }, 5000);
    }

}
