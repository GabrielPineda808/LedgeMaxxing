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

        String description = ans("\nPlease enter a description for your deposit: ");

        String vendor = ans("\nPlease enter the vendor for your deposit");

        String amount = ans("Please enter the amount for your deposit");

        String dt = ans("\nWould you like to use a custom date and time for this deposit? Enter yes or no: " ).toUpperCase();

        if(dt.equals("YES")){
            String d = ans("\nPlease enter the custom date for your deposit in MM-DD-YYYY format: ");
            String t = ans("\nPlease enter the custom time for your deposit in HH:MM format: ");
        }

    }


}
