import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradientPaintDemo2 extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        /**
         * public GradientPaint(float x1,float y1,Color color1,float x2,float y2,Color
         * color2,boolean cyclic,boolean cyclic)
         */
        GradientPaint gp1 = new GradientPaint(15, 15, Color.green, 40, 40, Color.black, true);
        g2d.setPaint(gp1);
        g2d.fillRect(00, 00, 350, 350);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GradientsGreenBlacK");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GradientPaintDemo2());
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}