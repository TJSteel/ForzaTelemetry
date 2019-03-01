package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
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
import java.awt.Label;

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
	private JPanel pnlGearSelection;
	private JLabel lblGearSelection;
	private JPanel pnlGearSelectionHeadingBox;
	private JLabel lblGearSelection_1;
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
	private JPanel pnlDriverInputsMainPanel;
	private JPanel pnlCurrentThrottlePercentage;
	private JPanel pnlCurrentBrakePercentage;
	private JPanel pnlCurrentClutchPercentage;
	private JPanel pnlCurrentHandbrakePercentage;
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
	private JPanel pnlCurrentSteeringPercentage;
	private JPanel pnlCurrentThrottleBar;
	private JPanel pnlCurrentBrakeBar;
	private JPanel pnlCurrentClutchBar;
	private JPanel pnlCurrentHandbrakeBar;
	private JPanel pnlCurrentSteeringBar;
	private JLabel lblNewLabel;
	private JLabel label_38;
	private JLabel label_39;
	private JLabel label_40;
	private JLabel label_41;
	private JPanel pnlTrackMap;
	private JPanel pnlHandbrakePercenatgePerLap;
	private JLabel lblHandbrakePer;
	private JPanel pnlHandbrakePercenatgePerLapReadout;
	private JLabel label_7;
	// }} variables

	/**
	 * Create the frame. 
	 */
	public DashboardUI(ArrayList<Player> players, ReadWriteLock playersReadWriteLock) {
		super(players, playersReadWriteLock);
		setOpacity(0.0f);
		this.initialize();

		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		
		JPanel pnlRaceInformation = new JPanel();
		pnlRaceInformation.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		pnlRaceInformation.setBackground(Color.BLACK);
		pnlRaceInformation.setBounds(0, 45, 272, 404);
		contentPane.add(pnlRaceInformation);
		pnlRaceInformation.setLayout(null);
		
		JPanel pnlRaceInformationHeading = new JPanel();
		pnlRaceInformationHeading.setLayout(null);
		pnlRaceInformationHeading.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		pnlRaceInformationHeading.setBackground(Color.BLACK);
		pnlRaceInformationHeading.setBounds(0, 0, 272, 32);
		pnlRaceInformation.add(pnlRaceInformationHeading);
		
		JLabel raceinfo_lbl = new JLabel("RACE INFORMATION");
		raceinfo_lbl.setBounds(0, 1, 272, 32);
		pnlRaceInformationHeading.add(raceinfo_lbl);
		raceinfo_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		raceinfo_lbl.setForeground(Color.WHITE);
		raceinfo_lbl.setFont(new Font("Calibri", Font.BOLD, 19));
		
		JPanel pnlTrackName = new JPanel();
		pnlTrackName.setLayout(null);
		pnlTrackName.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlTrackName.setBackground(Color.BLACK);
		pnlTrackName.setBounds(0, 31, 129, 32);
		pnlRaceInformation.add(pnlTrackName);
		
		JLabel lblTrack = new JLabel("    TRACK NAME");
		lblTrack.setBounds(0, 0, 129, 32);
		pnlTrackName.add(lblTrack);
		lblTrack.setHorizontalAlignment(SwingConstants.LEFT);
		lblTrack.setForeground(Color.WHITE);
		lblTrack.setFont(new Font("Calibri", Font.BOLD, 11));
		
		JPanel pnlCurrentTurnName = new JPanel();
		pnlCurrentTurnName.setLayout(null);
		pnlCurrentTurnName.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlCurrentTurnName.setBackground(Color.BLACK);
		pnlCurrentTurnName.setBounds(0, 93, 129, 32);
		pnlRaceInformation.add(pnlCurrentTurnName);
		
		JLabel lblCurrentTurn = new JLabel("    LAP DISTANCE");
		lblCurrentTurn.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentTurn.setForeground(Color.WHITE);
		lblCurrentTurn.setFont(new Font("Calibri", Font.BOLD, 11));
		lblCurrentTurn.setBounds(0, 0, 129, 32);
		pnlCurrentTurnName.add(lblCurrentTurn);
		
		JPanel pnlTotalTurns = new JPanel();
		pnlTotalTurns.setLayout(null);
		pnlTotalTurns.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlTotalTurns.setBackground(Color.BLACK);
		pnlTotalTurns.setBounds(0, 124, 129, 32);
		pnlRaceInformation.add(pnlTotalTurns);
		
		JLabel lblTotalTurns = new JLabel("    TOTAL TURNS");
		lblTotalTurns.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalTurns.setForeground(Color.WHITE);
		lblTotalTurns.setFont(new Font("Calibri", Font.BOLD, 11));
		lblTotalTurns.setBounds(0, 0, 129, 32);
		pnlTotalTurns.add(lblTotalTurns);
		
		JPanel pnlCurrentTurnNumber = new JPanel();
		pnlCurrentTurnNumber.setLayout(null);
		pnlCurrentTurnNumber.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlCurrentTurnNumber.setBackground(Color.BLACK);
		pnlCurrentTurnNumber.setBounds(0, 155, 129, 32);
		pnlRaceInformation.add(pnlCurrentTurnNumber);
		
		JLabel lblCurrentTurnNumber = new JLabel("    CURRENT TURN NUMBER");
		lblCurrentTurnNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentTurnNumber.setForeground(Color.WHITE);
		lblCurrentTurnNumber.setFont(new Font("Calibri", Font.BOLD, 11));
		lblCurrentTurnNumber.setBounds(0, 0, 125, 32);
		pnlCurrentTurnNumber.add(lblCurrentTurnNumber);
		
		JPanel pnlCurrentTurnName_1 = new JPanel();
		pnlCurrentTurnName_1.setLayout(null);
		pnlCurrentTurnName_1.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlCurrentTurnName_1.setBackground(Color.BLACK);
		pnlCurrentTurnName_1.setBounds(0, 186, 129, 32);
		pnlRaceInformation.add(pnlCurrentTurnName_1);
		
		JLabel lblLapLength = new JLabel("    CURRENT TURN NAME");
		lblLapLength.setHorizontalAlignment(SwingConstants.LEFT);
		lblLapLength.setForeground(Color.WHITE);
		lblLapLength.setFont(new Font("Calibri", Font.BOLD, 11));
		lblLapLength.setBounds(0, 0, 129, 32);
		pnlCurrentTurnName_1.add(lblLapLength);
		
		pnlThrottlePercentagePerLap = new JPanel();
		pnlThrottlePercentagePerLap.setLayout(null);
		pnlThrottlePercentagePerLap.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlThrottlePercentagePerLap.setBackground(Color.BLACK);
		pnlThrottlePercentagePerLap.setBounds(0, 248, 129, 32);
		pnlRaceInformation.add(pnlThrottlePercentagePerLap);
		
		pnlGearChangesPerLap = new JPanel();
		pnlGearChangesPerLap.setBounds(0, 0, 129, 32);
		pnlThrottlePercentagePerLap.add(pnlGearChangesPerLap);
		pnlGearChangesPerLap.setLayout(null);
		pnlGearChangesPerLap.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlGearChangesPerLap.setBackground(Color.BLACK);
		
		lblAverageGearChanges = new JLabel("    GEAR CHANGES PER LAP");
		lblAverageGearChanges.setHorizontalAlignment(SwingConstants.LEFT);
		lblAverageGearChanges.setForeground(Color.WHITE);
		lblAverageGearChanges.setFont(new Font("Calibri", Font.BOLD, 11));
		lblAverageGearChanges.setBounds(0, 0, 129, 32);
		pnlGearChangesPerLap.add(lblAverageGearChanges);
		
		pnlBrakePercentagePerLap = new JPanel();
		pnlBrakePercentagePerLap.setLayout(null);
		pnlBrakePercentagePerLap.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlBrakePercentagePerLap.setBackground(Color.BLACK);
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
		pnlFuelUsagePerLap.setBackground(Color.BLACK);
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
		pnlClutchPercentagePerLap.setBackground(Color.BLACK);
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
		pnlTrackNameReadout.setBackground(Color.BLACK);
		pnlTrackNameReadout.setBounds(128, 31, 144, 32);
		pnlRaceInformation.add(pnlTrackNameReadout);
		
		lblCicuitDeCatalunya = new JLabel("Cicuit de Catalunya");
		lblCicuitDeCatalunya.setHorizontalAlignment(SwingConstants.CENTER);
		lblCicuitDeCatalunya.setForeground(Color.WHITE);
		lblCicuitDeCatalunya.setFont(new Font("Calibri", Font.BOLD, 11));
		lblCicuitDeCatalunya.setBounds(0, 0, 144, 32);
		pnlTrackNameReadout.add(lblCicuitDeCatalunya);
		
		pnlLapDistanceReadout = new JPanel();
		pnlLapDistanceReadout.setLayout(null);
		pnlLapDistanceReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlLapDistanceReadout.setBackground(Color.BLACK);
		pnlLapDistanceReadout.setBounds(128, 93, 144, 32);
		pnlRaceInformation.add(pnlLapDistanceReadout);
		
		lblNa_8 = new JLabel("4.655 KM");
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
		pnlTotalTurnsReadout.setBackground(Color.BLACK);
		pnlTotalTurnsReadout.setBounds(128, 124, 144, 32);
		pnlRaceInformation.add(pnlTotalTurnsReadout);
		
		JLabel label_2 = new JLabel("16");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Calibri", Font.BOLD, 11));
		label_2.setBounds(0, 0, 144, 32);
		pnlTotalTurnsReadout.add(label_2);
		
		pnlCurrentTurnNumberReadout = new JPanel();
		pnlCurrentTurnNumberReadout.setLayout(null);
		pnlCurrentTurnNumberReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlCurrentTurnNumberReadout.setBackground(Color.BLACK);
		pnlCurrentTurnNumberReadout.setBounds(128, 155, 144, 32);
		pnlRaceInformation.add(pnlCurrentTurnNumberReadout);
		
		JLabel lblNa_1 = new JLabel("N/A");
		lblNa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_1.setForeground(Color.WHITE);
		lblNa_1.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_1.setBounds(0, 0, 144, 32);
		pnlCurrentTurnNumberReadout.add(lblNa_1);
		
		pnlCurrentTurnNameReadout = new JPanel();
		pnlCurrentTurnNameReadout.setLayout(null);
		pnlCurrentTurnNameReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlCurrentTurnNameReadout.setBackground(Color.BLACK);
		pnlCurrentTurnNameReadout.setBounds(128, 186, 144, 32);
		pnlRaceInformation.add(pnlCurrentTurnNameReadout);
		
		JLabel lblKm = new JLabel("RADION");
		lblKm.setHorizontalAlignment(SwingConstants.CENTER);
		lblKm.setForeground(Color.WHITE);
		lblKm.setFont(new Font("Calibri", Font.BOLD, 11));
		lblKm.setBounds(0, 0, 144, 32);
		pnlCurrentTurnNameReadout.add(lblKm);
		
		pnlGearChangesPerLapReadout = new JPanel();
		pnlGearChangesPerLapReadout.setLayout(null);
		pnlGearChangesPerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlGearChangesPerLapReadout.setBackground(Color.BLACK);
		pnlGearChangesPerLapReadout.setBounds(128, 217, 144, 32);
		pnlRaceInformation.add(pnlGearChangesPerLapReadout);
		
		JLabel lblNa_3 = new JLabel("N/A");
		lblNa_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_3.setForeground(Color.WHITE);
		lblNa_3.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_3.setBounds(0, 0, 144, 32);
		pnlGearChangesPerLapReadout.add(lblNa_3);
		
		pnlThrottlePercentagePerLapReadout = new JPanel();
		pnlThrottlePercentagePerLapReadout.setLayout(null);
		pnlThrottlePercentagePerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlThrottlePercentagePerLapReadout.setBackground(Color.BLACK);
		pnlThrottlePercentagePerLapReadout.setBounds(128, 248, 144, 32);
		pnlRaceInformation.add(pnlThrottlePercentagePerLapReadout);
		
		JLabel lblNa_4 = new JLabel("N/A");
		lblNa_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_4.setForeground(Color.WHITE);
		lblNa_4.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_4.setBounds(0, 0, 144, 32);
		pnlThrottlePercentagePerLapReadout.add(lblNa_4);
		
		pnlBrakePercentagePerLapReadout = new JPanel();
		pnlBrakePercentagePerLapReadout.setLayout(null);
		pnlBrakePercentagePerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlBrakePercentagePerLapReadout.setBackground(Color.BLACK);
		pnlBrakePercentagePerLapReadout.setBounds(128, 279, 144, 32);
		pnlRaceInformation.add(pnlBrakePercentagePerLapReadout);
		
		JLabel lblNa_5 = new JLabel("N/A");
		lblNa_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_5.setForeground(Color.WHITE);
		lblNa_5.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_5.setBounds(0, 0, 144, 32);
		pnlBrakePercentagePerLapReadout.add(lblNa_5);
		
		pnlFuelUsagePerLapReadout = new JPanel();
		pnlFuelUsagePerLapReadout.setLayout(null);
		pnlFuelUsagePerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) Color.WHITE));
		pnlFuelUsagePerLapReadout.setBackground(Color.BLACK);
		pnlFuelUsagePerLapReadout.setBounds(128, 310, 144, 32);
		pnlRaceInformation.add(pnlFuelUsagePerLapReadout);
		
		JLabel lblNa_6 = new JLabel("N/A");
		lblNa_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_6.setForeground(Color.WHITE);
		lblNa_6.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_6.setBounds(0, 0, 144, 32);
		pnlFuelUsagePerLapReadout.add(lblNa_6);
		
		pnlClutchPecentagePerLapReadout = new JPanel();
		pnlClutchPecentagePerLapReadout.setLayout(null);
		pnlClutchPecentagePerLapReadout.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(255, 255, 255)));
		pnlClutchPecentagePerLapReadout.setBackground(Color.BLACK);
		pnlClutchPecentagePerLapReadout.setBounds(128, 341, 144, 32);
		pnlRaceInformation.add(pnlClutchPecentagePerLapReadout);
		
		JLabel lblNa_7 = new JLabel("N/A");
		lblNa_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa_7.setForeground(Color.WHITE);
		lblNa_7.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNa_7.setBounds(0, 0, 144, 32);
		pnlClutchPecentagePerLapReadout.add(lblNa_7);
		
		JPanel pnlWeatherCondition = new JPanel();
		pnlWeatherCondition.setBounds(0, 62, 129, 32);
		pnlRaceInformation.add(pnlWeatherCondition);
		pnlWeatherCondition.setLayout(null);
		pnlWeatherCondition.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlWeatherCondition.setBackground(Color.BLACK);
		
		JLabel lblWeatherConditions = new JLabel("    WEATHER CONDITION");
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
		panel_12.setBackground(Color.BLACK);
		
		JLabel lblNa_2 = new JLabel("N/A");
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
		pnlHandbrakePercenatgePerLap.setBackground(Color.BLACK);
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
		pnlHandbrakePercenatgePerLapReadout.setBackground(Color.BLACK);
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
		pnlLiveTimingGrid.setBackground(Color.BLACK);
		pnlLiveTimingGrid.setBounds(993, 45, 271, 249);
		contentPane.add(pnlLiveTimingGrid);
		pnlLiveTimingGrid.setLayout(null);
		
		JLabel lblLiveTiming = new JLabel("LIVE TIMING");
		lblLiveTiming.setBounds(0, 1, 271, 32);
		pnlLiveTimingGrid.add(lblLiveTiming);
		lblLiveTiming.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveTiming.setForeground(Color.WHITE);
		lblLiveTiming.setFont(new Font("Calibri", Font.BOLD, 19));
		
		JPanel pnlLiveTimingHeading = new JPanel();
		pnlLiveTimingHeading.setBounds(0, 0, 271, 32);
		pnlLiveTimingGrid.add(pnlLiveTimingHeading);
		pnlLiveTimingHeading.setLayout(null);
		pnlLiveTimingHeading.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		pnlLiveTimingHeading.setBackground(Color.BLACK);
		
		JPanel pnlLapHeading = new JPanel();
		pnlLapHeading.setLayout(null);
		pnlLapHeading.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLapHeading.setBackground(Color.BLACK);
		pnlLapHeading.setBounds(0, 31, 36, 32);
		pnlLiveTimingGrid.add(pnlLapHeading);
		
		JLabel lblLap = new JLabel("LAP");
		lblLap.setHorizontalAlignment(SwingConstants.CENTER);
		lblLap.setForeground(Color.WHITE);
		lblLap.setFont(new Font("Calibri", Font.BOLD, 11));
		lblLap.setBounds(0, 0, 36, 32);
		pnlLapHeading.add(lblLap);
		
		pnlSector2Heading = new JPanel();
		pnlSector2Heading.setLayout(null);
		pnlSector2Heading.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlSector2Heading.setBackground(Color.BLACK);
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
		pnlSector1Heading.setBackground(Color.BLACK);
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
		pnlSector3Heading.setBackground(Color.BLACK);
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
		pnlLapTimeHeading.setBackground(Color.BLACK);
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
		pnlLap1.setBackground(Color.BLACK);
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
		pnlLap2.setBackground(Color.BLACK);
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
		pnlLap3.setBackground(Color.BLACK);
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
		pnlLap4.setBackground(Color.BLACK);
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
		pnlLap5.setBackground(Color.BLACK);
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
		pnlLap6.setBackground(Color.BLACK);
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
		pnlLap1Sector1Time.setBackground(Color.BLACK);
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
		pnlLap2Sector1Time.setBackground(Color.BLACK);
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
		pnlLap3Sector1Time.setBackground(Color.BLACK);
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
		pnlLap4Sector1Time.setBackground(Color.BLACK);
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
		pnlLap5Sector1Time.setBackground(Color.BLACK);
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
		pnlLap6Sector1Time.setBackground(Color.BLACK);
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
		pnlLap1Sector2Time.setBackground(Color.BLACK);
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
		pnlLap2Sector2Time.setBackground(Color.BLACK);
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
		pnlLap3Sector2Time.setBackground(Color.BLACK);
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
		pnlLap4Sector2Time.setBackground(Color.BLACK);
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
		pnlLap5Sector2Time.setBackground(Color.BLACK);
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
		pnlLap6Sector2Time.setBackground(Color.BLACK);
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
		pnlLap1Sector3Time.setBackground(Color.BLACK);
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
		pnlLap2Sector3Time.setBackground(Color.BLACK);
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
		pnlLap3Sector3Time.setBackground(Color.BLACK);
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
		pnlLap4Sector3Time.setBackground(Color.BLACK);
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
		pnlLap5Sector3Time.setBackground(Color.BLACK);
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
		pnlLa6Sector3Time.setBackground(Color.BLACK);
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
		pnlLap1FinishTime.setBackground(Color.BLACK);
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
		pnlLap2FinishTime.setBackground(Color.BLACK);
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
		pnlLap3FinishTime.setBackground(Color.BLACK);
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
		pnlLap4FinishTime.setBackground(Color.BLACK);
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
		pnlLap5FinishTime.setBackground(Color.BLACK);
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
		pnlLap6FinishTime.setBackground(Color.BLACK);
		pnlLap6FinishTime.setBounds(211, 217, 60, 32);
		pnlLiveTimingGrid.add(pnlLap6FinishTime);
		
		label_33 = new JLabel("00:00.00");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Calibri", Font.BOLD, 11));
		label_33.setBounds(0, 0, 60, 32);
		pnlLap6FinishTime.add(label_33);
		
		pnlDriverInputsMainPanel = new JPanel();
		pnlDriverInputsMainPanel.setBorder(new MatteBorder(1, 2, 2, 2, (Color) Color.WHITE));
		pnlDriverInputsMainPanel.setBackground(Color.BLACK);
		pnlDriverInputsMainPanel.setBounds(993, 336, 271, 368);
		contentPane.add(pnlDriverInputsMainPanel);
		pnlDriverInputsMainPanel.setLayout(null);
		
		pnlCurrentThrottlePercentage = new JPanel();
		pnlCurrentThrottlePercentage.setBackground(Color.BLACK);
		pnlCurrentThrottlePercentage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentThrottlePercentage.setBounds(10, 302, 55, 55);
		pnlDriverInputsMainPanel.add(pnlCurrentThrottlePercentage);
		pnlCurrentThrottlePercentage.setLayout(null);
		
		lblNewLabel = new JLabel("N/A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(-1, 0, 56, 55);
		pnlCurrentThrottlePercentage.add(lblNewLabel);
		
		pnlCurrentBrakePercentage = new JPanel();
		pnlCurrentBrakePercentage.setBackground(Color.BLACK);
		pnlCurrentBrakePercentage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentBrakePercentage.setBounds(75, 302, 55, 55);
		pnlDriverInputsMainPanel.add(pnlCurrentBrakePercentage);
		pnlCurrentBrakePercentage.setLayout(null);
		
		label_38 = new JLabel("N/A");
		label_38.setHorizontalAlignment(SwingConstants.CENTER);
		label_38.setForeground(Color.WHITE);
		label_38.setBounds(0, 0, 56, 55);
		pnlCurrentBrakePercentage.add(label_38);
		
		pnlCurrentClutchPercentage = new JPanel();
		pnlCurrentClutchPercentage.setBackground(Color.BLACK);
		pnlCurrentClutchPercentage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentClutchPercentage.setBounds(140, 302, 55, 55);
		pnlDriverInputsMainPanel.add(pnlCurrentClutchPercentage);
		pnlCurrentClutchPercentage.setLayout(null);
		
		label_39 = new JLabel("N/A");
		label_39.setHorizontalAlignment(SwingConstants.CENTER);
		label_39.setForeground(Color.WHITE);
		label_39.setBounds(0, 0, 56, 55);
		pnlCurrentClutchPercentage.add(label_39);
		
		pnlCurrentHandbrakePercentage = new JPanel();
		pnlCurrentHandbrakePercentage.setBackground(Color.BLACK);
		pnlCurrentHandbrakePercentage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentHandbrakePercentage.setBounds(205, 302, 55, 55);
		pnlDriverInputsMainPanel.add(pnlCurrentHandbrakePercentage);
		pnlCurrentHandbrakePercentage.setLayout(null);
		
		label_40 = new JLabel("N/A");
		label_40.setHorizontalAlignment(SwingConstants.CENTER);
		label_40.setForeground(Color.WHITE);
		label_40.setBounds(0, 0, 56, 55);
		pnlCurrentHandbrakePercentage.add(label_40);
		
		pnlCurrentSteeringPercentage = new JPanel();
		pnlCurrentSteeringPercentage.setBackground(Color.BLACK);
		pnlCurrentSteeringPercentage.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentSteeringPercentage.setBounds(10, 42, 55, 55);
		pnlDriverInputsMainPanel.add(pnlCurrentSteeringPercentage);
		pnlCurrentSteeringPercentage.setLayout(null);
		
		label_41 = new JLabel("N/A");
		label_41.setHorizontalAlignment(SwingConstants.CENTER);
		label_41.setForeground(Color.WHITE);
		label_41.setBounds(0, 0, 56, 55);
		pnlCurrentSteeringPercentage.add(label_41);
		
		pnlCurrentThrottleBar = new JPanel();
		pnlCurrentThrottleBar.setBackground(Color.BLACK);
		pnlCurrentThrottleBar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentThrottleBar.setBounds(10, 108, 55, 183);
		pnlDriverInputsMainPanel.add(pnlCurrentThrottleBar);
		pnlCurrentThrottleBar.setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/Handbrake (Transparent).png")).getImage();
		
		pnlCurrentBrakeBar = new JPanel();
		pnlCurrentBrakeBar.setBackground(Color.BLACK);
		pnlCurrentBrakeBar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentBrakeBar.setBounds(75, 108, 55, 183);
		pnlDriverInputsMainPanel.add(pnlCurrentBrakeBar);
		
		pnlCurrentClutchBar = new JPanel();
		pnlCurrentClutchBar.setBackground(Color.BLACK);
		pnlCurrentClutchBar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentClutchBar.setBounds(140, 108, 55, 183);
		pnlDriverInputsMainPanel.add(pnlCurrentClutchBar);
		
		pnlCurrentHandbrakeBar = new JPanel();
		pnlCurrentHandbrakeBar.setBackground(Color.BLACK);
		pnlCurrentHandbrakeBar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentHandbrakeBar.setBounds(205, 108, 55, 183);
		pnlDriverInputsMainPanel.add(pnlCurrentHandbrakeBar);
		
		pnlCurrentSteeringBar = new JPanel();
		pnlCurrentSteeringBar.setBackground(Color.BLACK);
		pnlCurrentSteeringBar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		pnlCurrentSteeringBar.setBounds(75, 42, 185, 55);
		pnlDriverInputsMainPanel.add(pnlCurrentSteeringBar);
		
		JPanel panel_65 = new JPanel();
		panel_65.setLayout(null);
		panel_65.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		panel_65.setBackground(Color.BLACK);
		panel_65.setBounds(0, 0, 271, 32);
		pnlDriverInputsMainPanel.add(panel_65);
		
		JLabel lblDriverInputs = new JLabel("DRIVER INPUTS");
		lblDriverInputs.setHorizontalAlignment(SwingConstants.CENTER);
		lblDriverInputs.setForeground(Color.WHITE);
		lblDriverInputs.setFont(new Font("Calibri", Font.BOLD, 19));
		lblDriverInputs.setBounds(0, 1, 271, 32);
		panel_65.add(lblDriverInputs);
		
		pnlLap7 = new JPanel();
		pnlLap7.setLayout(null);
		pnlLap7.setBorder(new MatteBorder(1, 2, 1, 1, (Color) Color.WHITE));
		pnlLap7.setBackground(Color.BLACK);
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
		pnlLap7Sector1Time.setBackground(Color.BLACK);
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
		pnlLap7Sector2Time.setBackground(Color.BLACK);
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
		pnlLap7Sector3Time.setBackground(Color.BLACK);
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
		pnlLap7FinishTime.setBackground(Color.BLACK);
		pnlLap7FinishTime.setBounds(1204, 293, 60, 32);
		contentPane.add(pnlLap7FinishTime);
		
		label_6 = new JLabel("00:00.00");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Calibri", Font.BOLD, 11));
		label_6.setBounds(0, 0, 60, 32);
		pnlLap7FinishTime.add(label_6);
		
		pnlTrackMap = new JPanel();
		pnlTrackMap.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.WHITE));
		pnlTrackMap.setBackground(Color.BLACK);
		pnlTrackMap.setBounds(0, 457, 272, 247);
		contentPane.add(pnlTrackMap);
		pnlTrackMap.setLayout(null);
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
		pnlMain.setBounds(279, 45, 706, 659);
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
		lblFuelData.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
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
		lblFuelLapsRemainingData.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
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
		
		pnlGearSelection = new JPanel();
		pnlGearSelection.setBounds(277, 390, 153, 32);
		pnlMain.add(pnlGearSelection);
		pnlGearSelection.setLayout(null);
		pnlGearSelection.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		pnlGearSelection.setBackground(Color.BLACK);
		
		lblGearSelection = new JLabel("GEAR SELECTION");
		lblGearSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblGearSelection.setForeground(Color.WHITE);
		lblGearSelection.setFont(new Font("Calibri", Font.BOLD, 19));
		lblGearSelection.setBounds(0, 3, 153, 28);
		pnlGearSelection.add(lblGearSelection);

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
