import java.util.ArrayList;
import java.util.Random;
import jm.music.data.Part;

/**
 * This class contatains methods to manipulate ArrayList<MelodicCell> Objects.
 */
public class CellTranslate {

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    /**
     * Detects if any of the first and last notes of the MelodicCells are repeating and will replace them with a new MelodicCell
     * that won't make it repeating. It will also make sure MelodicCells are not repeated next to eachother.
     * @param cellList : the list of MelodicCells
     * @param database : database of MelodicCells to use when replacing cells
     * @return the list of cells without repeats
     */
    public static final ArrayList<MelodicCell> removeRepeats(ArrayList<MelodicCell> cellList, MelodicCellDatabase database) {
        ArrayList<MelodicCell> newCellList = (ArrayList<MelodicCell>) cellList.clone();

        for (int i = 1; i < cellList.size(); i++) {
            MelodicCell previousCell = newCellList.get(i - 1);
            MelodicCell currentCell = newCellList.get(i);
            int lastNoteOfPreviousCell = previousCell.getPitchArray()[previousCell.getSize() - 1];
            int firstNoteOfCurrentCell = currentCell.getPitchArray()[0];

            while (lastNoteOfPreviousCell == firstNoteOfCurrentCell || previousCell.equals(currentCell)) {
                int randomInt = RANDOM_NUMBER_GENERATOR.nextInt(0, database.getDatabase().size());
                MelodicCell newCell = database.getDatabase().get(randomInt).copy();
                newCellList.set(i, newCell);
                firstNoteOfCurrentCell = newCell.getPitchArray()[0];
            }
        }

        return newCellList;
    }

    /**
     * Converts an ArrayList<MelodicCells> to a Part.
     * @param cellList : the cell list to convert
     * @return the cell list as a Part
     */
    public static final Part convertToPart(ArrayList<MelodicCell> cellList) {
        Part part = new Part();

        for (MelodicCell cell : cellList) {
            part.add(cell);
        }

        return part;
    }
}
