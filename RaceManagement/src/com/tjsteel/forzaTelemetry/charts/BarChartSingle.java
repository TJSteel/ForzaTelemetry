package com.tjsteel.forzaTelemetry.charts;

import javax.swing.*;

import com.tjsteel.forzaTelemetry.utility.Calc;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BarChartSingle extends JPanel {

    private float min;
    private float max;
    private float value;
    private Color barColor;
    private Color borderColor;
    private boolean isHorizontal;

    public BarChartSingle(float min, float max, float value, Color barColor, Color borderColor) {
    	this.setMin(min);
    	this.setMax(max);
    	this.setValue(value);
    	this.setBarColor(barColor);
    	this.setBorderColor(borderColor);
    }
    public BarChartSingle() {
    	this.setMin(0);
    	this.setMax(100);
    	this.setValue(0);
    	this.setBarColor(Color.WHITE);
    	this.setBorderColor(new Color(255,255,255,127));
    }
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g1){
		
        Graphics2D g = (Graphics2D) g1;
        //draw the border
        g.setColor(this.getBorderColor());
        g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);

        //set and calculate variables for drawing of the value
        int x, y, width, height;

        if (isHorizontal()) {
            x = (int) Calc.coordZero(this.getMin(), this.getMax(), this.getWidth(), true);
            width = (int) Calc.coordLength(this.getMin(), this.getMax(), this.getWidth(), this.getValue());
            y = 0;
            height = this.getHeight();
        } else {
            x = 0;
            width = this.getWidth();
            y = (int) (int) Calc.coordZero(this.getMin(), this.getMax(), this.getHeight());
            height = (int) Calc.coordLength(this.getMin(), this.getMax(), this.getHeight(), this.getValue(), true);
        }
        
        //draw the rectangle to represent the value
        g.setColor(getBarColor());
        g.fillRect(x, y, width, height);
    }

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new BarChartSingle());
        f.setSize(100,150);
        f.setVisible(true);
    }

    // {{ Getters and Setters
    
	/**
	 * @return the min
	 */
	public float getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(float min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public float getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(float max) {
		this.max = max;
	}

	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(float value) {
		this.value = value;
	}

	/**
	 * @return the barColor
	 */
	public Color getBarColor() {
		return barColor;
	}

	/**
	 * @param barColor the barColor to set
	 */
	public void setBarColor(Color barColor) {
		this.barColor = barColor;
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
	/**
	 * @return the isHorizontal
	 */
	public boolean isHorizontal() {
		return isHorizontal;
	}
	/**
	 * @param isHorizontal the isHorizontal to set
	 */
	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}
	
    // }} Getters and Setters

}