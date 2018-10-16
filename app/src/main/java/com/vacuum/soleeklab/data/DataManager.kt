package com.vacuum.mvp3.data

import android.provider.ContactsContract

class DataManager{


    DataManager(SharedPrefsHelper mSharedPrefsHelper){
        mSharedPrefsHelper.this = mSharedPrefsHelper;
    }
    void clear(){
        mSharedPrefsHelper.clear();
    }
    void saveEmailId(Email:String){
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
