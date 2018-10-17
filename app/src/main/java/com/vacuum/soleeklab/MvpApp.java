package com.vacuum.soleeklab;

import android.app.Application;

import com.vacuum.soleeklab.data.DataManager;
import com.vacuum.soleeklab.data.SharedPrefsHelper;

import javax.inject.Inject;

public class MvpApp extends Application {



    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        /*mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();*/

        //mApplicationComponent.inject(this);

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}