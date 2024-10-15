package com.pluralsight;

import java.io.IOException;

import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.ans;
import static com.pluralsight.LedgerScreen.Ledger;

public class Reports {
    public static void reports() throws IOException, InterruptedException {
        System.out.println("\nYou are on the Ledger Screen!" +
                "\nEnter h (Return to home) or x (Exit app) at any time!");

        System.out.println("Please enter one of the following options: " +
                "\n1 ) Month to Date" +
                "\n2 ) Previous Month" +
                "\n3 ) Year to Date" +
                "\n4 ) Previous Year" +
                "\n5 ) Search by Vendor" +
                "\n0 ) Return to Ledger Screen");
        String choice = ans("\nEnter here:").toUpperCase();
        inputChecker(choice);
        switch (choice){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "0":
                Ledger();
                break;


        }
    }
}
