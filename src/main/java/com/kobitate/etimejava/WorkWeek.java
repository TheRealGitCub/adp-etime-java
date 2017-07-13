package com.kobitate.etimejava;

/**
 * Created by TheRealGitCub on 7/11/17.
 */


import java.util.HashMap;

public class WorkWeek {
    private HashMap<String, WorkDay> week;
    private String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    private double totalHours = 0;

    /**
     * Constructs new work week
     * @param startDate date the week starts on, in the format MM/DD (provided by ADP)
     */
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

    /**
     * get a specific day
     * @param day day of the week as: SUN, MON, TUE, WED, THU, FRI, or SAT
     * @return a workday object for the specified day
     */
    public WorkDay get(String day) {
        return week.get(day);
    }

    /**
     * Add a new block to a specific day
     * @param block a new block with hour(s)
     * @param day day of the week as: SUN, MON, TUE, WED, THU, FRI, or SAT
     */
    public void addBlockToDay(WorkBlock block, String day) {
        week.get(day).addBlock(block);
        totalHours += block.getHours();
    }

    /**
     * Get total number of hours worked this week
     * @return hours worked in a decimal format, calculated by ADP
     */
    public double getTotalHours() {
        return totalHours;
    }
}
