package charts;

import javax.swing.*;

import utility.Calc;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class LineChart extends JPanel {

    private Point2D min;
    private Point2D max;
    private ArrayList<Point2D> values;
    private Color lineColor;
    private Color borderColor;

    public LineChart(Point2D min, Point2D max, Color lineColor, Color borderColor) {
    	this.setMin(min);
    	this.setMax(max);
    	this.setValues(new ArrayList<Point2D>());
    	this.setLineColor(lineColor);
    	this.setBorderColor(borderColor);
    }
    public LineChart(Color lineColor, Color borderColor) {
    	this.setMin(new Point2D.Double(0,0));
    	this.setMax(new Point2D.Double(100,100));
    	this.setValues(new ArrayList<Point2D>());
    	this.setLineColor(lineColor);
    	this.setBorderColor(borderColor);
    }
    public LineChart() {
    	this.setMin(new Point2D.Double(0,0));
    	this.setMax(new Point2D.Double(100,100));
    	this.setValues(new ArrayList<Point2D>());
    	this.setLineColor(Color.WHITE);
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

        //draw the line to represent the value if there are more than 1 points
        if (this.getValues().size() > 1) {
            g.setColor(this.getLineColor());
            float x1, y1, x2, y2;
            float zeroPercent; //the percentage of how far through the range the center should be
            zeroPercent = (float)(this.getMax().getY() / (this.getMax().getY() - this.getMin().getY()));

            //loop through all points and draw a line for each
            for (int i = 0, size = this.getValues().size(); i < size-1; i++) {
                x1 =  (float) this.getValues().get(i).getX();
                x1 /= this.getMax().getX() - this.getMin().getX();
                x1 *= this.getWidth()-1;
                x1 = Calc.coordValue((float)this.getMin().getX(), (float)this.getMax().getX(), (float)this.getWidth()-1, (float)this.getValues().get(i).getX(), true);
    
                y1 = (float) this.getValues().get(i).getY();
                y1 /= (this.getMax().getY() - this.getMin().getY());
                y1 *= this.getHeight()-1;
                y1 = ((this.getHeight()-1)*zeroPercent) + this.getHeight()-1 + (y1*-1);
                y1 = (float)((((this.getHeight()-1) * (this.getValues().get(i).getY() / (this.getMax().getY() - this.getMin().getY())))*-1));
                y1 = Calc.coordValue((float)this.getMin().getY(), (float)this.getMax().getY(), (float)this.getHeight()-1, (float)this.getValues().get(i).getY());

                
                x2 = (float) this.getValues().get(i+1).getX();
                x2 /= this.getMax().getX() - this.getMin().getX();
                x2 *= this.getWidth()-1;
                x2 = Calc.coordValue((float)this.getMin().getX(), (float)this.getMax().getX(), (float)this.getWidth()-1, (float)this.getValues().get(i+1).getX(), true);
                
                y2 = (float) this.getValues().get(i+1).getY();
                y2 /= this.getMax().getY() - this.getMin().getY();
                y2 *= this.getHeight()-1;
                y2 = this.getHeight()-1 + (y2*-1);
                y2 = (float)((((this.getHeight()-1) * (this.getValues().get(i+1).getY() / (this.getMax().getY() - this.getMin().getY())))*-1));
                y2 = Calc.coordValue((float)this.getMin().getY(), (float)this.getMax().getY(), (float)this.getHeight()-1, (float)this.getValues().get(i+1).getY());
            	
            	g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
            	//System.out.println(" x1 = " + x1 + " y1 = " + y1 + " x2 = " + x2 + " y2 = " + y2);
        	}
        }
        
    }

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new LineChart());
        f.setSize(100,150);
        f.setVisible(true);
    }


	/**
	 * @return the barColor
	 */
	public Color getLineColor() {
		return lineColor;
	}

	/**
	 * @param barColor the barColor to set
	 */
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
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
		this.getValues().add(value);
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