package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.pluralsight.Home.*;
import static com.pluralsight.Quit.Exit;

public class Deposit {
    static Transaction x;
    public static void AddDeposit() throws InterruptedException, IOException {

        Thread.sleep(500);

        System.out.println("\nYou are on the Add Deposit Screen!" +
                "\nEnter h (Return to home) or x (Exit app) at any time!");

        System.out.println("\nPlease have the deposit description, vendor, and amount at the ready." +
                "\nIf using a custom date and time have please have that ready as well.");

        try{
            DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("hh:mm:ss");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while(true){
                String description = ans("\nPlease enter a description for your deposit: ");
                inputerCheck(description);

                String vendor = ans("\nPlease enter the vendor for your deposit");
                inputerCheck(vendor);

                String amount = ans("\nPlease enter the amount for your deposit");
                inputerCheck(amount);

                String dt = ans("\nWould you like to use a custom date and time for this deposit? Enter yes or no: ");
                inputerCheck(dt);

                LocalDate date = LocalDate.now() ;
                String dateString = date.format(dateFormatter);


                LocalTime time = LocalTime.now();
                String hourString = time.format(hourFormat);




                if (dt.equalsIgnoreCase("YES")) {
                    String cd = ans("\nPlease enter the custom date for your deposit in YYYY-MM-DD format: ");
                    inputerCheck(cd);
                    LocalDate customDate = (LocalDate) dateFormatter.parse(cd);


                    String ct = ans("\nPlease enter the custom time for your deposit in HH:MM:SS format: ");
                    inputerCheck(ct);
                    Time customTime = (Time) hourFormat.parse(ct);

                     x = new Transaction(customDate.toString(),customTime.toString(),description,vendor,amount);
                }else{
                    x = new Transaction(dateString,hourString,description,vendor,amount);
                }


                FileWriter fr = new FileWriter("transactions.csv", true);
                BufferedWriter br = new BufferedWriter(fr);
                br.write(x.display());
                br.newLine();
                br.close();
                String close = ans("\nWould you like to add another deposit? Enter yes or no: ");
                if(close.equalsIgnoreCase("no")){
                    HomeScreen();
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void inputerCheck(String input) throws IOException, InterruptedException {
        if(input.equalsIgnoreCase("H")){
            HomeScreen();
        }else if(input.equalsIgnoreCase("x")){
            Exit();
        }

    }
}
