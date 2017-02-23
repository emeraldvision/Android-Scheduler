package com.emeraldvision.scheduler;

import java.util.ArrayList;

/**
 * Created by Ther on 2/22/2017.
 */

public class EventStorage {

    private ArrayList<Event> eventList;

    private EventStorage() {
        eventList = new ArrayList<>();
    }

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    static private EventStorage instance = new EventStorage();

    public static EventStorage getInstance() {
        return instance;
    }
}
