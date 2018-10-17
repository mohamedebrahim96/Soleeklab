package com.vacuum.soleeklab.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vacuum.soleeklab.R;
import com.vacuum.soleeklab.ui.main.MainActivity;
import com.vacuum.soleeklab.ui.splash.SplashActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class LoginActivity extends AppCompatActivity implements LoginMvpView {

    TextView full_name,password,phone,email;
    Button mButtonInput;
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
        mButtonInput = (Button) findViewById(R.id.buttonRegister);
        presenter = new Loginpresenter(this);
    }

    @Override
    public void showValidationError() {
        Toast.makeText(this, "input not valid", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void inputuccess() {
        Toast.makeText(this, "succes", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

    @Override
    public void inputError() {
        Toast.makeText(this, "input error", Toast.LENGTH_SHORT).show();

    }
}
