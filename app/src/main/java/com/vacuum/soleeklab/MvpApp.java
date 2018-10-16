package com.vacuum.soleeklab;

import android.app.Application;
import android.content.Context;

import com.vacuum.soleeklab.data.DataManager;
import com.vacuum.soleeklab.data.SharedPrefsHelper;

import java.util.logging.Level;

public class MvpApp extends Application {


    public DataManager dataManager;
    //private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        /*mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();*/

        //mApplicationComponent.inject(this);

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);

    }

    /*public DataManager getDatamanager(){
        return dataManager;
    }*/

}