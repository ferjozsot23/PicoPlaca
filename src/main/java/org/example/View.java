package org.example;


import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    CleanedData cleaner = new CleanedData();
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

    private void sendCleanedData(CleanedData cleaner) {
        predictor.getCleanedData(cleaner);
    }


    // printResult()
    
    // Function for read user input
    private String readString(String message){
        System.out.print(message);
        return scanner.next();
    }
}
