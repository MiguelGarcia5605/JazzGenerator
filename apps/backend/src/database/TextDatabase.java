package database;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TextDatabase {

    ArrayList<String> mData = new ArrayList<String>();
    Scanner mScanner;

    public void addData(String address) {
        File file = new File(address);
        
        try {
            mScanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println("PROGRAM ERROR: File not found while trying to add data to database from " + address);
        }

        while (mScanner.hasNext()) {
            mData.add(mScanner.next());
        }

        mScanner.close();
    }

    public void printData() {
        System.out.println(mData.toString());
    }
}