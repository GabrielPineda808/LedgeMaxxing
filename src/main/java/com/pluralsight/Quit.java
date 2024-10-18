package com.pluralsight;

public class Quit {
    public static void Exit() throws InterruptedException {

        Thread.sleep(500); // delays the output

        System.out.println("\nThank you for using LedgeMaxxing! Please use our app again!");

        Thread.sleep(500);

        System.exit(0); // shuts down the program after displaying goodbye message

    }
}
