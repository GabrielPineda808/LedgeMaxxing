package com.pluralsight;
import java.io.*;

import static com.pluralsight.Home.HomeScreen;

public class LedgeMaxxing {
    public static void main(String[] args) throws InterruptedException, IOException {

        if(new File("transactions.csv").isFile()){
            HomeScreen();
        }else {
            FileWriter s = new FileWriter("transactions.csv",true);
            BufferedWriter br = new BufferedWriter(s);

            br.write("DATE | TIME | DESCRIPTION | VENDOR | AMOUNT ");
            br.close();
            HomeScreen();
        }
    }
}