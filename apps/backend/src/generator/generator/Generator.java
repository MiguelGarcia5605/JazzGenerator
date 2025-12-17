package generator.generator;

import java.util.ArrayList;

import database.TextDatabase;
import generator.cell.Cell;
import generator.cell.RhythmicCell;
import generator.chord.ChordProgression;
import jm.JMC;
import jm.music.data.Part;
import utils.MusicUtils;

public class Generator implements JMC {
    
    TextDatabase mMajorCellsDatabase;
    TextDatabase mMinorCellsDatabase;
    TextDatabase mDominantCellsDatabase;
    TextDatabase mRhythmicCellsDatabase;

    ArrayList<Cell> mMajorCellsArray;
    ArrayList<Cell> mMinorCellsArray;
    ArrayList<Cell> mDominantCellsArray;
    ArrayList<RhythmicCell> mRhythmicCellsArray;

    public Generator(TextDatabase majorCellsDatabase, TextDatabase minorCellsDatabase, TextDatabase dominantCellsDatabase, TextDatabase rhythmicCellsDatabase) {
        mMajorCellsDatabase = majorCellsDatabase;
        mMinorCellsDatabase = minorCellsDatabase;
        mDominantCellsDatabase = dominantCellsDatabase;
        mRhythmicCellsDatabase = rhythmicCellsDatabase;
        mMajorCellsArray = new ArrayList<Cell>();
        mMinorCellsArray = new ArrayList<Cell>();
        mDominantCellsArray = new ArrayList<Cell>();
        mRhythmicCellsArray = new ArrayList<RhythmicCell>();
        exportData();
    }

    private void exportData() {
        for (String s : mMajorCellsDatabase.getData()) {
            mMajorCellsArray.add(MusicUtils.stringToCell(s));
        }

        for (String s : mMinorCellsDatabase.getData()) {
            mMinorCellsArray.add(MusicUtils.stringToCell(s));
        }

        for (String s : mDominantCellsDatabase.getData()) {
            mDominantCellsArray.add(MusicUtils.stringToCell(s));
        }

        for (String s : mRhythmicCellsDatabase.getData()) {
            mRhythmicCellsArray.add(MusicUtils.stringToRhythmicCell(s));
        }
    }

    public Part createLickOverProgression(ChordProgression progression) {
        ArrayList<Cell> lick = MusicUtils.generateLick(mMajorCellsArray, mMinorCellsArray, mDominantCellsArray, mRhythmicCellsArray, progression);

        Part p = MusicUtils.convertToPart(lick);

        return p;
    }
}
