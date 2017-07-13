package com.kobitate.etimejava;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kobi on 7/11/17.
 */
public class WorkDay {
    private String weekDay;
    //private Date date;
    private ArrayList<WorkBlock> blocks;
    private long hours;

    public WorkDay(String weekDay) {
        this.weekDay = weekDay;
        //this.date = date;
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

    /*
    public Date getDate() {
        return date;
    }
    */

    public ArrayList<WorkBlock> getBlocks() {
        return blocks;
    }

    public long getHours() {
        return hours;
    }
}
