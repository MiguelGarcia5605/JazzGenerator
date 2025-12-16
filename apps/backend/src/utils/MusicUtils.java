package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import generator.cell.Cell;
import generator.cell.RhythmicCell;
import generator.chord.Chord;
import generator.chord.ChordProgression;

public final class MusicUtils implements JMC{

    public static final int BASE_MIDI_NOTE = C0;

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    public static final int[] NOTE_OFFSETS = new int[] { /* Used for conversions. */
        0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11, 11
    };

    public static final String[] NOTES_AS_STRINGS = new String[] {
        "B#", "C", "C#", "Db", "D", "D#", "Eb", "E", "Fb", "E#", "F", "F#", "Gb", "G", "G#", "Ab", "A",  "A#", "Bb", "B", "Cb"
    };

    public static ArrayList<Cell> generateLick(ArrayList<Cell> cellDatabase, ArrayList<RhythmicCell> rhythmicCellDatabase, ChordProgression chordProgression) {
        ArrayList<Cell> lick = new ArrayList<Cell>();

        // Add random cells from cell database
        for (int i = 0; i < chordProgression.getLength(); i++) {
            lick.add(cellDatabase.get(i).copy()); // randomize later RANDOM_NUMBER_GENERATOR.nextInt(0, cellDatabase.size())
        }

        // loop through lick and modify cell
        for (int i = 0; i < (lick.size() - 1); i++) {
            Cell currentCell = lick.get(i).copy();
            Cell nextCell = lick.get(i + 1).copy();

            Cell modifiedCell = new Cell();


            
            // Check if lick has adjacent duplicate cells or notes
            boolean hasDuplicateNotes = MusicUtils.hasAdjacentDuplicateNotes(currentCell, nextCell);
            boolean hasDuplicateCells = MusicUtils.hasAdjacentDuplicateCells(currentCell, nextCell);

            if (hasDuplicateNotes || hasDuplicateCells) {
                // replace cell until false

            }

            // Check if first notes are a fifth apart
            Note currentCellFirstNote = currentCell.getNote(0);
            Note nextCellFirstNote = nextCell.getNote(0);

            int firstNotesAreFifths = MusicUtils.isFifthInterval(currentCellFirstNote, nextCellFirstNote);

            // Add scalar motion if true
            if (firstNotesAreFifths == 1) {
                // going up
                Cell scalerCell  = new Cell();
                scalerCell.add(currentCellFirstNote);

                for (int k = 0; k  < (currentCell.length() - 1); k++) {
                    scalerCell.add(MusicUtils.getNextScalerNoteUp(scalerCell.getNote(k), currentCell.getChord()));
                }

                modifiedCell = scalerCell.copy();


            } else if (firstNotesAreFifths == -1) {
                // going down
                Cell scalerCell  = new Cell();
                scalerCell.add(currentCellFirstNote);

                for (int k = 0; k  < (currentCell.length() - 1); k++) {
                    scalerCell.add(MusicUtils.getNextScalerNoteDown(scalerCell.getNote(k), currentCell.getChord()));
                }

                modifiedCell = scalerCell.copy();
            }

            // // Apply Rhythnic Translation
            modifiedCell = MusicUtils.applyRhythmicTranslation(modifiedCell, rhythmicCellDatabase.get(i)).copy();

            lick.set(i, modifiedCell);

        }


        return lick;
    }

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

    public static Note getNextScalerNoteUp(Note startingNote, Chord chord) {

        int[] scaleMode = chord.getScaleMode();
        int chordRootPitch = chord.getRootPitch();

        // Get scale degree
        int startingNotePitch = startingNote.getPitch();
        int scaleDegree = 1;

        int k = (startingNotePitch % 12);

        if (k == 0) {
            k = 12;
        }

        int difference =  k - (chordRootPitch % 12);
        for (int i = 0; i < scaleMode.length; i++) {
            if (scaleMode[i] == difference) {
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

    public static Note getNextScalerNoteDown(Note startingNote, Chord chord) {

        int[] scaleMode = chord.getScaleMode();
        int chordRootPitch = chord.getRootPitch();

        // Get scale degree
        int startingNotePitch = startingNote.getPitch();
        int scaleDegree = 1;

        int k = (startingNotePitch % 12);

        if (k == 0) {
            k = 12;
        }

        int difference =  k - (chordRootPitch % 12);
        for (int i = 0; i < scaleMode.length; i++) {
            if (scaleMode[i] == difference) {
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
