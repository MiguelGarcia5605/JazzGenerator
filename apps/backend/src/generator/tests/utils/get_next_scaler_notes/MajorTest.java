package generator.tests.utils.get_next_scaler_notes;

import generator.chord.Chord;
import generator.chord.ChordType;
import jm.JMC;
import jm.music.data.Note;
import utils.MusicUtils;

/**
 * Checks if two cells have adjacent duplicates.
 */
public class MajorTest implements JMC{

    public static void main(String[] args) {

        System.out.println("CASE 1 \n ------------------------------------------");

        // Case 1 - 60, 62, 64, 65; Cmaj7 chord going up
        Note startingNote = new Note(C4, EIGHTH_NOTE);
        Note secondNote = MusicUtils.getNextScalerNoteUp(startingNote, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Note thirdNote = MusicUtils.getNextScalerNoteUp(secondNote, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Note fourthNote = MusicUtils.getNextScalerNoteUp(thirdNote, new Chord(Chord.MAJOR_SEVENTH, C4));

        System.out.println(startingNote);
        System.out.println(secondNote);
        System.out.println(thirdNote);
        System.out.println(fourthNote);

        System.out.println("\nCASE 2 \n ------------------------------------------");

        // Case 2 - 60, 59, 57, 55; Cmaj7 chord going down
        Note startingNote2 = new Note(C4, EIGHTH_NOTE);
        Note secondNote2 = MusicUtils.getNextScalerNoteDown(startingNote2, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Note thirdNote2 = MusicUtils.getNextScalerNoteDown(secondNote2, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Note fourthNote2 = MusicUtils.getNextScalerNoteDown(thirdNote2, new Chord(ChordType.MAJOR_SEVENTH, C4));

        System.out.println(startingNote2);
        System.out.println(secondNote2);
        System.out.println(thirdNote2);
        System.out.println(fourthNote2);

        System.out.println("\nCASE 3 \n ------------------------------------------");

        // Case 2 - 64, 65, 67, 69; Cmaj7 chord going up
        Note startingNote3 = new Note(E4, EIGHTH_NOTE);
        Note secondNote3 = MusicUtils.getNextScalerNoteUp(startingNote3, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Note thirdNote3 = MusicUtils.getNextScalerNoteUp(secondNote3, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Note fourthNote3 = MusicUtils.getNextScalerNoteUp(thirdNote3, new Chord(ChordType.MAJOR_SEVENTH, C4));

        System.out.println(startingNote3);
        System.out.println(secondNote3);
        System.out.println(thirdNote3);
        System.out.println(fourthNote3);

    }

}
