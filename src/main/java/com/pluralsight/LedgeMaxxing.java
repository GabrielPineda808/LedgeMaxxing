package com.pluralsight;
import java.util.Scanner;
public class LedgeMaxxing {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        HomeScreen();
    }

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
            case "A":
                AddDeposit();
                break;
            default:
                System.out.println("Sorry! We do not have that option. Please input another character.");
                HomeScreen();
        }
    }

    public static void AddDeposit(){
        System.out.println("Add Deposit Screen");
    }
}
