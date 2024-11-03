package org.magicEagle.Main;

import org.magicEagle.utils.SimLoop;
import javax.swing.*;

/**
 * @Author: CoderAnchel
 * The Main class serves as the entry point for the Magic Eagle - Eurofighter Typhoon CORE application.
 */
public class Main {
    /**
     * The main method initializes the application window and starts the simulation loop.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.setResizable(false);
        window.setTitle("Magic Eagle - Eurofighter Typhoon DemoUI");
        window.setVisible(true);

        SimLoop simLoop = new SimLoop();
        window.add(simLoop);
        window.pack();
        Thread simThread = new Thread(simLoop);
        simThread.start();

        simLoop.requestFocus();
    }
}
