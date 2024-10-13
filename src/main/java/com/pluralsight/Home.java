package com.pluralsight;
import java.io.IOException;
import java.util.Scanner;

import static com.pluralsight.Deposit.AddDeposit;
import static com.pluralsight.LedgerScreen.Ledger;
import static com.pluralsight.Payment.MakePayment;
import static com.pluralsight.Quit.Exit;

public class Home {
    static Scanner s = new Scanner(System.in);
    public static void HomeScreen() throws InterruptedException, IOException {

        String ans = ans("\nWelcome to LedgeMaxxer! Thank you for using our service. \n" +
                "Please enter a character that corresponds with one of the options below.\n" +
                "D) Add Deposit\n" +
                "P) Make Payment(Debit)\n" +
                "L) Ledger\n" +
                "X) Exit\n" +
                "Enter here: ");

        switch (ans.toUpperCase()){
            case "D":
                AddDeposit();
                break;
            case "P":
                MakePayment();
                break;
            case "L":
                Ledger();
                break;
            case "X":
                Exit();
            default:
                Thread.sleep(400);
                System.out.println("\nSorry! We do not have that option. Please input another character.");
                Thread.sleep(700);
                HomeScreen();
                break;
        }
    }

    public static String ans(String m){
        System.out.println(m);
        return s.nextLine();
    }

}
