package charts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LedRound extends JPanel {

	private static final long serialVersionUID = 1L;
    private boolean on;
    private Color ledColor;
    private Color ledOffColor;
    private Color borderColor;
	
    public LedRound(boolean on, Color ledColor, Color borderColor) {
		super();
		this.on = on;
		this.ledColor = ledColor;
		this.ledOffColor = new Color(ledColor.getRed(), ledColor.getGreen(), ledColor.getBlue(), 127);
		this.borderColor = borderColor;
		this.setBackground(new Color(0, 0, 0));
		this.setOpaque(false);

	}
    public LedRound() {
		super();
		this.on = false;
		this.ledColor = Color.GREEN;
		this.borderColor = new Color(0,255,0,127);
	}

	public void paint(Graphics g1){
		
        Graphics2D g = (Graphics2D) g1;
        //draw the border
        g.setColor(this.getBorderColor());
        g.drawOval(0, 0, this.getWidth()-1, this.getHeight()-1);

        //draw the lit LED if on
        if (this.isOn()) {
            g.setColor(getLedColor());
        } else {
        	g.setColor(getLedOffColor());
        }
        g.fillOval(0, 0, this.getWidth()-1, this.getHeight()-1);
    }

    public static void main(String[] a) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new LedRound());
        f.setSize(100,100);
        f.setVisible(true);
    }
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public Color getLedColor() {
		return ledColor;
	}
	public void setLedColor(Color ledColor) {
		this.ledColor = ledColor;
	}
	public Color getLedOffColor() {
		return ledOffColor;
	}
	public void setLedOffColor(Color ledOffColor) {
		this.ledOffColor = ledOffColor;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

    
    
}