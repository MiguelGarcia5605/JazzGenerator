package generator.tests.utils.get_next_scaler_notes;

import generator.chord.Chord;
import generator.chord.ChordType;
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
        Note secondNote = MusicUtils.getNextScalerNoteDown(startingNote, new Chord(ChordType.MINOR_SEVENTH, C4));
        Note thirdNote = MusicUtils.getNextScalerNoteDown(secondNote, new Chord(ChordType.MINOR_SEVENTH, C4));
        Note fourthNote = MusicUtils.getNextScalerNoteDown(thirdNote, new Chord(ChordType.MINOR_SEVENTH, C4));

        System.out.println(startingNote);
        System.out.println(secondNote);
        System.out.println(thirdNote);
        System.out.println(fourthNote);

        System.out.println("\nCASE 2 \n ------------------------------------------");

        // Case 2 - 63, 65, 67, 69; Cmin7 chord going up
        Note startingNote2 = new Note(63, EIGHTH_NOTE);
        Note secondNote2 = MusicUtils.getNextScalerNoteUp(startingNote2, new Chord(ChordType.MINOR_SEVENTH, C4));
        Note thirdNote2 = MusicUtils.getNextScalerNoteUp(secondNote2, new Chord(ChordType.MINOR_SEVENTH, C4));
        Note fourthNote2 = MusicUtils.getNextScalerNoteUp(thirdNote2, new Chord(ChordType.MINOR_SEVENTH, C4));

        System.out.println(startingNote2);
        System.out.println(secondNote2);
        System.out.println(thirdNote2);
        System.out.println(fourthNote2);

        System.out.println("\nCASE 3 \n ------------------------------------------");

        // Case 3 - 70, 72, 74, 75; Cmin7 chord going up
        Note startingNote3 = new Note(AS4, EIGHTH_NOTE);
        Note secondNote3 = MusicUtils.getNextScalerNoteUp(startingNote3, new Chord(ChordType.MINOR_SEVENTH, C4));
        Note thirdNote3 = MusicUtils.getNextScalerNoteUp(secondNote3, new Chord(ChordType.MINOR_SEVENTH, C4));
        Note fourthNote3 = MusicUtils.getNextScalerNoteUp(thirdNote3, new Chord(ChordType.MINOR_SEVENTH, C4));

        System.out.println(startingNote3);
        System.out.println(secondNote3);
        System.out.println(thirdNote3);
        System.out.println(fourthNote3);

        System.out.println("\nCASE 4 \n ------------------------------------------");

        // Case 4 - 76, 77, 79, 81; Dmin7 chord going up
        Note startingNote4 = new Note(E5, EIGHTH_NOTE);
        Note secondNote4 = MusicUtils.getNextScalerNoteUp(startingNote4, new Chord(ChordType.MINOR_SEVENTH, D5));
        Note thirdNote4 = MusicUtils.getNextScalerNoteUp(secondNote4, new Chord(ChordType.MINOR_SEVENTH, D5));
        Note fourthNote4 = MusicUtils.getNextScalerNoteUp(thirdNote4, new Chord(ChordType.MINOR_SEVENTH, D5));

        System.out.println(startingNote4);
        System.out.println(secondNote4);
        System.out.println(thirdNote4);
        System.out.println(fourthNote4);

        System.out.println("\nCASE 5 \n ------------------------------------------");

        // Case 5 - 59, 60, 62, 64; Dmin7 chord going up
        Note startingNote5 = new Note(B3, EIGHTH_NOTE);
        Note secondNote5 = MusicUtils.getNextScalerNoteUp(startingNote5, new Chord(ChordType.MINOR_SEVENTH, D4));
        Note thirdNote5 = MusicUtils.getNextScalerNoteUp(secondNote5, new Chord(ChordType.MINOR_SEVENTH, D4));
        Note fourthNote5 = MusicUtils.getNextScalerNoteUp(thirdNote5, new Chord(ChordType.MINOR_SEVENTH, D4));

        System.out.println(startingNote5);
        System.out.println(secondNote5);
        System.out.println(thirdNote5);
        System.out.println(fourthNote5);

        System.out.println("\nCASE 6 \n ------------------------------------------");

        // Case 5 - 83, 84, 86, 88; Dmin7 chord going up
        Note startingNote6 = new Note(B5, EIGHTH_NOTE);
        Note secondNote6 = MusicUtils.getNextScalerNoteUp(startingNote6, new Chord(ChordType.MINOR_SEVENTH, D4));
        Note thirdNote6 = MusicUtils.getNextScalerNoteUp(secondNote6, new Chord(ChordType.MINOR_SEVENTH, D4));
        Note fourthNote6 = MusicUtils.getNextScalerNoteUp(thirdNote6, new Chord(ChordType.MINOR_SEVENTH, D4));

        System.out.println(startingNote6);
        System.out.println(secondNote6);
        System.out.println(thirdNote6);
        System.out.println(fourthNote6);

    }

}
