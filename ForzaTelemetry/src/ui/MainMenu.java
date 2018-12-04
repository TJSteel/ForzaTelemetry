package ui;

import javax.swing.JFrame;

import forza.ForzaTelemetry;
import forza.Player;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainMenu extends DefaultUI {

	private static final long serialVersionUID = 1L;

	public MainMenu(ArrayList<Player> players) {
		super(players);
		this.setBounds(100, 100, 689, 582);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton btnTelemetryDashboard = new JButton("Telemetry");
		btnTelemetryDashboard.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Telemetry Button Pressed");
				dispose();
				TelemetryUI ui = new TelemetryUI(getPlayers());
				ui.setVisible(true);
			}
		});
		btnTelemetryDashboard.setBounds(12, 13, 196, 25);
		this.getContentPane().add(btnTelemetryDashboard);
		
		JButton btnRaceDashboard = new JButton("Race");
		btnRaceDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Race Button Pressed");
				dispose();
				DashboardUI ui = new DashboardUI(getPlayers());
				ui.setVisible(true);
			}
		});
		btnRaceDashboard.setBounds(12, 51, 196, 25);
		this.getContentPane().add(btnRaceDashboard);
	}
}
