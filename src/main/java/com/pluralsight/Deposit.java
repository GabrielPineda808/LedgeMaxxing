package com.pluralsight;

import java.io.IOException;
import static com.pluralsight.Home.*;
import static com.pluralsight.Payment.userMessage;
import static com.pluralsight.Quit.Exit;

public class Deposit {

    public static void AddDeposit() throws InterruptedException, IOException {

        userMessage("deposit",""); // calls on userMessage method
    }

    public static void inputChecker(String input) throws IOException, InterruptedException { //checks user input to see if they want to go back to the homescreen or exit the app at any time
        if(input.equals("HOME")){
            HomeScreen(); // calls home screen method
        }else if(input.equals("EXIT")){
            Exit(); //calls exit method
        }

    }

}
