package com.vacuum.soleeklab.data;

import android.provider.ContactsContract;

public class DataManager{
    SharedPrefsHelper mSharedPrefsHelper;

    DataManager(SharedPrefsHelper mSharedPrefsHelper){
        this.mSharedPrefsHelper = mSharedPrefsHelper;
    }
    void clear(){
        mSharedPrefsHelper.clear();
    }
    void saveEmailId(String Email){
        mSharedPrefsHelper.putEmail(ContactsContract.CommonDataKinds.Email);
    }
    String getEmailId() {
        return mSharedPrefsHelper.email;
    }

    void setLoggedIn() {
        mSharedPrefsHelper.loggedInMode = true;
    }

    Boolean getLoggedInMode() {
        return mSharedPrefsHelper.loggedInMode;
    }
}