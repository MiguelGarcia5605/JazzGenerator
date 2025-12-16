package generator.tests.utils.remove_adjacent_duplicate_notes_and_cells;

import generator.cell.Cell;
import generator.chord.Chord;
import generator.chord.ChordType;
import jm.JMC;
import jm.music.data.Note;
import utils.MusicUtils;

/**
 * Checks if two cells have adjacent duplicates.
 */
public class Test implements JMC{

    public static void main(String[] args) {
        // Case 1 = True, False; duplicate adjacent notes
        Note[] phraseOneNotes = new Note[] {
            new Note(C4, EIGHTH_NOTE),
            new Note(E4, EIGHTH_NOTE),
            new Note(G4, EIGHTH_NOTE),
            new Note(B4, EIGHTH_NOTE),
        };
    
        Note[] phraseTwoNotes = new Note[] {
            new Note(B4, EIGHTH_NOTE),
            new Note(C4, EIGHTH_NOTE),
            new Note(E4, EIGHTH_NOTE),
            new Note(G4, EIGHTH_NOTE),
        };
    
        Cell phrase1 = new Cell(phraseOneNotes, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Cell phrase2 = new Cell(phraseTwoNotes, new Chord(ChordType.MAJOR_SEVENTH, C4));

        // Case 2 = False, True; duplicate adjacent cells
        Note[] phraseThreeNotes = new Note[] {
            new Note(C4, EIGHTH_NOTE),
            new Note(E4, EIGHTH_NOTE),
            new Note(G4, EIGHTH_NOTE),
            new Note(B4, EIGHTH_NOTE),
        };
    
        Note[] phraseFourNotes = new Note[] {
            new Note(C4, EIGHTH_NOTE),
            new Note(E4, EIGHTH_NOTE),
            new Note(G4, EIGHTH_NOTE),
            new Note(B4, EIGHTH_NOTE),
        };
    
        Cell phrase3 = new Cell(phraseThreeNotes, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Cell phrase4 = new Cell(phraseFourNotes, new Chord(ChordType.MAJOR_SEVENTH, C4));

        // Case 3 = True, True; duplicate adjacent cells and notes
        Note[] phraseFiveNotes = new Note[] {
            new Note(B4, EIGHTH_NOTE),
            new Note(E4, EIGHTH_NOTE),
            new Note(G4, EIGHTH_NOTE),
            new Note(B4, EIGHTH_NOTE),
        };
    
        Note[] phraseSixNotes = new Note[] {
            new Note(B4, EIGHTH_NOTE),
            new Note(E4, EIGHTH_NOTE),
            new Note(G4, EIGHTH_NOTE),
            new Note(B4, EIGHTH_NOTE),
        };
    
        Cell phrase5 = new Cell(phraseFiveNotes, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Cell phrase6 = new Cell(phraseSixNotes, new Chord(ChordType.MAJOR_SEVENTH, C4));

        // Case 2 = False, False; duplicate adjacent cells
        Note[] phraseSevenNotes = new Note[] {
            new Note(C4, EIGHTH_NOTE),
            new Note(E4, EIGHTH_NOTE),
            new Note(G4, EIGHTH_NOTE),
            new Note(B4, EIGHTH_NOTE),
        };
    
        Note[] phraseEightNotes = new Note[] {
            new Note(C4, EIGHTH_NOTE),
            new Note(E4, EIGHTH_NOTE),
            new Note(B4, EIGHTH_NOTE),
            new Note(G4, EIGHTH_NOTE),
        };
    
        Cell phrase7 = new Cell(phraseSevenNotes, new Chord(ChordType.MAJOR_SEVENTH, C4));
        Cell phrase8 = new Cell(phraseEightNotes, new Chord(ChordType.MAJOR_SEVENTH, C4));
    
        boolean caseOneNoteResults = MusicUtils.hasAdjacentDuplicateNotes(phrase1, phrase2);
        boolean caseOneCellResults = MusicUtils.hasAdjacentDuplicateCells(phrase1, phrase2);

        boolean caseTwoNoteResults = MusicUtils.hasAdjacentDuplicateNotes(phrase3, phrase4);
        boolean caseTwoCellResults = MusicUtils.hasAdjacentDuplicateCells(phrase3, phrase4);

        boolean caseThreeNoteResults = MusicUtils.hasAdjacentDuplicateNotes(phrase5, phrase6);
        boolean caseThreeCellResults = MusicUtils.hasAdjacentDuplicateCells(phrase5, phrase6);

        boolean caseFourNoteResults = MusicUtils.hasAdjacentDuplicateNotes(phrase7, phrase8);
        boolean caseFourCellResults = MusicUtils.hasAdjacentDuplicateCells(phrase7, phrase8);

        System.out.println("CASE 1: " + "\nduplicate notes = " + caseOneNoteResults + "\nduplicate cells = " + caseOneCellResults);
        System.out.println("CASE 2: "+ "\nduplicate notes = " + caseTwoNoteResults + "\nduplicate cells = " + caseTwoCellResults);
        System.out.println("CASE 3: "+ "\nduplicate notes = " + caseThreeNoteResults + "\nduplicate cells = " + caseThreeCellResults);
        System.out.println("CASE 4: "+ "\nduplicate notes = " + caseFourNoteResults + "\nduplicate cells = " + caseFourCellResults);

    }

}
