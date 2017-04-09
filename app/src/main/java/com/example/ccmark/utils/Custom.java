package com.example.ccmark.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ccmark on 2017/4/9.
 */

public final class Custom {

    private Custom(){

    }

//    /**
//     * 时间转换
//     */
//
//   public static int convertDataFormate(String datastr){
//
//       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//       try {
//           Date date = simpleDateFormat.parse(datastr);
//
//       } catch (ParseException e) {
//           e.printStackTrace();
//       }
//
//       return 1;
//   }

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

}
