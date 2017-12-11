package com.dw.jobrunner.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class DateTimeUtilTest {
    @Test
    public void getEndOfWeekDate() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date endOfWeekDate = DateTimeUtil.getEndOfWeekDate(new Date());
        assertEquals("10/12/2017", sdf.format(DateTimeUtil.getEndOfWeekDate(sdf.parse("06/12/2017"))));
        assertEquals("10/12/2017", sdf.format(DateTimeUtil.getEndOfWeekDate(sdf.parse("10/12/2017"))));
        assertEquals("03/12/2017", sdf.format(DateTimeUtil.getEndOfWeekDate(sdf.parse("03/12/2017"))));
        assertEquals("10/12/2017", sdf.format(DateTimeUtil.getEndOfWeekDate(sdf.parse("04/12/2017"))));
    }


}