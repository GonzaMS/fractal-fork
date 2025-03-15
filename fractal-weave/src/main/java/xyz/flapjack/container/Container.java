package xyz.flapjack.container;

/* Open. */
import javax.swing.*;

public class Container {
    /**
     * Called on launch, this means the JAR is not being run correctly.
     * @param args any passed arguments.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        JOptionPane.showMessageDialog(frame, "Please use this file as a Weave mod", "Fractal", JOptionPane.WARNING_MESSAGE);
    }
}
