package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReadWriteLock;

import javax.swing.SwingConstants;
import charts.BarChartSingle;
import enums.Speed;
import forza.Player;
import utility.Calc;

public class DashboardUI extends DefaultUI {


	// {{ variables
	private static final long serialVersionUID = 1L;

	private BarChartSingle barRPM1;
	private BarChartSingle barRPM2;
	private BarChartSingle barRPM3;
	private BarChartSingle barRPM4;
	private BarChartSingle barRPM5;
	private BarChartSingle barRPM6;
	private BarChartSingle barRPM7;
	private BarChartSingle barRPM8;
	private BarChartSingle barRPM9;
	private BarChartSingle barRPM10;
	private BarChartSingle barRPM11;
	private BarChartSingle barRPM12;
	private BarChartSingle barRPM13;
	private BarChartSingle barRPM14;
	
	private JLabel lblCurrentLap;
	private JLabel lblCurrentLapData;
	private JLabel lblBestLap;
	private JLabel lblBestLapData;
	private JLabel lblLastLapDelta;
	private JLabel lblLastLapDeltaData;
	private JLabel lblRaceTime;
	private JLabel lblRaceTimeData;
	private JLabel lblCurrentSpeed;
	private JLabel lblCurrentSpeedData;
	private JLabel lblFuel;
	private JLabel lblFuelData;
	private JLabel lblCurrentGear;
	private JLabel lblCurrentGearData;
	private JLabel lblFrontLeftTemp;
	private JLabel lblFrontLeftTempData;
	private JLabel lblRearLeftTemp;
	private JLabel lblRearLeftTempData;
	private JLabel lblFrontRightTemp;
	private JLabel lblFrontRightTempData;
	private JLabel lblRearRightTemp;
	private JLabel lblRearRightTempData;
	private JLabel lblFuelLapsRemaining;
	private JLabel lblFuelLapsRemainingData;
	
	private JPanel pnlMain;
	private JPanel pnlCurrentLap;
	private JPanel pnlBestLap;
	private JPanel pnlLastLapDelta;
	private JPanel pnlRaceTime;
	private JPanel pnlCurrentSpeed;
	private JPanel pnlFuel;
	private JPanel pnlCurrentGear;
	private JPanel pnlFrontLeftTemp;
	private JPanel pnlRearLeftTemp;
	private JPanel pnlFrontRightTemp;
	private JPanel pnlRearRightTemp;
	private JPanel pnlFuelLapsRemaining;
	
	private float redlineRPM = 9000.0f;
	private float redlineRange = 1000.0f;
	// }} variables

	/**
	 * Create the frame.
	 */
	public DashboardUI(ArrayList<Player> players, ReadWriteLock playersReadWriteLock) {
		super(players, playersReadWriteLock);
		this.initialize();
    	Timer timer = new Timer();
    	timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
            	updateFields();
            }
        }, 50, 50);
	}
	
	public void initialize() {
		super.initialize();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	dispose();
				MainMenu ui = new MainMenu(getPlayers(), getPlayersReadWriteLock());
				ui.setVisible(true);
		    }
		});
		
		pnlMain = new JPanel();
		pnlMain.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		pnlMain.setBackground(Color.DARK_GRAY);
		pnlMain.setBounds(295, 11, 706, 659);
		contentPane.add(pnlMain);
		pnlMain.setLayout(null);
		
		pnlCurrentLap = new JPanel();
		pnlCurrentLap.setForeground(Color.WHITE);
		pnlCurrentLap.setBackground(Color.DARK_GRAY);
		pnlCurrentLap.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 200, 0)));
		pnlCurrentLap.setBounds(10, 120, 344, 124);
		pnlMain.add(pnlCurrentLap);
		pnlCurrentLap.setLayout(null);
		
		lblCurrentLap = new JLabel("Current Lap");
		lblCurrentLap.setLabelFor(pnlCurrentLap);
		lblCurrentLap.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentLap.setForeground(Color.WHITE);
		lblCurrentLap.setFont(new Font("Calibri", Font.BOLD, 19));
		lblCurrentLap.setBounds(0, 99, 343, 14);
		pnlCurrentLap.add(lblCurrentLap);
		
		lblCurrentLapData = new JLabel("-00:00.000");
		lblCurrentLapData.setForeground(Color.WHITE);
		lblCurrentLapData.setBounds(10, 12, 324, 76);
		lblCurrentLapData.setLabelFor(pnlCurrentLap);
		lblCurrentLapData.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentLapData.setFont(new Font("Tahoma", Font.PLAIN, 48));
		pnlCurrentLap.add(lblCurrentLapData);
		
		pnlBestLap = new JPanel();
		pnlBestLap.setBackground(Color.DARK_GRAY);
		pnlBestLap.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		pnlBestLap.setBounds(10, 255, 344, 124);
		pnlMain.add(pnlBestLap);
		pnlBestLap.setLayout(null);
		
		lblBestLap = new JLabel("Best Lap");
		lblBestLap.setLabelFor(pnlBestLap);
		lblBestLap.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestLap.setForeground(Color.WHITE);
		lblBestLap.setFont(new Font("Calibri", Font.BOLD, 19));
		lblBestLap.setBounds(0, 99, 343, 14);
		pnlBestLap.add(lblBestLap);
		
		lblBestLapData = new JLabel("-00:00.000");
		lblBestLapData.setBounds(10, 12, 324, 76);
		lblBestLapData.setLabelFor(pnlBestLap);
		lblBestLapData.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestLapData.setForeground(Color.WHITE);
		lblBestLapData.setFont(new Font("Tahoma", Font.PLAIN, 48));
		pnlBestLap.add(lblBestLapData);
		
		pnlLastLapDelta = new JPanel();
		pnlLastLapDelta.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 200, 0)));
		pnlLastLapDelta.setBackground(Color.DARK_GRAY);
		pnlLastLapDelta.setBounds(352, 120, 344, 124);
		pnlMain.add(pnlLastLapDelta);
		pnlLastLapDelta.setLayout(null);
		
		lblLastLapDelta = new JLabel("Delta");
		lblLastLapDelta.setLabelFor(pnlLastLapDelta);
		lblLastLapDelta.setFont(new Font("Calibri", Font.BOLD, 19));
		lblLastLapDelta.setForeground(Color.WHITE);
		lblLastLapDelta.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastLapDelta.setBounds(0, 99, 343, 14);
		pnlLastLapDelta.add(lblLastLapDelta);
		
		lblLastLapDeltaData = new JLabel("-00:00.000");
		lblLastLapDeltaData.setBounds(10, 12, 324, 76);
		lblLastLapDeltaData.setLabelFor(pnlLastLapDelta);
		lblLastLapDeltaData.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastLapDeltaData.setForeground(Color.WHITE);
		lblLastLapDeltaData.setFont(new Font("Tahoma", Font.PLAIN, 48));
		pnlLastLapDelta.add(lblLastLapDeltaData);
		
		pnlRaceTime = new JPanel();
		pnlRaceTime.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 200, 0)));
		pnlRaceTime.setBackground(Color.DARK_GRAY);
		pnlRaceTime.setBounds(352, 255, 344, 124);
		pnlMain.add(pnlRaceTime);
		pnlRaceTime.setLayout(null);
		
		lblRaceTime = new JLabel("Race Time");
		lblRaceTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaceTime.setForeground(Color.WHITE);
		lblRaceTime.setFont(new Font("Calibri", Font.BOLD, 19));
		lblRaceTime.setBounds(0, 99, 343, 14);
		pnlRaceTime.add(lblRaceTime);
		
		lblRaceTimeData = new JLabel("01h:00:00.000");
		lblRaceTimeData.setBounds(10, 12, 324, 76);
		lblRaceTimeData.setLabelFor(pnlRaceTime);
		lblRaceTimeData.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaceTimeData.setForeground(Color.WHITE);
		lblRaceTimeData.setFont(new Font("Tahoma", Font.PLAIN, 48));
		pnlRaceTime.add(lblRaceTimeData);
		
		pnlCurrentSpeed = new JPanel();
		pnlCurrentSpeed.setForeground(Color.WHITE);
		pnlCurrentSpeed.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		pnlCurrentSpeed.setBackground(Color.DARK_GRAY);
		pnlCurrentSpeed.setBounds(452, 390, 244, 124);
		pnlMain.add(pnlCurrentSpeed);
		pnlCurrentSpeed.setLayout(null);
		
		lblCurrentSpeed = new JLabel("Speed KM/H");
		lblCurrentSpeed.setFont(new Font("Calibri", Font.BOLD, 12));
		lblCurrentSpeed.setForeground(Color.WHITE);
		lblCurrentSpeed.setBounds(10, 89, 224, 24);
		lblCurrentSpeed.setLabelFor(pnlCurrentSpeed);
		lblCurrentSpeed.setToolTipText("");
		lblCurrentSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCurrentSpeed.add(lblCurrentSpeed);
		
		lblCurrentSpeedData = new JLabel("888.88");
		lblCurrentSpeedData.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblCurrentSpeedData.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentSpeedData.setForeground(Color.WHITE);
		lblCurrentSpeedData.setLabelFor(pnlCurrentSpeed);
		lblCurrentSpeedData.setToolTipText("");
		lblCurrentSpeedData.setBounds(10, 11, 224, 67);
		pnlCurrentSpeed.add(lblCurrentSpeedData);

		pnlFuel = new JPanel();
		pnlFuel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		pnlFuel.setBackground(Color.DARK_GRAY);
		pnlFuel.setBounds(572, 524, 124, 124);
		pnlMain.add(pnlFuel);
		pnlFuel.setLayout(null);
		
		lblFuel = new JLabel("Fuel %");
		lblFuel.setBounds(10, 89, 104, 24);
		lblFuel.setLabelFor(pnlFuel);
		pnlFuel.add(lblFuel);
		lblFuel.setToolTipText("");
		lblFuel.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuel.setForeground(Color.WHITE);
		lblFuel.setFont(new Font("Calibri", Font.BOLD, 12));
		
		lblFuelData = new JLabel("888.8");
		lblFuelData.setBounds(10, 11, 104, 67);
		lblFuelData.setLabelFor(pnlFuel);
		pnlFuel.add(lblFuelData);
		lblFuelData.setToolTipText("");
		lblFuelData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelData.setForeground(Color.WHITE);
		lblFuelData.setFont(new Font("Tahoma", Font.PLAIN, 38));

		pnlCurrentGear = new JPanel();
		pnlCurrentGear.setBackground(new Color(0, 0, 255));
		pnlCurrentGear.setBounds(264, 390, 176, 258);
		pnlMain.add(pnlCurrentGear);
		pnlCurrentGear.setLayout(null);
		
		lblCurrentGear = new JLabel("Gear Selection");
		lblCurrentGear.setForeground(Color.WHITE);
		lblCurrentGear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentGear.setToolTipText("");
		lblCurrentGear.setBounds(10, 201, 156, 46);
		pnlCurrentGear.add(lblCurrentGear);
		lblCurrentGear.setLabelFor(pnlCurrentGear);
		lblCurrentGear.setFont(new Font("Calibri", Font.BOLD, 19));
		
		lblCurrentGearData = new JLabel("N");
		lblCurrentGearData.setForeground(Color.WHITE);
		lblCurrentGearData.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentGearData.setFont(lblCurrentGearData.getFont().deriveFont(162f));
		lblCurrentGearData.setBounds(10, 11, 156, 179);
		pnlCurrentGear.add(lblCurrentGearData);

		pnlFrontLeftTemp = new JPanel();
		pnlFrontLeftTemp.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		pnlFrontLeftTemp.setBackground(Color.DARK_GRAY);
		pnlFrontLeftTemp.setBounds(10, 390, 124, 124);
		pnlMain.add(pnlFrontLeftTemp);
		pnlFrontLeftTemp.setLayout(null);
		
		lblFrontLeftTemp = new JLabel("Front Left Temp");
		lblFrontLeftTemp.setBounds(10, 89, 104, 24);
		lblFrontLeftTemp.setLabelFor(pnlFrontLeftTemp);
		lblFrontLeftTemp.setToolTipText("");
		lblFrontLeftTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrontLeftTemp.setForeground(Color.WHITE);
		lblFrontLeftTemp.setFont(new Font("Calibri", Font.BOLD, 12));
		pnlFrontLeftTemp.add(lblFrontLeftTemp);
		
		lblFrontLeftTempData = new JLabel("888.8");
		lblFrontLeftTempData.setBounds(10, 11, 104, 67);
		lblFrontLeftTempData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrontLeftTempData.setForeground(Color.WHITE);
		lblFrontLeftTempData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		pnlFrontLeftTemp.add(lblFrontLeftTempData);

		pnlRearLeftTemp = new JPanel();
		pnlRearLeftTemp.setBackground(Color.DARK_GRAY);
		pnlRearLeftTemp.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		pnlRearLeftTemp.setBounds(10, 524, 124, 124);
		pnlMain.add(pnlRearLeftTemp);
		pnlRearLeftTemp.setLayout(null);
		
		lblRearLeftTemp = new JLabel("Rear Left Temp");
		lblRearLeftTemp.setLabelFor(pnlRearLeftTemp);
		lblRearLeftTemp.setToolTipText("");
		lblRearLeftTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblRearLeftTemp.setForeground(Color.WHITE);
		lblRearLeftTemp.setFont(new Font("Calibri", Font.BOLD, 12));
		lblRearLeftTemp.setBounds(10, 89, 104, 24);
		pnlRearLeftTemp.add(lblRearLeftTemp);
		
		lblRearLeftTempData = new JLabel("888.8");
		lblRearLeftTempData.setHorizontalAlignment(SwingConstants.CENTER);
		lblRearLeftTempData.setForeground(Color.WHITE);
		lblRearLeftTempData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblRearLeftTempData.setBounds(10, 11, 104, 67);
		pnlRearLeftTemp.add(lblRearLeftTempData);

		pnlFrontRightTemp = new JPanel();
		pnlFrontRightTemp.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		pnlFrontRightTemp.setBackground(Color.DARK_GRAY);
		pnlFrontRightTemp.setBounds(130, 390, 124, 124);
		pnlMain.add(pnlFrontRightTemp);
		pnlFrontRightTemp.setLayout(null);

		lblFrontRightTemp = new JLabel("Front Right Temp");
		lblFrontRightTemp.setBounds(10, 89, 104, 24);
		lblFrontRightTemp.setLabelFor(pnlFrontRightTemp);
		lblFrontRightTemp.setToolTipText("");
		lblFrontRightTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrontRightTemp.setForeground(Color.WHITE);
		lblFrontRightTemp.setFont(new Font("Calibri", Font.BOLD, 12));
		pnlFrontRightTemp.add(lblFrontRightTemp);
		
		lblFrontRightTempData = new JLabel("888.8");
		lblFrontRightTempData.setBounds(10, 11, 104, 67);
		lblFrontRightTempData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrontRightTempData.setForeground(Color.WHITE);
		lblFrontRightTempData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		pnlFrontRightTemp.add(lblFrontRightTempData);
		
		pnlRearRightTemp = new JPanel();
		pnlRearRightTemp.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		pnlRearRightTemp.setBackground(Color.DARK_GRAY);
		pnlRearRightTemp.setBounds(130, 524, 124, 124);
		pnlMain.add(pnlRearRightTemp);
		pnlRearRightTemp.setLayout(null);
		
		lblRearRightTemp = new JLabel("Rear Right Temp");
		lblRearRightTemp.setBounds(10, 89, 104, 24);
		lblRearRightTemp.setLabelFor(pnlRearRightTemp);
		lblRearRightTemp.setToolTipText("");
		lblRearRightTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblRearRightTemp.setForeground(Color.WHITE);
		lblRearRightTemp.setFont(new Font("Calibri", Font.BOLD, 12));
		pnlRearRightTemp.add(lblRearRightTemp);
		
		lblRearRightTempData = new JLabel("888.8");
		lblRearRightTempData.setBounds(10, 11, 104, 67);
		lblRearRightTempData.setBackground(Color.BLACK);
		lblRearRightTempData.setForeground(Color.WHITE);
		lblRearRightTempData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblRearRightTempData.setLabelFor(pnlRearRightTemp);
		lblRearRightTempData.setHorizontalAlignment(SwingConstants.CENTER);
		pnlRearRightTemp.add(lblRearRightTempData);

		pnlFuelLapsRemaining = new JPanel();
		pnlFuelLapsRemaining.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		pnlFuelLapsRemaining.setBackground(Color.DARK_GRAY);
		pnlFuelLapsRemaining.setBounds(452, 524, 124, 124);
		pnlMain.add(pnlFuelLapsRemaining);
		pnlFuelLapsRemaining.setLayout(null);
		
		lblFuelLapsRemaining = new JLabel("Fuel Laps Left");
		lblFuelLapsRemaining.setBounds(10, 89, 104, 24);
		lblFuelLapsRemaining.setLabelFor(pnlFuelLapsRemaining);
		pnlFuelLapsRemaining.add(lblFuelLapsRemaining);
		lblFuelLapsRemaining.setToolTipText("");
		lblFuelLapsRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelLapsRemaining.setForeground(Color.WHITE);
		lblFuelLapsRemaining.setFont(new Font("Calibri", Font.BOLD, 12));
		
		lblFuelLapsRemainingData = new JLabel("88.8");
		lblFuelLapsRemainingData.setBounds(10, 11, 104, 67);
		lblFuelLapsRemainingData.setLabelFor(pnlFuelLapsRemaining);
		pnlFuelLapsRemaining.add(lblFuelLapsRemainingData);
		lblFuelLapsRemainingData.setToolTipText("");
		lblFuelLapsRemainingData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelLapsRemainingData.setForeground(Color.WHITE);
		lblFuelLapsRemainingData.setFont(new Font("Tahoma", Font.PLAIN, 38));

		barRPM1 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM1.setOpaque(false);
		barRPM1.setBounds(10, 11, 48, 98);
		barRPM1.setHorizontal(true);
		pnlMain.add(barRPM1);

		barRPM2 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM2.setOpaque(false);
		barRPM2.setBounds(59, 11, 48, 98);
		barRPM2.setHorizontal(true);
		pnlMain.add(barRPM2);

		barRPM3 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM3.setOpaque(false);
		barRPM3.setBounds(108, 11, 48, 98);
		barRPM3.setHorizontal(true);
		pnlMain.add(barRPM3);

		barRPM4 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM4.setOpaque(false);
		barRPM4.setBounds(157, 11, 48, 98);
		barRPM4.setHorizontal(true);
		pnlMain.add(barRPM4);

		barRPM5 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM5.setOpaque(false);
		barRPM5.setBounds(206, 11, 48, 98);
		barRPM5.setHorizontal(true);
		pnlMain.add(barRPM5);

		barRPM6 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM6.setOpaque(false);
		barRPM6.setBounds(255, 11, 48, 98);
		barRPM6.setHorizontal(true);
		pnlMain.add(barRPM6);

		barRPM7 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM7.setOpaque(false);
		barRPM7.setBounds(304, 11, 48, 98);
		barRPM7.setHorizontal(true);
		pnlMain.add(barRPM7);

		barRPM8 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM8.setOpaque(false);
		barRPM8.setBounds(353, 11, 48, 98);
		barRPM8.setHorizontal(true);
		pnlMain.add(barRPM8);

		barRPM9 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM9.setOpaque(false);
		barRPM9.setBounds(402, 11, 48, 98);
		barRPM9.setHorizontal(true);
		pnlMain.add(barRPM9);

		barRPM10 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM10.setOpaque(false);
		barRPM10.setBounds(451, 11, 48, 98);
		barRPM10.setHorizontal(true);
		pnlMain.add(barRPM10);

		barRPM11 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM11.setOpaque(false);
		barRPM11.setBounds(500, 11, 48, 98);
		barRPM11.setHorizontal(true);
		pnlMain.add(barRPM11);

		barRPM12 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM12.setOpaque(false);
		barRPM12.setBounds(549, 11, 48, 98);
		barRPM12.setHorizontal(true);
		pnlMain.add(barRPM12);

		barRPM13 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM13.setOpaque(false);
		barRPM13.setBounds(598, 11, 48, 98);
		barRPM13.setHorizontal(true);
		pnlMain.add(barRPM13);

		barRPM14 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM14.setOpaque(false);
		barRPM14.setBounds(647, 11, 48, 98);
		barRPM14.setHorizontal(true);
		pnlMain.add(barRPM14);

	}
    public void updateFields() {
    	super.updateFields();
    	getPlayersReadWriteLock().readLock().lock();
    	try {
        	DecimalFormat df1 = new DecimalFormat("#.0");
        	DecimalFormat df2 = new DecimalFormat("#.00");
        	
        	Player currPlayer = getSelectedPlayer();
    		if (currPlayer.getTelemetryPacket() != null) {
		    	this.lblCurrentLapData.setText(Calc.secondsToTime(currPlayer.getTelemetryPacket().getTrack().getCurrentLap()));
		    	this.lblBestLapData.setText(Calc.secondsToTime((currPlayer.getTelemetryPacket().getTrack().getBestLap())));
		    	this.lblLastLapDeltaData.setText(Calc.secondsToTime(currPlayer.getLastLapDelta()));
		    	this.lblRaceTimeData.setText(Calc.secondsToTime(currPlayer.getTelemetryPacket().getTrack().getCurrentRaceTime()));
		    	this.lblCurrentSpeedData.setText(df2.format(currPlayer.getTelemetryPacket().getVelocity().getSpeed(Speed.MPH)));
		    	this.lblFuelData.setText(Float.toString(currPlayer.getTelemetryPacket().getEngine().getFuel()));
		    	this.lblCurrentGearData.setText(Short.toString(currPlayer.getTelemetryPacket().getEngine().getGear()));
		    	this.lblFrontLeftTempData.setText(df1.format(currPlayer.getTelemetryPacket().getTyre().getTireTempFrontLeft()));
		    	this.lblRearLeftTempData.setText(df1.format(currPlayer.getTelemetryPacket().getTyre().getTireTempRearLeft()));
		    	this.lblFrontRightTempData.setText(df1.format(currPlayer.getTelemetryPacket().getTyre().getTireTempFrontRight()));
		    	this.lblRearRightTempData.setText(df1.format(currPlayer.getTelemetryPacket().getTyre().getTireTempRearRight()));
		    	this.lblFuelLapsRemainingData.setText("N/A");

		    	float currentRPM = currPlayer.getTelemetryPacket().getEngine().getCurrentEngineRpm();
		    	float redlineRPM = this.redlineRPM;
		    	float redlineRange = this.redlineRange;
		    	
		    	barRPM1.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 1, 14));
		    	barRPM1.repaint();
		    	barRPM2.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 2, 14));
		    	barRPM2.repaint();
		    	barRPM3.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 3, 14));
		    	barRPM3.repaint();
		    	barRPM4.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 4, 14));
		    	barRPM4.repaint();
		    	barRPM5.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 5, 14));
		    	barRPM5.repaint();
		    	barRPM6.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 6, 14));
		    	barRPM6.repaint();
		    	barRPM7.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 7, 14));
		    	barRPM7.repaint();
		    	barRPM8.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 8, 14));
		    	barRPM8.repaint();
		    	barRPM9.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 9, 14));
		    	barRPM9.repaint();
		    	barRPM10.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 10, 14));
		    	barRPM10.repaint();
		    	barRPM11.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 11, 14));
		    	barRPM11.repaint();
		    	barRPM12.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 12, 14));
		    	barRPM12.repaint();
		    	barRPM13.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 13, 14));
		    	barRPM13.repaint();
		    	barRPM14.setValue(getRPMBarValue(currentRPM, redlineRPM, redlineRange, 14, 14));
		    	barRPM14.repaint();
        	}
    	} finally {
    		getPlayersReadWriteLock().readLock().unlock();
    	}

    }
    public void setReceivingTraffic(boolean receiving) {
    	
    }
    private Player getSelectedPlayer() {
    	return super.getSelectedPlayer(null);
    }
    public void reset() {
    	getSelectedPlayer().reset();
    }
    private float getRPMBarValue(float currentRPM, float redlineRPM, float redlineRange, int barNumber, int barCount) {
    	float barMax = redlineRPM - redlineRange + ((redlineRange / barCount) * barNumber);
    	if (currentRPM >= barMax) return 100.0f;
    	return 0.0f;
    }
}
