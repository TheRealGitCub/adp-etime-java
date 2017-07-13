package com.kobitate.etimejava;

/**
 * Created by TheRealGitCub on 7/11/17.
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkBlock {
    private Date timeIn;
    private Date timeOut;
    private double hours;

    DateFormat format = new SimpleDateFormat("hh:mma");

    public WorkBlock(String timeIn, String timeOut, String hours) {

        try {
            this.timeIn = format.parse(timeIn);
            this.timeOut = format.parse(timeOut);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String[] hoursSplit = hours.split(":");
        double calcHours = Double.valueOf(hoursSplit[0]);
        double calcMinutes = Double.valueOf(hoursSplit[1]);

        calcHours += (calcMinutes/60);

        this.hours = calcHours;

    }

    public WorkBlock(String timeIn) {

        try {
            this.timeIn = format.parse(timeIn);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.timeOut = null;
        this.hours = 0;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public double getHours() {
        return hours;
    }
}
