package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import utility.Calc;

public class PaintTest extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g1){
		
        Graphics2D g = (Graphics2D) g1;
        int centerX;
        int centerY;
        float startAngle;
        float endAngle;
        int numLines;
        int startLength;
        int endLength;
        float angleIncrement;
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

        centerX = 100;
        centerY = 100;
        startAngle = 180-22.5F;
        endAngle = 360-22.5F;
        numLines = 8;
        startLength = 80;
        endLength = 90;
        angleIncrement = (float)(endAngle - startAngle) / numLines;


        g.setStroke(new BasicStroke(4F));
        g.setColor(Color.white);

        for (float currAngle = startAngle; currAngle <= endAngle; currAngle += angleIncrement){
            x1 = (int) Calc.getRightTriangleAdjacentLeg(startLength, Math.toRadians(currAngle)) + centerX;
            y1 = (int) Calc.getRightTriangleOppositeLeg(startLength, Math.toRadians(currAngle)) + centerY;
            x2 = (int) Calc.getRightTriangleAdjacentLeg(endLength, Math.toRadians(currAngle)) + centerX;
            y2 = (int) Calc.getRightTriangleOppositeLeg(endLength, Math.toRadians(currAngle)) + centerY;

            g.drawLine(x1, y1, x2, y2);
        }


        int arcSize = 90*2;
        startAngle = 22.5F;
        endAngle = 180;
        g.drawArc(centerX-(arcSize/2), centerY-(arcSize/2), arcSize, arcSize, (int)startAngle, (int)endAngle);

        g.setColor(Color.red);
        int circleSize = 80;
        g.drawOval(centerX-(circleSize/2), centerY-(circleSize/2), circleSize, circleSize);

    }

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new PaintTest());
        f.setSize(800,375);
        f.setVisible(true);
    }
}