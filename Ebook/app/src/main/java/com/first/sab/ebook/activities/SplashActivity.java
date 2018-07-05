package com.first.sab.ebook.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.first.sab.ebook.R;

public class SplashActivity extends AppCompatActivity {

    private int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this , CreateActivity.class);
                startActivity(intent);
                finish();
            }
        } ,SPLASH_DISPLAY_LENGTH);
    }



}


