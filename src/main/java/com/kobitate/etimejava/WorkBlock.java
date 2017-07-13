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

    /**
     * Constructor, creates already-completed work block
     * @param timeIn Time clocked in, in the format 1:00PM (provided by ADP)
     * @param timeOut Time clocked out, in the format 1:00PM (provided by ADP)
     * @param hours Total hours worked, in the format HH:MM (provided by ADP)
     */
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

    /**
     * Constructor, creates in-progress work block
     * @param timeIn Time clocked in, in the format 1:00PM (provided by ADP)
     */
    public WorkBlock(String timeIn) {

        try {
            this.timeIn = format.parse(timeIn);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.timeOut = null;
        this.hours = 0;
    }

    /**
     * Get Time clocked in
     * @return time clocked in as Date object
     */
    public Date getTimeIn() {
        return timeIn;
    }

    /**
     * Get Time clocked out
     * @return time clocked out as Date object
     */
    public Date getTimeOut() {
        return timeOut;
    }

    /**
     * Get total hours worked
     * @return Hours worked as a double, calculated by ADP
     */
    public double getHours() {
        return hours;
    }
}
