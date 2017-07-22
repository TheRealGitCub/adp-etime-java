package com.kobitate.etimejava;

/**
 * Created by TheRealGitCub on 7/11/17.
 */


import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Timecard {
    private HashMap<String, WorkDay> week;
    private double totalHours = 0;

    /**
     * Constructs new work week
     */
    public Timecard() {
        week = new HashMap<>();
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
     * @param day day in the format SUN 12/31
     */
    public void addBlockToDay(WorkBlock block, String day) {
        WorkDay workDay;
        if (!week.containsKey(day)) {
            String[] daySplit = day.split(" ");
            workDay = new WorkDay(daySplit[0], daySplit[1]);
        }
        else {
            workDay = week.get(day);
        }
        workDay.addBlock(block);
        totalHours += block.getHours();
    }

    public boolean clockedIn() {
		String todayKey = getTodayKey();
		if (week.containsKey(todayKey)) {
			WorkDay todayWorkDay = week.get(todayKey);
			for (WorkBlock block : todayWorkDay.getBlocks()) {
				if (block.getTimeOut() == null) {
					return true;
				}
			}
		}

		return false;
	}

	public String getTodayKey() {
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MM/dd");
		String todayKey = dateFormat.format(today);
		return todayKey;
	}

    /**
     * Get total number of hours worked this week
     * @return hours worked in a decimal format, calculated by ADP
     */
    public double getTotalHours() {
        return totalHours;
    }
}
