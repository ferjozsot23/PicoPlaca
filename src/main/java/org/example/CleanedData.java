package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanedData {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
    private static final SimpleDateFormat HOUR_FORMAT = new SimpleDateFormat("HH:mm");
    int digitPlate;
    int numberDay;
    Date formatedHour;

    // Cleaning involves validate and format the data
    public boolean clean(String userPlate, String userDate, String userHour) {
        if (!isValidData(userPlate, userDate, userHour)) return false;
        digitPlate = formatPlate(userPlate);
        try {
            numberDay = formatDate(userDate);
            formatedHour = formatHour(userHour);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    Date formatHour(String userHour) {
        return null;
    }

    public int formatDate(String userDate) throws ParseException {
        Date formatedDate = DATE_FORMAT.parse(userDate);
        return getDay(formatedDate);
    }

    public int getDay(Date formatedDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatedDate);
        int numberDay = calendar.get(Calendar.DAY_OF_WEEK);
        return (numberDay + 5) % 7 + 1;
    }

    public int formatPlate(String userPlate) {
        char charDigitPlate = userPlate.charAt(userPlate.length() - 1);
        return Character.getNumericValue(charDigitPlate);
    }

    private boolean isValidData(String userPlate, String userDate, String userHour) {
        return isValidPlate(userPlate) && isValidDate(userDate) && isValidHour(userHour);
    }

    public boolean isValidHour(String userHour) {
        HOUR_FORMAT.setLenient(false);
        if (userHour == null) return false;
        try {
            HOUR_FORMAT.parse(userHour);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isValidDate(String userDate) {
        DATE_FORMAT.setLenient(false);
        if (userDate == null) return false;
        try {
            DATE_FORMAT.parse(userDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isValidPlate(String userPlate) {
        if (userPlate == null) return false;

        String pattern = "^[A-Z]{3}-[0-9]{3,4}$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(userPlate);

        return matcher.matches();
    }


}
