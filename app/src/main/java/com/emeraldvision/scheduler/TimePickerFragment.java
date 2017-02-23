package com.emeraldvision.scheduler;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TimePicker;

import org.joda.time.DateTime;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    long longDate;
    private TimePickerDialog.OnTimeSetListener listener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        longDate = getArguments().getLong("longTime");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the display time as the default time in the picker
        DateTime d = new DateTime(longDate);
        int hour = d.getHourOfDay();
        int minute = d.getMinuteOfHour();

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {
        // Listen for time choice
        listener.onTimeSet(view, hour, minute);
    }

    public void setListener(TimePickerDialog.OnTimeSetListener listener) {
        this.listener = listener;
    }

}