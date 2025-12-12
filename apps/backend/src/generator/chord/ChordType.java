package generator.chord;

public class ChordType {

    public static final int
        MAJOR_SEVENTH = 0,
        MINOR_SEVENTH = 1,
        DOMINANT_SEVENTH = 2,
        HALF_DIMINISHED_SEVENTH = 3;

    public int mChordType;

    public ChordType(int chordType) {
        mChordType = chordType;
    }

    public ChordType(String string) {
        mChordType = stringToChordType(string);
    }

    public int getChordType() {
        return mChordType;
    }

    private static int stringToChordType(String string) {
        switch (string) {
            case "maj7":
                return MAJOR_SEVENTH;
            case "min7":
                return MINOR_SEVENTH;
            case "dom7":
                return DOMINANT_SEVENTH;
            case "halfdim7":
                return HALF_DIMINISHED_SEVENTH; 
            default:
                return 0;   
        }
    }

    public static String chordTypeToString(int chordType) {
        switch (chordType) {
            case 0:
                return "maj7";
            case 1:
                return "min7";
            case 2:
                return "dom7";
            case 3:
                return "halfdim7"; 
            default:
                return "null";   
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChordType) {
            ChordType chord = (ChordType) obj;
            if (this.getChordType() == chord.getChordType()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}