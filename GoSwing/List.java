import javax.swing.*;
import javax.swing.event.*;

public class List implements ListSelectionListener {
    String[] ListEntries = { "alpha", "beta", "gamma", "delta", "epilon", "zeta", "eta", "theta" };
    JList list = new JList(ListEntries);

    public static void main(String[] args) {
        List l = new List();
        l.go();
    }

    public void go() {
        JFrame frame = new JFrame();

        JScrollPane scroller = new JScrollPane(list);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(scroller);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addListSelectionListener(this);

        frame.setVisible(true);
        frame.setSize(300, 300);
    }

    public void valueChanged(ListSelectionEvent lse) {
        if (!lse.getValueIsAdjusting()) {
            String selection = (String) list.getSelectedValue();
            System.out.println(selection);
        }
    }
}
