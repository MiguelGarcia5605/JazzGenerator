package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import generator.generator.Generator;
import jm.music.data.Part;
import jm.util.Write;
import utils.MusicUtils;

public class PressListener implements ActionListener {

    AppWindow mAppWindow;
    Generator mGenerator;
    int mCount;

    public PressListener(AppWindow appWindow, Generator generator) {
        mAppWindow = appWindow;
        mGenerator = generator;
        mCount = 0;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String field1Text = mAppWindow.getField1Text();
        String field2Text = mAppWindow.getField2Text();
        
        Part lick = mGenerator.createLickOverProgression(MusicUtils.stringToChordProgression(field1Text));

        Write.midi(lick, field2Text + "\\lick(" + mCount + ").mid");
        mCount++;
    }
}
