package com.pluralsight;
import java.io.*;

import static com.pluralsight.Home.HomeScreen;

public class LedgeMaxxing {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("\n-----------WELCOME TO LEDGEMAXXING-----------");

        System.out.println("\nWelcome to LedgeMaxxer! Thank you for using our service.");

        if(new File("transactions.csv").isFile()){ // checking to see if the user has ran the program before therefore creating a the tranasction csv. Run home screen if thet have
            HomeScreen(); // calls on the homescreen to start programs
        }else {// if the user has not used the program before or deleted their previous tranasctions csv file we create one with the proper table headers

            FileWriter s = new FileWriter("transactions.csv",true); // creating file
            BufferedWriter br = new BufferedWriter(s); //writing to file

            br.write("DATE | TIME | DESCRIPTION | VENDOR | AMOUNT ");//adding table headers to table
            br.close(); // closing writing

            HomeScreen(); // calling on the homescreen after careting file and headers.
        }

    }
}