package generator.chord;

public class Chord extends ChordType{

    public int mRootPitch;

    public Chord(int chordType, int rootPitch) {
        super(chordType);
        mRootPitch = rootPitch;
    }

    public Chord(String string, int rootPitch) {
        super(string);
        mRootPitch = rootPitch;
    }
}
