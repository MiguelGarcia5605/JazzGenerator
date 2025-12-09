package Generation;
import java.util.ArrayList;
import java.util.Random;
import Cell.Cell;
import Database.CellDatabase;
import Mod.CellMod;
import jm.JMC;
import jm.music.data.Part;

/**
 * This class is intended to hold various generation methods for jazz licks.
 */
public class Generator implements JMC {

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    /**
     * This generation method generates a lick of any length by randomly choosing MelodicCells from the given database.
     * @param database
     * @param length : the amount of measures
     * @return the generated jazz lick
     */
    public static final Part generatorV1(CellDatabase database, int length) {
        ArrayList<Cell> phrase = new ArrayList<Cell>();

        for (int i = 0; i < length * 2; i++) {
            int randomInt = RANDOM_NUMBER_GENERATOR.nextInt(0, database.getDatabase().size());

            Cell cell = database.getDatabase().get(randomInt).copy();         /* Must use copy() to avoid issues */

            cell.setTitle("cell_" + i + "_" + randomInt);
            phrase.add(cell);
        }

        Part lick = CellMod.convertToPart(phrase);

        return lick;
    }

    /**
     * This generation method generates a lick of any length by randomly choosing MelodicCells from the given database.
     * - Removes adjacent duplicate cells and notes
     * @param database
     * @param length : the amount of measures
     * @return the generated jazz lick
     */
    public static final Part generatorV2(CellDatabase database, int length) {
        ArrayList<Cell> phrase = new ArrayList<Cell>();

        for (int i = 0; i < length * 2; i++) {
            int randomInt = RANDOM_NUMBER_GENERATOR.nextInt(0, database.getDatabase().size());

            Cell cell = database.getDatabase().get(randomInt).copy();         /* Must use copy() to avoid issues */

            cell.setTitle("cell_" + i + "_" + randomInt);
            phrase.add(cell);
        }

        phrase = CellMod.removeAdjacentDuplicates(phrase, database);

        Part lick = CellMod.convertToPart(phrase);

        return lick;
    }

        /**
     * This generation method generates a lick of any length by randomly choosing MelodicCells from the given database.
     * - Removes adjacent duplicate cells and notes
     * @param database
     * @param length : the amount of measures
     * @return the generated jazz lick
     */
    public static final Part generatorV3(CellDatabase database, int length) {
        ArrayList<Cell> phrase = new ArrayList<Cell>();

        for (int i = 0; i < length * 2; i++) {
            int randomInt = RANDOM_NUMBER_GENERATOR.nextInt(0, database.getDatabase().size());

            Cell cell = database.getDatabase().get(randomInt).copy();         /* Must use copy() to avoid issues */

            cell.setTitle("cell_" + i + "_" + randomInt);
            phrase.add(cell);
        }

        phrase = CellMod.removeAdjacentDuplicates(phrase, database);

        phrase = CellMod.addScalarMotion(phrase);

        Part lick = CellMod.convertToPart(phrase);

        return lick;
    }
}