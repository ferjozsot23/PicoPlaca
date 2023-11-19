package org.example;


public class View {
    CleanedData cleaner = new CleanedData();
    Predictor predictor = new Predictor(this);
    public void getUserData() {
        // Recieve user data
        // Invoque cleaning data
        // Send cleanded data to Predictor class
    }
    // printResutl()
}
