package com.dw.jobrunner.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

    public static Date getEndOfWeekDate(Date targetDate){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(targetDate);
        //calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        Date adate = new Date();
        if(day == 1){
            return targetDate;
        }else{
            calendar.add(Calendar.DAY_OF_MONTH, 8 - day);
            return calendar.getTime();
        }

    }
}
