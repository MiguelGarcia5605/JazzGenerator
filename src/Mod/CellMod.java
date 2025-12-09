package Mod;
import java.util.ArrayList;
import java.util.Random;
import Cell.Cell;
import Database.CellDatabase;
import jm.music.data.Note;
import jm.music.data.Part;

/**
 * This class contatains methods to manipulate ArrayList<MelodicCell> Objects.
 */
public class CellMod {

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    /**
     * Converts an ArrayList<MelodicCells> to a Part.
     * @param cellList : the cell list to convert
     * @return the cell list as a Part
     */
    public static final Part convertToPart(ArrayList<Cell> cellList) {
        Part part = new Part();

        for (Cell cell : cellList) {
            part.add(cell);
        }

        return part;
    }

    /**
     * Removes adjacent repeated notes and cells.
     */
    public static ArrayList<Cell> removeAdjacentDuplicates(ArrayList<Cell> cellList, CellDatabase database) {

        // Create a copy of the cell list
        ArrayList<Cell> cellListCopy = (ArrayList<Cell>) cellList.clone();

        // Get database list
        ArrayList<Cell> databaseList = database.getDatabase();

        
        // Iterate through cell list copy
        for (int i = 1; i < cellListCopy.size(); i++) {
            // Get cells you are comparing
            Cell leftMostCell = cellListCopy.get(i - 1);
            Cell rightMostCell = cellList.get(i);

            // Check if cells are equal
            boolean cellsAreEqual = leftMostCell.equals(rightMostCell);

            // Check if cells contain adjacent repeating notes
            boolean cellsHaveAdjacentDuplicates = hasAdjacentDuplicates(leftMostCell, rightMostCell);

            // Replace current Cell if notes are not equal or if cellsHaveAdjacentDuplicates
            if (cellsAreEqual || cellsHaveAdjacentDuplicates) {
                // Change cell until that statement is false
                int j = 0;
                while (true) {
                    System.out.println(j);
                    Cell randomCell = databaseList.get(RANDOM_NUMBER_GENERATOR.nextInt(0, databaseList.size())).copy();
                    cellListCopy.set(i, randomCell);
                    
                    if (!leftMostCell.equals(randomCell) && !hasAdjacentDuplicates(leftMostCell, randomCell)) {
                        break;
                    }
                    j++;
                }
            }

            System.out.println("BOOOOOOOOOOOOOm");

        }

        return cellListCopy;
    }

    private static boolean hasAdjacentDuplicates(Cell leftMostCell, Cell rightMostCell) {
        // Get Notes
        Note lastNoteOfLeftMostCell = leftMostCell.getNote(leftMostCell.length() - 1);
        Note firstNoteOfRightMostCell = rightMostCell.getNote(0);

        int pitchOne = lastNoteOfLeftMostCell.getPitch();
        int pitchTwo = firstNoteOfRightMostCell.getPitch();

        // Check if pitch value matches
        if (pitchOne == pitchTwo) {
            return true;
        } else {
            return false;
        }
    }
}
