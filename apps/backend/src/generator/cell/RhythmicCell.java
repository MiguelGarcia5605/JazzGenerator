package generator.cell;

public class RhythmicCell {

    double[] mRhythmicValues;

    public RhythmicCell(double[] rhythmicValues) {
        mRhythmicValues = rhythmicValues;
    }

    public double[] getRhythmArray() {
        return mRhythmicValues;
    }

    public double getRhythmicValue(int i) {
        return mRhythmicValues[i];
    }

    public int getLength() {
        return mRhythmicValues.length;
    }
}
