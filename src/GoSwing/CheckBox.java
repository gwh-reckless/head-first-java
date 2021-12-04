
import javax.swing.*;
import java.awt.event.*;

public class CheckBox implements ItemListener {

    JCheckBox check = new JCheckBox("Goes to 11");

    public static void main(String[] args) {
        CheckBox cb = new CheckBox();
        cb.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        check.addItemListener(this);
        frame.getContentPane().add(check);
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent ev) {
        String onOrOff = "off";
        if (check.isSelected())
            onOrOff = "on";
        System.out.println("Check box is " + onOrOff);
    }
}
