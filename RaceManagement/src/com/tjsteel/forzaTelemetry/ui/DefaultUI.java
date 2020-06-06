package com.tjsteel.forzaTelemetry.ui;

import java.util.concurrent.locks.ReadWriteLock;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.border.BevelBorder;

import com.tjsteel.forzaTelemetry.forza.Player;

public class DefaultUI extends JFrame {

	private Player player;
	protected static final long serialVersionUID = 1L;
	public JPanel contentPane;
	private Font dseg;
	private ReadWriteLock playersReadWriteLock;
	
	/**
	 * Create the frame.
	 */
	public DefaultUI(Player player, ReadWriteLock playersReadWriteLock) {
		this.setPlayer(player);
		this.setPlayersReadWriteLock(playersReadWriteLock);
	}

	public void initialize() {
		//load fonts
		try {
			setDseg(Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResource("com/tjsteel/forzaTelemetry/fonts/DSEG7Classic-Bold.ttf").openStream()).deriveFont(Font.BOLD, 30f));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("other issue");
		}

		setTitle("Forza Telemetry");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}
	
	/**
	 * Function to update the displayed fields
	 */
    public void updateFields() {
    }

    public void setReceivingTraffic(boolean receiving) {
    }

    public void reset() {
    }

	public Player getPlayer() {
		return player;
	}

	private void setPlayer(Player player) {
		this.player = player;
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
