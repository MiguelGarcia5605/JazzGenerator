package generator.tests.generater.v1;

import java.util.ArrayList;
import java.util.Arrays;

import generator.cell.Cell;
import generator.cell.RhythmicCell;
import generator.chord.Chord;
import generator.chord.ChordProgression;
import generator.chord.ChordType;
import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.util.Write;
import utils.MusicUtils;

public class Test implements JMC{



    public static void main(String[] args) {

        // Dmin7
        Note[] phraseOneNotes = new Note[] {
            new Note(D5, EIGHTH_NOTE),
            new Note(F5, EIGHTH_NOTE),
            new Note(CS5, EIGHTH_NOTE),
            new Note(E5, EIGHTH_NOTE),
        };

        Note[] phraseTwoNotes = new Note[] {
            new Note(A5, EIGHTH_NOTE),
            new Note(E5, EIGHTH_NOTE),
            new Note(F5, EIGHTH_NOTE),
            new Note(G5, EIGHTH_NOTE),
        };

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

        ArrayList<RhythmicCell> rhythmicCellDatabase = new ArrayList<RhythmicCell>();

        RhythmicCell rhythmicCell1 = new RhythmicCell(rhythmicCell1Values);
        RhythmicCell rhythmicCell2 = new RhythmicCell(rhythmicCell2Values);

        rhythmicCellDatabase.add(rhythmicCell1);
        rhythmicCellDatabase.add(rhythmicCell2);

        ArrayList<Cell> cellDatabase = new ArrayList<Cell>() {};

        Cell cell1 = new Cell(phraseOneNotes, new Chord(ChordType.MINOR_SEVENTH, D4));
        Cell cell2 = new Cell(phraseTwoNotes, new Chord(ChordType.MINOR_SEVENTH, D4));

        cellDatabase.add(cell1);
        cellDatabase.add(cell2);

        Chord[] chords = new Chord[] {
            new Chord(ChordType.MINOR_SEVENTH, D4),
            new Chord(ChordType.MINOR_SEVENTH, D4),
        };

        ChordProgression chordProgression = new ChordProgression(chords);

        ArrayList<Cell> lick = MusicUtils.generateLick(cellDatabase, rhythmicCellDatabase, chordProgression);

        Part example = MusicUtils.convertToPart(cellDatabase);

        Write.midi(example, "example.mid");

        Part exampleTranslated = MusicUtils.convertToPart(lick);

        Write.midi(exampleTranslated, "exampleTranslated.mid");
    }
}
