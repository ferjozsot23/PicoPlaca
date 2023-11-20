package org.fernandosoto;

import org.fernandosoto.business.Predictor;
import org.fernandosoto.presentation.View;
import org.fernandosoto.utilitary.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PredictorTest {
    Predictor predictor;

    @BeforeEach
    public void setUp() {
        predictor = new Predictor(new View());
    }

    @Test
    void test_isRestrictedDay_Restricted() {
        int digitPlate = 6;
        int day = 3;
        assertTrue(predictor.isRestrictedDay(digitPlate, day));
    }

    @Test
    void test_isRestrictedDay_NoRestricted() {
        int digitPlate = 6;
        int day = 4;
        assertFalse(predictor.isRestrictedDay(digitPlate, day));
    }

    @Test
    void test_isRestrictedHour_Restricted() throws ParseException {
        // Hour limits of interval one
        Date hour_lim_inf1 = Util.HOUR_FORMAT.parse("7:00");
        Date hour_lim_sup1 = Util.HOUR_FORMAT.parse("9:30");
        // Hour limits of interval two
        Date hour_lim_inf2 = Util.HOUR_FORMAT.parse("16:00");
        Date hour_lim_sup2 = Util.HOUR_FORMAT.parse("19:30");

        assertTrue(predictor.isRestrictedHour(hour_lim_inf1));
        assertTrue(predictor.isRestrictedHour(hour_lim_sup1));
        assertTrue(predictor.isRestrictedHour(hour_lim_inf2));
        assertTrue(predictor.isRestrictedHour(hour_lim_sup2));
    }

    @Test
    void test_isRestrictedHour_NoRestricted() throws ParseException {
        // Hour limits of interval one
        Date hour_lim_inf1 = Util.HOUR_FORMAT.parse("06:59");
        Date hour_lim_sup1 = Util.HOUR_FORMAT.parse("9:31");
        // Hour limits of interval two
        Date hour_lim_inf2 = Util.HOUR_FORMAT.parse("15:59");
        Date hour_lim_sup2 = Util.HOUR_FORMAT.parse("19:29");

        assertFalse(predictor.isRestrictedHour(hour_lim_inf1));
        assertFalse(predictor.isRestrictedHour(hour_lim_sup1));
        assertFalse(predictor.isRestrictedHour(hour_lim_inf2));
        assertFalse(predictor.isRestrictedHour(hour_lim_sup2));
    }
}