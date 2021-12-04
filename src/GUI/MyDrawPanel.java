
/**
 *  Purpose: Demo of make your own drawing widget
 *  Explaination: If you want to put your own graphics own the screen, 
 *  your best bet is to make your own paintable widget. 
 *  It's a piece of cake:
 *  Make a subclass of JPanel and override one method, paintComponent().
 * 
 *  If the user iconifies/minimizes the window, the 
 *  JVM knows the frame needs "repair" when it gets de-iconified, 
 *  so it calls paintComponent() again. Anytime the JVM thinks the 
 *  display needs refreshing, your paintComponent() method will be 
 *  called.
 * 
 *  On more thing: you never call this method yourself. 
 * 
 *  The argument to this method (a Graphics object) is the actual drawing canvas that 
 *  gets slapped onto the real display. You can't get this by yourself, it must be haned to you 
 *  by the system. But you can ask the system to refresh the display(repaint()), 
 *  which ultimately leads to paintComponent() being called.
 */
import java.awt.*;
import javax.swing.*;

// Make a subclass of JPanel, a widget that you can add to a frame just like anything else.
// Except this one is your customized widget.
class MyDrawPanel extends JPanel {
  public void paintComponent(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;

    g.fillRect(0, 0, this.getWidth(), this.getHeight());

    int red = (int) (Math.random() * 256);
    int green = (int) (Math.random() * 256);
    int blue = (int) (Math.random() * 256);

    Color randomColor = new Color(red, green, blue);
    Color startColor = randomColor;

    red = (int) (Math.random() * 256);
    green = (int) (Math.random() * 256);
    blue = (int) (Math.random() * 256);

    Color endColor = new Color(red, green, blue);

    g.setColor(randomColor);
    // 500 px from the left
    // 500 px from the top
    // 100 px width
    // 100 px height
    g.fillOval(400, 400, 100, 100);

    GradientPaint gradient = new GradientPaint(500, 500, startColor, 650, 650, endColor);
    g2d.setPaint(gradient);

    g2d.fillOval(500, 500, 100, 100);

    Image image = new ImageIcon("./blsd.jpg").getImage();
    // 3,4 : The x,y coordinates for where the pciture's top left corner should go.
    // This says: "3 pixels from the left edge of the panel and 4 pixels from the
    // top edge of the panel". These number are always relative to the widget (in
    // this case your JPanel subclass, not the entire frame)
    g.drawImage(image, 3, 4, this);

  }

  public static void main(String[] args) {
    MyDrawPanel mdp = new MyDrawPanel();
    JFrame frame = new JFrame();
    frame.getContentPane().add(mdp);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 700);
    frame.setVisible(true);
  }
}
