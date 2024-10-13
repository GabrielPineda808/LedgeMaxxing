package com.pluralsight;

import java.io.IOException;

import static com.pluralsight.Home.*;
import static com.pluralsight.Quit.Exit;

public class Deposit {
    public static void AddDeposit() throws InterruptedException, IOException {

        Thread.sleep(500);

        System.out.println("\nYou are on the Add Deposit Screen!" +
                "\nEnter h (Return to home) or x (Exit app) at any time!");

        System.out.println("\nPlease have the deposit description, vendor, and amount at the ready." +
                "\nIf using a custom date and time have please have that ready as well." );

        String dt = ans("\nWould you like to use a custom date and time for this deposit? Enter yes or no: " ).toUpperCase();

        switch (dt) {
            case "YES":
                System.out.println("Custom");
                break;
            case "NO":
                System.out.println("System");
                break;
            case "H":
                HomeScreen();
                break;
            case "X":
                Exit();
                break;
            default:
                System.out.println("Sorry! That was not a proper choice. Try again!");

        }

    }
}
