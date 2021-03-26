
/**
 *  Purpose: Demo of the easiest  GUI app in java
 */
import javax.swing.*;

public class SimpleGui1 {
  public static void main(String[] args) {
    // JFrame : a object represents the window on screen
    // it's where you put all the things liks buttons, checkboxes, text fields, and
    // soon.
    // It can have an honest-to-goodest menu bar with menu items.
    // And has all the little windowing icons for minimizing, maximizing, and
    // closing the window.
    JFrame frame = new JFrame();

    /**
     * Swing Compoent: Look in javax.swing.package. There are a ton of Swing
     * components you can add. The most common include JButton, JRadioButton,
     * JCheckBox, JLabel, JList, JScrollPane, JSlider, JTextArea, JTextField, and
     * JTable.
     */

    // Make a button widget
    JButton button = new JButton("Click me");

    // Add the widget to the frame
    /**
     * Notice: You don't add things to the frame directly. Think of the frame as the
     * trim aro8und the window, and you can add things to the window pane.
     */
    frame.getContentPane().add(button);

    /**
     * This line makes the program quit as soon as you close the window (if you
     * leave this out it will just sit there on the screen forever)
     */
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Give the frame a size, in pixels.
    frame.setSize(300, 300);

    // Finally, make it visible (if you forget this step, you won't see anything
    // when you run this code)
    frame.setVisible(true);
  }

}
