import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;

public class MelodicCellDatabase implements JMC {

    public static final Phrase[] database = new Phrase[] {
        // Basic 1-3-5-7 Going Up
        new Phrase(
            new Note[] {
                new Note(C4, EIGHTH_NOTE),
                new Note(E4, EIGHTH_NOTE),
                new Note(G4, EIGHTH_NOTE),
                new Note(B4, EIGHTH_NOTE),
            }
        ),
    
        new Phrase(
            new Note[] {
                new Note(B3, EIGHTH_NOTE),
                new Note(C4, EIGHTH_NOTE),
                new Note(E4, EIGHTH_NOTE),
                new Note(G4, EIGHTH_NOTE),
            }
        ),

        new Phrase(
            new Note[] {
                new Note(G4, EIGHTH_NOTE),
                new Note(B4, EIGHTH_NOTE),
                new Note(C5, EIGHTH_NOTE),
                new Note(E5, EIGHTH_NOTE),
            }
        ),

        new Phrase(
            new Note[] {
                new Note(E4, EIGHTH_NOTE),
                new Note(G4, EIGHTH_NOTE),
                new Note(B4, EIGHTH_NOTE),
                new Note(C5, EIGHTH_NOTE),
            }
        ),

        // Basic 1-3-5-7 Going Down
        new Phrase(
            new Note[] {
                new Note(B4, EIGHTH_NOTE),
                new Note(G4, EIGHTH_NOTE),
                new Note(E4, EIGHTH_NOTE),
                new Note(C4, EIGHTH_NOTE),
            }
        ),
    
        new Phrase(
            new Note[] {
                new Note(C5, EIGHTH_NOTE),
                new Note(B4, EIGHTH_NOTE),
                new Note(G4, EIGHTH_NOTE),
                new Note(E4, EIGHTH_NOTE),
            }
        ),

        new Phrase(
            new Note[] {
                new Note(E5, EIGHTH_NOTE),
                new Note(C5, EIGHTH_NOTE),
                new Note(B4, EIGHTH_NOTE),
                new Note(G4, EIGHTH_NOTE),
            }
        ),

        new Phrase(
            new Note[] {
                new Note(G4, EIGHTH_NOTE),
                new Note(E4, EIGHTH_NOTE),
                new Note(C4, EIGHTH_NOTE),
                new Note(B3, EIGHTH_NOTE),
            }
        ),
    };

    public static Phrase[] getDatabase() {
        return database;
    }

}