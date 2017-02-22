package com.emeraldvision.scheduler;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class NewEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        ActionBar titleBar = getSupportActionBar();
        if (titleBar != null) {
            titleBar.setTitle("Add Event");
        }

        // initialize date as current date
        DateTime start = new DateTime();
        int dateID = R.id.new_event_date;
        String dateString = start.toString(DateTimeFormat.longDate());
        setTextOnView(dateID, dateString);
        TextView dateTextView = (TextView) findViewById(dateID);

        // initialize start as current time
        int startID = R.id.start_time;
        String startString = start.toString(DateTimeFormat.shortTime());
        setTextOnView(startID, startString);

        // initialize end 1 hour after start
        DateTime end = start.plusHours(1);
        int endID = R.id.end_time;
        String endString = end.toString(DateTimeFormat.shortTime());
        setTextOnView(endID, endString);
    }

    // add time to display
    private void setTextOnView(int viewID, String stringID) {
        ((TextView) findViewById(viewID)).setText(stringID);
    }
}