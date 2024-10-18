package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.*;

public class Payment {
    static DateTimeFormatter hourFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
    public static void MakePayment() throws InterruptedException {

        userMessage("payment","-");

    }

    public static void userMessage(String message, String negative) throws InterruptedException { // prompts the user options that will take in a pareamter to set wther to promp for deposit or payment. Second string takes in a "-" to make the payment a substraction.

        Transaction transaction; //declaring transaction object

        System.out.println("\n-----------"+message.toUpperCase()+"-----------");

        System.out.println("\nEnter HOME (Return to home) or EXIT (Exit app) at any time!");

        System.out.println("\nPlease have the "+message+" description, vendor, and amount at the ready." +
                "\nIf using a custom date and time have please have that ready as well.");

        try{

                String description = ans("\nPlease enter a DESCRIPTION for your "+message+": "); // grabbing transaction description
                inputChecker(description); //calls input checker to check if user entered text that promps the homescreen or exits the app

                String vendor = ans("\nPlease enter the VENDOR for your "+message+": ");// grabbing vendor
                inputChecker(vendor);


                String amount; // declaring amount string
                while (true){ // while loop to validate that the user has entered a valid number for the transaction amount

                    amount = ans("\nPlease enter the AMOUNT for your "+message+": "); //grabbing amount

                    inputChecker(amount);

                    try { //validating string to float. If not a valid float it will prompt the user to enter the amount again.
                        Float.parseFloat(amount); // checking to see if the string can be parsed to float in order to validate
                        break; // if valid break the loop
                    }catch (NumberFormatException w){
                        System.out.println("\nThat is a not a valid amount. Please enter again.");// lets user know the amount was not valid and reruns the loop.
                    }

                }

                String amountToString = negative + amount; // adding a subtraction symbol if one was given as a parameter.
                inputChecker(amountToString);

                String dt = ans("\nWould you like to use a custom date and time for this "+message+"? Enter yes or no: ");// prompting user for a custom input
                inputChecker(dt);

                while(!dt.equalsIgnoreCase("yes")&& !dt.equalsIgnoreCase("no")){// if yes or no is not entered we will prompt the user again.

                    System.out.println("\nThat is not a proper choice. Please enter again.");

                    dt =ans("\nWould you like to use a custom date and time for this "+message+"? Enter yes or no: ");

                }

                LocalDate date = LocalDate.now() ; // grabbing the current date
                String dateString = date.format(dateFormatter); //formatting the current date

                LocalTime time = LocalTime.now(); // grabbing the current time
                String hourString = time.format(hourFormat); // formatting the current time

                if (dt.equalsIgnoreCase("YES")) {//if the user wants a custom time then we will place that into our transaction object

                    transaction = new Transaction(customDate(message),customTime(message),description,vendor,amountToString); // creates transaction object by callig on the custom date and time method so the user can input them.

                }else{

                    transaction = new Transaction(dateString,hourString,description,vendor,amountToString);// creates a transaction object using the current date and time.
                }


                FileWriter fr = new FileWriter("transactions.csv", true);// writing to the transaction csv we created when initialzing the app
                BufferedWriter br = new BufferedWriter(fr);// writing to the csv when all input is given

                br.write(transaction.display());//writing the transaction object info to our csv
                br.newLine();//creating a new line when writing
                br.close();// closing our writier

                String close = ans("\nWould you like to add another "+message+"? Enter yes or no: "); // prompting user for another transaction
                inputChecker(close);

                while(!close.equalsIgnoreCase("yes")&& !close.equalsIgnoreCase("no")){// if yes or no is not entered we will prompt the user again.

                    System.out.println("\nThat is not a proper choice. Please enter again.");
                    close = ans("\nWould you like to add another "+message+"? Enter yes or no: ");

                }

                if(close.equalsIgnoreCase("no")){// if the user does not want to add another transaction we return home

                    HomeScreen();

                }else{

                    userMessage(message,negative); // if they do we run our prompts again.

                }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static String customDate(String message) throws IOException, InterruptedException {//validates the custom date from user

        String customeDate;
        customeDate = ans("\nPlease enter the CUSTOM DATE for your "+message+" in YYYY-MM-DD format: "); // grabbing the custom date from user
        inputChecker(customeDate);

        while(!validDate(customeDate)){ // If the date is not valid we let the user know and try agina

            System.out.println("\nThat is not a proper date format. Please try again.");
            customeDate = ans("\nEnter date: ");

            if(validDate(customeDate)){
                break;
            }
        }

        return LocalDate.parse(customeDate,dateFormatter).toString(); //return the formated custom date as string
    }

    public static String customTime(String message) throws IOException, InterruptedException { // validates the custom time from suer

        String customeTime = ans("\nPlease enter the CUSTOM TIME for your "+message+" in HH:MM 24 hour military format: ");// grabs the custom time
        inputChecker(customeTime);

        while(!validTime(customeTime+ ":01")){ //if the time is not valid we will prompt the user to enter the time again

            System.out.println("\nThat is not a proper time format. Please try again.");
            customeTime = ans("\nPlease enter the CUSTOM TIME for your "+message+" in HH:MM 24 hour military format: ");

            if(validTime(customeTime+ ":01")){
                break;
            }
        }

        return LocalTime.parse(customeTime+ ":01",hourFormat).toString(); // return the custom formatted date as a string

    }

    public static boolean validDate(String dateStr) { //checkingto see if the custom date string from user can be parsed and formatted as and actual date

        try {

            LocalDate.parse(dateStr, dateFormatter);

        } catch (DateTimeParseException e) {

            return false;

        }

        return true;
    }
    public static boolean validTime(String time) {// check to see if the custom tiem string can be parsed and formatted as an actual time.

        try {

            LocalTime.parse(time, hourFormat);
        } catch (DateTimeParseException e) {

            return false;

        }

        return true;

    }
}
