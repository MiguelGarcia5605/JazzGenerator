package tools;
import jm.music.data.Note;
import jm.music.data.Phrase;

/**
 * This class represents a musical phrase associated with a chord.
 */
public class Cell extends Phrase {
    
    public Chord mChord;

    public Cell() {
        super();
    }

    /**
     * Constructs a Cell Object.
     * @param notes : the notes
     * @param chord : the chord context
     */
    public Cell(Note[] notes, Chord chord) {
        super(notes);
        mChord = chord;
    }
    
    public Chord getChord() {
        return mChord;
    }

    public void setChord(Chord chord) {
        mChord = chord;
    }

    @Override
    public Cell copy() {
        Cell copy = new Cell();
        this.copyAttributesTo(copy);
        return copy;
    }

    private void copyAttributesTo(Cell copy) {
        copy.setChord(this.getChord());
        copy.addNoteList(this.getNoteArray());
        copy.setTitle(this.getTitle() + " copy");
        copy.setInstrument(this.getInstrument());
        copy.setAppend(this.getAppend());
        copy.setPan(this.getPan());
        copy.setLinkedPhrase(this.getLinkedPhrase());
        copy.setMyPart(this.getMyPart());
        copy.setTempo(this.getTempo());
        copy.setNumerator(this.getNumerator());
        copy.setDenominator(this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell otherCell = (Cell) obj;

            if (this.length() == otherCell.length()) {
                // Go Through Note Arrays And Make Sure All Notes Are Equal
                for (int i = 0; i < this.length(); i++) {
                    if (!this.getNoteArray()[i].equals(otherCell.getNoteArray()[i])) {
                        return false;
                    }
                }
            } else {
                return false;
            }

            if (!this.mChord.equals(otherCell.getChord())) {
                return false;
            }

            return true;
        } else {
            return false;
        }
    }
}