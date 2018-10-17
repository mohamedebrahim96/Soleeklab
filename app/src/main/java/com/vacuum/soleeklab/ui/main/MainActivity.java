package com.vacuum.soleeklab.ui.main;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.vacuum.soleeklab.R;
import com.vacuum.soleeklab.data.network.APIClient;
import com.vacuum.soleeklab.data.network.ApiInterface;
import com.vacuum.soleeklab.data.network.model.Country;
import com.vacuum.soleeklab.ui.login.LoginActivity;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private Button log_out;
    private RecyclerView recyclerView;
    private final static String TAG = "SOLEEK";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        api();
    }

    private void api() {

        ApiInterface apiService =
                APIClient.getClient().create(ApiInterface.class);

        Call<List<Country>> call = apiService.getAllCountries();
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                List<Country> countries = response.body();
                Log.e(TAG, "countries array" + countries.size());
                recyclerView.setAdapter(new CountryAdapter(countries, getApplicationContext()));

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void initview() {
        log_out =  findViewById(R.id.log_out);
        recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        auth = FirebaseAuth.getInstance();
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signout();
            }
        });

    }
    private void signout() {
        auth.signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
}
