package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
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
	private JLabel lblCurrentLapData;
	private JLabel lblBestLapData;
	private JLabel lblLastLapDeltaData;
	private JLabel lblRaceTimeData;
	private JLabel lblCurrentSpeedData;
	private JLabel lblFuelData;
	private JLabel lblCurrentGearData;
	private JLabel lblFrontLeftTempData;
	private JLabel lblRearLeftTempData;
	private JLabel lblFrontRightTempData;
	private JLabel lblRearRightTempData;
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
	
	private float redlineRPM = 6500.0f;
	private float redlineRange = 1000.0f;
	private JPanel pnlCurrentLapHeadingBox;
	private JPanel pnlFastestLapHeadingBox;
	private JLabel lblFastestLap;
	private JPanel pnlDeltaHeadingBox;
	private JLabel lblDelta;
	private JPanel pnlRaceTimeHeadingBox;
	private JLabel lblRaceTime;
	private JPanel pnlFuelLapsRemainingHeadingBox;
	private JLabel lblFuelLapsRemanining;
	private JPanel pnlRearLeftTireTempHeadingBox;
	private JLabel lblRearLeftTireTemp;
	private JPanel pnlRearRightTireTempHeadingBox;
	private JLabel lblRearRightTireTemp;
	private JPanel pnlFrontLeftTireTempHeadingBox;
	private JLabel lblFrontLeftTire;
	private JPanel pnlFrontRightTireTempHeadingBox;
	private JLabel lblFrontRightTire;
	private JPanel pnlFuelPercenatgeHeadingBox;
	private JLabel lblFuelPercantage;
	private JPanel pnlCurrentSpeedMPHHeadingBox;
	private JLabel lblCurrentSpeedMph;
	private JPanel panel;
	private JLabel lblGearSelection;
	private JPanel pnlGearSelectionHeadingBox;
	private JLabel lblGearSelection_1;
	// }} variables

	/**
	 * Create the frame.
	 */
	public DashboardUI(ArrayList<Player> players, ReadWriteLock playersReadWriteLock) {
		super(players, playersReadWriteLock);
		this.initialize();

		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
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
		pnlMain.setBackground(Color.BLACK);
		pnlMain.setBounds(295, 11, 706, 659);
		contentPane.add(pnlMain);
		pnlMain.setLayout(null);
		
		pnlCurrentLap = new JPanel();
		pnlCurrentLap.setForeground(Color.WHITE);
		pnlCurrentLap.setBackground(Color.BLACK);
		pnlCurrentLap.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlCurrentLap.setBounds(10, 120, 344, 124);
		pnlMain.add(pnlCurrentLap);
		pnlCurrentLap.setLayout(null);
		
		lblCurrentLapData = new JLabel("-00:00.000");
		lblCurrentLapData.setForeground(Color.WHITE);
		lblCurrentLapData.setBounds(0, 31, 344, 93);
		lblCurrentLapData.setLabelFor(pnlCurrentLap);
		lblCurrentLapData.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentLapData.setFont(new Font("Tahoma", Font.PLAIN, 48));
		pnlCurrentLap.add(lblCurrentLapData);
		
		pnlCurrentLapHeadingBox = new JPanel();
		pnlCurrentLapHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlCurrentLapHeadingBox.setBackground(Color.BLACK);
		pnlCurrentLapHeadingBox.setBounds(0, 0, 344, 32);
		pnlCurrentLap.add(pnlCurrentLapHeadingBox);
		pnlCurrentLapHeadingBox.setLayout(null);
		
		JLabel lbCurrentLap = new JLabel("CURRENT LAP");
		lbCurrentLap.setLabelFor(pnlCurrentLapHeadingBox);
		lbCurrentLap.setHorizontalAlignment(SwingConstants.CENTER);
		lbCurrentLap.setForeground(Color.WHITE);
		lbCurrentLap.setFont(new Font("Calibri", Font.BOLD, 19));
		lbCurrentLap.setBounds(0, 3, 344, 28);
		pnlCurrentLapHeadingBox.add(lbCurrentLap);
		
		pnlBestLap = new JPanel();
		pnlBestLap.setBackground(Color.BLACK);
		pnlBestLap.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlBestLap.setBounds(10, 255, 344, 124);
		pnlMain.add(pnlBestLap);
		pnlBestLap.setLayout(null);
		
		lblBestLapData = new JLabel("-00:00.000");
		lblBestLapData.setBounds(0, 32, 344, 92);
		lblBestLapData.setLabelFor(pnlBestLap);
		lblBestLapData.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestLapData.setForeground(Color.WHITE);
		lblBestLapData.setFont(new Font("Tahoma", Font.PLAIN, 48));
		pnlBestLap.add(lblBestLapData);
		
		pnlFastestLapHeadingBox = new JPanel();
		pnlFastestLapHeadingBox.setLayout(null);
		pnlFastestLapHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlFastestLapHeadingBox.setBackground(Color.BLACK);
		pnlFastestLapHeadingBox.setBounds(0, 0, 344, 32);
		pnlBestLap.add(pnlFastestLapHeadingBox);
		
		lblFastestLap = new JLabel("FASTEST LAP");
		lblFastestLap.setLabelFor(pnlFastestLapHeadingBox);
		lblFastestLap.setHorizontalAlignment(SwingConstants.CENTER);
		lblFastestLap.setForeground(Color.WHITE);
		lblFastestLap.setFont(new Font("Calibri", Font.BOLD, 19));
		lblFastestLap.setBounds(0, 3, 344, 28);
		pnlFastestLapHeadingBox.add(lblFastestLap);
		
		pnlLastLapDelta = new JPanel();
		pnlLastLapDelta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlLastLapDelta.setBackground(Color.BLACK);
		pnlLastLapDelta.setBounds(352, 120, 344, 124);
		pnlMain.add(pnlLastLapDelta);
		pnlLastLapDelta.setLayout(null);
		
		lblLastLapDeltaData = new JLabel("-00:00.000");
		lblLastLapDeltaData.setBounds(0, 31, 344, 93);
		lblLastLapDeltaData.setLabelFor(pnlLastLapDelta);
		lblLastLapDeltaData.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastLapDeltaData.setForeground(Color.WHITE);
		lblLastLapDeltaData.setFont(new Font("Tahoma", Font.PLAIN, 48));
		pnlLastLapDelta.add(lblLastLapDeltaData);
		
		pnlDeltaHeadingBox = new JPanel();
		pnlDeltaHeadingBox.setLayout(null);
		pnlDeltaHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlDeltaHeadingBox.setBackground(Color.BLACK);
		pnlDeltaHeadingBox.setBounds(0, 0, 344, 32);
		pnlLastLapDelta.add(pnlDeltaHeadingBox);
		
		lblDelta = new JLabel("DELTA");
		lblDelta.setLabelFor(pnlDeltaHeadingBox);
		lblDelta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelta.setForeground(Color.WHITE);
		lblDelta.setFont(new Font("Calibri", Font.BOLD, 19));
		lblDelta.setBounds(0, 3, 344, 28);
		pnlDeltaHeadingBox.add(lblDelta);
		
		pnlRaceTime = new JPanel();
		pnlRaceTime.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlRaceTime.setBackground(Color.BLACK);
		pnlRaceTime.setBounds(352, 255, 344, 124);
		pnlMain.add(pnlRaceTime);
		pnlRaceTime.setLayout(null);
		
		lblRaceTimeData = new JLabel("00:00:00.000");
		lblRaceTimeData.setBounds(0, 31, 344, 93);
		lblRaceTimeData.setLabelFor(pnlRaceTime);
		lblRaceTimeData.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaceTimeData.setForeground(Color.WHITE);
		lblRaceTimeData.setFont(new Font("Tahoma", Font.PLAIN, 48));
		pnlRaceTime.add(lblRaceTimeData);
		
		pnlRaceTimeHeadingBox = new JPanel();
		pnlRaceTimeHeadingBox.setLayout(null);
		pnlRaceTimeHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlRaceTimeHeadingBox.setBackground(Color.BLACK);
		pnlRaceTimeHeadingBox.setBounds(0, 0, 344, 32);
		pnlRaceTime.add(pnlRaceTimeHeadingBox);
		
		lblRaceTime = new JLabel("RACE TIME");
		lblRaceTime.setLabelFor(pnlRaceTimeHeadingBox);
		lblRaceTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaceTime.setForeground(Color.WHITE);
		lblRaceTime.setFont(new Font("Calibri", Font.BOLD, 19));
		lblRaceTime.setBounds(0, 3, 344, 28);
		pnlRaceTimeHeadingBox.add(lblRaceTime);
		
		pnlCurrentSpeed = new JPanel();
		pnlCurrentSpeed.setForeground(Color.WHITE);
		pnlCurrentSpeed.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentSpeed.setBackground(Color.BLACK);
		pnlCurrentSpeed.setBounds(452, 390, 244, 124);
		pnlMain.add(pnlCurrentSpeed);
		pnlCurrentSpeed.setLayout(null);
		
		lblCurrentSpeedData = new JLabel("888.88");
		lblCurrentSpeedData.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblCurrentSpeedData.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentSpeedData.setForeground(Color.WHITE);
		lblCurrentSpeedData.setLabelFor(pnlCurrentSpeed);
		lblCurrentSpeedData.setToolTipText("");
		lblCurrentSpeedData.setBounds(0, 25, 244, 99);
		pnlCurrentSpeed.add(lblCurrentSpeedData);
		
		pnlCurrentSpeedMPHHeadingBox = new JPanel();
		pnlCurrentSpeedMPHHeadingBox.setLayout(null);
		pnlCurrentSpeedMPHHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentSpeedMPHHeadingBox.setBackground(Color.BLACK);
		pnlCurrentSpeedMPHHeadingBox.setBounds(0, 0, 244, 25);
		pnlCurrentSpeed.add(pnlCurrentSpeedMPHHeadingBox);
		
		lblCurrentSpeedMph = new JLabel("CURRENT SPEED MP/H");
		lblCurrentSpeedMph.setLabelFor(pnlCurrentSpeedMPHHeadingBox);
		lblCurrentSpeedMph.setToolTipText("");
		lblCurrentSpeedMph.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentSpeedMph.setForeground(Color.WHITE);
		lblCurrentSpeedMph.setFont(new Font("Calibri", Font.BOLD, 11));
		lblCurrentSpeedMph.setBounds(0, 3, 244, 23);
		pnlCurrentSpeedMPHHeadingBox.add(lblCurrentSpeedMph);

		pnlFuel = new JPanel();
		pnlFuel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlFuel.setBackground(Color.BLACK);
		pnlFuel.setBounds(572, 524, 124, 124);
		pnlMain.add(pnlFuel);
		pnlFuel.setLayout(null);
		
		lblFuelData = new JLabel("888.8");
		lblFuelData.setBounds(0, 26, 124, 98);
		lblFuelData.setLabelFor(pnlFuel);
		pnlFuel.add(lblFuelData);
		lblFuelData.setToolTipText("");
		lblFuelData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelData.setForeground(Color.WHITE);
		lblFuelData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		
		pnlFuelPercenatgeHeadingBox = new JPanel();
		pnlFuelPercenatgeHeadingBox.setLayout(null);
		pnlFuelPercenatgeHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlFuelPercenatgeHeadingBox.setBackground(Color.BLACK);
		pnlFuelPercenatgeHeadingBox.setBounds(0, 0, 124, 27);
		pnlFuel.add(pnlFuelPercenatgeHeadingBox);
		
		lblFuelPercantage = new JLabel("FUEL %");
		lblFuelPercantage.setToolTipText("");
		lblFuelPercantage.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelPercantage.setForeground(Color.WHITE);
		lblFuelPercantage.setFont(new Font("Calibri", Font.BOLD, 11));
		lblFuelPercantage.setBounds(0, 3, 121, 22);
		pnlFuelPercenatgeHeadingBox.add(lblFuelPercantage);

		pnlCurrentGear = new JPanel();
		pnlCurrentGear.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentGear.setBackground(Color.BLACK);
		pnlCurrentGear.setBounds(265, 390, 176, 258);
		pnlMain.add(pnlCurrentGear);
		pnlCurrentGear.setLayout(null);
		
		lblCurrentGearData = new JLabel("N");
		lblCurrentGearData.setForeground(Color.WHITE);
		lblCurrentGearData.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentGearData.setFont(new Font("Tahoma", Font.PLAIN, 162));
		lblCurrentGearData.setBounds(0, 31, 176, 227);
		pnlCurrentGear.add(lblCurrentGearData);
		
		pnlGearSelectionHeadingBox = new JPanel();
		pnlGearSelectionHeadingBox.setBounds(0, 0, 176, 32);
		pnlCurrentGear.add(pnlGearSelectionHeadingBox);
		pnlGearSelectionHeadingBox.setLayout(null);
		pnlGearSelectionHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlGearSelectionHeadingBox.setBackground(Color.BLACK);
		
		lblGearSelection_1 = new JLabel("GEAR SELECTION");
		lblGearSelection_1.setLabelFor(pnlGearSelectionHeadingBox);
		lblGearSelection_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGearSelection_1.setForeground(Color.WHITE);
		lblGearSelection_1.setFont(new Font("Calibri", Font.BOLD, 19));
		lblGearSelection_1.setBounds(0, 3, 176, 28);
		pnlGearSelectionHeadingBox.add(lblGearSelection_1);

		pnlFrontLeftTemp = new JPanel();
		pnlFrontLeftTemp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlFrontLeftTemp.setBackground(Color.BLACK);
		pnlFrontLeftTemp.setBounds(10, 390, 122, 124);
		pnlMain.add(pnlFrontLeftTemp);
		pnlFrontLeftTemp.setLayout(null);
		
		lblFrontLeftTempData = new JLabel("888.8");
		lblFrontLeftTempData.setBounds(0, 26, 122, 98);
		lblFrontLeftTempData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrontLeftTempData.setForeground(Color.WHITE);
		lblFrontLeftTempData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		pnlFrontLeftTemp.add(lblFrontLeftTempData);
		
		pnlFrontLeftTireTempHeadingBox = new JPanel();
		pnlFrontLeftTireTempHeadingBox.setLayout(null);
		pnlFrontLeftTireTempHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlFrontLeftTireTempHeadingBox.setBackground(Color.BLACK);
		pnlFrontLeftTireTempHeadingBox.setBounds(0, 0, 122, 27);
		pnlFrontLeftTemp.add(pnlFrontLeftTireTempHeadingBox);
		
		lblFrontLeftTire = new JLabel("FRONT LEFT TIRE TEMP");
		lblFrontLeftTire.setLabelFor(pnlFrontLeftTireTempHeadingBox);
		lblFrontLeftTire.setToolTipText("");
		lblFrontLeftTire.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrontLeftTire.setForeground(Color.WHITE);
		lblFrontLeftTire.setFont(new Font("Calibri", Font.BOLD, 11));
		lblFrontLeftTire.setBounds(0, 3, 122, 22);
		pnlFrontLeftTireTempHeadingBox.add(lblFrontLeftTire);

		pnlRearLeftTemp = new JPanel();
		pnlRearLeftTemp.setBackground(Color.BLACK);
		pnlRearLeftTemp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlRearLeftTemp.setBounds(10, 524, 122, 124);
		pnlMain.add(pnlRearLeftTemp);
		pnlRearLeftTemp.setLayout(null);
		
		lblRearLeftTempData = new JLabel("888.8");
		lblRearLeftTempData.setHorizontalAlignment(SwingConstants.CENTER);
		lblRearLeftTempData.setForeground(Color.WHITE);
		lblRearLeftTempData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblRearLeftTempData.setBounds(0, 26, 122, 98);
		pnlRearLeftTemp.add(lblRearLeftTempData);
		
		pnlRearLeftTireTempHeadingBox = new JPanel();
		pnlRearLeftTireTempHeadingBox.setLayout(null);
		pnlRearLeftTireTempHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlRearLeftTireTempHeadingBox.setBackground(Color.BLACK);
		pnlRearLeftTireTempHeadingBox.setBounds(0, 0, 122, 27);
		pnlRearLeftTemp.add(pnlRearLeftTireTempHeadingBox);
		
		lblRearLeftTireTemp = new JLabel("REAR LEFT TIRE TEMP");
		lblRearLeftTireTemp.setLabelFor(pnlRearLeftTireTempHeadingBox);
		lblRearLeftTireTemp.setToolTipText("");
		lblRearLeftTireTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblRearLeftTireTemp.setForeground(Color.WHITE);
		lblRearLeftTireTemp.setFont(new Font("Calibri", Font.BOLD, 11));
		lblRearLeftTireTemp.setBounds(0, 3, 122, 22);
		pnlRearLeftTireTempHeadingBox.add(lblRearLeftTireTemp);

		pnlFrontRightTemp = new JPanel();
		pnlFrontRightTemp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlFrontRightTemp.setBackground(Color.BLACK);
		pnlFrontRightTemp.setBounds(130, 390, 124, 124);
		pnlMain.add(pnlFrontRightTemp);
		pnlFrontRightTemp.setLayout(null);
		
		lblFrontRightTempData = new JLabel("888.8");
		lblFrontRightTempData.setBounds(0, 26, 124, 98);
		lblFrontRightTempData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrontRightTempData.setForeground(Color.WHITE);
		lblFrontRightTempData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		pnlFrontRightTemp.add(lblFrontRightTempData);
		
		pnlFrontRightTireTempHeadingBox = new JPanel();
		pnlFrontRightTireTempHeadingBox.setLayout(null);
		pnlFrontRightTireTempHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlFrontRightTireTempHeadingBox.setBackground(Color.BLACK);
		pnlFrontRightTireTempHeadingBox.setBounds(0, 0, 124, 27);
		pnlFrontRightTemp.add(pnlFrontRightTireTempHeadingBox);
		
		lblFrontRightTire = new JLabel("FRONT RIGHT TIRE TEMP");
		lblFrontRightTire.setLabelFor(pnlFrontRightTireTempHeadingBox);
		lblFrontRightTire.setToolTipText("");
		lblFrontRightTire.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrontRightTire.setForeground(Color.WHITE);
		lblFrontRightTire.setFont(new Font("Calibri", Font.BOLD, 11));
		lblFrontRightTire.setBounds(0, 3, 124, 22);
		pnlFrontRightTireTempHeadingBox.add(lblFrontRightTire);
		
		pnlRearRightTemp = new JPanel();
		pnlRearRightTemp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlRearRightTemp.setBackground(Color.BLACK);
		pnlRearRightTemp.setBounds(130, 524, 124, 124);
		pnlMain.add(pnlRearRightTemp);
		pnlRearRightTemp.setLayout(null);
		
		lblRearRightTempData = new JLabel("888.8");
		lblRearRightTempData.setBounds(0, 26, 124, 98);
		lblRearRightTempData.setBackground(Color.BLACK);
		lblRearRightTempData.setForeground(Color.WHITE);
		lblRearRightTempData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblRearRightTempData.setLabelFor(pnlRearRightTemp);
		lblRearRightTempData.setHorizontalAlignment(SwingConstants.CENTER);
		pnlRearRightTemp.add(lblRearRightTempData);
		
		pnlRearRightTireTempHeadingBox = new JPanel();
		pnlRearRightTireTempHeadingBox.setBounds(0, 0, 124, 27);
		pnlRearRightTemp.add(pnlRearRightTireTempHeadingBox);
		pnlRearRightTireTempHeadingBox.setLayout(null);
		pnlRearRightTireTempHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlRearRightTireTempHeadingBox.setBackground(Color.BLACK);
		
		lblRearRightTireTemp = new JLabel("REAR RIGHT TIRE TEMP");
		lblRearRightTireTemp.setLabelFor(pnlRearRightTireTempHeadingBox);
		lblRearRightTireTemp.setToolTipText("");
		lblRearRightTireTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblRearRightTireTemp.setForeground(Color.WHITE);
		lblRearRightTireTemp.setFont(new Font("Calibri", Font.BOLD, 11));
		lblRearRightTireTemp.setBounds(0, 3, 124, 22);
		pnlRearRightTireTempHeadingBox.add(lblRearRightTireTemp);

		pnlFuelLapsRemaining = new JPanel();
		lblFuelPercantage.setLabelFor(pnlFuelLapsRemaining);
		pnlFuelLapsRemaining.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlFuelLapsRemaining.setBackground(Color.BLACK);
		pnlFuelLapsRemaining.setBounds(452, 524, 124, 124);
		pnlMain.add(pnlFuelLapsRemaining);
		pnlFuelLapsRemaining.setLayout(null);
		
		lblFuelLapsRemainingData = new JLabel("88.8");
		lblFuelLapsRemainingData.setBounds(0, 26, 121, 98);
		lblFuelLapsRemainingData.setLabelFor(pnlFuelLapsRemaining);
		pnlFuelLapsRemaining.add(lblFuelLapsRemainingData);
		lblFuelLapsRemainingData.setToolTipText("");
		lblFuelLapsRemainingData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelLapsRemainingData.setForeground(Color.WHITE);
		lblFuelLapsRemainingData.setFont(new Font("Tahoma", Font.PLAIN, 38));
		
		pnlFuelLapsRemainingHeadingBox = new JPanel();
		pnlFuelLapsRemainingHeadingBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlFuelLapsRemainingHeadingBox.setBackground(Color.BLACK);
		pnlFuelLapsRemainingHeadingBox.setBounds(0, 0, 121, 27);
		pnlFuelLapsRemaining.add(pnlFuelLapsRemainingHeadingBox);
		pnlFuelLapsRemainingHeadingBox.setLayout(null);
		
		lblFuelLapsRemanining = new JLabel("FUEL LAPS REMAINING");
		lblFuelLapsRemanining.setLabelFor(pnlFuelLapsRemainingHeadingBox);
		lblFuelLapsRemanining.setBounds(0, 3, 121, 22);
		pnlFuelLapsRemainingHeadingBox.add(lblFuelLapsRemanining);
		lblFuelLapsRemanining.setToolTipText("");
		lblFuelLapsRemanining.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelLapsRemanining.setForeground(Color.WHITE);
		lblFuelLapsRemanining.setFont(new Font("Calibri", Font.BOLD, 11));

		barRPM1 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM1.setBorderColor(Color.WHITE);
		barRPM1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM1.setBackground(new Color(240, 240, 240));
		barRPM1.setOpaque(false);
		barRPM1.setBounds(10, 11, 48, 98);
		barRPM1.setHorizontal(true);
		pnlMain.add(barRPM1);

		barRPM2 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM2.setBorderColor(Color.WHITE);
		barRPM2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM2.setBackground(new Color(240, 240, 240));
		barRPM2.setOpaque(false);
		barRPM2.setBounds(59, 11, 48, 98);
		barRPM2.setHorizontal(true);
		pnlMain.add(barRPM2);

		barRPM3 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM3.setBorderColor(Color.WHITE);
		barRPM3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM3.setBackground(new Color(240, 240, 240));
		barRPM3.setOpaque(false);
		barRPM3.setBounds(108, 11, 48, 98);
		barRPM3.setHorizontal(true);
		pnlMain.add(barRPM3);

		barRPM4 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM4.setBorderColor(Color.WHITE);
		barRPM4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM4.setBackground(new Color(240, 240, 240));
		barRPM4.setOpaque(false);
		barRPM4.setBounds(157, 11, 48, 98);
		barRPM4.setHorizontal(true);
		pnlMain.add(barRPM4);

		barRPM5 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM5.setBorderColor(Color.WHITE);
		barRPM5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM5.setBackground(new Color(240, 240, 240));
		barRPM5.setOpaque(false);
		barRPM5.setBounds(206, 11, 48, 98);
		barRPM5.setHorizontal(true);
		pnlMain.add(barRPM5);

		barRPM6 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM6.setBorderColor(Color.WHITE);
		barRPM6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM6.setBackground(new Color(240, 240, 240));
		barRPM6.setOpaque(false);
		barRPM6.setBounds(255, 11, 48, 98);
		barRPM6.setHorizontal(true);
		pnlMain.add(barRPM6);

		barRPM7 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM7.setBorderColor(Color.WHITE);
		barRPM7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM7.setBackground(new Color(240, 240, 240));
		barRPM7.setOpaque(false);
		barRPM7.setBounds(304, 11, 48, 98);
		barRPM7.setHorizontal(true);
		pnlMain.add(barRPM7);

		barRPM8 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM8.setBorderColor(Color.WHITE);
		barRPM8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM8.setBackground(new Color(240, 240, 240));
		barRPM8.setOpaque(false);
		barRPM8.setBounds(353, 11, 48, 98);
		barRPM8.setHorizontal(true);
		pnlMain.add(barRPM8);

		barRPM9 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM9.setBorderColor(Color.WHITE);
		barRPM9.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM9.setBackground(new Color(240, 240, 240));
		barRPM9.setOpaque(false);
		barRPM9.setBounds(402, 11, 48, 98);
		barRPM9.setHorizontal(true);
		pnlMain.add(barRPM9);

		barRPM10 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM10.setBorderColor(Color.WHITE);
		barRPM10.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM10.setBackground(new Color(240, 240, 240));
		barRPM10.setOpaque(false);
		barRPM10.setBounds(451, 11, 48, 98);
		barRPM10.setHorizontal(true);
		pnlMain.add(barRPM10);

		barRPM11 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM11.setBorderColor(Color.WHITE);
		barRPM11.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM11.setBackground(new Color(240, 240, 240));
		barRPM11.setOpaque(false);
		barRPM11.setBounds(500, 11, 48, 98);
		barRPM11.setHorizontal(true);
		pnlMain.add(barRPM11);

		barRPM12 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM12.setBorderColor(Color.WHITE);
		barRPM12.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM12.setBackground(new Color(240, 240, 240));
		barRPM12.setOpaque(false);
		barRPM12.setBounds(549, 11, 48, 98);
		barRPM12.setHorizontal(true);
		pnlMain.add(barRPM12);

		barRPM13 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM13.setBorderColor(Color.WHITE);
		barRPM13.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM13.setBackground(new Color(240, 240, 240));
		barRPM13.setOpaque(false);
		barRPM13.setBounds(598, 11, 48, 98);
		barRPM13.setHorizontal(true);
		pnlMain.add(barRPM13);

		barRPM14 = new BarChartSingle(0, 100, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barRPM14.setBorderColor(Color.WHITE);
		barRPM14.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		barRPM14.setBackground(new Color(240, 240, 240));
		barRPM14.setOpaque(false);
		barRPM14.setBounds(647, 11, 48, 98);
		barRPM14.setHorizontal(true);
		pnlMain.add(barRPM14);
		
		panel = new JPanel();
		panel.setBounds(277, 390, 153, 32);
		pnlMain.add(panel);
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		panel.setBackground(Color.BLACK);
		
		lblGearSelection = new JLabel("GEAR SELECTION");
		lblGearSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblGearSelection.setForeground(Color.WHITE);
		lblGearSelection.setFont(new Font("Calibri", Font.BOLD, 19));
		lblGearSelection.setBounds(0, 3, 153, 28);
		panel.add(lblGearSelection);

	}
    public void updateFields() {
    	super.updateFields();
    	getPlayersReadWriteLock().readLock().lock();
    	try {
        	DecimalFormat df1 = new DecimalFormat("0.0");
        	DecimalFormat df2 = new DecimalFormat("0.00");
        	
        	Player currPlayer = getSelectedPlayer();
    		if (currPlayer.getTelemetryPacket() != null) {
		    	this.lblCurrentLapData.setText(Calc.secondsToTime(currPlayer.getTelemetryPacket().getTrack().getCurrentLap()));
		    	this.lblBestLapData.setText(Calc.secondsToTime((currPlayer.getTelemetryPacket().getTrack().getBestLap())));
		    	this.lblLastLapDeltaData.setText(Calc.secondsToTime(currPlayer.getLastLapDelta()));
		    	this.lblRaceTimeData.setText(Calc.secondsToTime(currPlayer.getTelemetryPacket().getTrack().getCurrentRaceTime()));
		    	this.lblCurrentSpeedData.setText(df2.format(currPlayer.getTelemetryPacket().getVelocity().getSpeed(Speed.MPH)));
		    	this.lblFuelData.setText(df2.format(currPlayer.getTelemetryPacket().getEngine().getFuel() * 100));
		    	this.lblCurrentGearData.setText(Short.toString(currPlayer.getTelemetryPacket().getEngine().getGear()));
		    	this.lblFrontLeftTempData.setText(df1.format(currPlayer.getTelemetryPacket().getTyre().getTireTempFrontLeft()));
		    	this.lblRearLeftTempData.setText(df1.format(currPlayer.getTelemetryPacket().getTyre().getTireTempRearLeft()));
		    	this.lblFrontRightTempData.setText(df1.format(currPlayer.getTelemetryPacket().getTyre().getTireTempFrontRight()));
		    	this.lblRearRightTempData.setText(df1.format(currPlayer.getTelemetryPacket().getTyre().getTireTempRearRight()));
		    	this.lblFuelLapsRemainingData.setText(df1.format(currPlayer.getFuelLapsRemaining()));

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
