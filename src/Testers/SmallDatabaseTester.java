package Testers;
import java.io.File;
import java.io.FileNotFoundException;
import Database.CellDatabase;
import Generation.Generator;
import Mod.CellMod;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
 
public class SmallDatabaseTester implements JMC {
    
    public static void main(String[] args) throws FileNotFoundException{
        String rootProjectPath = new File("").getAbsolutePath();
        String databasePath = rootProjectPath + "\\src\\Database\\TestDatabase.txt";  
        
        CellDatabase testDatabase = new CellDatabase();
        testDatabase.readData(databasePath);

        Part lick = Generator.generatorV2(testDatabase, 2);

        Write.midi(lick, "test.mid");
    }
}