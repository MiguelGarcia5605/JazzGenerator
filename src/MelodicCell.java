import java.util.Enumeration;
import jm.music.data.Note;
import jm.music.data.Phrase;

/**
 * This class represents a Phrase that is comprised of four eighth notes.
 */
public class MelodicCell extends Phrase {

    public static final int[] MAJOR_MODE = new int[] {0, 2, 4, 5, 7, 9, 11, 12};
    public static final int[] MINOR_MODE = new int[] {0, 2, 3, 5, 7, 9, 10, 12};
    public static final int STARTING_PITCH = C4;
    public String mChord;

    public MelodicCell() {
        super();
    };

    /**
     * Constructs a MelodicCell object using scale degrees.
     * @param scaleDegree1
     * @param scaleDegree2
     * @param scaleDegree3
     * @param scaleDegree4
     * @param chord
     */
    public MelodicCell(int scaleDegree1, int scaleDegree2, int scaleDegree3, int scaleDegree4, String chord) {
        mChord = chord;
        
        if (mChord.equals("maj7")) {
            Note[] noteList = new Note[] {
                new Note(STARTING_PITCH + MAJOR_MODE[scaleDegree1 - 1], EIGHTH_NOTE),
                new Note(STARTING_PITCH + MAJOR_MODE[scaleDegree2 - 1], EIGHTH_NOTE),
                new Note(STARTING_PITCH + MAJOR_MODE[scaleDegree3 - 1], EIGHTH_NOTE),
                new Note(STARTING_PITCH + MAJOR_MODE[scaleDegree4 - 1], EIGHTH_NOTE),
            };
            this.addNoteList(noteList);
        } else if ((mChord.equals("min7"))) {
            Note[] noteList = new Note[] {
                new Note(STARTING_PITCH + MINOR_MODE[scaleDegree1 - 1], EIGHTH_NOTE),
                new Note(STARTING_PITCH + MINOR_MODE[scaleDegree2 - 1], EIGHTH_NOTE),
                new Note(STARTING_PITCH + MINOR_MODE[scaleDegree3 - 1], EIGHTH_NOTE),
                new Note(STARTING_PITCH + MINOR_MODE[scaleDegree4 - 1], EIGHTH_NOTE),
            };
            this.addNoteList(noteList);
        }
    }

    @Override
    public MelodicCell copy() {
        MelodicCell var1 = new MelodicCell();
        this.copyAttributes(var1);
        Enumeration var2 = getNoteList().elements();

        while (var2.hasMoreElements()) {
            var1.addNote(((Note)var2.nextElement()).copy());
        }

        return var1;
    }

    private void copyAttributes(MelodicCell var1) {
        var1.setChord(this.getChord());
        var1.setTitle(this.getTitle() + " copy");
        var1.setInstrument(this.getInstrument());
        var1.setAppend(this.getAppend());
        var1.setPan(this.getPan());
        var1.setLinkedPhrase(this.getLinkedPhrase());
        var1.setMyPart(this.getMyPart());
        var1.setTempo(this.getTempo());
        var1.setNumerator(this.getNumerator());
        var1.setDenominator(this.getDenominator());
    }

    public void setChord(String chord) {
        mChord = chord;
    }

    public String getChord() {
        return mChord;
    }

    @Override 
    public boolean equals(Object obj) {
        if (obj instanceof MelodicCell) {
            MelodicCell cellBeingComparedTo = (MelodicCell) obj;
            Note[] notesOfCellBeingCompared = this.getNoteArray();
            Note[] notesOfCellBeingComparedTo = cellBeingComparedTo.getNoteArray();
            boolean cellsAreEqual = true;
    
            for (int i = 0; i < 4; i++) {
                if (notesOfCellBeingCompared[i].getPitch() != notesOfCellBeingComparedTo[i].getPitch()) {
                    cellsAreEqual = false;
                    break;
                }
            }

            if (!mChord.equals(cellBeingComparedTo.getChord())) {
                cellsAreEqual = false;
            }
    
            return cellsAreEqual;
        } else {
            return false;
        }
    }
}