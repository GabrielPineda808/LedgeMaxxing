package com.pluralsight;

import java.io.IOException;

import static com.pluralsight.Deposit.inputChecker;
import static com.pluralsight.Home.ans;
import static com.pluralsight.Payment.validDate;

public class CustomSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        searchPrompt();
    }
    public static void searchPrompt() throws IOException, InterruptedException {
        System.out.println("\nYou will now be conducting a CUSTOM SEARCH \n" +
                "\nPlease have the start date, end date, description, vendor, and amount if needed. \n" +
                "\nHit the enter key if you would like to skip a search filter");

        String startDate = ans("\nEnter the start date for your custom search");
        inputChecker(startDate);
        while(!validDate(startDate)){ // If the date is not valid we let the user know and try agina
            System.out.println("\nThat is not a proper date format. Please try again.");
            startDate= ans("\nEnter the start date for your custom search");
            if (startDate.isEmpty()){
                break;
            }
            if(validDate(startDate)){
                break;
            }
        }


        String endDate = ans("\nEnter the end date for your custom search ");
        inputChecker(endDate);
        while(!validDate(endDate)){ // If the date is not valid we let the user know and try agina
            System.out.println("\nThat is not a proper date format. Please try again.");
            endDate= ans("\nEnter the start date for your custom search");
            if (endDate.isEmpty()){
                break;
            }
            if(validDate(endDate)){
                break;
            }
        }

        String description = ans("\nEnter the description for your custom search.");
        inputChecker(description);

        String vendor = ans("\nEnter the vendor for your custom search.");
        inputChecker(vendor);

        String amount;

        while (true){ // while loop to validate that the user has entered a valid number for the transaction amount
            amount = ans("\nEnter the amount if needed"); //grabbing amount
            inputChecker(amount);
            if (amount.isEmpty()){
                break;
            }
            try { //validating string to float. If not a valid float it will prompt the user to enter the amount again.
                Float.parseFloat(amount); // checking to see if the string can be parsed to float in order to validate
                break; // if valid break the loop
            }catch (NumberFormatException w){
                System.out.println("\nThat is a not a valid amount. Please enter again.");// lets user know the amount was not valid and reruns the loop.
            }
        }



    }
}
