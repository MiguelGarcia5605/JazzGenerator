package Testers;
import java.io.File;
import java.io.FileNotFoundException;
import Database.CellDatabase;
import Generation.Generator;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
 
public class Tester implements JMC {
    
    public static void main(String[] args) throws FileNotFoundException{
        String rootProjectPath = new File("").getAbsolutePath();
        String databasePath = rootProjectPath + "\\data\\MajorCellsDatabase.txt";

        // MelodicCellDatabase database = new MelodicCellDatabase(
        //     databasePath, "maj7");
        // database.initializeDatabase();

        
        // Phrase p = new Phrase();
        // p.equals(p);
        
        // Note n = new Note();
        // n.equals(n);
        
        
        CellDatabase testDatabase = new CellDatabase();
        testDatabase.readData(databasePath);

        Part lick = Generator.generatorV1(testDatabase, 16);
        Write.midi(lick, "lick.mid");
    }
}