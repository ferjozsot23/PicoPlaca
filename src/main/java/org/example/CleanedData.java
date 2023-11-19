package org.example;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanedData {

    // Cleaning involves validate and format the data
    public boolean clean(String userPlate, String userDate, String userHour) {
        if (!isValidData(userPlate, userDate, userHour)) {
            return false;
        }
        return true;
    }

    private boolean isValidData(String userPlate, String userDate, String userHour) {
        return isValidPlate(userPlate) && isValidDate(userDate);
    }

    public boolean isValidDate(String userDate) {
        return true;
    }

    public boolean isValidPlate(String userPlate) {
        if (userPlate == null) return false;

        String pattern = "^[A-Z]{3}-[0-9]{3,4}$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(userPlate);

        return matcher.matches();
    }


}
