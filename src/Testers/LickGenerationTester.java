package Testers;
import java.io.File;
import java.io.FileNotFoundException;

import Cell.Cell;
import Chords.Chord;
import Chords.ChordProgression;
import Database.CellDatabase;
import Generation.Generator;
import Mod.CellMod;
import jm.JMC;
import jm.music.data.*;
import jm.music.tools.Mod;
import jm.util.*;
 
public class LickGenerationTester implements JMC {
    
    public static void main(String[] args) throws FileNotFoundException{
        String rootProjectPath = new File("").getAbsolutePath();
        String databasePath = rootProjectPath + "\\src\\Database\\MajorCellsDatabase.txt";  

        Chord[] chords = new Chord[] {
            new Chord("min7"),
            new Chord("maj7"),
        };

        Note[] rootNotes = new Note[] {
            new Note(D4, EIGHTH_NOTE),
            new Note(C4, EIGHTH_NOTE),
        };

        ChordProgression ii_I = new ChordProgression(chords, rootNotes);
        
        CellDatabase testDatabase = new CellDatabase();
        testDatabase.readData(databasePath);

        Cell cell1 = testDatabase.getDatabase().get(0).copy();
        Cell cell2 = testDatabase.getDatabase().get(2).copy();
        Cell cell3 = testDatabase.getDatabase().get(14).copy();
        
        // Mod.transpose(cell1, 2);
        // Mod.transpose(cell2, 2);
        // Mod.transpose(cell3, 2);

        testDatabase.printData(testDatabase.getMajorCellDatabase());

        Part p = new Part();
        p.add(cell1);
        p.add(cell2);
        p.add(cell3);
        //Part lick = Generator.generatorV3(testDatabase, 4);


        Write.midi(p, "lick.mid");
    }
}