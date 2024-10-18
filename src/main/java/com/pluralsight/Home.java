package com.pluralsight;
import java.io.IOException;
import java.util.Scanner;

import static com.pluralsight.Deposit.AddDeposit;
import static com.pluralsight.LedgerScreen.Ledger;
import static com.pluralsight.Payment.MakePayment;
import static com.pluralsight.Quit.Exit;

public class Home {
    static Scanner s = new Scanner(System.in); //initializing scanner
    public static void HomeScreen() throws InterruptedException, IOException {

        System.out.println("\n-----------HOME-----------");

        String ans = ans("\nWelcome to LedgeMaxxer! Thank you for using our service. \n" +
                "\nPlease enter a character that corresponds with one of the options below.\n" +
                "\nD) Add Deposit\n" +
                "P) Make Payment(Debit)\n" +
                "L) Ledger\n" +
                "X) Exit\n" +
                "\nEnter here: "); // displaying home screen and prompting user input

        switch (ans.toUpperCase()){ //switch case (if statements) that will go to a screen based on user input
            case "D":
                AddDeposit(); // calls on deposit screen method to enter deposit
                break;
            case "P":
                MakePayment(); // calls on payment screen method to enter payment
                break;
            case "L":
                Ledger(); // calls on ledeger screen method;
                break;
            case "X":
                Exit(); // calls on method that exits program.
            default:
                System.out.println("\nSorry! We do not have that option. Please input another character.");

                HomeScreen(); // if the user input does not have a method that corresponds it will call on the home screen so the user can see their options and try again.
                break;
        }
    }

    public static String ans(String m){ //anser method that will take in the users next line in console that can be reused whenever a string is needed.
        System.out.println(m);
        return s.nextLine().trim(); // takes next user input
    }
}
