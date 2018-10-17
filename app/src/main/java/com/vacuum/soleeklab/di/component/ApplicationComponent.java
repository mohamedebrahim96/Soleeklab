package com.vacuum.soleeklab.di.component;

import android.app.Application;
import android.content.Context;

import com.vacuum.soleeklab.MvpApp;
import com.vacuum.soleeklab.data.DataManager;
import com.vacuum.soleeklab.di.ApplicationContext;
import com.vacuum.soleeklab.di.module.ApplicationModule;
import com.vacuum.soleeklab.ui.splash.SplashActivity;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {

    /*@Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MvpApp application);
        ApplicationComponent build();
    }
    //void inject(MvpApp app);

    //void inject(SplashActivity splashActivity);
    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();*/
}