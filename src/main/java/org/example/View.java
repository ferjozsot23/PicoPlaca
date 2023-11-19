package org.example;


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
            userPlate = readString("Enter the licence plate (ex: PBU-1234): ");
            userDate = readString("Enter the date (ex: 11-18-2023): ");
            userHour = readString("Enter the time: (19:00): ");

        } while (!cleaner.clean(userPlate, userDate, userHour));
        
        // Send cleaned data to Predictor class
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
    
    // Function for read user input
    private String readString(String message){
        System.out.print(message);
        return scanner.next();
    }
}
