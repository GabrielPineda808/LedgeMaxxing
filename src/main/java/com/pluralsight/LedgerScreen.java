package com.pluralsight;

import java.io.*;

import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.HomeScreen;
import static com.pluralsight.Home.ans;
import static com.pluralsight.Reports.reports;

public class LedgerScreen {
    static String input;

    public static void Ledger() throws InterruptedException, IOException {
        Thread.sleep(500);

        System.out.println("\nYou are on the Ledger Screen!" +
                "\nEnter h (Return to home) or x (Exit app) at any time!");

        System.out.println("Please enter one of the following options: " +
                "\nA ) All - display all entries" +
                "\nD ) Deposits - display all deposits only" +
                "\nP ) Payments - display all payments only" +
                "\nR ) Reports - view default reports or custom reports" +
                "\nH ) Return to Home");
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
                    allPayments();
                    break;
                case "R":
                    reports();
                    break;
            case"H":
                HomeScreen();
                break;
                default:
                    Thread.sleep(300);
                    System.out.println("\nThat is not a valid option. Please enter a correct option.");
                    Ledger();
        }
    }

    public static void allEntries() throws IOException, InterruptedException {


        BufferedReader br = new BufferedReader(fr());


        while((input= br.readLine()) != null) {
            System.out.println(input + "\n");
        }
        runReport();
    }

    public static void allPayments() throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(fr());

        while((input= br.readLine()) != null) {
            String[] tran = input.split(" \\| ");

            Transaction x = new Transaction(tran[0],tran[1],tran[2],tran[3],tran[4]);
            if(x.getAmount().contains("-")){
                System.out.println(x.display() + "\n");
            }
        }
        runReport();

    }
    public static void runReport() throws IOException, InterruptedException {

        String another = ans("\nWould you like to view another option? ");
        inputChecker(another);
        switch (another.toUpperCase()){
            case "YES":
                Ledger();
                break;
            case"NO":
                HomeScreen();
                break;
            default:
                System.out.println("That is not a valid option. Please enter again.");
                runReport();
        }
    }
    public static void allDeposits() throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(fr());

        while((input= br.readLine()) != null) {
            String[] tran = input.split(" \\| ");

            Transaction x = new Transaction(tran[0],tran[1],tran[2],tran[3],tran[4]);
            if(!x.getAmount().contains("-")){
                System.out.println(x.display()+"\n");
            }
        }
        runReport();
    }

    public static InputStreamReader fr() throws FileNotFoundException {
        return new FileReader("transactions.csv");
    }

}
