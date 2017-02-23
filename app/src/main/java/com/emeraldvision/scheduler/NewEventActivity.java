package com.emeraldvision.scheduler;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;


public class NewEventActivity extends AppCompatActivity {

    DateTime start;
    DateTime end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        ActionBar titleBar = getSupportActionBar();
        if (titleBar != null) {
            titleBar.setTitle("Add Event");
        }

        // initialize date as current date
        start = new DateTime();
        final long longTime = start.getMillis();
        int dateID = displayDate();
        View dateView = findViewById(dateID);
        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(longTime);
            }
        });

        // initialize start as current time
        int startID = R.id.start_time;
        String startString = start.toString(DateTimeFormat.shortTime());
        setTextOnView(startID, startString);

        // initialize end 1 hour after start
        end = start.plusHours(1);
        int endID = R.id.end_time;
        String endString = end.toString(DateTimeFormat.shortTime());
        setTextOnView(endID, endString);
    }

    private int displayDate() {
        int dateID = R.id.new_event_date;
        String dateString = start.toString(DateTimeFormat.longDate());
        setTextOnView(dateID, dateString);
        return dateID;
    }

    // add time to display
    private void setTextOnView(int viewID, String stringID) {
        ((TextView) findViewById(viewID)).setText(stringID);
    }

    // show Date Picker
    private void showDatePickerDialog(long longTime) {
        DatePickerFragment dateFragment = new DatePickerFragment();
        Bundle arguments = new Bundle();
        arguments.putLong("longTime", longTime);
        dateFragment.setArguments(arguments);
        dateFragment.show(getSupportFragmentManager(), getString(R.string.datePicker));
        dateFragment.setListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                start = start.withDate(year, month, dayOfMonth);
                displayDate();
            }
        });
    }
}