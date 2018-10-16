package com.vacuum.soleeklab;

import android.app.Application;

import java.util.logging.Level;

public class MvpApp extends Application {



    //private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        /*mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();*/

        //mApplicationComponent.inject(this);

    }


}