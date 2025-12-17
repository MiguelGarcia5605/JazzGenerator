package generator.tests.utils.string_to_cell;

import generator.cell.Cell;
import jm.JMC;
import jm.util.Write;
import utils.MusicUtils;

public class Test implements JMC {
    public static void main(String[] args) {
        String text = "C4-Eb4-G4-Bb4-min7-C4";
        Cell test = MusicUtils.stringToCell(text);

        System.out.println(test.toString());
        System.out.println(test.getChord().getChordType());
        System.out.println(test.getChord().getRootPitch());

        Write.midi(test, "test.mid");
    }
}
