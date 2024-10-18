package com.pluralsight;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.ans;
import static com.pluralsight.Home.s;
import static com.pluralsight.LedgerScreen.fr;
import static com.pluralsight.Payment.validDate;

public class CustomSearch {
    static String startDate;
    static String endDate;
    static String description;
    static String vendor;
    static String amount;
    public static void main(String[] args) throws IOException, InterruptedException {
        searchPrompt();
    }

    public static void searchPrompt() throws IOException, InterruptedException {

        System.out.println("\nYou will now be conducting a CUSTOM SEARCH \n" +
                "\nPlease have the start date, end date, description, vendor, and amount if needed. " +
                "\nHit the enter key if you would like to skip a search filter");

        startDate = ans("\nEnter the start date for your custom search");

        if (!startDate.isEmpty()) {
            while (!validDate(startDate)) { // If the date is not valid we let the user know and try agina
                System.out.println("\nThat is not a proper date format. Please try again.");
                startDate = ans("\nEnter the start date for your custom search");
                if (startDate.isEmpty()) {
                    isEmpty(startDate, "start date");
                    break;
                }
                if (validDate(startDate)) {
                    break;
                }
            }
        } else {
            isEmpty(startDate, "start date");
        }

        inputChecker(startDate);

        endDate = ans("\nEnter the end date for your custom search ");

        if (!endDate.isEmpty()) {
            while (!validDate(endDate)) { // If the date is not valid we let the user know and try agina
                System.out.println("\nThat is not a proper date format. Please try again.");
                endDate = ans("\nEnter the start date for your custom search");
                if (endDate.isEmpty()) {
                    isEmpty(endDate, "end date");
                    break;
                }
                if (validDate(endDate)) {
                    break;
                }
            }
        } else {
            isEmpty(endDate, "end date");
        }

        inputChecker(endDate);

        description = ans("\nEnter the description for your custom search.");

        inputChecker(description);

        vendor = ans("\nEnter the vendor for your custom search.");

        inputChecker(vendor);

        while (true) { // while loop to validate that the user has entered a valid number for the transaction amount
            amount = ans("\nEnter the amount if needed"); //grabbing amount
            inputChecker(amount);
            if (amount.isEmpty()) {
                isEmpty(amount, "amount");
                break;
            }
            try { //validating string to float. If not a valid float it will prompt the user to enter the amount again.
                Float.parseFloat(amount);// checking to see if the string can be parsed to float in order to validate
                break; // if valid break the loop
            } catch (NumberFormatException w) {
                System.out.println("\nThat is a not a valid amount. Please enter again.");// lets user know the amount was not valid and reruns the loop.
            }
        }
    }

    public static void isEmpty(String input, String message){
        if(input.isEmpty()){
            System.out.println("Skipping the "+ message +" filter");
        }
    }
}
