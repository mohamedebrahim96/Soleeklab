package com.vacuum.soleeklab.ui.splash;

import android.os.Handler;

import com.vacuum.soleeklab.data.DataManager;

public class SplashPresenter implements SplashMvpPresenter {
    SplashMvpView mvpView;
    DataManager manager;
    public SplashPresenter(DataManager manager,SplashMvpView mvpView) {
        this.mvpView = mvpView;
        this.manager = manager;
        //manager.saveEmailId("ebrahimm131@gmail.com");
    }



    @Override
    public void decideNextActivity() {
        if (manager.getEmailId()!=null){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mvpView.openMainActivity();
                }
            }, 5000);
        }else {
            mvpView.message();
        }


    }
}
