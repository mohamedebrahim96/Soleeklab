package com.vacuum.soleeklab.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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

public class LoginActivity extends AppCompatActivity implements LoginMvpView {

    TextView full_name,password_Edit,phone,email_Edit;
    Button mButtonInput;
    Loginpresenter presenter;
    private FirebaseAuth firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebase = FirebaseAuth.getInstance();
        if (firebase.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
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
    @Override
    public void login_server() {

        final String email = email_Edit.getText().toString().trim();
        final String password = password_Edit.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }


        //authenticate user
        firebase.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                inputPassword.setError(getString(R.string.minimum_password));
                            } else {
                                Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

    }
}
