package generator.chord;

public class ChordProgression {

    Chord[] mChords;

    public ChordProgression(Chord[] chords) {
        mChords = chords;
    }

    public int getLength() {
        return mChords.length;
    }
}
