import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GradientPaintDemo1 extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        /**
         * public GradientPaint(float x1,float y1,Color color1,float x2,float y2,Color
         * color2)
         * 
         */
        GradientPaint gp1 = new GradientPaint(10, 20, Color.green, 150, 150, Color.black);
        g2d.setPaint(gp1);
        g2d.fillRect(00, 00, 350, 350);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GradientsGreenBlack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GradientPaintDemo1());
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}