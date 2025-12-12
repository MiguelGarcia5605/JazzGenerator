package utils;

import java.util.ArrayList;
import java.util.Random;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import utils.cell.Cell;

public class MusicUtils implements JMC{

    public static final int BASE_MIDI_NOTE = C0;

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    public static final int[] NOTE_OFFSETS = new int[] { /* Used for conversions. */
        0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11, 11
    };

    public static final String[] NOTES_AS_STRINGS = new String[] {
        "B#", "C", "C#", "Db", "D", "D#", "Eb", "E", "Fb", "E#", "F", "F#", "Gb", "G", "G#", "Ab", "A",  "A#", "Bb", "B", "Cb"
    };

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
     * Implements scalar motion between cell's with first notes that are a fifth apart.
     */
    public static ArrayList<Cell> addScalarMotion(ArrayList<Cell> cellList) {

        // Create a copy of the cell list
        ArrayList<Cell> cellListCopy = (ArrayList<Cell>) cellList.clone();

        for (int i = 1; i < cellListCopy.size(); i++) {
            // Get cells you are comparing
            Cell leftMostCell = cellListCopy.get(i - 1).copy();
            Cell rightMostCell = cellList.get(i).copy();

            Note leftMostCellFirstNote = leftMostCell.getNote(0);
            Note rightMostCellFirstNote = rightMostCell.getNote(0);

            if (isFifthInterval(leftMostCellFirstNote, rightMostCellFirstNote)) {

                Cell newCell = leftMostCell.copy();

                // check if its going up or down
                if (leftMostCellFirstNote.getPitch() < rightMostCellFirstNote.getPitch()) {
                    // up
                    for (int j = 0; j < (leftMostCell.length() - 1); j++) {
                        Note nextScalarNote = getNextScalerNoteUp(newCell.getNote(j), JMC.MAJOR_SCALE);
                        newCell.setNote(nextScalarNote, j + 1);
                    }

                    for (Note n : newCell.getNoteArray()) {
                        System.out.println(n.toString());
                    }

                    cellListCopy.set(i - 1, newCell);
                } else {
                    // down
                    for (int j = 0; j < (leftMostCell.length() - 1); j++) {
                        Note nextScalarNote = getNextScalerNoteDown(newCell.getNote(j), JMC.MAJOR_SCALE);
                        newCell.setNote(nextScalarNote, j + 1);
                    }

                    for (Note n : newCell.getNoteArray()) {
                        System.out.println(n.toString());
                    }

                    cellListCopy.set(i - 1, newCell);
                }



            }

        }

        return cellListCopy;
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

        Note nextNote = new Note(nextNotePitch, JMC.EIGHTH_NOTE);

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
        if (scaleDegree != 0) {
            nextNotePitch -= scaleMode[scaleDegree - 1] - scaleMode[scaleDegree - 2];
        } else {
            nextNotePitch -= 12 - scaleMode[scaleMode.length - 1];
        }

        Note nextNote = new Note(nextNotePitch, JMC.EIGHTH_NOTE);

        return nextNote;
    }

    public static boolean isFifthInterval(Note note1, Note note2) {
        int FIFTH_INTERVAL_DIFFERENCE = 7;

        int pitchOne = note1.getPitch();
        int pitchTwo = note2.getPitch();
        int difference = Math.abs(pitchOne - pitchTwo);

        if (difference == FIFTH_INTERVAL_DIFFERENCE) {
            return true;
        } else {
            return false;
        }
    }

    // /**
    //  * Removes adjacent repeated notes and cells.
    //  */
    // public static ArrayList<Cell> removeAdjacentDuplicates(ArrayList<Cell> cellList, CellDatabase database) {

    //     // Create a copy of the cell list
    //     ArrayList<Cell> cellListCopy = (ArrayList<Cell>) cellList.clone();

    //     // Get database list
    //     ArrayList<Cell> databaseList = database.getDatabase();

        
    //     // Iterate through cell list copy
    //     for (int i = 1; i < cellListCopy.size(); i++) {
    //         // Get cells you are comparing
    //         Cell leftMostCell = cellListCopy.get(i - 1).copy();
    //         Cell rightMostCell = cellList.get(i).copy();

    //         // Check if cells are equal
    //         boolean cellsAreEqual = leftMostCell.equals(rightMostCell);

    //         // Check if cells contain adjacent repeating notes
    //         boolean cellsHaveAdjacentDuplicates = hasAdjacentDuplicates(leftMostCell, rightMostCell);

    //         // Replace current Cell if notes are not equal or if cellsHaveAdjacentDuplicates
    //         if (cellsAreEqual || cellsHaveAdjacentDuplicates) {
    //             // Change cell until that statement is false
    //             while (true) {
    //                 Cell randomCell = databaseList.get(RANDOM_NUMBER_GENERATOR.nextInt(0, databaseList.size())).copy();
    //                 cellListCopy.set(i, randomCell);
                    
    //                 if (!leftMostCell.equals(randomCell) && !hasAdjacentDuplicates(leftMostCell, randomCell)) {
    //                     break;
    //                 }
    //             }
    //         }

    //     }

    //     return cellListCopy;
    // }

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
