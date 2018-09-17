/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icons;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import enums.Drivetrain;

/**
 * @author Jay
 */
@SuppressWarnings("serial")
public class DrivetrainIcon extends JPanel {

	// {{ Variables
    /**
	 * variables
	 */
	private BufferedImage biNwd;
	private BufferedImage biFwd;
	private BufferedImage biRwd;
	private BufferedImage biAwd;
    private final int iconWidth = 47;
    private final int iconHeight = 128;
    private Drivetrain drivetrain = Drivetrain.NONE;
    // }} Variables

    // {{ Constructor
    public DrivetrainIcon() {
    	try {
        	setBiNwd(ImageIO.read(getClass().getClassLoader().getResource("images/NwdIcon.png")));
        	setBiFwd(ImageIO.read(getClass().getClassLoader().getResource("images/FwdIcon.png")));
        	setBiRwd(ImageIO.read(getClass().getClassLoader().getResource("images/RwdIcon.png")));
        	setBiAwd(ImageIO.read(getClass().getClassLoader().getResource("images/AwdIcon.png")));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
        this.setPreferredSize(new Dimension(this.getIconWidth(), this.getIconHeight()));
    }
    // }} Constructor
    
    // {{ Custom Paint method for drawing the gauge
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        switch (this.getDrivetrain()) {
	        case NONE:
		        g2d.drawImage(this.getBiNwd(), 0, 0, null);
		        break;
	        case FWD:
		        g2d.drawImage(this.getBiFwd(), 0, 0, null);
		        break;
	        case RWD:
		        g2d.drawImage(this.getBiRwd(), 0, 0, null);
		        break;
	        case AWD:
		        g2d.drawImage(this.getBiAwd(), 0, 0, null);
		        break;
        }
    }
    // }}

    // {{ Getters and Setters
    
	/**
	 * @return the biNwd
	 */
	private BufferedImage getBiNwd() {
		return biNwd;
	}

	/**
	 * @param biNwd the biNwd to set
	 */
	private void setBiNwd(BufferedImage biNwd) {
		this.biNwd = biNwd;
	}

	/**
	 * @return the biFwd
	 */
	private BufferedImage getBiFwd() {
		return biFwd;
	}

	/**
	 * @param biFwd the biFwd to set
	 */
	private void setBiFwd(BufferedImage biFwd) {
		this.biFwd = biFwd;
	}

	/**
	 * @return the biRwd
	 */
	private BufferedImage getBiRwd() {
		return biRwd;
	}

	/**
	 * @param biRwd the biRwd to set
	 */
	private void setBiRwd(BufferedImage biRwd) {
		this.biRwd = biRwd;
	}

	/**
	 * @return the biAwd
	 */
	private BufferedImage getBiAwd() {
		return biAwd;
	}

	/**
	 * @param biAwd the biAwd to set
	 */
	private void setBiAwd(BufferedImage biAwd) {
		this.biAwd = biAwd;
	}

	/**
	 * @return the iconWidth
	 */
	private int getIconWidth() {
		return iconWidth;
	}

	/**
	 * @return the iconHeight
	 */
	private int getIconHeight() {
		return iconHeight;
	}

	/**
	 * @return the drivetrain
	 */
	private Drivetrain getDrivetrain() {
		return drivetrain;
	}

	/**
	 * @param drivetrain the drivetrain to set
	 */
	public void setDrivetrain(Drivetrain drivetrain) {
		this.drivetrain = drivetrain;
	}


    // }} Getters and Setters
}