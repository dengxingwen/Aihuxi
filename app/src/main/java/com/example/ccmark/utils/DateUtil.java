package com.example.ccmark.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ccmark on 2017/4/14.
 */

public class DateUtil {

    /**
     * 获取制定日期是周几
     */

    public  static String getWeekDay(String datetime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        java.util.Date date = null;
        try {
            date = sdf.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.get(Calendar.WEEK_OF_MONTH);
        date = cl.getTime();
        return sdf.format(date);
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
