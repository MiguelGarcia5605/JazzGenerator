package generator.tests.utils.get_next_scaler_notes;

import jm.JMC;
import jm.music.data.Note;
import utils.MusicUtils;

/**
 * Checks if two cells have adjacent duplicates.
 */
public class MinorTest implements JMC{

    public static void main(String[] args) {

        System.out.println("CASE 1 \n ------------------------------------------");

        // Case 1 - 60, 58, 57, 55; Cmin7 chord going down
        Note startingNote = new Note(C4, EIGHTH_NOTE);
        Note secondNote = MusicUtils.getNextScalerNoteDown(startingNote, DORIAN_SCALE);
        Note thirdNote = MusicUtils.getNextScalerNoteDown(secondNote, DORIAN_SCALE);
        Note fourthNote = MusicUtils.getNextScalerNoteDown(thirdNote, DORIAN_SCALE);

        System.out.println(startingNote);
        System.out.println(secondNote);
        System.out.println(thirdNote);
        System.out.println(fourthNote);

        System.out.println("\nCASE 2 \n ------------------------------------------");

        // Case 2 - 63, 65, 67, 69; Cmin7 chord going up
        Note startingNote2 = new Note(63, EIGHTH_NOTE);
        Note secondNote2 = MusicUtils.getNextScalerNoteUp(startingNote2, DORIAN_SCALE);
        Note thirdNote2 = MusicUtils.getNextScalerNoteUp(secondNote2, DORIAN_SCALE);
        Note fourthNote2 = MusicUtils.getNextScalerNoteUp(thirdNote2, DORIAN_SCALE);

        System.out.println(startingNote2);
        System.out.println(secondNote2);
        System.out.println(thirdNote2);
        System.out.println(fourthNote2);

        System.out.println("\nCASE 3 \n ------------------------------------------");

        // Case 2 - 70, 72, 74, 75; Cmin7 chord going up
        Note startingNote3 = new Note(70, EIGHTH_NOTE);
        Note secondNote3 = MusicUtils.getNextScalerNoteUp(startingNote3, DORIAN_SCALE);
        Note thirdNote3 = MusicUtils.getNextScalerNoteUp(secondNote3, DORIAN_SCALE);
        Note fourthNote3 = MusicUtils.getNextScalerNoteUp(thirdNote3, DORIAN_SCALE);

        System.out.println(startingNote3);
        System.out.println(secondNote3);
        System.out.println(thirdNote3);
        System.out.println(fourthNote3);

    }

}
