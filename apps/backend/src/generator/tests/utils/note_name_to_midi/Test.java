package generator.tests.utils.note_name_to_midi;

import utils.MusicUtils;

public class Test {

    public static void main(String[] args) {
        // case 1 should return (34)
        int midi1 = MusicUtils.noteNameToMidiValue("A#1");
        System.out.println(midi1);

        // case 2 should return (60)
        int midi2 = MusicUtils.noteNameToMidiValue("C4");
        System.out.println(midi2);
        
    }
}
