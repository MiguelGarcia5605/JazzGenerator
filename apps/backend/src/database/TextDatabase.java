package database;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TextDatabase {

    ArrayList<String> mData;
    Scanner mScanner;

    public TextDatabase(String address) {
        mData = readData(address);
    }

    private ArrayList<String> readData(String address) {
        ArrayList<String> data = new ArrayList<String>();

        File file = new File(address);
        
        try {
            mScanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println("PROGRAM ERROR: File not found while trying to add data to database from " + address);
        }

        while (mScanner.hasNext()) {
            data.add(mScanner.next());
        }

        mScanner.close();

        return data;
    }

    public void printData() {
        System.out.println(mData.toString());
    }

    public ArrayList<String> getData() {
        return mData;
    }
}