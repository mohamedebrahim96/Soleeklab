package com.vacuum.soleeklab;

import android.app.Application;

import com.vacuum.soleeklab.di.component.ApplicationComponent;
import com.vacuum.soleeklab.di.component.DaggerApplicationComponent;

import javax.inject.Inject;

public class MvpApp extends Application {


    private MvpApp Instance;
    private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        initializeDagger();
    }
    private void initializeDagger() {
        Instance = this;
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .application(this)
                .build();
    }
    MvpApp getInstance(){
        return Instance;
    }
    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}