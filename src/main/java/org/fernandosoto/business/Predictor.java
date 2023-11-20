package org.fernandosoto.business;

import org.fernandosoto.presentation.View;
import org.fernandosoto.utilitary.Util;

import java.text.ParseException;
import java.util.Date;

public class Predictor {
    int digitPlate;
    int numberDay;
    Date hour;
    boolean isRestrictRoad;
    private View view;

    public Predictor(View view) {
        this.view = view;
    }

    // Get the cleaned data
    public void getCleanedData(DataValidator cleaner) {
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
        Date startInterval1, endInterval1, startInterval2, endInterval2;
        try {
            startInterval1 = Util.HOUR_FORMAT.parse("07:00");
            endInterval1 = Util.HOUR_FORMAT.parse("09:30");
            startInterval2 = Util.HOUR_FORMAT.parse("16:00");
            endInterval2 = Util.HOUR_FORMAT.parse("19:30");

        } catch (ParseException e) {
            return false;
        }
        return isInInterval(hour, startInterval1, endInterval1) || isInInterval(hour, startInterval2, endInterval2);
    }

    private void sendResult() {
        view.printResult(isRestrictRoad);
    }

    private boolean isInInterval(Date hour, Date start, Date end) {
        // Checks if an hour is within the range or if it is equal to the lower or upper limit
        return ((hour.equals(start) || (hour.after(start)) && (hour.equals(end) || hour.before(end))));
    }

}
