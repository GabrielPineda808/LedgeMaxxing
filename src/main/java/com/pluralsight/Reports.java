package com.pluralsight;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.ans;
import static com.pluralsight.LedgerScreen.Ledger;
import static com.pluralsight.LedgerScreen.fr;

public class Reports {
    static LocalDateTime time = LocalDateTime.now(); //grabbing the current date
    static String year = Integer.toString(time.getYear()); // grabbing the current year
    static String month = Integer.toString(time.getMonthValue());//getting the current month
    static String pYear = Integer.toString(time.minusYears(1).getYear());//getting whatever the previous year is
    static String pMonth = Integer.toString(time.minusMonths(1).getMonthValue());//getting the previous month
    static String input;

    public static void reports() throws IOException, InterruptedException {
        System.out.println("\nYou are on the Reports Screen!" +
                "\nEnter h (Return to home) or x (Exit app) at any time!\n");

        System.out.println("\nPlease enter one of the following options: \n" +
                "\n1 ) Month to Date" +
                "\n2 ) Previous Month" +
                "\n3 ) Year to Date" +
                "\n4 ) Previous Year" +
                "\n5 ) Search by Vendor" +
                "\n0 ) Return to Ledger Screen");
        String choice = ans("\nEnter here: ").toUpperCase(); //grabbing user input
        inputChecker(choice);
        switch (choice){ // switch case to call on the method tht will perform what the user wants
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
                System.out.println("\nThat is a not a valid report option. Please try again.\n");
                reports(); //re runs the report page if the input is not valid

        }
    }

    public static void monthToDate() throws IOException, InterruptedException { //method to grab every transaction in the current month

        BufferedReader br = new BufferedReader(fr());//loading the transaction file

        while((input = br.readLine())!= null){ //while loop to go through each line in transaction csv
            String[] user = input.split("\\|");//creating an array splitting the transaction by table header
            Transaction x = new Transaction(user[0],user[1],user[2],user[3],user[4]);//creating an object with our array
            String[] userTime= x.getDate().split("-");// grabbing the date and splitting it into an array
            if(userTime[0].contains(year) && userTime[1].contains(month)){//if the transaction date contains the current uear and month
                System.out.println("\n"+ x.display()+ "\n");//it will print
            }
        }
        option();// asking the user if they eant to run another option in the report page
    }

    public static void previousMonth() throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(fr());

        while((input = br.readLine())!= null){
            String[] user = input.split("\\|");
            Transaction x = new Transaction(user[0],user[1],user[2],user[3],user[4]);
            String[] userTime= x.getDate().split("-");
            if(userTime[0].contains(year) && userTime[1].contains(pMonth)){//if the user contains this year and whatever the previous month may be
                System.out.println("\n"+ x.display()+ "\n");//displays if there
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
            if(userTime[0].contains(year)){//if the transaction contains the current year
                System.out.println("\n"+ x.display()+ "\n");//displays if available
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
            if(userTime[0].contains(pYear)){//grabbing all transactions that contain the previous year in the date
                System.out.println("\n"+ x.display()+ "\n");
            }
        }
        option();
    }
    public static void byVendor() throws IOException, InterruptedException {
        boolean vendorNotFound = true;
        String v = ans("\nPlease enter the VENDOR: ");
        BufferedReader br = new BufferedReader(fr());
            while ((input = br.readLine()) != null) {

                String[] user = input.split("\\|");
                Transaction x = new Transaction(user[0], user[1], user[2], user[3], user[4]);

                if (x.getVendor().toUpperCase().contains(v.toUpperCase())) { // if the transaction contains the user inputted vendor
                    System.out.println("\n" + x.display());
                    vendorNotFound = false;
                }
            }
            if (vendorNotFound){
                System.out.println("\nThere is no vendor that contains " + v + "\n");
            }

        option();
    }

    public static void option() throws IOException, InterruptedException { // method that asks the user if they want to re run the optons page

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
                System.out.println("\nPlease enter a valid option and try again.\n");
                option();

        }
    }
}
