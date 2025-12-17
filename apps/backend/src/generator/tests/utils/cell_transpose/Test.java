package generator.tests.utils.cell_transpose;

import generator.cell.Cell;
import generator.chord.Chord;
import generator.chord.ChordType;
import jm.JMC;
import jm.music.data.Note;
import jm.util.Write;
import utils.MusicUtils;

public class Test implements JMC {
    public static void main(String[] args) {
        Note[] phraseOneNotes = new Note[] {
        new Note(E5, EIGHTH_NOTE),
        new Note(F5, EIGHTH_NOTE),
        new Note(D5, EIGHTH_NOTE),
        new Note(E5, EIGHTH_NOTE),
        };

        
        Cell cell = new Cell(phraseOneNotes, new Chord(ChordType.MINOR_SEVENTH, D4));
        Write.midi(cell, "cell.mid");

        MusicUtils.transposeCell(cell, A4);
        Write.midi(cell, "cellTransposed.mid");
    }
}
