package com.vacuum.soleeklab.ui.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vacuum.soleeklab.R;

public class SplashActivity extends AppCompatActivity implements SplashMvpView{


    SplashPresenter mSplashPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashPresenter = SplashPresenter(SplashMvpView());
        //mSplashPresenter.onAttach(this);
        mSplashPresenter.decideNextActivity();

    }




    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openMainActivity() {

    }
}
