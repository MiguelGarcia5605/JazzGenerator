package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PressListener implements ActionListener {

    AppWindow mAppWindow;

    public PressListener(AppWindow appWindow) {
        mAppWindow = appWindow;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String field1Text = mAppWindow.getField1Text();
        String field2Text = mAppWindow.getField2Text();
        System.out.println("text field 1 contains : " + field1Text);
        System.out.println("text field 2 contains : " + field2Text);
    }
}
