package org.example;

import javax.swing.*;
import java.awt.*;

/***
 * Creates a window in which circles and squares appear randomly.
 *
 * Created by Thomas Choboter and Spandan Suthar.
 */
public class Main {

    private static final int FRAME_WIDTH = 1920;

    private static final int FRAME_HEIGHT = 1080;

    // Milliseconds to wait after starting circle creation clock
    // and box creation clock. Should be positive to avoid
    // concurrent write exceptions.
    private static final int PHASE_DIFF = 500;

    // Range of shape sizes (diameters/widths) to create shapes within
    private static final int MIN_SIZE = 50;
    private static final int MAX_SIZE = 200;

    public static void main(String[] args) throws InterruptedException {

        // Establish display
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        Screen s = new Screen();
        frame.add(s);
        frame.setVisible(true);

        // Set up tick-based shape creation threads
        CircleBuilder c = new CircleBuilder(FRAME_WIDTH, FRAME_HEIGHT, MAX_SIZE, MIN_SIZE);
        BoxBuilder b = new BoxBuilder(FRAME_WIDTH, FRAME_HEIGHT, MAX_SIZE, MIN_SIZE);
        Thread circThread = new Thread(c);
        Thread boxThread = new Thread(b);

        // Start shape creation threads with phase difference
        circThread.start();
        Thread.sleep(PHASE_DIFF);
        boxThread.start();

        // Set up shape repository
        Repository r = Repository.getInstance();
        r.addPropertyChangeListener(s);
    }
}