package generator.tests.utils.string_to_chord_progression;

import generator.chord.Chord;
import generator.chord.ChordProgression;
import jm.JMC;
import utils.MusicUtils;

public class Test implements JMC {
    public static void main(String[] args) {
        String text = "Gdom7";
        Chord test = MusicUtils.stringToChord(text);

        System.out.println(test.getChordType());
        System.out.println(test.getRootPitch());

        String text2 = "Gdom7-Cmaj7";
        ChordProgression test2 = MusicUtils.stringToChordProgression(text2);

        System.out.println(test2.getChord(0).getChordType());
        System.out.println(test2.getChord(0).getRootPitch());
        System.out.println(test2.getChord(1).getChordType());
        System.out.println(test2.getChord(1).getRootPitch());
    }
}