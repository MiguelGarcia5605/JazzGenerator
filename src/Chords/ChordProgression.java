package Chords;

import jm.music.data.Note;

/**
 * Represents a musical chord progression
 */
public class ChordProgression {

    Chord[] mChords;
    Note[] mRootNotes;

    public ChordProgression(Chord[] chords, Note[] rootNotes) {
        mChords = chords;
        mRootNotes = rootNotes;
    }

    public Chord[] getChords() {
        return mChords;
    }

    public Note[] getRootNotes() {
        return mRootNotes;
    }
}
