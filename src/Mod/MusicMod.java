package Mod;
import java.util.ArrayList;
import java.util.Arrays;
import Cell.Cell;
import Chord.Chord;
import jm.JMC;
import jm.music.data.Note;

/**
 * This class includes various methods useful for manipulating musical data.
 */
public class MusicMod implements JMC{

    public static final String REGEX = "-";
    public static final double DEFAULT_NOTE_LENGTH = EIGHTH_NOTE;
    public static final int BASE_MIDI_NOTE = C0;

    public static final int[] NOTE_OFFSETS = new int[] { /* Used for conversions. */
        0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11, 11
    };

    public static final String[] NOTES_AS_STRINGS = new String[] {
        "B#", "C", "C#", "Db", "D", "D#", "Eb", "E", "Fb", "E#", "F", "F#", "Gb", "G", "G#", "Ab", "A",  "A#", "Bb", "B", "Cb"
    };
    
    /**
     * Takes a string and converts it to a cell using the given text format in Cell Database.
     * This will assume all notes are eighth notes.
     * @param text : the string to convert
     * @return : a cell representation of the string
     */
    public static Cell stringToCell(String text) {
        String[] cellStringsWithChord = text.split(REGEX);

        // Extract Chord From End
        Chord chordContext = new Chord(cellStringsWithChord[cellStringsWithChord.length - 1]);
        String[] cellStrings = Arrays.copyOf(cellStringsWithChord, cellStringsWithChord.length - 1);
        
        // Convert Cell Strings To Midi Values
        ArrayList<Integer> cellMidiValues = new ArrayList<Integer>();
        for (String noteName: cellStrings) {
            cellMidiValues.add(noteNameToMidiValue(noteName));
        }

        // Convert To Note Objects
        Note[] notes = new Note[cellMidiValues.size()];

        for (int i = 0; i < cellMidiValues.size(); i++) {
            notes[i] = new Note(cellMidiValues.get(i), DEFAULT_NOTE_LENGTH);
        }

        return new Cell(notes, chordContext);  
    }

    /**
     * Converts a note name to its midi value.
     * @param note : the midi note as text
     * @return the midi note as an int
     */
    public static int noteNameToMidiValue(String note) {
        int lengthOfString = note.length();
        int octaveNumber = Integer.parseInt(note.substring(lengthOfString - 1, lengthOfString));
        String noteName = note.substring(0, lengthOfString - 1);
        int noteOffset = getNoteOffset(noteName);

        return BASE_MIDI_NOTE + noteOffset + (octaveNumber * 12); /* 12 Notes Total. This expression calculates the Midi Value*/
    }

    /**
     * Calculates the offset from the given note to the base midi note.
     * @param note : the given note as a string
     * @return the offset
     */
    private static int getNoteOffset(String note) {
        for (int i = 0; i < NOTES_AS_STRINGS.length; i++) {
            if (NOTES_AS_STRINGS[i].equals(note)) {
                return NOTE_OFFSETS[i];
            }
        }

        return 0;
    }
}
