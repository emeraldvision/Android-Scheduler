package com.emeraldvision.scheduler;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        ActionBar titleBar = getSupportActionBar();
        if (titleBar != null) {
            titleBar.setTitle("Add Event");
        }
    }
}