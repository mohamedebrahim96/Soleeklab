package com.vacuum.soleeklab.data;

import android.database.Observable;

import com.vacuum.soleeklab.data.prefs.PreferencesHelper;

public interface DataManager extends PreferencesHelper{

    void updateApiHeader(Long userId, String accessToken);

    void setUserAsLoggedOut();

    void updateUserInfo(
            String accessToken,
            Long userId,
            Boolean loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    boolean LoggedInMode();
}