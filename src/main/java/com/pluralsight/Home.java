package com.pluralsight;
import java.util.Scanner;

import static com.pluralsight.Deposit.AddDeposit;

public class Home {
    static Scanner s = new Scanner(System.in);
    public static void HomeScreen(){
        System.out.print("Welcome to LedgeMaxxer! Thank you for using our service. \n" +
                "Please enter a character that corresponds with one of the options below.\n" +
                "D) Add Deposit\n" +
                "P) Make Payment(Debit)\n" +
                "L) Ledger\n" +
                "X) Exit\n" +
                "Enter here: ");

        String ans = s.nextLine();
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
                System.out.println("Sorry! We do not have that option. Please input another character.");
                HomeScreen();
        }
    }


}
