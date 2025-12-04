import jm.JMC;

public class MelodicCellDatabase implements JMC {

    public static final MelodicCell[] database = new MelodicCell[] {
        new MelodicCell(1, 3, 5, 7, "maj7"),
        new MelodicCell(7, 1, 3, 5, "maj7"),
        new MelodicCell(5, 7, 1, 3, "maj7"),
        new MelodicCell(3, 5, 7, 1, "maj7"),

        new MelodicCell(7, 5, 3, 1, "maj7"),
        new MelodicCell(1, 7, 5, 3, "maj7"),
        new MelodicCell(3, 1, 7, 5, "maj7"),
        new MelodicCell(5, 3, 1, 7, "maj7"),
    };

    public static MelodicCell[] getDatabase() {
        return database;
    }

}