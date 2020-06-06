package com.tjsteel.forzaTelemetry.charts;

import javax.swing.*;

import com.tjsteel.forzaTelemetry.utility.Calc;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class LineChart extends JPanel {

	private static final long serialVersionUID = 1L;

    private Point2D min;
    private Point2D max;
    private ArrayList<Point2D> values;
    private Color lineColor;
    private Color borderColor;
    private boolean inverted = false;
    private boolean maintainRatio = false;
    private int borderSize = 0;

    public LineChart(Point2D min, Point2D max, Color lineColor, Color borderColor) {
    	this.setMin(min);
    	this.setMax(max);
    	this.setValues(new ArrayList<Point2D>());
    	this.setLineColor(lineColor);
    	this.setBorderColor(borderColor);
    }
    public LineChart(Color lineColor, Color borderColor) {
    	this.setMin(new Point2D.Double(0,0));
    	this.setMax(new Point2D.Double(0,0));
    	this.setValues(new ArrayList<Point2D>());
    	this.setLineColor(lineColor);
    	this.setBorderColor(borderColor);
    }
    public LineChart() {
    	this.setMin(new Point2D.Double(0,0));
    	this.setMax(new Point2D.Double(0,0));
    	this.setValues(new ArrayList<Point2D>());
    	this.setLineColor(Color.WHITE);
    	this.setBorderColor(new Color(255,255,255,127));
    }
	
    public void setMaintainRatio(boolean maintainRatio) {
    	this.maintainRatio = maintainRatio; 
    }

    public void setBorderSize(int borderSize) {
    	this.borderSize = borderSize; 
    }

	public void paint(Graphics g1){
		
        Graphics2D g = (Graphics2D) g1;
        //draw the border
        g.setColor(getBorderColor());
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);

        //only draw value lines if there are at least 2 points to connect
        if (this.getValues().size() < 2) {
        	return;
        }
    
        g.setColor(this.getLineColor());
        int x1, y1, x2, y2;

        //loop through all points and draw a line for each
        for (int i = 0, size = this.getValues().size(); i < size-1; i++) {
            x1 = (int) ((borderSize/2) + Calc.coordValue(this.getMin().getX(), this.getMax().getX(), this.getWidth()-borderSize, this.getValues().get(i).getX(), true));
            x2 = (int) ((borderSize/2) + Calc.coordValue(this.getMin().getX(), this.getMax().getX(), this.getWidth()-borderSize, this.getValues().get(i+1).getX(), true));
            y1 = (int) ((borderSize/2) + Calc.coordValue(this.getMin().getY(), this.getMax().getY(), this.getHeight()-borderSize, this.getValues().get(i).getY(), this.isInverted()));
            y2 = (int) ((borderSize/2) + Calc.coordValue(this.getMin().getY(), this.getMax().getY(), this.getHeight()-borderSize, this.getValues().get(i+1).getY(), this.isInverted()));
        	g.drawLine(x1, y1, x2, y2);
        	if (i == size - 2) {
        		int dotSize = 10;
        		g.fillOval(x2-(dotSize/2), y2-(dotSize/2), dotSize, dotSize);
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
		double x, y;
		if (this.getValues().size() == 0) {
			this.getMin().setLocation(value);
			this.getMax().setLocation(value);
		}
		this.getValues().add(value);
		if (this.getMin() == null) this.setMin(value); 
		if (this.getMax() == null) this.setMax(value); 
		x = value.getX() < this.getMin().getX() ? value.getX() : this.getMin().getX();
		y = value.getY() < this.getMin().getY() ? value.getY() : this.getMin().getY();
		this.getMin().setLocation(x, y);
		x = value.getX() > this.getMax().getX() ? value.getX() : this.getMax().getX();
		y = value.getY() > this.getMax().getY() ? value.getY() : this.getMax().getY();
		this.getMax().setLocation(x, y);
		updateMinMax();
	}
	
	/**
	 * @return the values
	 */
	public ArrayList<Point2D> getValues() {
		return values;
	}
	public void setValues(ArrayList<Point2D> values) {
		this.values = values;
	}
	private void updateMinMax() {
		if (values.size()==0) return;
		this.getMin().setLocation(values.get(0));; 
		this.getMax().setLocation(values.get(0));;
		for (Point2D value : values) {
			double x, y;
			if (this.getMin() == null) this.setMin(value); 
			if (this.getMax() == null) this.setMax(value); 
			x = value.getX() < this.getMin().getX() ? value.getX() : this.getMin().getX();
			y = value.getY() < this.getMin().getY() ? value.getY() : this.getMin().getY();
			this.getMin().setLocation(x, y);
			x = value.getX() > this.getMax().getX() ? value.getX() : this.getMax().getX();
			y = value.getY() > this.getMax().getY() ? value.getY() : this.getMax().getY();
			this.getMax().setLocation(x, y);
		}
		if (maintainRatio) {
			double xRange = this.getMax().getX() - this.getMin().getX(), 
					yRange = this.getMax().getY() - this.getMin().getY(),
					rangeDifference = xRange > yRange ? xRange - yRange : yRange - xRange;
			if (xRange > yRange) {
				this.getMax().setLocation(this.getMax().getX(), this.getMax().getY()+(rangeDifference/2));
				this.getMin().setLocation(this.getMin().getX(), this.getMin().getY()-(rangeDifference/2));
			} else {
				this.getMax().setLocation(this.getMax().getX()+(rangeDifference/2), this.getMax().getY());
				this.getMin().setLocation(this.getMin().getX()-(rangeDifference/2), this.getMin().getY());
			}
		}
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
	
	public void reset() {
    	this.setMin(new Point2D.Double(0,0));
    	this.setMax(new Point2D.Double(0,0));
    	this.setValues(new ArrayList<Point2D>());
	}
	/**
	 * @return the inverted
	 */
	public boolean isInverted() {
		return inverted;
	}
	/**
	 * @param inverted the inverted to set
	 */
	public void setInverted(boolean inverted) {
		this.inverted = inverted;
	}
	
}