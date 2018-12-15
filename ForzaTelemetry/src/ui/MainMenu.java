package ui;

import javax.swing.JFrame;

import forza.Player;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.awt.event.ActionEvent;

public class MainMenu extends DefaultUI {

	private static final long serialVersionUID = 1L;

	public MainMenu(ArrayList<Player> players, ReadWriteLock playersReadWriteLock) {
		super(players, playersReadWriteLock);
		this.setBounds(100, 100, 689, 582);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton btnTelemetryDashboard = new JButton("Telemetry");
		btnTelemetryDashboard.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelemetryUI ui = new TelemetryUI(getPlayers(), getPlayersReadWriteLock());
				ui.setVisible(true);
			}
		});
		btnTelemetryDashboard.setBounds(12, 13, 196, 25);
		this.getContentPane().add(btnTelemetryDashboard);
		
		JButton btnRaceDashboard = new JButton("Race");
		btnRaceDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DashboardUI ui = new DashboardUI(getPlayers(), getPlayersReadWriteLock());
				ui.setVisible(true);
			}
		});
		btnRaceDashboard.setBounds(12, 51, 196, 25);
		this.getContentPane().add(btnRaceDashboard);

		JButton btnTelemetryDashboardjFreeChart = new JButton("Telemetry jFreeChart");
		btnTelemetryDashboardjFreeChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelemetryUIjFreeChart ui = new TelemetryUIjFreeChart(getPlayers(), getPlayersReadWriteLock());
				ui.setVisible(true);
			}
		});
		btnTelemetryDashboardjFreeChart.setBounds(12, 89, 196, 25);
		this.getContentPane().add(btnTelemetryDashboardjFreeChart);
}

}
