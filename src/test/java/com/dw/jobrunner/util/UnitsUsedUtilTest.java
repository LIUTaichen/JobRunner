package com.dw.jobrunner.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class UnitsUsedUtilTest {
    @Test
    public void getUnitsUsed() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        assertEquals(1, UnitsUsedUtil.getUnitsUsed(sdf.parse("06/12/2017")), 0.000001);
        assertEquals(0.0, UnitsUsedUtil.getUnitsUsed(sdf.parse("10/12/2017")), 0.000001);
        assertEquals(0.5,UnitsUsedUtil.getUnitsUsed(sdf.parse("09/12/2017")), 0.000001);
        assertEquals(1, UnitsUsedUtil.getUnitsUsed(sdf.parse("04/12/2017")), 0.000001);
        assertEquals(1, UnitsUsedUtil.getUnitsUsed(sdf.parse("08/12/2017")), 0.000001);
    }

}