package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.ans;

public class LedgerScreen {
    public static void main(String[] args) throws InterruptedException, IOException {
        Ledger();
    }
    public static void Ledger() throws InterruptedException, IOException {
        Thread.sleep(500);

        System.out.println("\nYou are on the Ledger Screen!" +
                "\nEnter h (Return to home) or x (Exit app) at any time!");

        System.out.println("Please enter one of the following options: " +
                "\nA ) All - display all entries" +
                "\nD ) Deposits - display all deposits only" +
                "\nP ) Payments - display all payments only" +
                "\nR ) Reports - view default reports or custom reports");
        String choice = ans("\nEnter here:").toUpperCase();
        inputChecker(choice);

        switch (choice) {
                case "A":
                    Entries(choice);
                    break;
                case "D":
                    break;
                case "P":
                    break;
                case "R":
                    break;
                default:
                    Thread.sleep(300);
                    System.out.println("\nThat is not a valid option. Please enter a correct option.");
                    Ledger();
                    break;
        }
    }

    public static void Entries(String x) throws IOException {
        FileReader fr = new FileReader("transactions.csv");
        BufferedReader br = new BufferedReader(fr);
        String input ;
        while((input= br.readLine()) != null) {
            System.out.println(input);
        }
    }
}
