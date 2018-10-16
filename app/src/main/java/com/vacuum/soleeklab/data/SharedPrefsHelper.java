package com.vacuum.soleeklab.data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefsHelper {
    SharedPreferences mSharedPreferences;
    Context mContext;

    //Consistant
    private final String MY_PREFS = "Soleek";
    private final String EMAIL = "Email";
    private final String loggedInMode  = "IS_LOGGED_IN";

    public SharedPrefsHelper(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences = mContext.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
    }


    String getEmail(){
        return  mSharedPreferences.getString(EMAIL,null);
    }

    Boolean loggedInMode(){
        return  mSharedPreferences.getBoolean(loggedInMode, false);
    }
    void setLoggedInMode(Boolean loggedIn){
        mSharedPreferences.edit().putBoolean(loggedInMode, loggedIn).apply();
    }

    void clear() {
            mSharedPreferences.edit().clear().apply();
    }

    void putEmail(String email) {
            mSharedPreferences.edit().putString(EMAIL, email).apply();
    }

}
