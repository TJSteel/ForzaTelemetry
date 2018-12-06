package ui;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;

import javax.swing.JFrame;
import javax.swing.JPanel;
import forza.Player;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.border.BevelBorder;

public class DefaultUI extends JFrame {

	private ArrayList<Player> players;
	protected static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	private Font dseg;
	private ReadWriteLock playersReadWriteLock;
	
	/**
	 * Create the frame.
	 */
	public DefaultUI(ArrayList<Player> players, ReadWriteLock playersReadWriteLock) {
		this.setPlayers(players);
		this.setPlayersReadWriteLock(playersReadWriteLock);
	}

	public void initialize() {
		//load fonts
		try {
			setDseg(Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResource("fonts/DSEG7Classic-Bold.ttf").openStream()).deriveFont(Font.BOLD, 30f));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTitle("Forza Telemetry");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}
	
	/**
	 * Function to update the displayed fields
	 */
    public void updateFields() {
    }
    public void setReceivingTraffic(boolean receiving) {
    }
    public Player getSelectedPlayer(String gamertag) {
    	Player returnPlayer = null;
    	for (Player currPlayer : this.getPlayers()) {
    		if (gamertag.equals(currPlayer.getGamertag())) {
    			returnPlayer = currPlayer;
    		}
    	}
    	return returnPlayer;
    }
    public void reset() {
    }

	public ArrayList<Player> getPlayers() {
		return players;
	}

	private void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * @return the playersReadWriteLock
	 */
	public ReadWriteLock getPlayersReadWriteLock() {
		return playersReadWriteLock;
	}

	/**
	 * @param playersReadWriteLock the playersReadWriteLock to set
	 */
	private void setPlayersReadWriteLock(ReadWriteLock playersReadWriteLock) {
		this.playersReadWriteLock = playersReadWriteLock;
	}

	/**
	 * @return the dseg
	 */
	public Font getDseg() {
		return dseg;
	}

	/**
	 * @param dseg the dseg to set
	 */
	private void setDseg(Font dseg) {
		this.dseg = dseg;
	}
}
