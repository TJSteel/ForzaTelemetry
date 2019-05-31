package ui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReadWriteLock;

import javax.swing.SwingConstants;
import charts.BarChartSingle;
import charts.LedRound;
import charts.LineChart;
import enums.Speed;
import forza.Player;
import utility.Calc;

class ValueBox extends JPanel{

	private static final long serialVersionUID = 1L;

	public static enum Layout {VALUE_BELOW, VALUE_RIGHT};
	private JLabel lblTitle;
	private JLabel lblValue;

	public ValueBox(String title, String value, int x, int y, int width, int height, int titleHeight, Layout layout) {
		int titleFontHeight = (int)(titleHeight * 0.35);
		int valueFontHeight = (int)((height - titleHeight) * 0.4);
		this.setBorder(DashboardUI.defaultBorder); 
		this.setBackground(DashboardUI.defaultBackgroundColor);
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		lblTitle = new JLabel(title.toUpperCase()); 
		lblTitle.setBounds(0, 0, width, titleHeight);
		lblTitle.setPreferredSize(new Dimension(width, titleHeight));
		lblTitle.setBorder(DashboardUI.defaultBorder);
		lblTitle.setForeground(DashboardUI.defaultFontColor);
		lblTitle.setBackground(DashboardUI.defaultBackgroundColor);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, titleFontHeight));
		this.add(lblTitle);
		
		lblValue = new JLabel(value); 
		lblValue.setBounds(0, lblTitle.getHeight()-1, width, this.getHeight()-lblTitle.getHeight()-1);
		lblValue.setPreferredSize(new Dimension(width, this.getHeight()-lblTitle.getHeight()-1));
		//lblValue.setBorder(DashboardUI.defaultBorder);
		lblValue.setForeground(DashboardUI.defaultFontColor);
		lblValue.setBackground(DashboardUI.defaultBackgroundColor);
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setVerticalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, valueFontHeight));
		this.add(lblValue);
		
	}
	
	public void setValue(String value) {
		lblValue.setText(value);
	}
}

public class DashboardUI extends DefaultUI {


	// {{ variables
	private static final long serialVersionUID = 1L;
	public static final Border defaultBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
	public static final Color defaultFontColor = Color.WHITE;
	public static final Color defaultBackgroundColor = Color.BLACK;

	private float redlineRPM = 7500.0f;
	private float redlineRange = 1500.0f;

	private ValueBox vbTyreTempFrontLeft;
	private ValueBox vbTyreTempFrontRight;
	private ValueBox vbTyreTempRearLeft;
	private ValueBox vbTyreTempRearRight;
	private ValueBox vbCurrentGear;
	private ValueBox vbCurrentSpeed;
	private ValueBox vbFuelLapsRemaining;
	private ValueBox vbFuel;
	private ValueBox vbCurrentLap;
	private ValueBox vbLastLapDelta;
	private ValueBox vbBestLap;
	private ValueBox vbRaceTime;	
	
	private LineChart lineTrackMap;

	private LedRound ledRPM[];
	
	private JPanel pnlMain;

	private BarChartSingle barSteer;
	private BarChartSingle barAccel;
	private BarChartSingle barBrake;
	private BarChartSingle barClutch;
	private BarChartSingle barHandbrake;
	private JLabel lblSteer;
	private JLabel lblAccel;
	private JLabel lblBrake;
	private JLabel lblClutch;
	private JLabel lblHandbrake;

	
	private JPanel pnlGearChangesPerLap;
	private JLabel lblAverageGearChanges;
	private JPanel pnlThrottlePercentagePerLap;
	private JLabel lblThrottlePercentPer;
	private JPanel pnlBrakePercentagePerLap;
	private JLabel lblBrakePer;
	private JPanel pnlFuelUsagePerLap;
	private JLabel lblFuelUsagePer;
	private JPanel pnlClutchPercentagePerLap;
	private JLabel lblClutchPer;
	private JPanel pnlLiveTimingGrid;
	private JPanel pnlTrackNameReadout;
	private JLabel lblCicuitDeCatalunya;
	private JPanel pnlLapDistanceReadout;
	private JLabel lblNa;
	private JPanel pnlTotalTurnsReadout;
	private JPanel pnlCurrentTurnNumberReadout;
	private JPanel pnlCurrentTurnNameReadout;
	private JPanel panel_12;
	private JPanel pnlGearChangesPerLapReadout;
	private JPanel pnlThrottlePercentagePerLapReadout;
	private JPanel pnlBrakePercentagePerLapReadout;
	private JPanel pnlFuelUsagePerLapReadout;
	private JPanel pnlClutchPecentagePerLapReadout;
	private JLabel lblNa_8;
	private JPanel pnlSector2Heading;
	private JLabel label;
	private JPanel pnlSector1Heading;
	private JPanel pnlSector3Heading;
	private JPanel pnlLapTimeHeading;
	private JLabel lblSector;
	private JLabel lblSector_1;
	private JLabel lblTime;
	private JPanel pnlLap1;
	private JLabel lblNa_9;
	private JPanel pnlLap2;
	private JLabel lblNa_10;
	private JPanel pnlLap3;
	private JLabel lblNa_11;
	private JPanel pnlLap4;
	private JLabel lblNa_12;
	private JPanel pnlLap5;
	private JLabel lblNa_13;
	private JPanel pnlLap6;
	private JLabel lblNa_14;
	private JPanel pnlLap1Sector1Time;
	private JLabel label_10;
	private JPanel pnlLap2Sector1Time;
	private JLabel label_11;
	private JPanel pnlLap3Sector1Time;
	private JLabel label_12;
	private JPanel pnlLap4Sector1Time;
	private JLabel label_13;
	private JPanel pnlLap5Sector1Time;
	private JLabel label_14;
	private JPanel pnlLap6Sector1Time;
	private JLabel label_15;
	private JPanel pnlLap1Sector2Time;
	private JLabel label_16;
	private JPanel pnlLap2Sector2Time;
	private JLabel label_17;
	private JPanel pnlLap3Sector2Time;
	private JLabel label_18;
	private JPanel pnlLap4Sector2Time;
	private JLabel label_19;
	private JPanel pnlLap5Sector2Time;
	private JLabel label_20;
	private JPanel pnlLap6Sector2Time;
	private JLabel label_21;
	private JPanel pnlLap1Sector3Time;
	private JLabel label_22;
	private JPanel pnlLap2Sector3Time;
	private JLabel label_23;
	private JPanel pnlLap3Sector3Time;
	private JLabel label_24;
	private JPanel pnlLap4Sector3Time;
	private JLabel label_25;
	private JPanel pnlLap5Sector3Time;
	private JLabel label_26;
	private JPanel pnlLa6Sector3Time;
	private JLabel label_27;
	private JPanel pnlLap1FinishTime;
	private JLabel label_28;
	private JPanel pnlLap2FinishTime;
	private JLabel label_29;
	private JPanel pnlLap3FinishTime;
	private JLabel label_30;
	private JPanel pnlLap4FinishTime;
	private JLabel label_31;
	private JPanel pnlLap5FinishTime;
	private JLabel label_32;
	private JPanel pnlLap6FinishTime;
	private JLabel label_33;
	private JPanel pnlDriverInput;
	private JPanel pnlLap7;
	private JLabel label_1;
	private JPanel pnlLap7Sector1Time;
	private JLabel label_3;
	private JPanel pnlLap7Sector2Time;
	private JLabel label_4;
	private JPanel pnlLap7Sector3Time;
	private JLabel label_5;
	private JPanel pnlLap7FinishTime;
	private JLabel label_6;
	private JPanel pnlHandbrakePercenatgePerLap;
	private JLabel lblHandbrakePer;
	private JPanel pnlHandbrakePercenatgePerLapReadout;
	private JLabel label_7;
	JLabel lblDriverInputs;
	JPanel panel_65;
	JLabel lblLap;
	JPanel pnlLapHeading;
	JPanel pnlLiveTimingHeading;
	JLabel lblLiveTiming;
	JLabel lblNa_2;
	JLabel lblWeatherConditions;
	JPanel pnlWeatherCondition;
	JPanel pnlRaceInformation;
	JPanel pnlRaceInformationHeading;
	JPanel pnlTrackName;
	JPanel pnlCurrentTurnName;
	JPanel pnlTotalTurns;
	JPanel pnlCurrentTurnNumber;
	JPanel pnlCurrentTurnName_1;
	
	JLabel lblTrack;
	JLabel lblCurrentTurn;
	JLabel lblTotalTurns;
	JLabel lblCurrentTurnNumber;
	JLabel lblLapLength;
	JLabel lblNa_1;
	JLabel lblNa_15;
	JLabel lblNa_3;
	JLabel lblNa_4;
	JLabel lblNa_5;
	JLabel lblNa_6;
	JLabel lblNa_7;
	JLabel lblKm;
	JLabel raceinfo_lbl;
	
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
		
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		contentPane.setForeground(defaultBackgroundColor);
		contentPane.setBackground(defaultBackgroundColor);
		
		pnlRaceInformation = new JPanel();
		pnlRaceInformation.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		pnlRaceInformation.setBackground(defaultBackgroundColor);
		pnlRaceInformation.setBounds(0, 45, 272, 404);
		contentPane.add(pnlRaceInformation);
		pnlRaceInformation.setLayout(null);
		
		pnlRaceInformationHeading = new JPanel();
		pnlRaceInformationHeading.setLayout(null);
		pnlRaceInformationHeading.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		pnlRaceInformationHeading.setBackground(defaultBackgroundColor);
		pnlRaceInformationHeading.setBounds(0, 0, 272, 32);
		pnlRaceInformation.add(pnlRaceInformationHeading);
		
		raceinfo_lbl = new JLabel("RACE INFORMATION");
		raceinfo_lbl.setBounds(0, 1, 272, 32);
		pnlRaceInformationHeading.add(raceinfo_lbl);
		raceinfo_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		raceinfo_lbl.setForeground(Color.WHITE);
		raceinfo_lbl.setFont(new Font("Calibri", Font.BOLD, 19));
		
		pnlTrackName = new JPanel();
		pnlTrackName.setLayout(null);
		pnlTrackName.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlTrackName.setBackground(defaultBackgroundColor);
		pnlTrackName.setBounds(0, 31, 129, 32);
		pnlRaceInformation.add(pnlTrackName);
		
		lblTrack = new JLabel("    TRACK NAME");
		lblTrack.setBounds(0, 0, 129, 32);
		pnlTrackName.add(lblTrack);
		lblTrack.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrack.setForeground(Color.WHITE);
		lblTrack.setFont(new Font("Calibri", Font.BOLD, 11));
		
		pnlCurrentTurnName = new JPanel();
		pnlCurrentTurnName.setLayout(null);
		pnlCurrentTurnName.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlCurrentTurnName.setBackground(defaultBackgroundColor);
		pnlCurrentTurnName.setBounds(0, 93, 129, 32);
		pnlRaceInformation.add(pnlCurrentTurnName);
		
		lblCurrentTurn = new JLabel("    LAP DISTANCE");
		lblCurrentTurn.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentTurn.setForeground(Color.WHITE);
		lblCurrentTurn.setFont(new Font("Calibri", Font.BOLD, 11));
		lblCurrentTurn.setBounds(0, 0, 129, 32);
		pnlCurrentTurnName.add(lblCurrentTurn);
		
		pnlTotalTurns = new JPanel();
		pnlTotalTurns.setLayout(null);
		pnlTotalTurns.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlTotalTurns.setBackground(defaultBackgroundColor);
		pnlTotalTurns.setBounds(0, 124, 129, 32);
		pnlRaceInformation.add(pnlTotalTurns);
		
		lblTotalTurns = new JLabel("    TOTAL TURNS");
		lblTotalTurns.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalTurns.setForeground(Color.WHITE);
		lblTotalTurns.setFont(new Font("Calibri", Font.BOLD, 11));
		lblTotalTurns.setBounds(0, 0, 129, 32);
		pnlTotalTurns.add(lblTotalTurns);
		
		pnlCurrentTurnNumber = new JPanel();
		pnlCurrentTurnNumber.setLayout(null);
		pnlCurrentTurnNumber.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlCurrentTurnNumber.setBackground(defaultBackgroundColor);
		pnlCurrentTurnNumber.setBounds(0, 155, 129, 32);
		pnlRaceInformation.add(pnlCurrentTurnNumber);
		
		lblCurrentTurnNumber = new JLabel("    CURRENT TURN NUMBER");
		lblCurrentTurnNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentTurnNumber.setForeground(Color.WHITE);
		lblCurrentTurnNumber.setFont(new Font("Calibri", Font.BOLD, 11));
		lblCurrentTurnNumber.setBounds(0, 0, 125, 32);
		pnlCurrentTurnNumber.add(lblCurrentTurnNumber);
		
		pnlCurrentTurnName_1 = new JPanel();
		pnlCurrentTurnName_1.setLayout(null);
		pnlCurrentTurnName_1.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlCurrentTurnName_1.setBackground(defaultBackgroundColor);
		pnlCurrentTurnName_1.setBounds(0, 186, 129, 32);
		pnlRaceInformation.add(pnlCurrentTurnName_1);
		
		lblLapLength = new JLabel("    CURRENT TURN NAME");
		lblLapLength.setHorizontalAlignment(SwingConstants.LEFT);
		lblLapLength.setForeground(Color.WHITE);
		lblLapLength.setFont(new Font("Calibri", Font.BOLD, 11));
		lblLapLength.setBounds(0, 0, 129, 32);
		pnlCurrentTurnName_1.add(lblLapLength);
		
		pnlThrottlePercentagePerLap = new JPanel();
		pnlThrottlePercentagePerLap.setLayout(null);
		pnlThrottlePercentagePerLap.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlThrottlePercentagePerLap.setBackground(defaultBackgroundColor);
		pnlThrottlePercentagePerLap.setBounds(0, 248, 129, 32);
		pnlRaceInformation.add(pnlThrottlePercentagePerLap);
		
		pnlGearChangesPerLap = new JPanel();
		pnlGearChangesPerLap.setBounds(0, 0, 129, 32);
		pnlThrottlePercentagePerLap.add(pnlGearChangesPerLap);
		pnlGearChangesPerLap.setLayout(null);
		pnlGearChangesPerLap.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlGearChangesPerLap.setBackground(defaultBackgroundColor);
		
		lblAverageGearChanges = new JLabel("    GEAR CHANGES PER LAP");
		lblAverageGearChanges.setHorizontalAlignment(SwingConstants.LEFT);
		lblAverageGearChanges.setForeground(Color.WHITE);
		lblAverageGearChanges.setFont(new Font("Calibri", Font.BOLD, 11));
		lblAverageGearChanges.setBounds(0, 0, 129, 32);
		pnlGearChangesPerLap.add(lblAverageGearChanges);
		
		pnlBrakePercentagePerLap = new JPanel();
		pnlBrakePercentagePerLap.setLayout(null);
		pnlBrakePercentagePerLap.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlBrakePercentagePerLap.setBackground(defaultBackgroundColor);
		pnlBrakePercentagePerLap.setBounds(0, 279, 129, 32);
		pnlRaceInformation.add(pnlBrakePercentagePerLap);
		
		lblThrottlePercentPer = new JLabel("    THROTTLE % PER LAP");
		lblThrottlePercentPer.setBounds(0, 0, 129, 32);
		pnlBrakePercentagePerLap.add(lblThrottlePercentPer);
		lblThrottlePercentPer.setHorizontalAlignment(SwingConstants.LEFT);
		lblThrottlePercentPer.setForeground(Color.WHITE);
		lblThrottlePercentPer.setFont(new Font("Calibri", Font.BOLD, 11));
		
		pnlFuelUsagePerLap = new JPanel();
		pnlFuelUsagePerLap.setLayout(null);
		pnlFuelUsagePerLap.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlFuelUsagePerLap.setBackground(defaultBackgroundColor);
		pnlFuelUsagePerLap.setBounds(0, 217, 129, 32);
		pnlRaceInformation.add(pnlFuelUsagePerLap);
		
		lblFuelUsagePer = new JLabel("    FUEL USAGE PER LAP");
		lblFuelUsagePer.setHorizontalAlignment(SwingConstants.LEFT);
		lblFuelUsagePer.setForeground(Color.WHITE);
		lblFuelUsagePer.setFont(new Font("Calibri", Font.BOLD, 11));
		lblFuelUsagePer.setBounds(0, 0, 129, 32);
		pnlFuelUsagePerLap.add(lblFuelUsagePer);
		
		pnlClutchPercentagePerLap = new JPanel();
		pnlClutchPercentagePerLap.setLayout(null);
		pnlClutchPercentagePerLap.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlClutchPercentagePerLap.setBackground(defaultBackgroundColor);
		pnlClutchPercentagePerLap.setBounds(0, 341, 129, 32);
		pnlRaceInformation.add(pnlClutchPercentagePerLap);
		
		lblClutchPer = new JLabel("    CLUTCH % PER LAP");
		lblClutchPer.setHorizontalAlignment(SwingConstants.LEFT);
		lblClutchPer.setForeground(Color.WHITE);
		lblClutchPer.setFont(new Font("Calibri", Font.BOLD, 11));
		lblClutchPer.setBounds(0, 0, 129, 32);
		pnlClutchPercentagePerLap.add(lblClutchPer);
		
		pnlTrackNameReadout = new JPanel();
		pnlTrackNameReadout.setLayout(null);
		pnlTrackNameReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlTrackNameReadout.setBackground(defaultBackgroundColor);
		pnlTrackNameReadout.setBounds(128, 31, 144, 32);
		pnlRaceInformation.add(pnlTrackNameReadout);
		
		lblCicuitDeCatalunya = new JLabel("Road Atlanta Club");
		lblCicuitDeCatalunya.setHorizontalAlignment(SwingConstants.CENTER);
		lblCicuitDeCatalunya.setForeground(Color.WHITE);
		lblCicuitDeCatalunya.setFont(new Font("Calibri", Font.BOLD, 11));
		lblCicuitDeCatalunya.setBounds(0, 0, 144, 32);
		pnlTrackNameReadout.add(lblCicuitDeCatalunya);
		
		pnlLapDistanceReadout = new JPanel();
		pnlLapDistanceReadout.setLayout(null);
		pnlLapDistanceReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlLapDistanceReadout.setBackground(defaultBackgroundColor);
		pnlLapDistanceReadout.setBounds(128, 93, 144, 32);
		pnlRaceInformation.add(pnlLapDistanceReadout);
		
		lblNa_8 = new JLabel("2849 Meters");
		lblNa_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_8.setForeground(Color.WHITE);
		lblNa_8.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_8.setBounds(0, 0, 144, 32);
		pnlLapDistanceReadout.add(lblNa_8);
		
		lblNa = new JLabel("N/A");
		pnlRaceInformation.add(lblNa);
		lblNa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa.setForeground(Color.WHITE);
		lblNa.setFont(new Font("Calibri", Font.BOLD, 11));
		
		pnlTotalTurnsReadout = new JPanel();
		pnlTotalTurnsReadout.setLayout(null);
		pnlTotalTurnsReadout.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlTotalTurnsReadout.setBackground(defaultBackgroundColor);
		pnlTotalTurnsReadout.setBounds(128, 124, 144, 32);
		pnlRaceInformation.add(pnlTotalTurnsReadout);
		
		lblNa_15 = new JLabel("N/A");
		lblNa_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_15.setForeground(Color.WHITE);
		lblNa_15.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_15.setBounds(0, 0, 144, 32);
		pnlTotalTurnsReadout.add(lblNa_15);
		
		pnlCurrentTurnNumberReadout = new JPanel();
		pnlCurrentTurnNumberReadout.setLayout(null);
		pnlCurrentTurnNumberReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlCurrentTurnNumberReadout.setBackground(defaultBackgroundColor);
		pnlCurrentTurnNumberReadout.setBounds(128, 155, 144, 32);
		pnlRaceInformation.add(pnlCurrentTurnNumberReadout);
		
		lblNa_1 = new JLabel("N/A");
		lblNa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_1.setForeground(Color.WHITE);
		lblNa_1.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_1.setBounds(0, 0, 144, 32);
		pnlCurrentTurnNumberReadout.add(lblNa_1);
		
		pnlCurrentTurnNameReadout = new JPanel();
		pnlCurrentTurnNameReadout.setLayout(null);
		pnlCurrentTurnNameReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlCurrentTurnNameReadout.setBackground(defaultBackgroundColor);
		pnlCurrentTurnNameReadout.setBounds(128, 186, 144, 32);
		pnlRaceInformation.add(pnlCurrentTurnNameReadout);
		
		lblKm = new JLabel("N/A");
		lblKm.setHorizontalAlignment(SwingConstants.CENTER);
		lblKm.setForeground(Color.WHITE);
		lblKm.setFont(new Font("Calibri", Font.BOLD, 11));
		lblKm.setBounds(0, 0, 144, 32);
		pnlCurrentTurnNameReadout.add(lblKm);
		
		pnlGearChangesPerLapReadout = new JPanel();
		pnlGearChangesPerLapReadout.setLayout(null);
		pnlGearChangesPerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlGearChangesPerLapReadout.setBackground(defaultBackgroundColor);
		pnlGearChangesPerLapReadout.setBounds(128, 217, 144, 32);
		pnlRaceInformation.add(pnlGearChangesPerLapReadout);
		
		lblNa_3 = new JLabel("N/A");
		lblNa_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_3.setForeground(Color.WHITE);
		lblNa_3.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_3.setBounds(0, 0, 144, 32);
		pnlGearChangesPerLapReadout.add(lblNa_3);
		
		pnlThrottlePercentagePerLapReadout = new JPanel();
		pnlThrottlePercentagePerLapReadout.setLayout(null);
		pnlThrottlePercentagePerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlThrottlePercentagePerLapReadout.setBackground(defaultBackgroundColor);
		pnlThrottlePercentagePerLapReadout.setBounds(128, 248, 144, 32);
		pnlRaceInformation.add(pnlThrottlePercentagePerLapReadout);
		
		lblNa_4 = new JLabel("N/A");
		lblNa_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_4.setForeground(Color.WHITE);
		lblNa_4.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_4.setBounds(0, 0, 144, 32);
		pnlThrottlePercentagePerLapReadout.add(lblNa_4);
		
		pnlBrakePercentagePerLapReadout = new JPanel();
		pnlBrakePercentagePerLapReadout.setLayout(null);
		pnlBrakePercentagePerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlBrakePercentagePerLapReadout.setBackground(defaultBackgroundColor);
		pnlBrakePercentagePerLapReadout.setBounds(128, 279, 144, 32);
		pnlRaceInformation.add(pnlBrakePercentagePerLapReadout);
		
		lblNa_5 = new JLabel("N/A");
		lblNa_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_5.setForeground(Color.WHITE);
		lblNa_5.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_5.setBounds(0, 0, 144, 32);
		pnlBrakePercentagePerLapReadout.add(lblNa_5);
		
		pnlFuelUsagePerLapReadout = new JPanel();
		pnlFuelUsagePerLapReadout.setLayout(null);
		pnlFuelUsagePerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlFuelUsagePerLapReadout.setBackground(defaultBackgroundColor);
		pnlFuelUsagePerLapReadout.setBounds(128, 310, 144, 32);
		pnlRaceInformation.add(pnlFuelUsagePerLapReadout);
		
		lblNa_6 = new JLabel("N/A");
		lblNa_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_6.setForeground(Color.WHITE);
		lblNa_6.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_6.setBounds(0, 0, 144, 32);
		pnlFuelUsagePerLapReadout.add(lblNa_6);
		
		pnlClutchPecentagePerLapReadout = new JPanel();
		pnlClutchPecentagePerLapReadout.setLayout(null);
		pnlClutchPecentagePerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(255, 255, 255)));
		pnlClutchPecentagePerLapReadout.setBackground(defaultBackgroundColor);
		pnlClutchPecentagePerLapReadout.setBounds(128, 341, 144, 32);
		pnlRaceInformation.add(pnlClutchPecentagePerLapReadout);
		
		lblNa_7 = new JLabel("N/A");
		lblNa_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_7.setForeground(Color.WHITE);
		lblNa_7.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_7.setBounds(0, 0, 144, 32);
		pnlClutchPecentagePerLapReadout.add(lblNa_7);
		
		pnlWeatherCondition = new JPanel();
		pnlWeatherCondition.setBounds(0, 62, 129, 32);
		pnlRaceInformation.add(pnlWeatherCondition);
		pnlWeatherCondition.setLayout(null);
		pnlWeatherCondition.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlWeatherCondition.setBackground(defaultBackgroundColor);

		lblWeatherConditions = new JLabel("    WEATHER CONDITION");
		lblWeatherConditions.setBounds(0, 0, 129, 32);
		pnlWeatherCondition.add(lblWeatherConditions);
		lblWeatherConditions.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeatherConditions.setForeground(Color.WHITE);
		lblWeatherConditions.setFont(new Font("Calibri", Font.BOLD, 11));
		
		panel_12 = new JPanel();
		panel_12.setBounds(128, 62, 144, 32);
		pnlRaceInformation.add(panel_12);
		panel_12.setLayout(null);
		panel_12.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		panel_12.setBackground(defaultBackgroundColor);
		
		lblNa_2 = new JLabel("N/A");
		lblNa_2.setBounds(0, 0, 144, 32);
		panel_12.add(lblNa_2);
		lblNa_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_2.setForeground(Color.WHITE);
		lblNa_2.setFont(new Font("Calibri", Font.BOLD, 11));
		
		lblBrakePer = new JLabel("    BRAKE % PER LAP");
		lblBrakePer.setBounds(0, 310, 129, 32);
		pnlRaceInformation.add(lblBrakePer);
		lblBrakePer.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrakePer.setForeground(Color.WHITE);
		lblBrakePer.setFont(new Font("Calibri", Font.BOLD, 11));
		
		pnlHandbrakePercenatgePerLap = new JPanel();
		pnlHandbrakePercenatgePerLap.setLayout(null);
		pnlHandbrakePercenatgePerLap.setBorder(new MatteBorder(1, 2, 2, 1, (Color) new Color(255, 255, 255)));
		pnlHandbrakePercenatgePerLap.setBackground(defaultBackgroundColor);
		pnlHandbrakePercenatgePerLap.setBounds(0, 372, 129, 32);
		pnlRaceInformation.add(pnlHandbrakePercenatgePerLap);
		
		lblHandbrakePer = new JLabel("    HANDBRAKE % PER LAP");
		lblHandbrakePer.setHorizontalAlignment(SwingConstants.LEFT);
		lblHandbrakePer.setForeground(Color.WHITE);
		lblHandbrakePer.setFont(new Font("Calibri", Font.BOLD, 11));
		lblHandbrakePer.setBounds(0, 0, 129, 32);
		pnlHandbrakePercenatgePerLap.add(lblHandbrakePer);
		
		pnlHandbrakePercenatgePerLapReadout = new JPanel();
		pnlHandbrakePercenatgePerLapReadout.setLayout(null);
		pnlHandbrakePercenatgePerLapReadout.setBorder(new MatteBorder(1, 1, 2, 2, (Color) new Color(255, 255, 255)));
		pnlHandbrakePercenatgePerLapReadout.setBackground(defaultBackgroundColor);
		pnlHandbrakePercenatgePerLapReadout.setBounds(128, 372, 144, 32);
		pnlRaceInformation.add(pnlHandbrakePercenatgePerLapReadout);
		
		label_7 = new JLabel("N/A");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Calibri", Font.BOLD, 11));
		label_7.setBounds(0, 0, 144, 32);
		pnlHandbrakePercenatgePerLapReadout.add(label_7);
		
		pnlLiveTimingGrid = new JPanel();
		pnlLiveTimingGrid.setForeground(Color.BLACK);
		pnlLiveTimingGrid.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlLiveTimingGrid.setBackground(defaultBackgroundColor);
		pnlLiveTimingGrid.setBounds(993, 45, 271, 249);
		contentPane.add(pnlLiveTimingGrid);
		pnlLiveTimingGrid.setLayout(null);
		
		lblLiveTiming = new JLabel("LIVE TIMING");
		lblLiveTiming.setBounds(0, 1, 271, 32);
		pnlLiveTimingGrid.add(lblLiveTiming);
		lblLiveTiming.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveTiming.setForeground(Color.WHITE);
		lblLiveTiming.setFont(new Font("Calibri", Font.BOLD, 19));
		
		pnlLiveTimingHeading = new JPanel();
		pnlLiveTimingHeading.setBounds(0, 0, 271, 32);
		pnlLiveTimingGrid.add(pnlLiveTimingHeading);
		pnlLiveTimingHeading.setLayout(null);
		pnlLiveTimingHeading.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		pnlLiveTimingHeading.setBackground(defaultBackgroundColor);
		
		pnlLapHeading = new JPanel();
		pnlLapHeading.setLayout(null);
		pnlLapHeading.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLapHeading.setBackground(defaultBackgroundColor);
		pnlLapHeading.setBounds(0, 31, 36, 32);
		pnlLiveTimingGrid.add(pnlLapHeading);
		
		lblLap = new JLabel("LAP");
		lblLap.setHorizontalAlignment(SwingConstants.CENTER);
		lblLap.setForeground(Color.WHITE);
		lblLap.setFont(new Font("Calibri", Font.BOLD, 11));
		lblLap.setBounds(0, 0, 36, 32);
		pnlLapHeading.add(lblLap);
		
		pnlSector2Heading = new JPanel();
		pnlSector2Heading.setLayout(null);
		pnlSector2Heading.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlSector2Heading.setBackground(defaultBackgroundColor);
		pnlSector2Heading.setBounds(94, 31, 60, 32);
		pnlLiveTimingGrid.add(pnlSector2Heading);
		
		lblSector = new JLabel("SECTOR 2");
		lblSector.setHorizontalAlignment(SwingConstants.CENTER);
		lblSector.setForeground(Color.WHITE);
		lblSector.setFont(new Font("Calibri", Font.BOLD, 11));
		lblSector.setBounds(0, 0, 60, 32);
		pnlSector2Heading.add(lblSector);
		
		pnlSector1Heading = new JPanel();
		pnlSector1Heading.setLayout(null);
		pnlSector1Heading.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlSector1Heading.setBackground(defaultBackgroundColor);
		pnlSector1Heading.setBounds(35, 31, 60, 32);
		pnlLiveTimingGrid.add(pnlSector1Heading);
		
		label = new JLabel("SECTOR 1");
		label.setBounds(0, 0, 60, 32);
		pnlSector1Heading.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Calibri", Font.BOLD, 11));
		
		pnlSector3Heading = new JPanel();
		pnlSector3Heading.setLayout(null);
		pnlSector3Heading.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlSector3Heading.setBackground(defaultBackgroundColor);
		pnlSector3Heading.setBounds(153, 31, 60, 32);
		pnlLiveTimingGrid.add(pnlSector3Heading);
		
		lblSector_1 = new JLabel("SECTOR 3");
		lblSector_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSector_1.setForeground(Color.WHITE);
		lblSector_1.setFont(new Font("Calibri", Font.BOLD, 11));
		lblSector_1.setBounds(0, 0, 60, 32);
		pnlSector3Heading.add(lblSector_1);
		
		pnlLapTimeHeading = new JPanel();
		pnlLapTimeHeading.setLayout(null);
		pnlLapTimeHeading.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(255, 255, 255)));
		pnlLapTimeHeading.setBackground(defaultBackgroundColor);
		pnlLapTimeHeading.setBounds(211, 31, 60, 32);
		pnlLiveTimingGrid.add(pnlLapTimeHeading);
		
		lblTime = new JLabel("LAP TIME");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Calibri", Font.BOLD, 11));
		lblTime.setBounds(0, 0, 60, 32);
		pnlLapTimeHeading.add(lblTime);
		
		pnlLap1 = new JPanel();
		pnlLap1.setLayout(null);
		pnlLap1.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLap1.setBackground(defaultBackgroundColor);
		pnlLap1.setBounds(0, 62, 36, 32);
		pnlLiveTimingGrid.add(pnlLap1);
		
		lblNa_9 = new JLabel("N/A");
		lblNa_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_9.setForeground(Color.WHITE);
		lblNa_9.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_9.setBounds(0, 0, 36, 32);
		pnlLap1.add(lblNa_9);
		
		pnlLap2 = new JPanel();
		pnlLap2.setLayout(null);
		pnlLap2.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLap2.setBackground(defaultBackgroundColor);
		pnlLap2.setBounds(0, 93, 36, 32);
		pnlLiveTimingGrid.add(pnlLap2);
		
		lblNa_10 = new JLabel("N/A");
		lblNa_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_10.setForeground(Color.WHITE);
		lblNa_10.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_10.setBounds(0, 0, 36, 32);
		pnlLap2.add(lblNa_10);
		
		pnlLap3 = new JPanel();
		pnlLap3.setLayout(null);
		pnlLap3.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLap3.setBackground(defaultBackgroundColor);
		pnlLap3.setBounds(0, 124, 36, 32);
		pnlLiveTimingGrid.add(pnlLap3);
		
		lblNa_11 = new JLabel("N/A");
		lblNa_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_11.setForeground(Color.WHITE);
		lblNa_11.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_11.setBounds(0, 0, 36, 32);
		pnlLap3.add(lblNa_11);
		
		pnlLap4 = new JPanel();
		pnlLap4.setLayout(null);
		pnlLap4.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLap4.setBackground(defaultBackgroundColor);
		pnlLap4.setBounds(0, 155, 36, 32);
		pnlLiveTimingGrid.add(pnlLap4);
		
		lblNa_12 = new JLabel("N/A");
		lblNa_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_12.setForeground(Color.WHITE);
		lblNa_12.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_12.setBounds(0, 0, 36, 32);
		pnlLap4.add(lblNa_12);
		
		pnlLap5 = new JPanel();
		pnlLap5.setLayout(null);
		pnlLap5.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLap5.setBackground(defaultBackgroundColor);
		pnlLap5.setBounds(0, 186, 36, 32);
		pnlLiveTimingGrid.add(pnlLap5);
		
		lblNa_13 = new JLabel("N/A");
		lblNa_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_13.setForeground(Color.WHITE);
		lblNa_13.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_13.setBounds(0, 0, 36, 32);
		pnlLap5.add(lblNa_13);
		
		pnlLap6 = new JPanel();
		pnlLap6.setLayout(null);
		pnlLap6.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLap6.setBackground(defaultBackgroundColor);
		pnlLap6.setBounds(0, 217, 36, 32);
		pnlLiveTimingGrid.add(pnlLap6);
		
		lblNa_14 = new JLabel("N/A");
		lblNa_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_14.setForeground(Color.WHITE);
		lblNa_14.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_14.setBounds(0, 0, 36, 32);
		pnlLap6.add(lblNa_14);
		
		pnlLap1Sector1Time = new JPanel();
		pnlLap1Sector1Time.setLayout(null);
		pnlLap1Sector1Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap1Sector1Time.setBackground(defaultBackgroundColor);
		pnlLap1Sector1Time.setBounds(35, 62, 60, 32);
		pnlLiveTimingGrid.add(pnlLap1Sector1Time);
		
		label_10 = new JLabel("00:00.00");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Calibri", Font.BOLD, 11));
		label_10.setBounds(0, 0, 60, 32);
		pnlLap1Sector1Time.add(label_10);
		
		pnlLap2Sector1Time = new JPanel();
		pnlLap2Sector1Time.setLayout(null);
		pnlLap2Sector1Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap2Sector1Time.setBackground(defaultBackgroundColor);
		pnlLap2Sector1Time.setBounds(35, 93, 60, 32);
		pnlLiveTimingGrid.add(pnlLap2Sector1Time);
		
		label_11 = new JLabel("00:00.00");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Calibri", Font.BOLD, 11));
		label_11.setBounds(0, 0, 60, 32);
		pnlLap2Sector1Time.add(label_11);
		
		pnlLap3Sector1Time = new JPanel();
		pnlLap3Sector1Time.setLayout(null);
		pnlLap3Sector1Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap3Sector1Time.setBackground(defaultBackgroundColor);
		pnlLap3Sector1Time.setBounds(35, 124, 60, 32);
		pnlLiveTimingGrid.add(pnlLap3Sector1Time);
		
		label_12 = new JLabel("00:00.00");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Calibri", Font.BOLD, 11));
		label_12.setBounds(0, 0, 60, 32);
		pnlLap3Sector1Time.add(label_12);
		
		pnlLap4Sector1Time = new JPanel();
		pnlLap4Sector1Time.setLayout(null);
		pnlLap4Sector1Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap4Sector1Time.setBackground(defaultBackgroundColor);
		pnlLap4Sector1Time.setBounds(35, 155, 60, 32);
		pnlLiveTimingGrid.add(pnlLap4Sector1Time);
		
		label_13 = new JLabel("00:00.00");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Calibri", Font.BOLD, 11));
		label_13.setBounds(0, 0, 60, 32);
		pnlLap4Sector1Time.add(label_13);
		
		pnlLap5Sector1Time = new JPanel();
		pnlLap5Sector1Time.setLayout(null);
		pnlLap5Sector1Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap5Sector1Time.setBackground(defaultBackgroundColor);
		pnlLap5Sector1Time.setBounds(35, 186, 60, 32);
		pnlLiveTimingGrid.add(pnlLap5Sector1Time);
		
		label_14 = new JLabel("00:00.00");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Calibri", Font.BOLD, 11));
		label_14.setBounds(0, 0, 60, 32);
		pnlLap5Sector1Time.add(label_14);
		
		pnlLap6Sector1Time = new JPanel();
		pnlLap6Sector1Time.setLayout(null);
		pnlLap6Sector1Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap6Sector1Time.setBackground(defaultBackgroundColor);
		pnlLap6Sector1Time.setBounds(35, 217, 60, 32);
		pnlLiveTimingGrid.add(pnlLap6Sector1Time);
		
		label_15 = new JLabel("00:00.00");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Calibri", Font.BOLD, 11));
		label_15.setBounds(0, 0, 60, 32);
		pnlLap6Sector1Time.add(label_15);
		
		pnlLap1Sector2Time = new JPanel();
		pnlLap1Sector2Time.setLayout(null);
		pnlLap1Sector2Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap1Sector2Time.setBackground(defaultBackgroundColor);
		pnlLap1Sector2Time.setBounds(94, 62, 60, 32);
		pnlLiveTimingGrid.add(pnlLap1Sector2Time);
		
		label_16 = new JLabel("00:00.00");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Calibri", Font.BOLD, 11));
		label_16.setBounds(0, 0, 60, 32);
		pnlLap1Sector2Time.add(label_16);
		
		pnlLap2Sector2Time = new JPanel();
		pnlLap2Sector2Time.setLayout(null);
		pnlLap2Sector2Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap2Sector2Time.setBackground(defaultBackgroundColor);
		pnlLap2Sector2Time.setBounds(94, 93, 60, 32);
		pnlLiveTimingGrid.add(pnlLap2Sector2Time);
		
		label_17 = new JLabel("00:00.00");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Calibri", Font.BOLD, 11));
		label_17.setBounds(0, 0, 60, 32);
		pnlLap2Sector2Time.add(label_17);
		
		pnlLap3Sector2Time = new JPanel();
		pnlLap3Sector2Time.setLayout(null);
		pnlLap3Sector2Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap3Sector2Time.setBackground(defaultBackgroundColor);
		pnlLap3Sector2Time.setBounds(94, 124, 60, 32);
		pnlLiveTimingGrid.add(pnlLap3Sector2Time);
		
		label_18 = new JLabel("00:00.00");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Calibri", Font.BOLD, 11));
		label_18.setBounds(0, 0, 60, 32);
		pnlLap3Sector2Time.add(label_18);
		
		pnlLap4Sector2Time = new JPanel();
		pnlLap4Sector2Time.setLayout(null);
		pnlLap4Sector2Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap4Sector2Time.setBackground(defaultBackgroundColor);
		pnlLap4Sector2Time.setBounds(94, 155, 60, 32);
		pnlLiveTimingGrid.add(pnlLap4Sector2Time);
		
		label_19 = new JLabel("00:00.00");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Calibri", Font.BOLD, 11));
		label_19.setBounds(0, 0, 60, 32);
		pnlLap4Sector2Time.add(label_19);
		
		pnlLap5Sector2Time = new JPanel();
		pnlLap5Sector2Time.setLayout(null);
		pnlLap5Sector2Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap5Sector2Time.setBackground(defaultBackgroundColor);
		pnlLap5Sector2Time.setBounds(94, 186, 60, 32);
		pnlLiveTimingGrid.add(pnlLap5Sector2Time);
		
		label_20 = new JLabel("00:00.00");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Calibri", Font.BOLD, 11));
		label_20.setBounds(0, 0, 60, 32);
		pnlLap5Sector2Time.add(label_20);
		
		pnlLap6Sector2Time = new JPanel();
		pnlLap6Sector2Time.setLayout(null);
		pnlLap6Sector2Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap6Sector2Time.setBackground(defaultBackgroundColor);
		pnlLap6Sector2Time.setBounds(94, 217, 60, 32);
		pnlLiveTimingGrid.add(pnlLap6Sector2Time);
		
		label_21 = new JLabel("00:00.00");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Calibri", Font.BOLD, 11));
		label_21.setBounds(0, 0, 60, 32);
		pnlLap6Sector2Time.add(label_21);
		
		pnlLap1Sector3Time = new JPanel();
		pnlLap1Sector3Time.setLayout(null);
		pnlLap1Sector3Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap1Sector3Time.setBackground(defaultBackgroundColor);
		pnlLap1Sector3Time.setBounds(153, 62, 60, 32);
		pnlLiveTimingGrid.add(pnlLap1Sector3Time);
		
		label_22 = new JLabel("00:00.00");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Calibri", Font.BOLD, 11));
		label_22.setBounds(0, 0, 60, 32);
		pnlLap1Sector3Time.add(label_22);
		
		pnlLap2Sector3Time = new JPanel();
		pnlLap2Sector3Time.setLayout(null);
		pnlLap2Sector3Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap2Sector3Time.setBackground(defaultBackgroundColor);
		pnlLap2Sector3Time.setBounds(153, 93, 60, 32);
		pnlLiveTimingGrid.add(pnlLap2Sector3Time);
		
		label_23 = new JLabel("00:00.00");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Calibri", Font.BOLD, 11));
		label_23.setBounds(0, 0, 60, 32);
		pnlLap2Sector3Time.add(label_23);
		
		pnlLap3Sector3Time = new JPanel();
		pnlLap3Sector3Time.setLayout(null);
		pnlLap3Sector3Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap3Sector3Time.setBackground(defaultBackgroundColor);
		pnlLap3Sector3Time.setBounds(153, 124, 60, 32);
		pnlLiveTimingGrid.add(pnlLap3Sector3Time);
		
		label_24 = new JLabel("00:00.00");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Calibri", Font.BOLD, 11));
		label_24.setBounds(0, 0, 60, 32);
		pnlLap3Sector3Time.add(label_24);
		
		pnlLap4Sector3Time = new JPanel();
		pnlLap4Sector3Time.setLayout(null);
		pnlLap4Sector3Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap4Sector3Time.setBackground(defaultBackgroundColor);
		pnlLap4Sector3Time.setBounds(153, 155, 60, 32);
		pnlLiveTimingGrid.add(pnlLap4Sector3Time);
		
		label_25 = new JLabel("00:00.00");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Calibri", Font.BOLD, 11));
		label_25.setBounds(0, 0, 60, 32);
		pnlLap4Sector3Time.add(label_25);
		
		pnlLap5Sector3Time = new JPanel();
		pnlLap5Sector3Time.setLayout(null);
		pnlLap5Sector3Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap5Sector3Time.setBackground(defaultBackgroundColor);
		pnlLap5Sector3Time.setBounds(153, 186, 60, 32);
		pnlLiveTimingGrid.add(pnlLap5Sector3Time);
		
		label_26 = new JLabel("00:00.00");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Calibri", Font.BOLD, 11));
		label_26.setBounds(0, 0, 60, 32);
		pnlLap5Sector3Time.add(label_26);
		
		pnlLa6Sector3Time = new JPanel();
		pnlLa6Sector3Time.setLayout(null);
		pnlLa6Sector3Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLa6Sector3Time.setBackground(defaultBackgroundColor);
		pnlLa6Sector3Time.setBounds(153, 217, 60, 32);
		pnlLiveTimingGrid.add(pnlLa6Sector3Time);
		
		label_27 = new JLabel("00:00.00");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Calibri", Font.BOLD, 11));
		label_27.setBounds(0, 0, 60, 32);
		pnlLa6Sector3Time.add(label_27);
		
		pnlLap1FinishTime = new JPanel();
		pnlLap1FinishTime.setLayout(null);
		pnlLap1FinishTime.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap1FinishTime.setBackground(defaultBackgroundColor);
		pnlLap1FinishTime.setBounds(211, 62, 60, 32);
		pnlLiveTimingGrid.add(pnlLap1FinishTime);
		
		label_28 = new JLabel("00:00.00");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Calibri", Font.BOLD, 11));
		label_28.setBounds(0, 0, 60, 32);
		pnlLap1FinishTime.add(label_28);
		
		pnlLap2FinishTime = new JPanel();
		pnlLap2FinishTime.setLayout(null);
		pnlLap2FinishTime.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap2FinishTime.setBackground(defaultBackgroundColor);
		pnlLap2FinishTime.setBounds(211, 93, 60, 32);
		pnlLiveTimingGrid.add(pnlLap2FinishTime);
		
		label_29 = new JLabel("00:00.00");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Calibri", Font.BOLD, 11));
		label_29.setBounds(0, 0, 60, 32);
		pnlLap2FinishTime.add(label_29);
		
		pnlLap3FinishTime = new JPanel();
		pnlLap3FinishTime.setLayout(null);
		pnlLap3FinishTime.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap3FinishTime.setBackground(defaultBackgroundColor);
		pnlLap3FinishTime.setBounds(211, 124, 60, 32);
		pnlLiveTimingGrid.add(pnlLap3FinishTime);
		
		label_30 = new JLabel("00:00.00");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Calibri", Font.BOLD, 11));
		label_30.setBounds(0, 0, 60, 32);
		pnlLap3FinishTime.add(label_30);
		
		pnlLap4FinishTime = new JPanel();
		pnlLap4FinishTime.setLayout(null);
		pnlLap4FinishTime.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap4FinishTime.setBackground(defaultBackgroundColor);
		pnlLap4FinishTime.setBounds(211, 155, 60, 32);
		pnlLiveTimingGrid.add(pnlLap4FinishTime);
		
		label_31 = new JLabel("00:00.00");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setForeground(Color.WHITE);
		label_31.setFont(new Font("Calibri", Font.BOLD, 11));
		label_31.setBounds(0, 0, 60, 32);
		pnlLap4FinishTime.add(label_31);
		
		pnlLap5FinishTime = new JPanel();
		pnlLap5FinishTime.setLayout(null);
		pnlLap5FinishTime.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap5FinishTime.setBackground(defaultBackgroundColor);
		pnlLap5FinishTime.setBounds(211, 186, 60, 32);
		pnlLiveTimingGrid.add(pnlLap5FinishTime);
		
		label_32 = new JLabel("00:00.00");
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setForeground(Color.WHITE);
		label_32.setFont(new Font("Calibri", Font.BOLD, 11));
		label_32.setBounds(0, 0, 60, 32);
		pnlLap5FinishTime.add(label_32);
		
		pnlLap6FinishTime = new JPanel();
		pnlLap6FinishTime.setLayout(null);
		pnlLap6FinishTime.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap6FinishTime.setBackground(defaultBackgroundColor);
		pnlLap6FinishTime.setBounds(211, 217, 60, 32);
		pnlLiveTimingGrid.add(pnlLap6FinishTime);
		
		label_33 = new JLabel("00:00.00");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Calibri", Font.BOLD, 11));
		label_33.setBounds(0, 0, 60, 32);
		pnlLap6FinishTime.add(label_33);
		

		
		
		
		
		
		
		pnlDriverInput = new JPanel();
		pnlDriverInput.setBorder(new MatteBorder(1, 2, 2, 2, (Color) Color.WHITE));
		pnlDriverInput.setBackground(defaultBackgroundColor);
		pnlDriverInput.setBounds(993, 336, 271, 368);
		contentPane.add(pnlDriverInput);
		pnlDriverInput.setLayout(null);

		lblDriverInputs = new JLabel("DRIVER INPUTS");
		lblDriverInputs.setBackground(defaultBackgroundColor);
		lblDriverInputs.setForeground(Color.WHITE);
		lblDriverInputs.setHorizontalAlignment(SwingConstants.CENTER);
		lblDriverInputs.setBounds(0, 0, 271, 32);
		lblDriverInputs.setBorder(defaultBorder);
		pnlDriverInput.add(lblDriverInputs);

		lblSteer = new JLabel("N/A");
		lblSteer.setBackground(defaultBackgroundColor);
		lblSteer.setForeground(Color.WHITE);
		lblSteer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSteer.setBounds(10, 42, 55, 55);
		lblSteer.setBorder(defaultBorder);
		pnlDriverInput.add(lblSteer);

		lblAccel = new JLabel("0");
		lblAccel.setBackground(defaultBackgroundColor);
		lblAccel.setForeground(Color.WHITE);
		lblAccel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccel.setBounds(10, 302, 55, 55);
		lblAccel.setBorder(defaultBorder);
		pnlDriverInput.add(lblAccel);

		lblBrake = new JLabel("0");
		lblBrake.setBackground(defaultBackgroundColor);
		lblBrake.setForeground(Color.WHITE);
		lblBrake.setHorizontalAlignment(SwingConstants.CENTER);
		lblBrake.setBounds(75, 302, 55, 55);
		lblBrake.setBorder(defaultBorder);
		pnlDriverInput.add(lblBrake);

		lblClutch = new JLabel("0");
		lblClutch.setBackground(defaultBackgroundColor);
		lblClutch.setForeground(Color.WHITE);
		lblClutch.setHorizontalAlignment(SwingConstants.CENTER);
		lblClutch.setBounds(140, 302, 55, 55);
		lblClutch.setBorder(defaultBorder);
		pnlDriverInput.add(lblClutch);

		lblHandbrake = new JLabel("0");
		lblHandbrake.setBackground(defaultBackgroundColor);
		lblHandbrake.setForeground(Color.WHITE);
		lblHandbrake.setHorizontalAlignment(SwingConstants.CENTER);
		lblHandbrake.setBounds(205, 302, 55, 55);
		lblHandbrake.setBorder(defaultBorder);
		pnlDriverInput.add(lblHandbrake);
		
		barSteer = new BarChartSingle(-127, 127, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barSteer.setOpaque(false);
		barSteer.setBounds(75, 42, 185, 55);
		barSteer.setHorizontal(true);
		pnlDriverInput.add(barSteer);

		barAccel = new BarChartSingle(0, 255, 0, new Color(0,200,0), new Color(0,200,0, 127));
		barAccel.setOpaque(false);
		barAccel.setBounds(10, 108, 55, 183);
		pnlDriverInput.add(barAccel);

		barBrake = new BarChartSingle(0, 255, 0, new Color(200,0,0), new Color(200,0,0, 127));
		barBrake.setOpaque(false);
		barBrake.setBounds(75, 108, 55, 183);
		pnlDriverInput.add(barBrake);
		
		barClutch = new BarChartSingle(0, 255, 0, new Color(200,200,0), new Color(200,200,0, 127));
		barClutch.setOpaque(false);
		barClutch.setBounds(140, 108, 55, 183);
		pnlDriverInput.add(barClutch);
		
		barHandbrake = new BarChartSingle(0, 255, 0, new Color(0,0,200), new Color(0,0,200, 127));
		barHandbrake.setOpaque(false);
		barHandbrake.setBounds(205, 108, 55, 183);
		pnlDriverInput.add(barHandbrake);		

		
		
		
		
		
		
		

		
		
		pnlLap7 = new JPanel();
		pnlLap7.setLayout(null);
		pnlLap7.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLap7.setBackground(defaultBackgroundColor);
		pnlLap7.setBounds(993, 293, 36, 32);
		contentPane.add(pnlLap7);
		
		label_1 = new JLabel("N/A");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Calibri", Font.BOLD, 11));
		label_1.setBounds(0, 0, 36, 32);
		pnlLap7.add(label_1);
		
		pnlLap7Sector1Time = new JPanel();
		pnlLap7Sector1Time.setLayout(null);
		pnlLap7Sector1Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap7Sector1Time.setBackground(defaultBackgroundColor);
		pnlLap7Sector1Time.setBounds(1028, 293, 60, 32);
		contentPane.add(pnlLap7Sector1Time);
		
		label_3 = new JLabel("00:00.00");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Calibri", Font.BOLD, 11));
		label_3.setBounds(0, 0, 60, 32);
		pnlLap7Sector1Time.add(label_3);
		
		pnlLap7Sector2Time = new JPanel();
		pnlLap7Sector2Time.setLayout(null);
		pnlLap7Sector2Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap7Sector2Time.setBackground(defaultBackgroundColor);
		pnlLap7Sector2Time.setBounds(1087, 293, 60, 32);
		contentPane.add(pnlLap7Sector2Time);
		
		label_4 = new JLabel("00:00.00");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Calibri", Font.BOLD, 11));
		label_4.setBounds(0, 0, 60, 32);
		pnlLap7Sector2Time.add(label_4);
		
		pnlLap7Sector3Time = new JPanel();
		pnlLap7Sector3Time.setLayout(null);
		pnlLap7Sector3Time.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap7Sector3Time.setBackground(defaultBackgroundColor);
		pnlLap7Sector3Time.setBounds(1146, 293, 60, 32);
		contentPane.add(pnlLap7Sector3Time);
		
		label_5 = new JLabel("00:00.00");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Calibri", Font.BOLD, 11));
		label_5.setBounds(0, 0, 60, 32);
		pnlLap7Sector3Time.add(label_5);
		
		pnlLap7FinishTime = new JPanel();
		pnlLap7FinishTime.setLayout(null);
		pnlLap7FinishTime.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlLap7FinishTime.setBackground(defaultBackgroundColor);
		pnlLap7FinishTime.setBounds(1204, 293, 60, 32);
		contentPane.add(pnlLap7FinishTime);
		
		label_6 = new JLabel("00:00.00");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Calibri", Font.BOLD, 11));
		label_6.setBounds(0, 0, 60, 32);
		pnlLap7FinishTime.add(label_6);
		
		pnlMain = new JPanel();
		pnlMain.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		pnlMain.setBackground(defaultBackgroundColor);
		pnlMain.setBounds(277, 45, 706, 659);
		contentPane.add(pnlMain);
		pnlMain.setLayout(null);

		ledRPM = new LedRound[14];
		int ledXpos = 10;
		for (int i = 0; i < 14; i++) {
			if (i >= 0 && i <= 4) {
				ledRPM[i] = new LedRound(true, new Color(0,200,255), new Color(0,200,255, 127));
			} else if (i >= 5 && i <= 9) {
				ledRPM[i] = new LedRound(true, new Color(255,255,0), new Color(255,255,0, 127));
			} else {
				ledRPM[i] = new LedRound(true, new Color(255,0,0), new Color(255,0,0, 127));
			}

			ledRPM[i].setBounds(ledXpos, 11, 48, 48);
			pnlMain.add(ledRPM[i]);
			ledXpos += 49;
		}
		
		vbTyreTempFrontLeft = new ValueBox("Front Left Temp", "888.8", 10, 397, 120, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbTyreTempFrontLeft);
		
		vbTyreTempFrontRight = new ValueBox("Front Right Temp", "888.8", 130, 397, 120, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbTyreTempFrontRight);
		
		vbTyreTempRearLeft = new ValueBox("Rear Left Temp", "888.8", 10, 528, 120, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbTyreTempRearLeft);
		
		vbTyreTempRearRight = new ValueBox("Rear Right Temp", "888.8", 130, 528, 120, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbTyreTempRearRight);
		
		vbCurrentGear = new ValueBox("Current Gear", "N", 260, 397, 186, 251, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbCurrentGear);
		
		vbCurrentSpeed = new ui.ValueBox("Current Speed", "888.88", 456, 397, 240, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbCurrentSpeed);
		
		vbFuel = new ui.ValueBox("Fuel %", "888.88", 576, 528, 120, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbFuel);
		
		vbFuelLapsRemaining = new ValueBox("Fuel, Laps Left", "888.8", 456, 528, 120, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbFuelLapsRemaining);
		
		vbCurrentLap = new ValueBox("Current Lap", "00:00:00.000", 10, 135, 342, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbCurrentLap);
		
		vbLastLapDelta = new ui.ValueBox("Last Lap Delta", "00:00:00.000", 353, 135, 343, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbLastLapDelta);
		
		vbBestLap = new ui.ValueBox("Best Lap", "00:00:00.000", 10, 266, 342, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbBestLap);
		
		vbRaceTime = new ui.ValueBox("Race Time", "00:00:00.000", 353, 266, 342, 120, 30, ui.ValueBox.Layout.VALUE_BELOW);
		pnlMain.add(vbRaceTime);
		
		lineTrackMap = new LineChart(Color.WHITE, Color.WHITE);
		lineTrackMap.setOpaque(false);
		lineTrackMap.setBounds(0, 457, 272, 247);
		lineTrackMap.setMaintainRatio(true);
		lineTrackMap.setBorderSize(10);
		contentPane.add(lineTrackMap);

	}
    public void updateFields() {
    	super.updateFields();
    	getPlayersReadWriteLock().readLock().lock();
    	try {
        	DecimalFormat df1 = new DecimalFormat("0.0");
        	DecimalFormat df2 = new DecimalFormat("0.00");
        	
        	Player currPlayer = getSelectedPlayer();
    		if (currPlayer.getTelemetryPacket() != null) {
		    	this.vbCurrentLap.setValue(Calc.secondsToTime(currPlayer.getTelemetryPacket().getTrack().getCurrentLap()));
		    	this.vbBestLap.setValue(Calc.secondsToTime((currPlayer.getTelemetryPacket().getTrack().getBestLap())));
		    	this.vbLastLapDelta.setValue(Calc.secondsToTime(currPlayer.getLastLapDelta()));
		    	this.vbRaceTime.setValue(Calc.secondsToTime(currPlayer.getTelemetryPacket().getTrack().getCurrentRaceTime()));
		    	this.vbCurrentSpeed.setValue(df2.format(currPlayer.getTelemetryPacket().getVelocity().getSpeed(Speed.MPH)));
		    	this.vbFuel.setValue(df2.format(currPlayer.getTelemetryPacket().getEngine().getFuel() * 100));
		    	this.vbCurrentGear.setValue(Short.toString(currPlayer.getTelemetryPacket().getEngine().getGear()));
		    	this.vbTyreTempFrontLeft.setValue(df1.format(currPlayer.getTelemetryPacket().getTyre().getTyreTempFrontLeft()));
		    	this.vbTyreTempFrontRight.setValue(df1.format(currPlayer.getTelemetryPacket().getTyre().getTyreTempRearLeft()));
		    	this.vbTyreTempRearLeft.setValue(df1.format(currPlayer.getTelemetryPacket().getTyre().getTyreTempFrontRight()));
		    	this.vbTyreTempRearRight.setValue(df1.format(currPlayer.getTelemetryPacket().getTyre().getTyreTempRearRight()));
		    	this.vbFuelLapsRemaining.setValue(df1.format(currPlayer.getFuelLapsRemaining()));

		    	float currentRPM = currPlayer.getTelemetryPacket().getEngine().getCurrentEngineRpm();
		    	float redlineRPM = this.redlineRPM;
		    	float redlineRange = this.redlineRange;
		    	
		    	for (int i = 0; i < 14; i++) {
			    	ledRPM[i].setOn(getRPMLedOn(currentRPM, redlineRPM, redlineRange, i-1, 14));
			    	ledRPM[i].repaint();
		    	}

		        this.lineTrackMap.addValue(new Point2D.Double(currPlayer.getTelemetryPacket().getTrack().getPositionX(), currPlayer.getTelemetryPacket().getTrack().getPositionZ()));
		        this.lineTrackMap.repaint();
		        
		        this.lblAccel.setText(Short.toString(currPlayer.getTelemetryPacket().getPlayerInput().getAccel()));
		        this.barAccel.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getAccel());
		        this.barAccel.repaint();
		        this.lblBrake.setText(Short.toString(currPlayer.getTelemetryPacket().getPlayerInput().getBrake()));
		        this.barBrake.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getBrake());
		        this.barBrake.repaint();
		        this.lblClutch.setText(Short.toString(currPlayer.getTelemetryPacket().getPlayerInput().getClutch()));
		        this.barClutch.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getClutch());
		        this.barClutch.repaint();
		        this.lblHandbrake.setText(Short.toString(currPlayer.getTelemetryPacket().getPlayerInput().getHandbrake()));
		        this.barHandbrake.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getHandbrake());
		        this.barHandbrake.repaint();
		        this.lblSteer.setText(Short.toString(currPlayer.getTelemetryPacket().getPlayerInput().getSteer()));
		        this.barSteer.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getSteer());
		        this.barSteer.repaint();
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
    private boolean getRPMLedOn(float currentRPM, float redlineRPM, float redlineRange, int ledNumber, int ledCount) {
    	float barMax = redlineRPM - redlineRange + ((redlineRange / ledCount) * ledNumber);
    	if (currentRPM >= barMax) return true;
    	return false;
    }
}
