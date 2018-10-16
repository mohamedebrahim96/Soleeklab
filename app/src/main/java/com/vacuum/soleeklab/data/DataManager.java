package com.vacuum.soleeklab.data;

import android.provider.ContactsContract;

public class DataManager{
    SharedPrefsHelper mSharedPrefsHelper;

    public DataManager(SharedPrefsHelper mSharedPrefsHelper){
        this.mSharedPrefsHelper = mSharedPrefsHelper;
    }
    void clear(){
        mSharedPrefsHelper.clear();
    }
    void saveEmailId(String Email){
        mSharedPrefsHelper.putEmail(Email);
    }
    String getEmailId() {
        return mSharedPrefsHelper.getEmail();
    }

    void setLoggedIn() {
        mSharedPrefsHelper.setLoggedInMode(true);
    }

    Boolean getLoggedInMode() {
        return mSharedPrefsHelper.loggedInMode();
    }
}