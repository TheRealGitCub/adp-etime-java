package com.kobitate.etimejava;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kobi on 7/11/17.
 */
public class WorkDay {
    private String weekDay;
    private String date;
    private ArrayList<WorkBlock> blocks;
    private long hours;

    public WorkDay(String weekDay, String date) {
        this.weekDay = weekDay;
        this.date = date;
        blocks = new ArrayList<WorkBlock>();
        hours = 0;
    }

    public void addBlock(WorkBlock block) {
        blocks.add(block);
        hours += block.getHours();
    }

    public String getWeekDay() {
        return weekDay;
    }


    public String getDate() {
        return date;
    }


    public ArrayList<WorkBlock> getBlocks() {
        return blocks;
    }

    public long getHours() {
        return hours;
    }
}
