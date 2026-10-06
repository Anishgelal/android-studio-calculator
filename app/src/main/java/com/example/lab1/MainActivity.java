package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button signupBtn;
    private TextView signupTv;

    private boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Connect XML views with Java variables
        signupBtn = findViewById(R.id.signUpButton);
        signupTv = findViewById(R.id.SignUptv);

        // Short click
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LifeCycleActivity.class);
                startActivity(i);
            }
        });

        // Long click
        signupBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Log.d("SIGNUP_BUTTON", "Sign Up button long clicked!");

                Toast.makeText(
                        MainActivity.this,
                        "SignUp button long pressed",
                        Toast.LENGTH_LONG
                ).show();

                return true;
            }
        });
    }
}