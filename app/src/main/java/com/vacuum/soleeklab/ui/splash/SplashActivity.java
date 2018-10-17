package com.vacuum.soleeklab.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.vacuum.soleeklab.MvpApp;
import com.vacuum.soleeklab.R;
import com.vacuum.soleeklab.data.DataManager;
import com.vacuum.soleeklab.data.SharedPrefsHelper;
import com.vacuum.soleeklab.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity implements SplashMvpView{


    SplashPresenter mSplashPresenter ;
    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);

        //dataManager = new MvpApp().getDatamanager();
        mSplashPresenter = new SplashPresenter(dataManager,this);
        //mSplashPresenter.onAttach(this);
        mSplashPresenter.decideNextActivity();

    }




    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openMainActivity() {
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
    @Override
    public void message() {
        Toast.makeText(this, "null Shaerd prefrences ", Toast.LENGTH_SHORT).show();
    }

}
