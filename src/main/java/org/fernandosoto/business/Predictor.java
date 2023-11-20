package org.fernandosoto.business;

import org.fernandosoto.presentation.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Predictor {
    int digitPlate;
    int numberDay;
    Date hour;
    boolean isRestrictRoad;
    private View view;
    // This class determine if a road is restricted based on licence plate, day and hour
    public Predictor(View view) {this.view = view;}

    // Get the cleaned data
    public void getCleanedData(DataValidator cleaner) {
        digitPlate = cleaner.digitPlate;
        numberDay = cleaner.numberDay;
        hour = cleaner.formatedHour;

        calculateRestrictedRoad();
    }

    // Calculate restricted-road based on day and hour
    private void calculateRestrictedRoad() {
        isRestrictRoad = isRestrictedDay(digitPlate, numberDay) && isRestrictedHour(hour);
        sendResult();
    }

    public boolean isRestrictedDay(int digitPlate, int day) {
        // If the digit plate is 0 and day 5 then the road is going to be restricted
        if (day == 5 && digitPlate == 0) return true;
        // If the day multiplied by two, or the day multiplied by two minus 1 is equal to the last digit of the license,
        // then the road will be restricted.
        if (day * 2 == digitPlate || day * 2 - 1 == digitPlate) return true;
        return false;
    }

    public boolean isRestrictedHour(Date hour) {
        Date startInterval1, endInterval1, startInterval2, endInterval2;

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        try {
            startInterval1 = timeFormat.parse("06:00");
            endInterval1 = timeFormat.parse("09:30");
            startInterval2 = timeFormat.parse("16:00");
            endInterval2 = timeFormat.parse("20:00");

        } catch (ParseException e) {
            return  false;
        }
        // The road will be restricted if it is within the hour intervals
        return isInInterval(hour, startInterval1, endInterval1) || isInInterval(hour, startInterval2, endInterval2);
    }
    private void sendResult() {
        view.printResult(isRestrictRoad);
    }
    private boolean isInInterval(Date hour, Date start, Date end) {
        // Checks if a time is within the range or if it is equal to the lower or upper limit
        return ((hour.equals(start) || (hour.after(start)) && (hour.equals(end) || hour.before(end))));
    }

}
