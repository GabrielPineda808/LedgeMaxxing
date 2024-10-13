package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.pluralsight.Home.*;
import static com.pluralsight.Quit.Exit;

public class Deposit {
    public static void AddDeposit() throws InterruptedException, IOException {

        Thread.sleep(500);

        System.out.println("\nYou are on the Add Deposit Screen!" +
                "\nEnter h (Return to home) or x (Exit app) at any time!");

        System.out.println("\nPlease have the deposit description, vendor, and amount at the ready." +
                "\nIf using a custom date and time have please have that ready as well.");

        String description = ans("\nPlease enter a description for your deposit: ");

        String vendor = ans("\nPlease enter the vendor for your deposit");

        String amount = ans("Please enter the amount for your deposit");

        String dt = ans("\nWould you like to use a custom date and time for this deposit? Enter yes or no: ").toUpperCase();

        LocalDate date = LocalDate.now() ;
        String dateString = dateFormat(date);


        LocalTime time = LocalTime.now();
        String hourString = timeFormat(time);


        Transaction x = new Transaction(dateString,hourString,description,vendor,amount);
        x.display();

        if (dt.equals("YES")) {
            String cd = ans("\nPlease enter the custom date for your deposit in MM-DD-YYYY format: ");
            LocalDate custDate = LocalDate.parse(cd);
            String customDate = dateFormat(custDate);

            String ct = ans("\nPlease enter the custom time for your deposit in HH:MM format: ");
            LocalTime custTime = LocalTime.parse(ct);
            String customTime = timeFormat(custTime);
        }


        FileWriter fr = new FileWriter("transactions.csv");
        BufferedWriter br = new BufferedWriter(fr);



    }
    public static String timeFormat(LocalTime x){
        DateTimeFormatter hformat = DateTimeFormatter.ofPattern("hh:mm:ss");
        return x.format(hformat);
    }

    public static String dateFormat(LocalDate x){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return x.format(formatter);
    }
}
