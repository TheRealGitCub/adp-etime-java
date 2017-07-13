package com.kobitate.etimejava;

/**
 * Created by TheRealGitCub on 7/11/17.
 */


import java.util.ArrayList;
import java.util.Date;

public class WorkDay {
    private String weekDay;
    private String date;
    private ArrayList<WorkBlock> blocks;
    private double hours;

    /**
     * Constructs a new work day
     * @param weekDay day of week, should be: SUN, MON, TUE, WED, THU, FRI, or SAT
     * @param date date in the format MM/DD (provided by ADP)
     */
    public WorkDay(String weekDay, String date) {
        this.weekDay = weekDay;
        this.date = date;
        blocks = new ArrayList<WorkBlock>();
        hours = 0;
    }

    /**
     * Add a new work block to this day
     * @param block new block with hours
     */
    public void addBlock(WorkBlock block) {
        blocks.add(block);
        hours += block.getHours();
    }

    /**
     * Get this work day
     * @return day of week as: SUN, MON, TUE, WED, THU, FRI, or SAT
     */
    public String getWeekDay() {
        return weekDay;
    }

    /**
     * Get this date
     * @return date in the format MM/DD
     */
    public String getDate() {
        return date;
    }

    /**
     * Get all blocks saved to this date
     * @return an ArrayList of blocks
     */
    public ArrayList<WorkBlock> getBlocks() {
        return blocks;
    }

    /**
     * Get total number of hours worked on this day
     * @return hours worked, calculated by ADP, in decimal format
     */
    public double getHours() {
        return hours;
    }
}
