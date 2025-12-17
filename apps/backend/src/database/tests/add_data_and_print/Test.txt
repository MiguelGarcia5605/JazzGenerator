package database.tests.add_data_and_print;

import java.io.File;
import database.TextDatabase;

public class Test {
    public static void main(String[] args) {
        String rootProjectPath = new File("").getAbsolutePath();
        String database1Path = rootProjectPath + "\\apps\\backend\\src\\database\\tests\\add_data_and_print\\data\\database1.txt";
        String database2Path = rootProjectPath + "\\apps\\backend\\src\\database\\tests\\add_data_and_print\\data\\database2.txt";  
        String database3Path = rootProjectPath + "\\apps\\backend\\src\\database\\tests\\add_data_and_print\\data\\database3.txt";  
        
        TextDatabase database1 = new TextDatabase();
        TextDatabase database2 = new TextDatabase();
        TextDatabase database3 = new TextDatabase();
        database1.addData(database1Path);
        database2.addData(database2Path);
        database3.addData(database3Path);

        database1.printData();
        database2.printData();
        database3.printData();
    }
}