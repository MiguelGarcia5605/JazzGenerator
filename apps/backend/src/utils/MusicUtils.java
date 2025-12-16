package utils;

import java.util.ArrayList;
import java.util.Random;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import generator.cell.Cell;
import generator.cell.RhythmicCell;

public final class MusicUtils implements JMC{

    public static final int BASE_MIDI_NOTE = C0;

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    public static final int[] NOTE_OFFSETS = new int[] { /* Used for conversions. */
        0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11, 11
    };

    public static final String[] NOTES_AS_STRINGS = new String[] {
        "B#", "C", "C#", "Db", "D", "D#", "Eb", "E", "Fb", "E#", "F", "F#", "Gb", "G", "G#", "Ab", "A",  "A#", "Bb", "B", "Cb"
    };

    /**
     * converts a note name as a string to an integer. for example C4 to 60.
     * @param note
     * @return
    
    */
    public static int noteNameToMidiValue(String note) {
        int lengthOfString = note.length();
        int octaveNumber = Integer.parseInt(note.substring(lengthOfString - 1, lengthOfString));
        String noteName = note.substring(0, lengthOfString - 1);
        int noteOffset = getNoteOffset(noteName);

        return BASE_MIDI_NOTE + noteOffset + (octaveNumber * 12); /* 12 Notes Total. This expression calculates the Midi Value*/
    }

    private static int getNoteOffset(String note) {
        for (int i = 0; i < NOTES_AS_STRINGS.length; i++) {
            if (NOTES_AS_STRINGS[i].equals(note)) {
                return NOTE_OFFSETS[i];
            }
        }

        return 0;
    }

    public static final Part convertToPart(ArrayList<Cell> cellList) {
        Part part = new Part();

        for (Cell cell : cellList) {
            part.add(cell);
        }

        return part;
    }

    /**
     * 1 = is fifth going up
     * -1 = is fifth going down
     * 0 = is not fifth
     */
    public static int isFifthInterval(Note note1, Note note2) {
        int FIFTH_INTERVAL_CHROMATIC_DIFFERENCE = 7;

        int pitchOne = note1.getPitch();
        int pitchTwo = note2.getPitch();
        int difference = pitchOne - pitchTwo;

        if (difference == -FIFTH_INTERVAL_CHROMATIC_DIFFERENCE) {
            return 1;
        } else if (difference == FIFTH_INTERVAL_CHROMATIC_DIFFERENCE) {
            return -1;
        } else {
            return 0;
        }
    }

    public static Note getNextScalerNoteUp(Note startingNote, int[] scaleMode) {

        // Get scale degree
        int startingNotePitch = startingNote.getPitch();
        int scaleDegree = 1;
        int remainder = startingNotePitch % 12;
        for (int i = 0; i < scaleMode.length; i++) {
            if (scaleMode[i] == remainder) {
                scaleDegree = i + 1;
            }

        }

        int nextNotePitch = startingNotePitch;

        // Get next scalar note
        if (scaleDegree != 7) {
            nextNotePitch += scaleMode[scaleDegree] - scaleMode[scaleDegree - 1];
        } else {
            nextNotePitch += 12 - scaleMode[scaleMode.length - 1];
        }

        Note nextNote = new Note(nextNotePitch, startingNote.getRhythmValue());

        return nextNote;
    }

    public static Note getNextScalerNoteDown(Note startingNote, int[] scaleMode) {

        // Get scale degree
        int startingNotePitch = startingNote.getPitch();
        int scaleDegree = 1;
        int remainder = startingNotePitch % 12;
        for (int i = 0; i < scaleMode.length; i++) {
            if (scaleMode[i] == remainder) {
                scaleDegree = i + 1;
            }

        }

        int nextNotePitch = startingNotePitch;

        // Get next scalar note
        if (scaleDegree != 1) {
            nextNotePitch -= scaleMode[scaleDegree - 1] - scaleMode[scaleDegree - 2];
        } else {
            nextNotePitch -= 12 - scaleMode[scaleMode.length - 1];
        }

        Note nextNote = new Note(nextNotePitch, startingNote.getRhythmValue());

        return nextNote;
    }

    public static boolean hasAdjacentDuplicateNotes(Cell leftMostCell, Cell rightMostCell) {
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

    public static boolean hasAdjacentDuplicateCells(Cell leftMostCell, Cell rightMostCell) {
        boolean isDuplicate = leftMostCell.equals(rightMostCell);
        return isDuplicate;
    }

    public static Cell applyRhythmicTranslation(Cell cell, RhythmicCell rhythmicCell) {
        // apply translation to first note
        Cell translatedCell = new Cell();

        for (int i = 0; i < cell.length(); i++) {

            if (rhythmicCell.getRhythmicValue(i) > 0.0) {
                int newNotePitch = cell.getNote(i).getPitch();
                double newRhythmicValue = rhythmicCell.getRhythmicValue(i);
                Note translatedNote = new Note(newNotePitch, newRhythmicValue);
                translatedCell.add(translatedNote);
    
            } else if (rhythmicCell.getRhythmicValue(i) < 0.0) {
                int newNotePitch = REST;
                double newRhythmicValue = -rhythmicCell.getRhythmicValue(i);
                Note translatedNote = new Note(newNotePitch, newRhythmicValue);
                translatedCell.add(translatedNote);
            }
            
        }

        return translatedCell;
    }
}
