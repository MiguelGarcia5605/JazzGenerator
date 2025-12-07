import java.util.ArrayList;
import java.util.Random;
import jm.JMC;
import jm.music.data.Part;

/**
 * This class is intended to hold various generation methods for jazz licks.
 */
public class LickGenerator implements JMC {

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    /**
     * This generation method generates a lick of any length by randomly choosing MelodicCells from the given database.
     * @param database
     * @param length : the amount of measures
     * @return the generated jazz lick
     */
    public static final Part generatorV1(MelodicCellDatabase database, int length) {
        ArrayList<MelodicCell> phrase = new ArrayList<MelodicCell>();

        for (int i = 0; i < length * 2; i++) {
            int randomInt = RANDOM_NUMBER_GENERATOR.nextInt(0, database.getDatabase().size());

            MelodicCell cell = database.getDatabase().get(randomInt).copy();         /* Must use copy() to avoid issues */

            cell.setTitle("cell_" + i + "_" + randomInt);
            phrase.add(cell);
        }

        Part lick = CellTranslate.convertToPart(phrase);

        return lick;
    }

    /**
     * This generation method generates a lick of any length by randomly choosing MelodicCells from the given database.
     * + This version removes any repeating notes that are next to eachother
     * @param database
     * @param length : the amount of measures
     * @return the generated jazz lick
     */
    public static final Part generatorV2(MelodicCellDatabase database, int length) {
        ArrayList<MelodicCell> phrase = new ArrayList<MelodicCell>();

        for (int i = 0; i < length * 2; i++) {
            int randomInt = RANDOM_NUMBER_GENERATOR.nextInt(0, database.getDatabase().size());

            MelodicCell cell = database.getDatabase().get(randomInt).copy();         /* Must use copy() to avoid issues */

            cell.setTitle("cell_" + i + "_" + randomInt);
            phrase.add(cell);
        }

        ArrayList<MelodicCell> phraseAltered = CellTranslate.removeRepeats(phrase, database);

        Part lick = CellTranslate.convertToPart(phraseAltered);

        return lick;
    }
}