package com.kobitate.etimejava;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kobi on 7/11/17.
 */
public class WorkBlock {
    private Date timeIn;
    private Date timeOut;
    private long hours;

    DateFormat format = new SimpleDateFormat("h:ma");

    public WorkBlock(String timeIn, String timeOut) {

        try {
            this.timeIn = format.parse(timeIn);
            this.timeOut = format.parse(timeOut);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = this.timeOut.getTime() - this.timeIn.getTime();
        this.hours = diff / (60 * 60 * 1000);

    }

    public WorkBlock(String timeIn) {

        DateFormat format = new SimpleDateFormat("h:ma");

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

    public long getHours() {
        return hours;
    }
}
