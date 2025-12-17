package apps;

import java.io.File;

import database.TextDatabase;
import generator.generator.Generator;
import gui.AppWindow;

public class App {
    public static void main(String[] args) {
        // Paths
        String ROOT_PATH = new File("").getAbsolutePath();
        String MAJOR_CELLS_DATABASE_PATH = ROOT_PATH + "\\apps\\backend\\src\\database\\data\\MajorCellsDatabase.txt";
        String MINOR_CELLS_DATABASE_PATH = ROOT_PATH + "\\apps\\backend\\src\\database\\data\\MinorCellsDatabase.txt";  
        String DOMINANT_CELLS_DATABASE_PATH = ROOT_PATH + "\\apps\\backend\\src\\database\\data\\DominantCellsDatabase.txt";
        String RHYTHMIC_CELLS_DATABASE_PATH = ROOT_PATH + "\\apps\\backend\\src\\database\\data\\RhythmicCellsDatabase.txt"; 

        // Add Data
        TextDatabase majorCellsDatabase = new TextDatabase(MAJOR_CELLS_DATABASE_PATH);
        TextDatabase minorCellsDatabase = new TextDatabase(MINOR_CELLS_DATABASE_PATH);
        TextDatabase dominantCellsDatabase = new TextDatabase(DOMINANT_CELLS_DATABASE_PATH);
        TextDatabase rhythmicCellsDatabase = new TextDatabase(RHYTHMIC_CELLS_DATABASE_PATH);

        // Create Generator
        Generator generator = new Generator(majorCellsDatabase, minorCellsDatabase, dominantCellsDatabase, rhythmicCellsDatabase);

        // Open App
        AppWindow appWindow = new AppWindow(generator);

    }
}
