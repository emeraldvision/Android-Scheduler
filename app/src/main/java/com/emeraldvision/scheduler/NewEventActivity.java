package com.emeraldvision.scheduler;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import static com.emeraldvision.scheduler.R.id.end_time;
import static com.emeraldvision.scheduler.R.id.start_time;


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

        // initialize date and times
        start = new DateTime();
        end = start.plusHours(1);

        // set up views
        setupDateView();
        setupStartTimeView(start_time);
        setupEndTimeView(end_time);
    }

    private void setupStartTimeView(int timeID) {
        displayTime(timeID, start);
        View timeView = findViewById(timeID);
        timeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartTimePickerDialog(start.getMillis());
            }
        });
    }

    private void setupEndTimeView(int timeID) {
        displayTime(timeID, end);
        View timeView = findViewById(timeID);
        timeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEndTimePickerDialog(end.getMillis());
            }
        });
    }

    private void displayTime(int timeID, DateTime time) {
        String startString = time.toString(DateTimeFormat.shortTime());
        setTextOnView(timeID, startString);
    }

    private void setupDateView() {
        int dateID = displayDate();
        View dateView = findViewById(dateID);
        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(start.getMillis());
            }
        });
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

    // show date picker
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

    // show start time picker
    private void showStartTimePickerDialog(long longTime) {
        TimePickerFragment timeFragment = new TimePickerFragment();
        Bundle arguments = new Bundle();
        arguments.putLong("longTime", longTime);
        timeFragment.setArguments(arguments);
        timeFragment.show(getSupportFragmentManager(), getString(R.string.timePicker));
        timeFragment.setListener(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                start = start.withTime(hour, minute, 0, 0);
                displayTime(start_time, NewEventActivity.this.start);
            }
        });
    }

    // show end time picker
    private void showEndTimePickerDialog(long longTime) {
        TimePickerFragment timeFragment = new TimePickerFragment();
        Bundle arguments = new Bundle();
        arguments.putLong("longTime", longTime);
        timeFragment.setArguments(arguments);
        timeFragment.show(getSupportFragmentManager(), getString(R.string.timePicker));
        timeFragment.setListener(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                end = end.withTime(hour, minute, 0, 0);
                displayTime(end_time, NewEventActivity.this.end);
            }
        });
    }

}