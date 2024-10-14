package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.HomeScreen;
import static com.pluralsight.Home.ans;

public class LedgerScreen {
    static FileReader fr;

    static {
        try {
            fr = new FileReader("transactions.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedReader br = new BufferedReader(fr);
    static String input ;
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
                    allEntries();
                    break;
                case "D":
                    allDeposits();
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

    public static void allEntries() throws IOException, InterruptedException {

        while((input= br.readLine()) != null) {
            System.out.println(input);
        }
        String another = ans("Would you like to run another report? ");
        if(another.equalsIgnoreCase("yes")){
            Ledger();
        }else {
            HomeScreen();
        }

    }
    public static void allDeposits() throws IOException {
        while((input= br.readLine()) != null) {
            String[] tran = input.split(" \\| ");

            Transaction x = new Transaction(tran[0],tran[1],tran[2],tran[3],tran[4]);
            if(x.getAmount().contains("-")){
                System.out.println(x.display());
            }
        }

    }

}
