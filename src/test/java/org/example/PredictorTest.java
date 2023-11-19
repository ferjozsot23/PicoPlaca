package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class PredictorTest {
    Predictor predictor;
    @BeforeEach
    public void setUp() {
        predictor = new Predictor(new View());
    }
    @Test
    void isRestrictedDay_Restricted() {
        int digitPlate = 6;
        int day = 3;
        assertTrue(predictor.isRestrictedDay(digitPlate, day));
    }

    @Test
    void isRestrictedDay_NoRestricted() {
        int digitPlate = 6;
        int day = 4;
        assertFalse(predictor.isRestrictedDay(digitPlate, day));
    }
}