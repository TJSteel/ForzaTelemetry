/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Jay
 */
@SuppressWarnings("serial")
public class GaugeRpm extends JPanel {

	// {{ Variables
    /**
	 * variables
	 */
	private BufferedImage biGauge;
	private BufferedImage biRedline;
	private BufferedImage biNeedle;
    private final int gaugeWidth = 128;
    private final int gaugeHeight = 128;
    private final double startAngle = 230;
    private final double maxAngle = 280;
    private final double maxGaugeRpm = 10000;
    private double rpm = 5478;
    private double maxRpm = 8100;
    // }} Variables

    // Constructor
    public GaugeRpm() {
    	try {
        	setBiGauge(ImageIO.read(getClass().getClassLoader().getResource("images/RpmGauge.png")));
        	setBiRedline(ImageIO.read(getClass().getClassLoader().getResource("images/RpmNeedle.png")));
        	setBiNeedle(ImageIO.read(getClass().getClassLoader().getResource("images/RpmNeedle.png")));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
        this.setPreferredSize(new Dimension(this.getGaugeWidth(), this.getGaugeHeight()));
    }
    
    // {{ Custom Paint method for drawing the gauge
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.getBiGauge(), 0, 0, null);
        //g2d.draw(new Arc2D.Double(x, y, width, height, start, extent, type));
        //g2d.clipRect(50, 50, 100, 100);
        g2d.setClip(new Arc2D.Double(0,0,this.getGaugeWidth(),this.getGaugeHeight(),
        		this.getEndAngle(),this.getRedlineAngle(), Arc2D.PIE));
        g2d.drawImage(this.getBiRedline(), 0, 0, null);
        g2d.setClip(null);
        g2d.rotate(this.getRPMAngleRadians(), this.getGaugeWidth() / 2, this.getGaugeHeight() / 2);
        g2d.drawImage(this.getBiNeedle(), 0, 0, null);
    }
    // }}

    // {{ Getters and Setters
    public BufferedImage getBiGauge() {
        return biGauge;
    }

    public void setBiGauge(BufferedImage biGauge) {
        this.biGauge = biGauge;
    }

    public BufferedImage getBiNeedle() {
        return biNeedle;
    }

    public void setBiNeedle(BufferedImage biNeedle) {
        this.biNeedle = biNeedle;
    }   
    
	private BufferedImage getBiRedline() {
		return biRedline;
	}

	private void setBiRedline(BufferedImage biRedline) {
		this.biRedline = biRedline;
	}
    
    private int getGaugeWidth() {
        return gaugeWidth;
    }

    private int getGaugeHeight() {
        return gaugeHeight;
    }

    private double getStartAngle() {
		return startAngle;
	}


    public void setRpm(double rpm) {
        this.rpm = (rpm > this.getMaxGaugeRpm() ? this.getMaxGaugeRpm() : rpm);
    }

    public double getMaxAngle() {
        return maxAngle;
    }

    public double getMaxGaugeRpm() {
        return maxGaugeRpm;
    }

    public double getRpm() {
        return rpm;
    }


	public double getMaxRpm() {
		return maxRpm;
	}


	public void setMaxRpm(double maxRpm) {
		this.maxRpm = maxRpm;
	}

    private double getRPMAngleRadians(){
        return this.getRPMAngleRadians(false);
    }
    
    private double getRPMAngleRadians(boolean rounded){
    	double rpmAngle = (double) this.getMaxAngle()*(this.getRpm() / this.getMaxGaugeRpm());
    	if (rounded) {
        	//return Math.toRadians(Math.round(rpmAngle));
        	return Math.toRadians(Math.round(rpmAngle*2)/2);
        }
        return Math.toRadians(rpmAngle);
    }

    private double getEndAngle() {
    	return this.getStartAngle()-this.getMaxAngle();
    }
    
    private double getRedlineAngle() {
    	return this.getMaxAngle()*((this.getMaxGaugeRpm()-this.getMaxRpm()) / this.getMaxGaugeRpm());
    }
    // }} Getters and Setters
}