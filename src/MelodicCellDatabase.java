import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class allows for a database of MelodicCell's to be created using a .txt file.
 * The file should formatted with 4 digit sequences each representing the scale degrees of each note in the MelodicCell.
 * For Example:
 *     1357
 *     7913
 *     5731
 */
public class MelodicCellDatabase {

    public ArrayList<MelodicCell> mDatabase = new ArrayList<MelodicCell>();
    public String mAddress; 
    public File mFile;
    public String mChordContext;

    /**
     * Constructs a new MelodicCellDatabase.
     * @param address : the address to the database file
     * @param chordContext : the chord context for the database 
     * @throws FileNotFoundException
     */
    public MelodicCellDatabase(String address, String chordContext) throws FileNotFoundException {
        mAddress = address;
        mChordContext = chordContext;
        mFile = new File(mAddress);
    }

    /**
     * Initializes the database with the information stored in the file.
     * @throws FileNotFoundException
     */
    public void initializeDatabase() throws FileNotFoundException {
        Scanner scanner = new Scanner(mFile);

        // Extract Sequences From File
        ArrayList<Integer> sequences = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            sequences.add(scanner.nextInt());
        }

        // Add To Database
        for (int i = 0; i < sequences.size(); i++) {
            int sequence = sequences.get(i);
            int[] digits = seperateDigits(sequence, 4);
            addMelodicCell(new MelodicCell(digits[0], digits[1], digits[2], digits[3], mChordContext));
        }
        
        scanner.close();
    }

    /**
     * Extracts each digit from an integer.
     * @param sequence : the integer to seperate
     * @param sequenceLength : the amount of digits the sequence contains
     * @return the seperated digits
     */
    private static final int[] seperateDigits(int sequence, int sequenceLength) {
        
        int[] digits = new int[sequenceLength];
        for (int i = 0; i < sequenceLength; i++) {
            int x = (int) Math.pow(10, (sequenceLength - 1) - i);
            digits[i] = sequence / x;
            sequence = sequence % x;
        }

        return digits;
    }
    
    public void addMelodicCell(MelodicCell cell) {
        mDatabase.add(cell);
    }

    public ArrayList<MelodicCell> getDatabase() {
        return mDatabase;
    }
    
    public String getDatabaseAddress() {
        return mAddress;
    }
}