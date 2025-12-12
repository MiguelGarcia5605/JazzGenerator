package generator.tests;

import java.io.File;
import java.io.FileNotFoundException;

import database.CellDatabase;
import generator.Generator;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
 
public class BigDatabaseTester implements JMC {
    
    public static void main(String[] args) throws FileNotFoundException{
        String rootProjectPath = new File("").getAbsolutePath();
        String databasePath = rootProjectPath + "\\src\\Database\\MajorCellsDatabase.txt";  
        
        CellDatabase testDatabase = new CellDatabase();
        testDatabase.readData(databasePath);

        Part lick = Generator.generatorV3(testDatabase, 4);
        Write.midi(lick, "lick.mid");
    }
}