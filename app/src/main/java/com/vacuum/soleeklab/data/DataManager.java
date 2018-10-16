package com.vacuum.soleeklab.data;

import android.provider.ContactsContract;

public class DataManager{


    DataManager(SharedPrefsHelper mSharedPrefsHelper){
        mSharedPrefsHelper.this = mSharedPrefsHelper;
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

    void getLoggedInMode(): Boolean? {
        return mSharedPrefsHelper.loggedInMode;
    }
}