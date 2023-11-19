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
    private void calculateRestrictedRoad() {
        isRestrictRoad = isRestrictedDay(digitPlate, numberDay) && isRestrictedHour(hour);
        sendResult();
    }
    public boolean isRestrictedDay(int digitPlate, int day) {
        if (day == 5 && digitPlate == 0) return true;
        if (day * 2 == digitPlate || day * 2 - 1 == digitPlate) return true;
        return false;
    }

    public boolean isRestrictedHour(Date hour) {
        return false;
    }



}
