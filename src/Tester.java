import java.io.FileNotFoundException;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
 
public class Tester implements JMC {
    
    public static void main(String[] args) throws FileNotFoundException{
        MelodicCellDatabase database = new MelodicCellDatabase("C:\\Coding Projects\\JazzGenerator\\src\\data\\MajorCellsDatabase.txt", "maj7");
        database.initializeDatabase();
        
        Part lick = LickGenerator.generatorV1(database, 2);
        Write.midi(lick, "Lick.mid");
    }
}