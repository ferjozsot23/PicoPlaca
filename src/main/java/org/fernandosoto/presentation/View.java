package org.fernandosoto.presentation;


import org.fernandosoto.business.DataValidator;
import org.fernandosoto.business.Predictor;

import java.util.Scanner;

// This class is in charge of interaction with the user
public class View {
    Scanner scanner = new Scanner(System.in);
    DataValidator cleaner = new DataValidator();
    Predictor predictor = new Predictor(this);

    public void getUserData() {
        // Receive user data until the data is cleaned
        String userPlate;
        String userDate;
        String userHour;
        do {
            userPlate = readUserData("Enter the licence plate (ex: PBU-1234): ");
            userDate = readUserData("Enter the date (ex: 11-18-2023): ");
            userHour = readUserData("Enter the time: (19:00): ");

        } while (!cleaner.clean(userPlate, userDate, userHour));
        sendCleanedData(cleaner);
    }

    private void sendCleanedData(DataValidator cleaner) {
        predictor.getCleanedData(cleaner);
    }

    public void printResult(boolean isRestrictRoad) {
        if (isRestrictRoad) {
            System.out.println("Restrict :(");
        } else {
            System.out.println("Allowed to Road :)!");
        }
    }

    private String readUserData(String message) {
        System.out.print(message);
        return scanner.next();
    }
}
