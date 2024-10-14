package com.pluralsight;

import static com.pluralsight.Home.ans;

public class LedgerScreen {
    public static void main(String[] args) {
        Ledger();
    }
    public static void Ledger(){
        System.out.println("\nYou are on the Make Payment Screen!" +
                "\nEnter h (Return to home) or x (Exit app) at any time!");

        System.out.println("Please enter one of the following options: " +
                "\nA ) All - display all entries" +
                "\nD ) Deposits - display all deposits only" +
                "\nP ) Payments - display all payments only" +
                "\nR ) Reports - view default reports or custom reports");
        String choice = ans("\nEnter here:");


    }
}
