package org.fernandosoto.business;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fernandosoto.utilitary.Util;


// This class validate the user data
public class DataValidator {
    public int digitPlate;
    public int numberDay;
    public Date formatedHour;

    public boolean clean(String userPlate, String userDate, String userHour) {
        if (isValidData(userPlate, userDate, userHour)) {
            formatData(userPlate, userDate, userHour);
            return true;
        }
        return false;
    }

    private void formatData(String userPlate, String userDate, String userHour) {
        try {
            formatPlate(userPlate);
            formatDate(userDate);
            formatHour(userHour);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean isValidData(String userPlate, String userDate, String userHour) {
        try {
            return isValidPlate(userPlate) && isValidDate(userDate) && isValidHour(userHour);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    // Validate user hour
    public boolean isValidHour(String userHour) throws ParseException {
        if (userHour == null) return false;
        Util.HOUR_FORMAT.parse(userHour);
        return true;
    }

    // Validate user date
    public boolean isValidDate(String userDate) throws ParseException {
        if (userDate == null) return false;
        Util.DATE_FORMAT.parse(userDate);
        return true;

    }

    // Validate user plate
    public boolean isValidPlate(String userPlate) {
        if (userPlate == null) return false;
        String pattern = "^[A-Z]{3}-[0-9]{3,4}$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(userPlate);

        return matcher.matches();
    }

    public void formatHour(String userHour) throws ParseException {
        formatedHour = Util.HOUR_FORMAT.parse(userHour);
    }

    public void formatDate(String userDate) throws ParseException {
        Date formatedDate = Util.DATE_FORMAT.parse(userDate);
        numberDay = getDay(formatedDate);
    }

    public void formatPlate(String userPlate) {
        char charDigitPlate = userPlate.charAt(userPlate.length() - 1);
        digitPlate = Character.getNumericValue(charDigitPlate);
    }

    public int getDay(Date formatedDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatedDate);
        int numberDay = calendar.get(Calendar.DAY_OF_WEEK);
        return (numberDay + 5) % 7 + 1;
    }
}
