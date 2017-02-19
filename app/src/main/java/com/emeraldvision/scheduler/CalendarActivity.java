package com.emeraldvision.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calendar);

        // list of time IDs
        List<Integer> timeList = Arrays.asList(R.id.time_0, R.id.time_1, R.id.time_2, R.id.time_3,
                R.id.time_4, R.id.time_5, R.id.time_6, R.id.time_7, R.id.time_8, R.id.time_9,
                R.id.time_10, R.id.time_11, R.id.time_12, R.id.time_13, R.id.time_14, R.id.time_15,
                R.id.time_16, R.id.time_17, R.id.time_18, R.id.time_19, R.id.time_20, R.id.time_21,
                R.id.time_22, R.id.time_23, R.id.time_24);

        // add labels to each hour's view
        for (int i = 0; i < 24; i++) {
            setTextOnView(timeList.get(i), i + ":00");
        }

        // create sample event
        DateTime startTime = new DateTime(2017, 9, 7, 3, 54);
        DateTime endTime = new DateTime(2017, 9, 7, 12, 00);
        Event sampleEvent = new Event("sample", startTime, endTime);

        // add single sample event
        addEventToView(timeList, sampleEvent);
    }

    private void addEventToView(List<Integer> timeList, Event event) {
        RelativeLayout relativeLayout;
        relativeLayout = (RelativeLayout) findViewById(R.id.day);
        View eventView = new View(this);
        eventView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        RelativeLayout.LayoutParams eventParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        eventParams.addRule(RelativeLayout.ALIGN_TOP, timeList.get(event.getStartHour()));
        eventParams.addRule(RelativeLayout.ABOVE, timeList.get(event.getEndHour()));
        eventParams.setMargins(getResources().getDimensionPixelSize(R.dimen.hour_width),
                getResources().getDimensionPixelSize(R.dimen.line_height), 0, 0);
        eventView.setLayoutParams(eventParams);
        relativeLayout.addView(eventView);
    }


    // add time to display
    private void setTextOnView(int viewID, String stringID) {
        ((TextView) findViewById(viewID).findViewById(R.id.time)).setText(stringID);
    }


}
