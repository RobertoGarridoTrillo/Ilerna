package button;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JButton;

public class JGradientButton extends JButton {

    // field attribute
    Color c;

    // constructor
    JGradientButton(Color c) {
        super();
        this.c = c;
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g.create();

        setContentAreaFilled(false);// it paints or not the containt
        setFocusPainted(true);// it shows or not the focus on the button

        g2.setPaint(new GradientPaint(
                new Point(0, 0),
                Color.WHITE,
                new Point(0, getHeight()),
                c)); //Color.GRAY));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();

        super.paintComponent(g);
    }
}
