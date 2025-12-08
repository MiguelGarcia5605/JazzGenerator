package Chord;

/**
 * Represents a musical chord.
 */
public class Chord {
    public int mChordValue;

    public Chord(int chord) {
        mChordValue = chord;
    }

    public Chord(String chord) {
        mChordValue = stringToChordValue(chord);
    }

    public int getChordValue() {
        return mChordValue;
    }

    private static int stringToChordValue(String chordName) {
        switch (chordName) {
            case "maj7":
                return ChordConstants.MAJOR_SEVENTH;
            case "min7":
                return ChordConstants.MINOR_SEVENTH;
            case "dom7":
                return ChordConstants.DOMINANT_SEVENTH;
            case "halfdim7":
                return ChordConstants.HALF_DIMINISHED_SEVENTH; 
            default:
                return 0;   
        }
    }

    public static String chordValueToString(int chordValue) {
        switch (chordValue) {
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
}