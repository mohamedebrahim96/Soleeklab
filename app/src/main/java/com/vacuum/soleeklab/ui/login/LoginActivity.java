package com.vacuum.soleeklab.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.vacuum.soleeklab.R;
import com.vacuum.soleeklab.ui.main.MainActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class LoginActivity extends AppCompatActivity implements LoginMvpView {

    TextView password_Edit,email_Edit;
    Button mButtonInput;
    Loginpresenter presenter;
    private FirebaseAuth firebase;
    private LottieAnimationView animation_view_fullname, animation_view_password, animation_view_email;

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
        validateFields2();
        firebase = FirebaseAuth.getInstance();
        mButtonInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.input(password_Edit.getText().toString().trim()
                        , email_Edit.getText().toString().trim());
            }
        });
    }

    private void initView(){
        email_Edit =  findViewById(R.id.email);
        password_Edit =  findViewById(R.id.password);
        mButtonInput =  findViewById(R.id.buttonRegister);
        presenter = new Loginpresenter(this);
        animation_view_email = findViewById(R.id.animation_view_email);
        animation_view_password = findViewById(R.id.animation_view_password);
    }

    private void validateFields2() {
        email_Edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (email_Edit.getText().toString().contains("@") && email_Edit.getText().toString().contains(".com")) {
                    animation_view_email.setAnimation(R.raw.success);
                    animation_view_email.playAnimation();
                } else {
                    animation_view_email.setProgress(0);
                }
            }
        });
        password_Edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                if (password_Edit.getText().length() >= 8) {
                    animation_view_password.setAnimation(R.raw.success);
                    animation_view_password.playAnimation();
                } else {
                    animation_view_password.setProgress(0);
                    password_Edit.setError("less than 8");

                }
            }
        });
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
                            Toast.makeText(LoginActivity.this, "auth_failed", Toast.LENGTH_LONG).show();
                        } else {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

    }
}
