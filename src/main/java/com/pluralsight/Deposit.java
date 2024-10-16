package com.pluralsight;

import java.io.IOException;
import static com.pluralsight.Home.*;
import static com.pluralsight.Payment.userMessage;
import static com.pluralsight.Quit.Exit;

public class Deposit {

    public static void AddDeposit() throws InterruptedException, IOException {

        userMessage("deposit","");
    }

    public static void inputChecker(String input) throws IOException, InterruptedException {
        if(input.equalsIgnoreCase("H")){
            HomeScreen();
        }else if(input.equalsIgnoreCase("x")){
            Exit();
        }

    }

}
