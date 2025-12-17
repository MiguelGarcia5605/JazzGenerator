package gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import generator.generator.Generator;

public class AppWindow {

    public static final String ROOT_PROJECT_PATH = new File("").getAbsolutePath();
    public static final String ICON_PATH = ROOT_PROJECT_PATH + "\\apps\\frontend\\src\\gui\\icons\\sax.png";
    public static final ImageIcon ICON = new ImageIcon(ICON_PATH);

    public static final String 
        BUTTON_GHOST_TEXT = "Generate Lick",
        TEXT_FIELD_1_GHOST_TEXT = "Dmin7/Gdom7/Cmaj7...",
        TEXT_FIELD_2_GHOST_TEXT = "C:/MidiFiles...",
        TITLE = "Jazz Generator";

    public static final float GHOST_TEXT_OPAQUE_VALUE = 0.5f;

    public static final Dimension SCREEN_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();

    public static final int WINDOW_Y_MARGIN = 300;
    public static final int COMPONENTS_X_MARGIN = 100;

    public static final int
        WINDOW_WIDTH = (int) SCREEN_DIMENSIONS.getWidth() / 3,
        BUTTON_WIDTH = WINDOW_WIDTH - COMPONENTS_X_MARGIN,
        TEXT_FIELD_1_WIDTH = WINDOW_WIDTH - COMPONENTS_X_MARGIN,
        TEXT_FIELD_2_WIDTH = WINDOW_WIDTH - COMPONENTS_X_MARGIN;

    public static final int
        WINDOW_HEIGHT = (int) SCREEN_DIMENSIONS.getHeight() - WINDOW_Y_MARGIN,
        BUTTON_HEIGHT = BUTTON_WIDTH / 4,
        TEXT_FIELD_1_HEIGHT = TEXT_FIELD_1_WIDTH / 4,
        TEXT_FIELD_2_HEIGHT = TEXT_FIELD_2_WIDTH / 4;

    public static final int
        WINDOW_X = ((int) SCREEN_DIMENSIONS.getWidth() / 2) - (WINDOW_WIDTH / 2),
        BUTTON_X = (WINDOW_WIDTH / 2) - (BUTTON_WIDTH / 2),
        TEXT_FIELD_1_X = (WINDOW_WIDTH / 2) - (TEXT_FIELD_1_WIDTH / 2),
        TEXT_FIELD_2_X = (WINDOW_WIDTH / 2) - (TEXT_FIELD_2_WIDTH / 2);

    public static final int
        WINDOW_Y = WINDOW_Y_MARGIN / 2,
        BUTTON_Y = (WINDOW_HEIGHT / 4) * 3,
        TEXT_FIELD_1_Y = (WINDOW_HEIGHT / 4),
        TEXT_FIELD_2_Y = (WINDOW_HEIGHT / 4) * 2;

    public static final Rectangle
        WINDOW_BOUNDS = new Rectangle(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT),
        BUTTON_BOUNDS = new Rectangle(BUTTON_X, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT),
        TEXT_FIELD_1_BOUNDS = new Rectangle(TEXT_FIELD_1_X, TEXT_FIELD_1_Y, TEXT_FIELD_1_WIDTH, TEXT_FIELD_1_HEIGHT),
        TEXT_FIELD_2_BOUNDS = new Rectangle(TEXT_FIELD_2_X, TEXT_FIELD_2_Y, TEXT_FIELD_2_WIDTH, TEXT_FIELD_2_HEIGHT);

    private JFrame mFrame;
    private JButton mButton;
    private JTextField mTextField1;
    private JTextField mTextField2;

    private TextPrompt mGhostText1;
    private TextPrompt mGhostText2;

    private Generator mGenerator;

    public AppWindow(Generator generator) {
        mGenerator = generator;
        init();
    }

    private void init() {
        mFrame = new JFrame();
        mButton = new JButton(BUTTON_GHOST_TEXT);
        mTextField1 = new JTextField();
        mTextField2 = new JTextField();

        mGhostText1 = new TextPrompt(TEXT_FIELD_1_GHOST_TEXT, mTextField1);
        mGhostText2 = new TextPrompt(TEXT_FIELD_2_GHOST_TEXT, mTextField2);

        mGhostText1.changeAlpha(GHOST_TEXT_OPAQUE_VALUE);
        mGhostText2.changeAlpha(GHOST_TEXT_OPAQUE_VALUE);

        mFrame.setTitle(TITLE);
        mFrame.setResizable(false);

        mButton.addActionListener(new PressListener(this, mGenerator));

        mButton.setBounds(BUTTON_BOUNDS);
        mTextField1.setBounds(TEXT_FIELD_1_BOUNDS);
        mTextField2.setBounds(TEXT_FIELD_2_BOUNDS);

        mFrame.add(mButton);
        mFrame.add(mTextField1);
        mFrame.add(mTextField2);

        mFrame.setIconImage(ICON.getImage());
        mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mFrame.setBounds(WINDOW_BOUNDS);
        mFrame.setLayout(null);
        mFrame.setVisible(true);
    }

    public String getField1Text() {
        return mTextField1.getText();
    }

    public String getField2Text() {
        return mTextField2.getText();
    }
}
