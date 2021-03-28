import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextArea {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JTextArea text = new JTextArea(10, 20);

        JScrollPane scroller = new JScrollPane(text);
        text.setLineWrap(true);

        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        frame.getContentPane().add(scroller);

        text.setText("Not all who are lost wnadering");

        text.append("button clicked");
        text.selectAll();
        text.requestFocus();

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

}
