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
        // Validate the user data
        if (!isValidData(userPlate, userDate, userHour)) return false;

        // Format the validated user data
        digitPlate = formatPlate(userPlate);
        try {
            numberDay = formatDate(userDate);
            formatedHour = formatHour(userHour);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    // Invokes the three validations for user data
    private boolean isValidData(String userPlate, String userDate, String userHour) {
        return isValidPlate(userPlate) && isValidDate(userDate) && isValidHour(userHour);
    }

    // Validate user hour
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
    // Validate user date
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
    // Validate user plate
    public boolean isValidPlate(String userPlate) {
        if (userPlate == null) return false;
        // Uses regex for match a valid license plate
        String pattern = "^[A-Z]{3}-[0-9]{3,4}$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(userPlate);

        return matcher.matches();
    }
    // Format an hour in a date form
    public Date formatHour(String userHour) throws ParseException {
        HOUR_FORMAT.setLenient(false);
        return HOUR_FORMAT.parse(userHour);
    }
    // Format a date extracting the number of week of this day
    public int formatDate(String userDate) throws ParseException {
        Date formatedDate = DATE_FORMAT.parse(userDate);
        return getDay(formatedDate);
    }
    // Format a license plate extracting its last digit
    public int formatPlate(String userPlate) {
        char charDigitPlate = userPlate.charAt(userPlate.length() - 1);
        return Character.getNumericValue(charDigitPlate);
    }

    // Get the number of week of a day
    public int getDay(Date formatedDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatedDate);
        int numberDay = calendar.get(Calendar.DAY_OF_WEEK);
        return (numberDay + 5) % 7 + 1;
    }
}
