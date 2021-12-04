
/**
 * Purpose: Demo of event in GUI 
 */
import javax.swing.*;
// A new import statement for the package that ActionListener and ActionEvent are in
import java.awt.event.*;

/**
 * Relationship between event source and listener
 * 1. Listner register with the event source
 * 2. Event source emit event to the listener
 * 3. Listener act.
 */

/**
 * Getting a button's ActionEvent: 1) Implement with ActionListener Interface
 * 2)Register with the button (tell it want to listen for events) 3)Define the
 * event-handling method (implement the actionPerformed() method from the
 * ActionListener interface)
 */

public class SimpleGui1B implements ActionListener {
  JButton button;

  public static void main(String[] args) {
    SimpleGui1B gui = new SimpleGui1B();
    gui.go();
  }

  public void go() {
    JFrame frame = new JFrame();
    button = new JButton("click me");

    // register your interest with the button. This says to the button, "Add me to
    // your list of listener". The argument you pass MUST be an object from a class
    // that implements ActionListener.
    button.addActionListener(this);

    frame.getContentPane().add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    button.setText("I've been clicked!");
  }
}
