package com.example.lab1;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_life_cycle);
        Log.d("LifecycleActivity", "onCreate() called");}

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycleActivity","onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycleActivity","onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("LifecycleActivity", "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycleActivity","onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycleActivity","onDestroy() called");
    }
}

