package generator.tests.utils.rhythmic_cell_translation;

import java.util.Arrays;

import generator.cell.Cell;
import generator.cell.RhythmicCell;
import generator.chord.Chord;
import generator.chord.ChordType;
import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.util.Write;
import utils.MusicUtils;

/**
 * Checks if two cells have adjacent duplicates.
 */
public class Test implements JMC{

    public static void main(String[] args) {
        // Dmin7
        Note[] phraseOneNotes = new Note[] {
            new Note(E5, EIGHTH_NOTE),
            new Note(F5, EIGHTH_NOTE),
            new Note(CS5, EIGHTH_NOTE),
            new Note(E5, EIGHTH_NOTE),
        };
    
        Note[] phraseTwoNotes = new Note[] {
            new Note(D5, EIGHTH_NOTE),
            new Note(E5, EIGHTH_NOTE),
            new Note(F5, EIGHTH_NOTE),
            new Note(G5, EIGHTH_NOTE),
        };

        // Gdom7
        Note[] phraseThreeNotes = new Note[] {
            new Note(A5, EIGHTH_NOTE),
            new Note(F5, EIGHTH_NOTE),
            new Note(E5, EIGHTH_NOTE),
            new Note(D5, EIGHTH_NOTE),
        };
    
        Note[] phraseFourNotes = new Note[] {
            new Note(EF5, EIGHTH_NOTE),
            new Note(B4, EIGHTH_NOTE),
            new Note(BF4, EIGHTH_NOTE),
            new Note(AF4, EIGHTH_NOTE),
        };
    
        // Cmaj7
        Note[] phraseFiveNotes = new Note[] {
            new Note(G4, WHOLE_NOTE),
        };

        Cell cell1 = new Cell(phraseOneNotes, new Chord(ChordType.MINOR_SEVENTH, D4));
        Cell cell2 = new Cell(phraseTwoNotes, new Chord(ChordType.MINOR_SEVENTH, D4));
        Cell cell3 = new Cell(phraseThreeNotes, new Chord(ChordType.DOMINANT_SEVENTH, G4));
        Cell cell4 = new Cell(phraseFourNotes, new Chord(ChordType.DOMINANT_SEVENTH, G4));
        Cell cell5 = new Cell(phraseFiveNotes, new Chord(ChordType.MAJOR_SEVENTH, C4));

        double[] rhythmicCell1Values = new double[] {
            QUARTER_NOTE,
            0.0,
            EIGHTH_NOTE, 
            EIGHTH_NOTE
        };

        double[] rhythmicCell2Values = new double[] {
            EIGHTH_NOTE,
            EIGHTH_NOTE,
            EIGHTH_NOTE, 
            EIGHTH_NOTE
        };

        double[] rhythmicCell3Values = new double[] {
            -EIGHTH_NOTE,
            EIGHTH_NOTE,
            EIGHTH_NOTE, 
            EIGHTH_NOTE
        };

        double[] rhythmicCell4Values = new double[] {
            QUARTER_NOTE,
            EIGHTH_NOTE_TRIPLET,
            EIGHTH_NOTE_TRIPLET, 
            EIGHTH_NOTE_TRIPLET
        };

        double[] rhythmicCell5Values = new double[] {
            WHOLE_NOTE,
            0.0,
            0.0, 
            0.0
        };

        RhythmicCell rhythmicCell1 = new RhythmicCell(rhythmicCell1Values);
        RhythmicCell rhythmicCell2 = new RhythmicCell(rhythmicCell2Values);
        RhythmicCell rhythmicCell3 = new RhythmicCell(rhythmicCell3Values);
        RhythmicCell rhythmicCell4 = new RhythmicCell(rhythmicCell4Values);
        RhythmicCell rhythmicCell5 = new RhythmicCell(rhythmicCell5Values);

        Cell translatedCell1 = MusicUtils.applyRhythmicTranslation(cell1, rhythmicCell1);
        Cell translatedCell2 = MusicUtils.applyRhythmicTranslation(cell2, rhythmicCell2);
        Cell translatedCell3 = MusicUtils.applyRhythmicTranslation(cell3, rhythmicCell3);

        System.out.println(translatedCell3.toString());
        Cell translatedCell4 = MusicUtils.applyRhythmicTranslation(cell4, rhythmicCell4);
        Cell translatedCell5 = MusicUtils.applyRhythmicTranslation(cell5, rhythmicCell5);

        Part part = new Part();
        part.add(cell1);
        part.add(cell2);
        part.add(cell3);
        part.add(cell4);
        part.add(cell5);

        Part translatedPart = new Part();
        translatedPart.add(translatedCell1);
        translatedPart.add(translatedCell2);
        translatedPart.add(translatedCell3);
        translatedPart.add(translatedCell4);
        translatedPart.add(translatedCell5);


        Write.midi(part, "cell.mid");
        Write.midi(translatedPart, "translatedCell.mid");
    }
}