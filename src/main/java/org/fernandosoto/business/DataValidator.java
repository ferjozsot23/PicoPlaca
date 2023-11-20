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
        if (!isValidData(userPlate, userDate, userHour)) return false;


        digitPlate = formatPlate(userPlate);
        try {
            numberDay = formatDate(userDate);
            formatedHour = formatHour(userHour);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private boolean isValidData(String userPlate, String userDate, String userHour) {
        return isValidPlate(userPlate) && isValidDate(userDate) && isValidHour(userHour);
    }

    // Validate user hour
    public boolean isValidHour(String userHour) {
        if (userHour == null) return false;
        try {
            Util.HOUR_FORMAT.parse(userHour);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    // Validate user date
    public boolean isValidDate(String userDate) {
        if (userDate == null) return false;
        try {
            Util.DATE_FORMAT.parse(userDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    // Validate user plate
    public boolean isValidPlate(String userPlate) {
        if (userPlate == null) return false;
        String pattern = "^[A-Z]{3}-[0-9]{3,4}$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(userPlate);

        return matcher.matches();
    }

    public Date formatHour(String userHour) throws ParseException {
        return Util.HOUR_FORMAT.parse(userHour);
    }

    public int formatDate(String userDate) throws ParseException {
        Date formatedDate = Util.DATE_FORMAT.parse(userDate);
        return getDay(formatedDate);
    }

    public int formatPlate(String userPlate) {
        char charDigitPlate = userPlate.charAt(userPlate.length() - 1);
        return Character.getNumericValue(charDigitPlate);
    }

    public int getDay(Date formatedDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatedDate);
        int numberDay = calendar.get(Calendar.DAY_OF_WEEK);
        return (numberDay + 5) % 7 + 1;
    }
}
