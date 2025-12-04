import java.util.Random;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
 
public class App implements JMC {

    public static void main(String[] args){

        Random RANDOM_NUMBER_GENERATOR = new Random();
        MelodicCell[] database = MelodicCellDatabase.getDatabase();

        Part part = new Part("Sax");
        
        int lickMeasureLength = 2;
        for (int i = 0; i < lickMeasureLength * 2; i++) {
            int randomInt = RANDOM_NUMBER_GENERATOR.nextInt(0, database.length);

            // Make sure it is a copy and not just a pointer
            MelodicCell cell = database[randomInt].copy();

            cell.setTitle("cell_" + i + "_" + randomInt);
            part.add(cell);
        }

        Score lick = new Score(part);

        lick.setTempo(120.0);
        // lick.setKeySignature(4);
        // Mod.transpose(lick, 4);
        
        Write.midi(lick, "Lick.mid");
    }
}
