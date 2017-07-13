package com.kobitate.etimejava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by christopher-tate on 7/13/17.
 */
public class WorkWeek {
    private HashMap<String, WorkDay> week;
    private String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    public WorkWeek() {
        week = new HashMap<String, WorkDay>();
        for(String day : days) {
            week.put(day, new WorkDay(day));
        }
    }
    public WorkDay get(String day) {
        return week.get(day);
    }
    public void addBlockToDay(WorkBlock block, String day) {
        week.get(day).addBlock(block);
    }
}
