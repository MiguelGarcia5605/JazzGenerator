package generator.tests.utils.fifth_interval;

import jm.JMC;
import jm.music.data.Note;
import utils.MusicUtils;

public class Test implements JMC {
    public static void main(String[] args) {
        // Case 1 should return (+1) - is fifth going up
        Note noteOne = new Note(C4, EIGHTH_NOTE);
        Note noteTwo = new Note(G4, EIGHTH_NOTE);
    
        int case1 = MusicUtils.isFifthInterval(noteOne, noteTwo);
        System.out.println("CASE 1: " + "\nis fifth = " + case1);
    
        // Case 2 should return (-1) - is fifth going down
        Note noteThree = new Note(G4, EIGHTH_NOTE);
        Note noteFour = new Note(C4, EIGHTH_NOTE);

        int case2 = MusicUtils.isFifthInterval(noteThree, noteFour);
        System.out.println("CASE 2: " + "\nis fifth = " + case2);
    
        // Case 3 should return (0)- is not a fifth
        Note noteFive = new Note(C4, EIGHTH_NOTE);
        Note noteSix = new Note(F4, EIGHTH_NOTE);

        int case3 = MusicUtils.isFifthInterval(noteFive, noteSix);
        System.out.println("CASE 3: " + "\nis fifth = " + case3);

        // Case 3 should return (+1)- is fifth going up
        Note noteSeven = new Note(E5, EIGHTH_NOTE);
        Note noteEight = new Note(B5, EIGHTH_NOTE);

        int case4 = MusicUtils.isFifthInterval(noteSeven, noteEight);
        System.out.println("CASE 4: " + "\nis fifth = " + case4);
    }
}