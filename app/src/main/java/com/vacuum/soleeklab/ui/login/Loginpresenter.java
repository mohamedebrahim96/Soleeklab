package com.vacuum.soleeklab.ui.login;

import android.text.TextUtils;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vacuum.soleeklab.utils.AppConstants;

public class Loginpresenter implements LoginMvpPresenter{
    private LoginMvpView loginMvpView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(AppConstants.DB_NAME);

    public Loginpresenter(LoginMvpView loginMvpView) {
        this.loginMvpView = loginMvpView;
    }
    @Override
    public void input(String name, String password,String phone) {
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(password) || TextUtils.isEmpty(phone)){
            loginMvpView.showValidationError();
        }
        else {
            myRef.child(AppConstants.KEY_NAME).setValue(name);
            myRef.child(AppConstants.KEY_PASS).setValue(password);
            myRef.child(AppConstants.KEY_PHONE).setValue(phone);
            myRef.push();
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    loginMvpView.inputuccess();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    loginMvpView.inputError();
                    Log.e("onCancelled: ", databaseError.toString());
                }
            });
        }
    }
}
