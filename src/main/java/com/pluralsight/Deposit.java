package com.pluralsight;

import static com.pluralsight.Home.ans;

public class Deposit {
    public static void AddDeposit() throws InterruptedException {
        Thread.sleep(500);

        System.out.println("\nYou are now on the Add Deposit Screen!");

        System.out.println("\nPlease have the deposit description, vendor, and amount at the ready." +
                "\nIf using a custom date and time have please have that ready as well." );

        String dt = ans("\nWould you like to use a custom date and time for this deposit? Enter yes or no: " ).toUpperCase();
        if(dt.equals("YES")){
            System.out.println("\nCustom date");
        }else {
            System.out.println("\nSystem date");
        }
    }
}
