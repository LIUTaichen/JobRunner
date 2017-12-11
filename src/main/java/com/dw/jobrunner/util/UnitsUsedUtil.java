package com.dw.jobrunner.util;

import java.util.Calendar;
import java.util.Date;

public class UnitsUsedUtil {

    public static Double getUnitsUsed(Date targetDate){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(targetDate);
            if(calendar.get(Calendar.DAY_OF_WEEK) == 1){
                return 0.0;
            }else if(calendar.get(Calendar.DAY_OF_WEEK) == 7){
                return 0.5;
            }
            else {
                return 1.0;
            }
    }
}
