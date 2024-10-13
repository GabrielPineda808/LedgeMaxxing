package com.pluralsight;
import java.util.Scanner;
public class LedgeMaxxing {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        HomeScreen();
    }

    public static void HomeScreen(){
        System.out.println("Welcome to LedgeMaxxer! Thank you for using our service. \n" +
                "Please enter a character that corresponds with one of the options below.\n" +
                "D) Add Deposit\n" +
                "P) Make Payment(Debit)\n" +
                "L) Ledger\n" +
                "X) Exit\n" +
                "Thank you!");

        String ans = s.nextLine();
    }
}
