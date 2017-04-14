package com.example.ccmark.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by ccmark on 2017/4/9.
 */

public final class Custom {

    /**
     * 获取当前日期
     * 2017-04-08
     * @return
     */
    public static String getNowDataStr(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }

    /**
     * 获取当前日期
     * 2017-04-08
     * @return
     */
    public static String getNowDataMonthStr(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }

    /**
     * @param timeStr
     * @return int hour
     */
    public static int getHour(String timeStr) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-DD-dd HH:mm:ss").parse(timeStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取制定日期是周几
     */

    public static String getWeekDay(String datetime, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.DAY_OF_MONTH, -day);
        date = cl.getTime();

        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");

        String week = dateFm.format(date);
        return week;

    }


    /**
     * 获取前x天日期
     */
    public static String getLastDay(String datetime, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        java.util.Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.DAY_OF_MONTH, -day);
        date = cl.getTime();
        return sdf.format(date);
    }


}
