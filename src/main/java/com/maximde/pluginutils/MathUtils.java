package com.maximde.pluginutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MathUtils {
    /**
     * Return true with a specific chance
     * @param percentChance example: 0.5F = 50%
     * @return boolean
     */
    public static boolean ifRandomPercent(float percentChance) {
        if(percentChance > 1.0F || percentChance <= 0) {
            throw new IllegalArgumentException("Percent must be between 1.0 and 0.000...1");
        }
        Random random = new Random();
        float randomFloat = random.nextFloat();
        return !(randomFloat > percentChance);
    }

    /**
     * @return Nice formated time as a String
     * Example: 15th of November Time: 13:03
     */
    public static String getCurrentTimeFormated() {
        String finalData = "Error";
        DateFormat dateFormatTime = new SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();
        int month = cal.get(2) + 1;
        String monthString;
        switch (month) {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:
                monthString = "March";
                break;
            case 4:
                monthString = "April";
                break;
            case 5:
                monthString = "May";
                break;
            case 6:
                monthString = "June";
                break;
            case 7:
                monthString = "July";
                break;
            case 8:
                monthString = "August";
                break;
            case 9:
                monthString = "September";
                break;
            case 10:
                monthString = "October";
                break;
            case 11:
                monthString = "November";
                break;
            case 12:
                monthString = "December";
                break;
            default:
                monthString = "Error";
        }

        finalData = cal.get(5) + "th of " + monthString + " " + cal.get(1) + " Time: " + dateFormatTime.format(cal.getTime());
        return finalData;
    }

    public static Long secondsToNanos(long seconds) {
        return TimeUnit.SECONDS.toNanos(seconds);
    }

    public static long nanosToSeconds(long nanos) {
        return TimeUnit.NANOSECONDS.toSeconds(nanos);
    }
}
