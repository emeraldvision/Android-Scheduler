package com.emeraldvision.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTextOnView(R.id.time_0, R.string.time_0);
        setTextOnView(R.id.time_1, R.string.time_1);
        setTextOnView(R.id.time_2, R.string.time_2);
        setTextOnView(R.id.time_3, R.string.time_3);
        setTextOnView(R.id.time_4, R.string.time_4);
        setTextOnView(R.id.time_5, R.string.time_5);
        setTextOnView(R.id.time_6, R.string.time_6);
        setTextOnView(R.id.time_7, R.string.time_7);
        setTextOnView(R.id.time_8, R.string.time_8);
        setTextOnView(R.id.time_9, R.string.time_9);
        setTextOnView(R.id.time_10, R.string.time_10);
        setTextOnView(R.id.time_11, R.string.time_11);
        setTextOnView(R.id.time_12, R.string.time_12);
        setTextOnView(R.id.time_13, R.string.time_13);
        setTextOnView(R.id.time_14, R.string.time_14);
        setTextOnView(R.id.time_15, R.string.time_15);
        setTextOnView(R.id.time_16, R.string.time_16);
        setTextOnView(R.id.time_17, R.string.time_17);
        setTextOnView(R.id.time_18, R.string.time_18);
        setTextOnView(R.id.time_19, R.string.time_19);
        setTextOnView(R.id.time_20, R.string.time_20);
        setTextOnView(R.id.time_21, R.string.time_21);
        setTextOnView(R.id.time_22, R.string.time_22);
        setTextOnView(R.id.time_23, R.string.time_23);
    }

    private void setTextOnView(int viewID, int stringID) {
        ((TextView)findViewById(viewID).findViewById(R.id.time)).setText(stringID);
    }


}
