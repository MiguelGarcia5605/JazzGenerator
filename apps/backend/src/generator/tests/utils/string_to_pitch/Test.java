package generator.tests.utils.string_to_pitch;

import utils.MusicUtils;

public class Test {

    public static void main(String[] args) {
        // case 1 should return (34)
        int midi1 = MusicUtils.stringToPitch("A#1");
        System.out.println(midi1);

        // case 2 should return (60)
        int midi2 = MusicUtils.stringToPitch("C4");
        System.out.println(midi2);
        
    }
}
