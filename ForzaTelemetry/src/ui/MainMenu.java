package ui;

import javax.swing.JFrame;

import forza.Player;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class MainMenu extends DefaultUI {

	private static final long serialVersionUID = 1L;

	public MainMenu(ArrayList<Player> players, ReadWriteLock playersReadWriteLock) {
		super(players, playersReadWriteLock);
		this.setBounds(100, 100, 689, 582);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JButton btnTelemetryDashboard = new JButton("Telemetry");
		btnTelemetryDashboard.setForeground(Color.WHITE);
		btnTelemetryDashboard.setBackground(Color.BLACK);
		btnTelemetryDashboard.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelemetryUI ui = new TelemetryUI(getPlayers(), getPlayersReadWriteLock());
				ui.setVisible(true);
			}
		});
		btnTelemetryDashboard.setBounds(12, 13, 150, 196);
		this.getContentPane().add(btnTelemetryDashboard);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 673, 543);
		getContentPane().add(panel);
		panel.setLayout(null);
		
				JButton btnTelemetryDashboardjFreeChart = new JButton("Telemetry jFreeChart");
				btnTelemetryDashboardjFreeChart.setBackground(Color.BLACK);
				btnTelemetryDashboardjFreeChart.setForeground(Color.WHITE);
				btnTelemetryDashboardjFreeChart.setBounds(334, 11, 150, 196);
				panel.add(btnTelemetryDashboardjFreeChart);
				
						JButton btnTelemetryDashboardxChart = new JButton("Telemetry xChart");
						btnTelemetryDashboardxChart.setBackground(Color.BLACK);
						btnTelemetryDashboardxChart.setForeground(Color.WHITE);
						btnTelemetryDashboardxChart.setBounds(497, 11, 150, 196);
						panel.add(btnTelemetryDashboardxChart);
						
						JButton btnRaceDashboard = new JButton("Race");
						btnRaceDashboard.setForeground(Color.WHITE);
						btnRaceDashboard.setBackground(Color.BLACK);
						btnRaceDashboard.setBounds(174, 11, 150, 196);
						panel.add(btnRaceDashboard);
						btnRaceDashboard.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
								DashboardUI ui = new DashboardUI(getPlayers(), getPlayersReadWriteLock());
								ui.setVisible(true);
							}
						});
						btnTelemetryDashboardxChart.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
								TelemetryUIxChart ui = new TelemetryUIxChart(getPlayers(), getPlayersReadWriteLock());
								ui.setVisible(true);
							}
						});
				btnTelemetryDashboardjFreeChart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						TelemetryUIjFreeChart ui = new TelemetryUIjFreeChart(getPlayers(), getPlayersReadWriteLock());
						ui.setVisible(true);
					}
				});
}
}
