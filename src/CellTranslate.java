import java.util.ArrayList;
import java.util.Random;
import jm.music.data.Part;

/**
 * This class contatains methods to manipulate ArrayList<MelodicCell> Objects.
 */
public class CellTranslate {

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
}
