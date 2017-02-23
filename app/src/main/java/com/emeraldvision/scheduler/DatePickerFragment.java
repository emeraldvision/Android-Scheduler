package com.emeraldvision.scheduler;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import org.joda.time.DateTime;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    long longDate;
    private DatePickerDialog.OnDateSetListener listener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        longDate = getArguments().getLong("longTime");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the display date as the default date in the picker
        DateTime d = new DateTime(longDate);
        int year = d.getYear();
        int month = d.getMonthOfYear() - 1;  // jodatime uses 1-12 while Android uses 0-11
        int day = d.getDayOfMonth();

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Listen for date choice
        listener.onDateSet(view, year, month + 1, day);   // jodatime uses 1-12 while Android uses 0-11
    }

    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }
}