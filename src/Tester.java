import java.io.File;
import java.io.FileNotFoundException;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
 
public class Tester implements JMC {
    
    public static void main(String[] args) throws FileNotFoundException{
        String rootProjectPath = new File("").getAbsolutePath();
        String databasePath = rootProjectPath + "\\data\\MajorCellsDatabase.txt";

        MelodicCellDatabase database = new MelodicCellDatabase(
            databasePath, "maj7");
        database.initializeDatabase();

        Part lick = LickGenerator.generatorV1(database, 2);
        Write.midi(lick, "Lick.mid");
    }
}