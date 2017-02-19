package com.emeraldvision.scheduler;

import org.joda.time.DateTime;

public class Event {
    private String name;
    private DateTime startTime;
    private DateTime endTime;

    public Event(String name, DateTime startTime, DateTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public int getStartHour() {
        return startTime.getHourOfDay();
    }

    public int getEndHour() {
        return endTime.getHourOfDay();
    }

}
