package org.example;

import java.util.Date;

public class Predictor {
    int digitPlate;
    int numberDay;
    Date hour;
    boolean isRestrictRoad;
    private View view;
    public Predictor(View view) {this.view = view;}

    public void getCleanedData(CleanedData cleaner) {
        digitPlate = cleaner.digitPlate;
        numberDay = cleaner.numberDay;
        hour = cleaner.formatedHour;

        calculateRestrictedRoad();
    }
    // getCleanedData
    // calculateRestrictRoad
    //-->isValidDay and --> isValidHour
    // sendResult()
}
