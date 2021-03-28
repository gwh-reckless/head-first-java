import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.FieldBorder;

import java.awt.*;

public class TextField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TextField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box fieldsBox = new Box(BoxLayout.Y_AXIS);
        frame.add(fieldsBox);

        JTextField field = new JTextField(20);
        field.setText("Whatever");
        field.selectAll();
        field.requestFocus();
        JTextField field2 = new JTextField("Your name");
        fieldsBox.add(field);
        fieldsBox.add(field2);

        frame.setVisible(true);
        frame.setSize(300, 300);
    }
}
