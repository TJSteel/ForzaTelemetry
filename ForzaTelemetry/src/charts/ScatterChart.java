//requires testing

package charts;

import javax.swing.*;

import utility.Calc;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class ScatterChart extends JPanel {

    private Point2D min;
    private Point2D max;
    private ArrayList<Point2D> values;
    private Color dotColor;
    private Color borderColor;

    public ScatterChart(Point2D min, Point2D max, Color dotColor, Color borderColor) {
    	this.setMin(min);
    	this.setMax(max);
    	this.setValues(new ArrayList<Point2D>());
    	this.setDotColor(dotColor);
    	this.setBorderColor(borderColor);
    }
    public ScatterChart(Color dotColor, Color borderColor) {
    	this.setValues(new ArrayList<Point2D>());
    	this.setDotColor(dotColor);
    	this.setBorderColor(borderColor);
    }
    public ScatterChart() {
    	this.setValues(new ArrayList<Point2D>());
    	this.setDotColor(Color.WHITE);
    	this.setBorderColor(new Color(255,255,255,127));
    }
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g1){
		
        Graphics2D g = (Graphics2D) g1;
        //draw the border
        g.setColor(getBorderColor());
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);

        //checking we have values to draw
        if (this.getValues().size() <= 0) {
        	return;
        }

        g.setColor(this.getDotColor());
        int x, y;

        //loop through all points and draw a dot for each
        for (int i = 0, size = this.getValues().size(); i < size; i++) {
            x = (int) Calc.coordValue(this.getMin().getX(), this.getMax().getX(), this.getWidth(), this.getValues().get(i).getX(), true);
            y = (int) Calc.coordValue(this.getMin().getY(), this.getMax().getY(), this.getHeight(), this.getValues().get(i).getY());
        	
        	g.drawLine(x, y, x, y);
    	}
    }

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new ScatterChart());
        f.setSize(100,150);
        f.setVisible(true);
    }


	/**
	 * @return the barColor
	 */
	public Color getDotColor() {
		return dotColor;
	}

	/**
	 * @param barColor the barColor to set
	 */
	public void setDotColor(Color dotColor) {
		this.dotColor = dotColor;
	}

	/**
	 * @return the borderColor
	 */
	public Color getBorderColor() {
		return borderColor;
	}

	/**
	 * @param borderColor the borderColor to set
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	public void addValue(Point2D value) {
		double x, y;
		this.getValues().add(value);
		if (this.getMin() == null) this.setMin(value); 
		if (this.getMax() == null) this.setMax(value); 
		x = value.getX() < this.getMin().getX() ? value.getX() : this.getMin().getX();
		y = value.getY() < this.getMin().getY() ? value.getY() : this.getMin().getY();
		this.getMin().setLocation(x, y);
		x = value.getX() > this.getMax().getX() ? value.getX() : this.getMax().getX();
		y = value.getY() > this.getMax().getY() ? value.getY() : this.getMax().getY();
		this.getMax().setLocation(x, y);
	}
	
	/**
	 * @return the values
	 */
	private ArrayList<Point2D> getValues() {
		return values;
	}
	private void setValues(ArrayList<Point2D> values) {
		this.values = values;
	}
	/**
	 * @return the min
	 */
	public Point2D getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(Point2D min) {
		this.min = min;
	}
	/**
	 * @return the max
	 */
	public Point2D getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(Point2D max) {
		this.max = max;
	}

}