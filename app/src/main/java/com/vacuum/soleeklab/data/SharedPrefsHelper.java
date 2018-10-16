package com.vacuum.soleeklab.data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefsHelper {
    SharedPreferences mSharedPreferences;

    Context mContext;
    private final String MY_PREFS = "Soleek";
    private final String EMAIL = "Email";

    SharedPrefsHelper(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences = mContext.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
    }


    String getEmail(){
        return  mSharedPreferences.getString(EMAIL,null);
    }

    Boolean loggedInMode(){
        return  mSharedPreferences.getBoolean("IS_LOGGED_IN", false);
    }

        get() = mSharedPreferences.getBoolean("IS_LOGGED_IN", false)
        set(loggedIn) = mSharedPreferences.edit().putBoolean("IS_LOGGED_IN", loggedIn).apply()



        void clear() {
            mSharedPreferences.edit().clear().apply();
        }

        void putEmail(String email) {
            mSharedPreferences.edit().putString(EMAIL, email).apply();
        }

}
