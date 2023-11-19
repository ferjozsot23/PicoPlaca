package org.example;

import org.junit.jupiter.api.BeforeEach;

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
}