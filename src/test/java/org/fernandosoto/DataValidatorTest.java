package org.fernandosoto;

import org.fernandosoto.business.DataValidator;
import org.fernandosoto.utilitary.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {
    private DataValidator dataValidator;

    @BeforeEach
    public void setUp() {
        dataValidator = new DataValidator();
    }

    @org.junit.jupiter.api.Test
    void isValidPlate() {
        assertTrue(dataValidator.isValidPlate("PBU-1234"));
        assertTrue(dataValidator.isValidPlate("PBU-123"));
    }

    @Test
    void isValidDate() throws ParseException {
        assertTrue(dataValidator.isValidDate("12-12-2024"));
    }

    @Test
    void isValidDateInvalid() throws ParseException {
        assertFalse(dataValidator.isValidDate(""));
        assertFalse(dataValidator.isValidDate(null));
        assertFalse(dataValidator.isValidDate(""));
    }

    @Test
    void isValidHour() throws ParseException {
        assertTrue(dataValidator.isValidHour("19:00"));
        assertTrue(dataValidator.isValidHour("9:00"));
    }

    @Test
    void isValidHourInvalid() throws ParseException {
        assertFalse(dataValidator.isValidHour("19H00"));
        assertFalse(dataValidator.isValidHour(null));
        assertFalse(dataValidator.isValidHour("Hola"));
    }

    @Test
    public void testFormatPlate() {
        String testPlate = "ABC-1234";
        dataValidator.formatPlate(testPlate);

        assertEquals(4, dataValidator.digitPlate);
    }


    @Test
    void formatDate() throws ParseException {
        DataValidator dataValidator = new DataValidator();
        String testDate = "10-30-2023";
        dataValidator.formatDate(testDate);

        assertEquals(1, dataValidator.numberDay);
    }


    @Test
    void formatDateInvalid() throws ParseException {
        String testDate = "Hello";
        ParseException exception = null;
        dataValidator.formatDate(testDate);
        assertNotNull(exception);

    }

    @Test
    void getDay() throws ParseException {
        Date sampleDate = Util.DATE_FORMAT.parse("11-18-2023");
        int numberDay = dataValidator.getDay(sampleDate);

        assertEquals(6, numberDay);
    }

    @Test
    void formatHour() throws ParseException {
        String testHour = "15:30";

        Date result = dataValidator.formatHour(testHour);
        String formattedResult = Util.HOUR_FORMAT.format(result);

        assertEquals(testHour, formattedResult);
    }

    @Test
    public void testFormatHourInvalid() throws ParseException {
        String invalidHour = "70:70";
        ParseException exception = null;
        dataValidator.formatHour(invalidHour);
        assertNotNull(exception);
    }
    */

}