package com.vacuum.soleeklab.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.vacuum.soleeklab.R;
import com.vacuum.soleeklab.ui.main.MainActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class SignupActivity extends AppCompatActivity implements SignupMvpView {

    TextView full_name,password_Edit,phone,email_Edit;
    Button mButtonInput;
    Signuppresenter presenter;
    private FirebaseAuth firebase;

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
        firebase = FirebaseAuth.getInstance();
        mButtonInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.input(full_name.getText().toString().trim()
                        , password_Edit.getText().toString().trim()
                        , email_Edit.getText().toString().trim()
                        , phone.getText().toString().trim());
            }
        });
    }

    private void initView(){
        full_name =  findViewById(R.id.full_name);
        email_Edit =  findViewById(R.id.email);
        password_Edit =  findViewById(R.id.password);
        phone =  findViewById(R.id.phone);
        mButtonInput =  findViewById(R.id.buttonRegister);
        presenter = new Signuppresenter(this);
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
    @Override
    public void login_server() {

        String email = email_Edit.getText().toString().trim();
        String password = password_Edit.getText().toString().trim();
        firebase.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignupActivity.this, "Welcome, "+full_name.toString().trim(), Toast.LENGTH_SHORT).show();
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "failed" + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                            Log.e("FIRE",task.getException().toString());
                        } else {
                            startActivity(new Intent(SignupActivity.this, MainActivity.class));
                            finish();
                        }
                    }
                });
    }
}
