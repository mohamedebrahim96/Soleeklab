package com.vacuum.soleeklab.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vacuum.soleeklab.R;

public class LoginActivity extends AppCompatActivity implements LoginMvpView {

    TextView full_name,password,phone,email;
    Button mButtonInput;
    View mView;
    Loginpresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/brownregular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        initView();
        mButtonInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.input(full_name.getText().toString().trim()
                        , password.getText().toString().trim()
                        , phone.getText().toString().trim());
            }


        });

    }

    private void initView(){
        full_name = (TextView) findViewById(R.id.full_name);
        password = (TextView) findViewById(R.id.password);
        phone = (TextView) findViewById(R.id.phone);
        mButtonInput = (Button) findViewById(R.id.mButtonInput);
        mView = findViewById(R.id.view);
        presenter = new Loginpresenter(this);
    }

    @Override
    public void showValidationError() {
        Snackbar.make(mView,getResources().getString(R.string.input_not_valid),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void inputuccess() {
        Snackbar.make(mView,getResources().getString(R.string.input_succes),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void inputError() {
        Snackbar.make(mView,getResources().getString(R.string.input_error),Snackbar.LENGTH_SHORT).show();
    }
}
