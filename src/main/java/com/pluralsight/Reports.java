package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.HomeScreen;
import static com.pluralsight.Home.ans;
import static com.pluralsight.LedgerScreen.Ledger;
import static com.pluralsight.LedgerScreen.fr;

public class Reports {
    static LocalDateTime time = LocalDateTime.now();
    static String year = Integer.toString(time.getYear());
    static String month = Integer.toString(time.getMonthValue());
    static String pYear = Integer.toString(time.minusYears(1).getYear());
    static String pMonth = Integer.toString(time.minusMonths(1).getMonthValue());
    static String input;

    public static void reports() throws IOException, InterruptedException {
        System.out.println("\nYou are on the Reports Screen!" +
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
                monthToDate();
                break;
            case "2":
                previousMonth();
                break;
            case "3":
                ytd();
                break;
            case "4":
                previousYear();
                break;
            case "5":
                byVendor();
                break;
            case "0":
                Ledger();
                break;
            default:
                System.out.println("That is a not a valid report option. Please try again.");
                reports();

        }
    }

    public static void monthToDate() throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(fr());

        while((input = br.readLine())!= null){
            String[] user = input.split("\\|");
            Transaction x = new Transaction(user[0],user[1],user[2],user[3],user[4]);
            String[] userTime= x.getDate().split("-");
            if(userTime[0].contains(year) && userTime[1].contains(month)){
                System.out.println(x.display()+ "\n");
            }
        }
        option();
    }

    public static void previousMonth() throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(fr());

        while((input = br.readLine())!= null){
            String[] user = input.split("\\|");
            Transaction x = new Transaction(user[0],user[1],user[2],user[3],user[4]);
            String[] userTime= x.getDate().split("-");
            if(userTime[0].contains(year) && userTime[1].contains(pMonth)){
                System.out.println(x.display()+ "\n");
            }
        }
        option();
    }
    public static void ytd() throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(fr());

        while((input = br.readLine())!= null){
            String[] user = input.split("\\|");
            Transaction x = new Transaction(user[0],user[1],user[2],user[3],user[4]);
            String[] userTime= x.getDate().split("-");
            if(userTime[0].contains(year)){
                System.out.println(x.display()+ "\n");
            }
        }
        option();
    }

    public static void previousYear() throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(fr());

        while((input = br.readLine())!= null){
            String[] user = input.split("\\|");
            Transaction x = new Transaction(user[0],user[1],user[2],user[3],user[4]);
            String[] userTime= x.getDate().split("-");
            if(userTime[0].contains(pYear)){
                System.out.println(x.display()+ "\n");
            }
        }
        option();
    }
    public static void byVendor() throws IOException, InterruptedException {

        String v = ans("\nPlease enter the VENDOR: ");

        BufferedReader br = new BufferedReader(fr());
        
        while((input = br.readLine())!= null){
            String[] user = input.split("\\|");
            Transaction x = new Transaction(user[0],user[1],user[2],user[3],user[4]);

            if(x.getVendor().toUpperCase().contains(v.toUpperCase())){
                System.out.println(x.display()+ "\n");
            }
        }
        option();
    }

    public static void option() throws IOException, InterruptedException {

        String another = ans("\nWould you like to view another report? Enter yes or no: ");
        inputChecker(another);

        switch (another.toUpperCase()){
            case "YES":
                reports();
                break;
            case "NO":
                Ledger();
                break;
            default:
                System.out.println("\nPlease enter a valid option and try again.");
                option();

        }
    }
}
