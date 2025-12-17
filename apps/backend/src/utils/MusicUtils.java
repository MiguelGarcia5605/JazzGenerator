package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.tools.Mod;
import generator.cell.Cell;
import generator.cell.RhythmicCell;
import generator.chord.Chord;
import generator.chord.ChordProgression;
import generator.chord.ChordType;

public final class MusicUtils implements JMC{

    public static final int BASE_MIDI_NOTE = C0;

    public static final String REGEX = "/";

    public static final double DEFAULT_NOTE_LENGTH = EIGHTH_NOTE;

    private static final Random RANDOM_NUMBER_GENERATOR = new Random();

    public static final int[] NOTE_OFFSETS = new int[] { /* Used for conversions. */
        0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11, 11
    };

    public static final String[] NOTES_AS_STRINGS = new String[] {
        "B#", "C", "C#", "Db", "D", "D#", "Eb", "E", "Fb", "E#", "F", "F#", "Gb", "G", "G#", "Ab", "A",  "A#", "Bb", "B", "Cb"
    };

    public static ArrayList<Cell> generateLick(ArrayList<Cell> majorCellsArray, ArrayList<Cell> minorCellsArray, ArrayList<Cell> dominantCellsArray, ArrayList<RhythmicCell> rhythmicCellsArray, ChordProgression chordProgression) {
        ArrayList<Cell> lick = new ArrayList<Cell>();

        // Add random cells from cell database
        for (int i = 0; i < chordProgression.getLength(); i++) {
            Chord currentProgressionChord = chordProgression.getChord(i);

            if (currentProgressionChord.getChordType() == ChordType.MAJOR_SEVENTH) {
                Cell cell1 = majorCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, majorCellsArray.size()));
                Cell cell2 = majorCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, majorCellsArray.size()));
                if (currentProgressionChord.getRootPitch() != cell1.getChord().getRootPitch()) {
                    // transpose cells
                    int amountToTranspose = currentProgressionChord.getRootPitch()  + -cell1.getChord().getRootPitch();
                    int amountToTranspose2 = currentProgressionChord.getRootPitch() + -cell2.getChord().getRootPitch();
                    Mod.transpose(cell1, amountToTranspose);
                    Mod.transpose(cell2, amountToTranspose2);
                }
                lick.add(cell1);
                lick.add(cell2);

            } else if (currentProgressionChord.getChordType() == ChordType.MINOR_SEVENTH) {
                Cell cell1 = minorCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, minorCellsArray.size()));
                Cell cell2 = minorCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, minorCellsArray.size()));
                lick.add(cell1);
                lick.add(cell2);
                if (currentProgressionChord.getRootPitch() != cell1.getChord().getRootPitch()) {
                    // transpose cells
                    int amountToTranspose = currentProgressionChord.getRootPitch()  + -cell1.getChord().getRootPitch();
                    int amountToTranspose2 = currentProgressionChord.getRootPitch() + -cell2.getChord().getRootPitch();
                    Mod.transpose(cell1, amountToTranspose);
                    Mod.transpose(cell2, amountToTranspose2);
                }
                
            } else if (currentProgressionChord.getChordType() == ChordType.DOMINANT_SEVENTH) {
                Cell cell1 = dominantCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, dominantCellsArray.size()));
                Cell cell2 = dominantCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, dominantCellsArray.size()));
                if (currentProgressionChord.getRootPitch() != cell1.getChord().getRootPitch()) {
                    // transpose cells
                    int amountToTranspose = currentProgressionChord.getRootPitch()  + -cell1.getChord().getRootPitch();
                    int amountToTranspose2 = currentProgressionChord.getRootPitch() + -cell2.getChord().getRootPitch();
                    Mod.transpose(cell1, amountToTranspose);
                    Mod.transpose(cell2, amountToTranspose2);
                }
                lick.add(cell1);
                lick.add(cell2);
            }
        }

        // loop through lick and modify cell
        for (int i = 0; i < (lick.size() - 1); i++) {
            Cell currentCell = lick.get(i);
            Cell nextCell = lick.get(i + 1);
            
            // Check if lick has adjacent duplicate cells or notes
            boolean hasDuplicateNotes = MusicUtils.hasAdjacentDuplicateNotes(currentCell, nextCell);
            boolean hasDuplicateCells = MusicUtils.hasAdjacentDuplicateCells(currentCell, nextCell);

            if (hasDuplicateNotes || hasDuplicateCells) {
                // replace cell until false
                while (true) {
                    Chord currentProgressionChord = chordProgression.getChord((i / 2));
                    Chord currentCellChord = lick.get(i).getChord();
    
                    if (currentProgressionChord.getChordType() == ChordType.MAJOR_SEVENTH) {
                        Cell replacement = majorCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, majorCellsArray.size()));
                        if (currentProgressionChord.getRootPitch() != currentCellChord.getRootPitch()) {
                            // transpose cells
                            int amountToTranspose = currentProgressionChord.getRootPitch()  + -currentCellChord.getRootPitch();
                            Mod.transpose(replacement, amountToTranspose);
                        }
                        lick.set(i, replacement);
    
                    } else if (currentProgressionChord.getChordType() == ChordType.MINOR_SEVENTH) {
                        Cell replacement = minorCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, minorCellsArray.size()));
                        if (currentProgressionChord.getRootPitch() != currentCellChord.getRootPitch()) {
                            // transpose cells
                            int amountToTranspose = currentProgressionChord.getRootPitch()  + -currentCellChord.getRootPitch();
                            Mod.transpose(replacement, amountToTranspose);
                        }
                        lick.set(i, replacement);
                        
                    } else if (currentProgressionChord.getChordType() == ChordType.DOMINANT_SEVENTH) {
                        Cell replacement = dominantCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, dominantCellsArray.size()));
                        if (currentProgressionChord.getRootPitch() != currentCellChord.getRootPitch()) {
                            // transpose cells
                            int amountToTranspose = currentProgressionChord.getRootPitch()  + -currentCellChord.getRootPitch();
                            Mod.transpose(replacement, amountToTranspose);
                        }
                        lick.set(i, replacement);

                    }

                    // Check if lick has adjacent duplicate cells or notes
                    hasDuplicateNotes = MusicUtils.hasAdjacentDuplicateNotes(lick.get(i), nextCell);
                    hasDuplicateCells = MusicUtils.hasAdjacentDuplicateCells(lick.get(i), nextCell);

                    if (!hasDuplicateNotes && !hasDuplicateCells) {
                        break;
                    }
                }

            }

            // Check if first notes are a fifth apart
            Cell newCurrentCell = lick.get(i);
            Cell newNextCell = lick.get(i + 1);

            Note currentCellFirstNote = newCurrentCell.getNote(0);
            Note nextCellFirstNote = newNextCell.getNote(0);

            int firstNotesAreFifths = MusicUtils.isFifthInterval(currentCellFirstNote, nextCellFirstNote);

            // Add scalar motion if true
            if (firstNotesAreFifths == 1) {
                // going up
                Cell scalerCell = new Cell();
                scalerCell.add(currentCellFirstNote);

                for (int k = 0; k  < (newCurrentCell.length() - 1); k++) {
                    scalerCell.add(MusicUtils.getNextScalerNoteUp(scalerCell.getNote(k), newCurrentCell.getChord()));
                }

                lick.set(i, scalerCell);


            } else if (firstNotesAreFifths == -1) {
                // going down
                Cell scalerCell  = new Cell();
                scalerCell.add(currentCellFirstNote);

                for (int k = 0; k  < (currentCell.length() - 1); k++) {
                    scalerCell.add(MusicUtils.getNextScalerNoteDown(scalerCell.getNote(k), currentCell.getChord()));
                }

                lick.set(i, scalerCell);
            }

            // // Apply Rhythnic Translation
            Cell modifiedCell = MusicUtils.applyRhythmicTranslation(lick.get(i), rhythmicCellsArray.get(RANDOM_NUMBER_GENERATOR.nextInt(0, rhythmicCellsArray.size())));

            lick.set(i, modifiedCell);

        }

        return lick;
    }

    /**
     * converts a note name as a string to an integer. for example C4 to 60.
     * @param note
     * @return
    
    */
    public static int stringToPitch(String note) {
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

    /*
        C4-E4-G4-B4-maj7-C4
     */
    public static Cell stringToCell(String string) {
        // seperate notes, chord type, and root note
        String[] stringArray = string.split(REGEX);

        // Extract Chord From End
        int rootNote = MusicUtils.stringToPitch(stringArray[stringArray.length - 1]);
        String chordTypeAsString = stringArray[stringArray.length - 2];
        Chord extractedChord = new Chord(chordTypeAsString, rootNote);

        String[] noteArrayAsStrings = Arrays.copyOf(stringArray, stringArray.length - 2);
        
        // Convert string array To Midi Values
        ArrayList<Integer> midiValues = new ArrayList<Integer>();

        for (String s: noteArrayAsStrings) {
            midiValues.add(stringToPitch(s));
        }

        // Convert To Note Objects
        Note[] notes = new Note[midiValues.size()];

        for (int i = 0; i < midiValues.size(); i++) {
            notes[i] = new Note(midiValues.get(i), DEFAULT_NOTE_LENGTH);
        }

        return new Cell(notes, extractedChord);  
    }

    /*
        0.5-0.5-0.5-0.5
     */
    public static RhythmicCell stringToRhythmicCell(String string) {
        String[] stringArray = string.split(REGEX);

        // Convert string array integers
        double[] rhythmicValuesArray = new double[stringArray.length];

        for (int i = 0; i < rhythmicValuesArray.length; i++) {
            rhythmicValuesArray[i] = Double.parseDouble(stringArray[i]);
        }

        return new RhythmicCell(rhythmicValuesArray);
    }

    public static ChordProgression stringToChordProgression(String string) {
        System.out.println(string);
        String[] stringArray = string.split(REGEX);
        System.out.println(Arrays.toString(stringArray));
        Chord[] chords = new Chord[stringArray.length];

        for (int i = 0; i < chords.length; i++) {
            chords[i] = MusicUtils.stringToChord(stringArray[i]);
        }

        ChordProgression chordProgression = new ChordProgression(chords);

        return chordProgression;
    }

    // Cmaj7
    public static Chord stringToChord(String string) {
        int rootPitch = MusicUtils.stringToPitch(string.substring(0, string.length() - 4) + "4");
        String chordType = string.substring(string.length() - 4);
        return new Chord(chordType, rootPitch);
    }
}
