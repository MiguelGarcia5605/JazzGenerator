import java.util.Random;

import jm.JMC;
import jm.music.data.*;
import jm.music.tools.Mod;
import jm.util.*;
 
public class App implements JMC {
    public static void main(String[] args){

        Random RANDOM_NUMBER_GENERATOR = new Random();
        Phrase[] database = MelodicCellDatabase.getDatabase();

        Part part = new Part("Sax");
        
        int lickMeasureLength = 2;
        for (int i = 0; i < lickMeasureLength * 2; i++) {
            int randomInt;
            
            if(i % 2 == 0)  {
                randomInt = RANDOM_NUMBER_GENERATOR.nextInt(0, 4);
            } else {
                randomInt = RANDOM_NUMBER_GENERATOR.nextInt(4, 8);
            }

            // Make sure it is a copy and not just a pointer
            Phrase cell = database[randomInt].copy();
            cell.setTitle("cell_" + i + "_" + randomInt);
            part.add(cell);
        }

        Score lick = new Score(part);

        lick.setTempo(120.0);
        lick.setKeySignature(4);
        Mod.transpose(lick, 4);
        
        Write.midi(lick, "Lick #3 Test.mid");
    }
}
