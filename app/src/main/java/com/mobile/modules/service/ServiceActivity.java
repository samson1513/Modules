package com.mobile.modules.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.mobile.modules.R;

/**
 * Created by Alex Michenko
 */
public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent service = new Intent(this, ForService.class);
        ContextCompat.startForegroundService(this, service);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent service = new Intent(this, ForService.class);
        stopService(service);
    }
}
