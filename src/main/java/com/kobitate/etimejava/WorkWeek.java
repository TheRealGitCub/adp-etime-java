package com.kobitate.etimejava;

/**
 * Created by TheRealGitCub on 7/11/17.
 */


import java.util.HashMap;

public class WorkWeek {
    private HashMap<String, WorkDay> week;
    private String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    private double totalHours = 0;

    public WorkWeek(String startDate) {
        week = new HashMap<String, WorkDay>();
        String date = startDate;
        for(String day : days) {
            week.put(day, new WorkDay(day, date));

            String[] dateSplit = date.split("/");
            // via https://stackoverflow.com/a/28295733/1465353
            String dayOfMonth = dateSplit[1].replaceAll("(^\\h*)|(\\h*$)","");
            date = dateSplit[0] + "/" + (Integer.valueOf(dayOfMonth) +1 );
        }
    }
    public WorkDay get(String day) {
        return week.get(day);
    }
    public void addBlockToDay(WorkBlock block, String day) {
        week.get(day).addBlock(block);
        totalHours += block.getHours();
    }

    public double getTotalHours() {
        return totalHours;
    }
}
