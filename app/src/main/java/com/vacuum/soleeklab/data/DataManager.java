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
    public void saveEmailId(String Email){
        mSharedPrefsHelper.putEmail(Email);
    }
    public String getEmailId() {
        return mSharedPrefsHelper.getEmail();
    }

    public void setLoggedIn() {
        mSharedPrefsHelper.setLoggedInMode(true);
    }

    public Boolean getLoggedInMode() {
        return mSharedPrefsHelper.loggedInMode();
    }
}