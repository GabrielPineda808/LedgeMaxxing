package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.HomeScreen;
import static com.pluralsight.Home.ans;

public class Payment {
    static DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
    public static void MakePayment() throws InterruptedException {


        userMessage("payment","-");
    }

    public static void userMessage(String message, String n) throws InterruptedException {
        Thread.sleep(500);
        Transaction x;
        System.out.println("\nYou are on the make "+message+" Screen!" +
                "\nEnter h (Return to home) or x (Exit app) at any time!");
        System.out.println("\nPlease have the "+message+" description, vendor, and amount at the ready." +
                "\nIf using a custom date and time have please have that ready as well.");
        try{


            while(true){
                String description = ans("\nPlease enter a DESCRIPTION for your "+message+": ");
                inputChecker(description);

                String vendor = ans("\nPlease enter the VENDOR for your "+message+": ");
                inputChecker(vendor);

                String amount = n+ans("\nPlease enter the AMOUNT for your "+message+": ");
                inputChecker(amount);

                String dt = ans("\nWould you like to use a custom date and time for this "+message+"? Enter yes or no: ");
                inputChecker(dt);

                while(!dt.equalsIgnoreCase("yes")&& !dt.equalsIgnoreCase("no")){
                    System.out.println("\nThat is not a proper choice. Please enter again.");
                    dt =ans("\nWould you like to use a custom date and time for this "+message+"? Enter yes or no: ");
                }


                LocalDate date = LocalDate.now() ;
                String dateString = date.format(dateFormatter);

                LocalTime time = LocalTime.now();
                String hourString = time.format(hourFormat);




                if (dt.equalsIgnoreCase("YES")) {

                    x = new Transaction(customDate(message),customTime(message),description,vendor,amount);
                }else{
                    x = new Transaction(dateString,hourString,description,vendor,amount);
                }


                FileWriter fr = new FileWriter("transactions.csv", true);
                BufferedWriter br = new BufferedWriter(fr);
                br.write(x.display());
                br.newLine();
                br.close();
                String close = ans("\nWould you like to add another "+message+"? Enter yes or no: ");
                inputChecker(close);
                if(close.equalsIgnoreCase("no")){
                    HomeScreen();
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static String customDate(String message) throws IOException, InterruptedException {
        String cd;
        cd = ans("\nPlease enter the CUSTOM DATE for your"+message+" in YYYY-MM-DD format: ");
        inputChecker(cd);
        while(!validDate(cd)){
            System.out.println("\nThat is not a proper date format. Please try again.");
            cd = ans("\nPlease enter the CUSTOM DATE for your"+message+" in YYYY-MM-DD format: ");
            if(validDate(cd)){
                break;
            }
        }
        return LocalDate.parse(cd,dateFormatter).toString();
    }

    public static String customTime(String message) throws IOException, InterruptedException {
        String ct = ans("\nPlease enter the CUSTOM TIME for your"+message+" in HH:MM 24 hour military format: ");

        inputChecker(ct);

        while(!validTime(ct+ ":01")){
            System.out.println("\nThat is not a proper time format. Please try again.");
            ct = ans("\nPlease enter the CUSTOM TIME for your"+message+" in HH:MM 24 hour military format: ");
            if(validTime(ct+ ":01")){
                break;
            }
        }

        return LocalTime.parse(ct+ ":01",hourFormat).toString();
    }
    public static boolean validDate(String dateStr) {
        try {
            LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
    public static boolean validTime(String time) {
        try {
            LocalTime.parse(time, hourFormat);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
