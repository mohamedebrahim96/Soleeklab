package com.vacuum.soleeklab.di.module;


import android.app.Application;
import android.content.Context;

import com.vacuum.soleeklab.MvpApp;
import com.vacuum.soleeklab.data.AppDataManager;
import com.vacuum.soleeklab.data.DataManager;
import com.vacuum.soleeklab.data.prefs.AppPreferencesHelper;
import com.vacuum.soleeklab.data.prefs.PreferencesHelper;
import com.vacuum.soleeklab.di.ApplicationContext;
import com.vacuum.soleeklab.di.PreferenceInfo;
import com.vacuum.soleeklab.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return (PreferencesHelper) appPreferencesHelper;
    }







}