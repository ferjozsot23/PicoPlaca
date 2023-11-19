package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CleanedDataTest {
    private CleanedData cleanedData;
    @BeforeEach
    public void setUp() {
        cleanedData = new CleanedData();
    }
    @org.junit.jupiter.api.Test
    void isValidPlate() {
        assertTrue(cleanedData.isValidPlate("PBU-1234"));
        assertTrue(cleanedData.isValidPlate("PBU-123"));
    }

    @Test
    void isValidDate() {
        assertTrue(cleanedData.isValidDate("12-12-2024"));
    }
    @Test
    void isValidDateInvalid() {
        assertFalse(cleanedData.isValidDate(""));
    }

    @Test
    void isValidHour() {
        assertTrue(cleanedData.isValidHour("19:00"));
        assertTrue(cleanedData.isValidHour("9:00"));
    }

    @Test
    void isValidHourInvalid() {
        assertFalse(cleanedData.isValidHour("19H00"));
    }
    @Test
    public void testFormatPlate() {
        String testPlate = "ABC-1234";
        int result = cleanedData.formatPlate(testPlate);

        assertEquals(4, result);
    }
}