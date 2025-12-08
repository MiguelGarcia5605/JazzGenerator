import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import jm.music.data.Note;

/**
 * This class allows for a database of Cell object to be created through .txt file.
 * The .txt file should formatted with MIDI notes each containing the character '-' in between notes.
 * The end of each cell should includes its chordal context.
 * Use spaces or lines to signify the end of a cell.
 * 
 * For Example:
 *     C4-E4-G4-B4-maj7
 *     C#5-G#7-G4-B4-E4-G4-dom7
 */
public class CellDatabase {

    public ArrayList<Cell> mData = new ArrayList<Cell>();

    /**
     * Imports data to the cell database from the given address of a .txt file.
     * @param address : the address of the .txt file to read
     * @throws FileNotFoundException
     */
    public void readData(String address) throws FileNotFoundException {
        // Scan Data From File
        File file = new File(address);
        Scanner scanner = new Scanner(file);

        ArrayList<String> fileData = new ArrayList<String>();
        ArrayList<Cell> cellList = new ArrayList<Cell>();

        while (scanner.hasNext()) {
            fileData.add(scanner.next());
        }

        scanner.close();
        
        // Convert Data To Cell Objects
        for (String datum: fileData) {
            cellList.add(MusicMod.stringToCell(datum));
        }

        mData = (ArrayList<Cell>) cellList.clone();
    }

    /**
     * Prints the database data to the console.
     */
    public void printData() {
        for (Cell cell : mData) {
            System.out.println(Chord.chordValueToString(cell.getChord().getChordValue()));

            Note[] notes = cell.getNoteArray();

            for (Note note : notes) {
                System.out.println(note.toString());
            }
            
            System.out.println("---------------------------------------");
        }
    }

    public ArrayList<Cell> getDatabase() {
        return mData;
    }
}