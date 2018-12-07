package ui;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReadWriteLock;

import javax.swing.JPanel;
import enums.Speed;
import forza.Player;
import gauges.GaugeRpm;
import icons.DrivetrainIcon;
import utility.Calc;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.border.LineBorder;

import charts.BarChartSingle;
import charts.LineChart;
import charts.ScatterChart;

import javax.swing.JToggleButton;

public class TelemetryUI extends DefaultUI {

	// {{ variables
	private static final long serialVersionUID = 1L;
	private GaugeRpm gaugeRpm;
	private JComboBox<String> cboGamertag;
	private JTextField txtNetworkDetails;
	private JTextField txtCarName;
	private JTextField txtClass;
	private JTextField txtPerformanceIndex;
	private JTextField txtDrivetrainType;
	private JTextField txtNumCylinders;
	private JTextField txtRpm;
	private JTextField txtSpeed;
	private JTextField txtMaxSpeed;
	private JTextField txtGearRatio;

	private JTextField txtCurrentLap;
	private JTextField txtLastLap;
	private JTextField txtBestLap;
	private JTextField txtAverageLap;

	private JLabel lblGamertag;
	private JLabel lblNetworkDetails;
	private JLabel lblCarName;
	private JLabel lblClass;
	private JLabel lblPerformanceIndex;
	private JLabel lblDrivetrainType;
	private JLabel lblNumCylinders;
	private JLabel lblRpm;
	private JLabel lblSpeed;
	private JLabel lblMaxSpeed;
	private JLabel lblGearRatio;
	private JButton btnReset;
	
	private DrivetrainIcon drivetrainIcon;
	private BarChartSingle barAccel;
	private BarChartSingle barBrake;
	private BarChartSingle barClutch;
	private BarChartSingle barHandbrake;
	private BarChartSingle barSteer;
	private JTextField txtLastLapDelta;
	private JTextField txtAccel;
	private JTextField txtBrake;
	private JTextField txtClutch;
	private JTextField txtHandbrake;
	private JTextField txtTest;

	private LineChart lineSteer;
	private LineChart lineAccel;
	private LineChart lineBrake;
	private LineChart lineClutch;
	private LineChart lineHandbrake;
	private LineChart lineTrackMap;
	private JTextField txtGear;
	private JToggleButton tglbtnRecordData;
	
	private ScatterChart scatterGForce;
	// }} variables
	
	/**
	 * Create the frame.
	 */
	public TelemetryUI(ArrayList<Player> players, ReadWriteLock playersReadWriteLock) {
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
		Container contentPane = getContentPane();
		lblGamertag = new JLabel("Gamertag:");
		lblGamertag.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGamertag.setBounds(10, 11, 150, 14);
		contentPane.add(lblGamertag);
		lblNetworkDetails = new JLabel("Network:");
		lblNetworkDetails.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNetworkDetails.setBounds(10, 36, 150, 14);
		contentPane.add(lblNetworkDetails);
		
		lblRpm = new JLabel("RPM:");
		lblRpm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRpm.setBounds(10, 201, 150, 14);
		contentPane.add(lblRpm);
		
		lblSpeed = new JLabel("Speed:");
		lblSpeed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpeed.setBounds(10, 226, 150, 14);
		contentPane.add(lblSpeed);
		
		lblMaxSpeed = new JLabel("Max Speed:");
		lblMaxSpeed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaxSpeed.setBounds(10, 254, 150, 14);
		contentPane.add(lblMaxSpeed);
		
		lblCarName = new JLabel("Car Number:");
		lblCarName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarName.setBounds(10, 64, 150, 14);
		contentPane.add(lblCarName);
		
		lblClass = new JLabel("Class:");
		lblClass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClass.setBounds(10, 92, 150, 14);
		contentPane.add(lblClass);
		
		lblPerformanceIndex = new JLabel("Performance Index:");
		lblPerformanceIndex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerformanceIndex.setBounds(10, 120, 150, 14);
		contentPane.add(lblPerformanceIndex);
		
		lblDrivetrainType = new JLabel("Drivetrain Type:");
		lblDrivetrainType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDrivetrainType.setBounds(10, 148, 150, 14);
		contentPane.add(lblDrivetrainType);
		
		lblNumCylinders = new JLabel("Number of Cylinders");
		lblNumCylinders.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumCylinders.setBounds(10, 176, 150, 14);
		contentPane.add(lblNumCylinders);
		
		txtNetworkDetails = new JTextField();
		txtNetworkDetails.setEditable(false);
		txtNetworkDetails.setColumns(10);
		txtNetworkDetails.setBounds(170, 36, 120, 20);
		contentPane.add(txtNetworkDetails);
		
		txtCarName = new JTextField();
		txtCarName.setEditable(false);
		txtCarName.setColumns(10);
		txtCarName.setBounds(170, 64, 120, 20);
		contentPane.add(txtCarName);
		
		txtClass = new JTextField();
		txtClass.setEditable(false);
		txtClass.setColumns(10);
		txtClass.setBounds(170, 92, 120, 20);
		contentPane.add(txtClass);
		
		txtPerformanceIndex = new JTextField();
		txtPerformanceIndex.setEditable(false);
		txtPerformanceIndex.setColumns(10);
		txtPerformanceIndex.setBounds(170, 120, 120, 20);
		contentPane.add(txtPerformanceIndex);
		
		txtDrivetrainType = new JTextField();
		txtDrivetrainType.setEditable(false);
		txtDrivetrainType.setColumns(10);
		txtDrivetrainType.setBounds(170, 148, 120, 20);
		contentPane.add(txtDrivetrainType);
		
		txtNumCylinders = new JTextField();
		txtNumCylinders.setEditable(false);
		txtNumCylinders.setColumns(10);
		txtNumCylinders.setBounds(170, 176, 120, 20);
		contentPane.add(txtNumCylinders);

		txtRpm = new JTextField();
		txtRpm.setEditable(false);
		txtRpm.setColumns(10);
		txtRpm.setBounds(170, 201, 120, 20);
		contentPane.add(txtRpm);
		
		txtSpeed = new JTextField();
		txtSpeed.setEditable(false);
		txtSpeed.setColumns(10);
		txtSpeed.setBounds(170, 226, 120, 20);
		contentPane.add(txtSpeed);
		
		txtMaxSpeed = new JTextField();
		txtMaxSpeed.setEditable(false);
		txtMaxSpeed.setColumns(10);
		txtMaxSpeed.setBounds(170, 251, 120, 20);
		contentPane.add(txtMaxSpeed);
		
		gaugeRpm = new GaugeRpm();
		gaugeRpm.setOpaque(false);
		gaugeRpm.setBackground(Color.DARK_GRAY);
		gaugeRpm.setBounds(327, 11, 128, 128);
		contentPane.add(gaugeRpm);
		
		txtGearRatio = new JTextField();
		txtGearRatio.setEditable(false);
		txtGearRatio.setColumns(10);
		txtGearRatio.setBounds(170, 276, 120, 20);
		contentPane.add(txtGearRatio);
		
		lblGearRatio = new JLabel("Gear Ratio:");
		lblGearRatio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGearRatio.setBounds(10, 279, 150, 14);
		contentPane.add(lblGearRatio);
		
		cboGamertag = new JComboBox<String>();
		cboGamertag.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				updateFields();
			}
		});
		cboGamertag.setMaximumRowCount(10);
		cboGamertag.setBounds(170, 7, 120, 22);
		contentPane.add(cboGamertag);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
				updateFields();
			}
		});
		btnReset.setBounds(170, 309, 120, 20);
		contentPane.add(btnReset);
		
		drivetrainIcon = new DrivetrainIcon();
		drivetrainIcon.setVisible(false);
		drivetrainIcon.setOpaque(false);
		drivetrainIcon.setBackground(Color.DARK_GRAY);
		drivetrainIcon.setBounds(10, 304, 47, 128);
		contentPane.add(drivetrainIcon);
		
		JPanel pnlRaceTiming = new JPanel();
		pnlRaceTiming.setBackground(Color.DARK_GRAY);
		pnlRaceTiming.setBorder(new LineBorder(Color.GRAY, 2));
		pnlRaceTiming.setBounds(1044, 11, 210, 300);
		contentPane.add(pnlRaceTiming);
		pnlRaceTiming.setLayout(null);
		
		txtAverageLap = new JTextField();
		txtAverageLap.setBounds(10, 236, 150, 40);
		pnlRaceTiming.add(txtAverageLap);
		txtAverageLap.setText("00:00.000");
		txtAverageLap.setOpaque(false);
		txtAverageLap.setHorizontalAlignment(SwingConstants.LEFT);
		txtAverageLap.setForeground(Color.WHITE);
		txtAverageLap.setFont(new Font("Arial", Font.PLAIN, 30));
		txtAverageLap.setColumns(10);
		txtAverageLap.setBorder(null);
		txtAverageLap.setBackground(Color.WHITE);
		
		JLabel lblAverageLap = new JLabel("Average Lap");
		lblAverageLap.setBounds(10, 221, 100, 20);
		pnlRaceTiming.add(lblAverageLap);
		lblAverageLap.setHorizontalAlignment(SwingConstants.LEFT);
		lblAverageLap.setForeground(Color.WHITE);
		lblAverageLap.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAverageLap.setBackground(Color.WHITE);
		
		txtBestLap = new JTextField();
		txtBestLap.setBounds(10, 176, 150, 40);
		pnlRaceTiming.add(txtBestLap);
		txtBestLap.setText("00:00.000");
		txtBestLap.setOpaque(false);
		txtBestLap.setHorizontalAlignment(SwingConstants.LEFT);
		txtBestLap.setForeground(Color.WHITE);
		txtBestLap.setFont(new Font("Arial", Font.PLAIN, 30));
		txtBestLap.setColumns(10);
		txtBestLap.setBorder(null);
		txtBestLap.setBackground(Color.WHITE);
		
		JLabel lblBestLap = new JLabel("Best Lap");
		lblBestLap.setBounds(10, 161, 100, 20);
		pnlRaceTiming.add(lblBestLap);
		lblBestLap.setHorizontalAlignment(SwingConstants.LEFT);
		lblBestLap.setForeground(Color.WHITE);
		lblBestLap.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBestLap.setBackground(Color.WHITE);
		
		txtLastLap = new JTextField();
		txtLastLap.setBounds(10, 116, 150, 40);
		pnlRaceTiming.add(txtLastLap);
		txtLastLap.setText("00:00.000");
		txtLastLap.setOpaque(false);
		txtLastLap.setHorizontalAlignment(SwingConstants.LEFT);
		txtLastLap.setForeground(Color.WHITE);
		txtLastLap.setFont(new Font("Arial", Font.PLAIN, 30));
		txtLastLap.setColumns(10);
		txtLastLap.setBorder(null);
		txtLastLap.setBackground(Color.WHITE);
		
		JLabel lblLastLap = new JLabel("Last Lap");
		lblLastLap.setBounds(10, 101, 100, 20);
		pnlRaceTiming.add(lblLastLap);
		lblLastLap.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastLap.setForeground(Color.WHITE);
		lblLastLap.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLastLap.setBackground(Color.WHITE);
		
		txtCurrentLap = new JTextField();
		txtCurrentLap.setBounds(10, 56, 150, 40);
		pnlRaceTiming.add(txtCurrentLap);
		txtCurrentLap.setOpaque(false);
		txtCurrentLap.setBorder(null);
		txtCurrentLap.setFont(new Font("Arial", Font.PLAIN, 30));
		txtCurrentLap.setText("00:00.000");
		txtCurrentLap.setForeground(Color.WHITE);
		txtCurrentLap.setHorizontalAlignment(SwingConstants.LEFT);
		txtCurrentLap.setBackground(Color.WHITE);
		txtCurrentLap.setColumns(10);
		
		JLabel lblCurrentLap = new JLabel("Current Lap");
		lblCurrentLap.setBounds(10, 41, 100, 20);
		pnlRaceTiming.add(lblCurrentLap);
		lblCurrentLap.setBackground(Color.WHITE);
		lblCurrentLap.setForeground(Color.WHITE);
		lblCurrentLap.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCurrentLap.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblLapTiming = new JLabel("  Lap Timing");
		lblLapTiming.setOpaque(true);
		lblLapTiming.setHorizontalAlignment(SwingConstants.LEFT);
		lblLapTiming.setForeground(Color.WHITE);
		lblLapTiming.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLapTiming.setBackground(Color.GRAY);
		lblLapTiming.setBounds(0, 0, 210, 30);
		pnlRaceTiming.add(lblLapTiming);
		
		txtLastLapDelta = new JTextField();
		txtLastLapDelta.setText("00:00.000");
		txtLastLapDelta.setOpaque(false);
		txtLastLapDelta.setHorizontalAlignment(SwingConstants.RIGHT);
		txtLastLapDelta.setForeground(Color.WHITE);
		txtLastLapDelta.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLastLapDelta.setColumns(10);
		txtLastLapDelta.setBorder(null);
		txtLastLapDelta.setBackground(Color.WHITE);
		txtLastLapDelta.setBounds(44, 101, 100, 20);
		pnlRaceTiming.add(txtLastLapDelta);
		
		JPanel pnlDriverInput = new JPanel();
		pnlDriverInput.setLayout(null);
		pnlDriverInput.setBorder(new LineBorder(Color.GRAY, 2));
		pnlDriverInput.setBackground(Color.DARK_GRAY);
		pnlDriverInput.setBounds(824, 11, 210, 300);
		contentPane.add(pnlDriverInput);
		
		
		JLabel lblPlayerInput = new JLabel("  Driver Input");
		lblPlayerInput.setOpaque(true);
		lblPlayerInput.setBounds(0, 0, 210, 30);
		pnlDriverInput.add(lblPlayerInput);
		lblPlayerInput.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerInput.setForeground(Color.WHITE);
		lblPlayerInput.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPlayerInput.setBackground(Color.GRAY);
		
		txtAccel = new JTextField();
		txtAccel.setOpaque(false);
		txtAccel.setBounds(10, 259, 40, 30);
		pnlDriverInput.add(txtAccel);
		txtAccel.setText("255");
		txtAccel.setHorizontalAlignment(SwingConstants.CENTER);
		txtAccel.setForeground(Color.WHITE);
		txtAccel.setFont(new Font("Arial", Font.PLAIN, 20));
		txtAccel.setColumns(10);
		txtAccel.setBorder(null);
		txtAccel.setBackground(Color.GRAY);

		barSteer = new BarChartSingle(-127, 127, 0, new Color(0,200,200), new Color(0,200,200, 127));
		barSteer.setOpaque(false);
		barSteer.setBounds(10, 37, 190, 40);
		barSteer.setHorizontal(true);
		pnlDriverInput.add(barSteer);

		barAccel = new BarChartSingle(0, 255, 0, new Color(0,200,0), new Color(0,200,0, 127));
		barAccel.setOpaque(false);
		barAccel.setBounds(10, 88, 40, 170);
		pnlDriverInput.add(barAccel);

		barBrake = new BarChartSingle(0, 255, 0, new Color(200,0,0), new Color(200,0,0, 127));
		barBrake.setOpaque(false);
		barAccel.setOpaque(false);
		barBrake.setBounds(60, 88, 40, 170);
		pnlDriverInput.add(barBrake);
		
		barClutch = new BarChartSingle(0, 255, 0, new Color(200,200,0), new Color(200,200,0, 127));
		barClutch.setOpaque(false);
		barAccel.setOpaque(false);
		barClutch.setBounds(110, 88, 40, 170);
		pnlDriverInput.add(barClutch);
		
		barHandbrake = new BarChartSingle(0, 255, 0, new Color(0,0,200), new Color(0,0,200, 127));
		barHandbrake.setOpaque(false);
		barAccel.setOpaque(false);
		barHandbrake.setBounds(160, 88, 40, 170);
		pnlDriverInput.add(barHandbrake);

		txtBrake = new JTextField();
		txtBrake.setText("255");
		txtBrake.setOpaque(false);
		txtBrake.setHorizontalAlignment(SwingConstants.CENTER);
		txtBrake.setForeground(Color.WHITE);
		txtBrake.setFont(new Font("Arial", Font.PLAIN, 20));
		txtBrake.setColumns(10);
		txtBrake.setBorder(null);
		txtBrake.setBackground(Color.GRAY);
		txtBrake.setBounds(60, 259, 40, 30);
		pnlDriverInput.add(txtBrake);
		
		txtClutch = new JTextField();
		txtClutch.setText("255");
		txtClutch.setOpaque(false);
		txtClutch.setHorizontalAlignment(SwingConstants.CENTER);
		txtClutch.setForeground(Color.WHITE);
		txtClutch.setFont(new Font("Arial", Font.PLAIN, 20));
		txtClutch.setColumns(10);
		txtClutch.setBorder(null);
		txtClutch.setBackground(Color.GRAY);
		txtClutch.setBounds(110, 259, 40, 30);
		pnlDriverInput.add(txtClutch);
		
		txtHandbrake = new JTextField();
		txtHandbrake.setText("255");
		txtHandbrake.setOpaque(false);
		txtHandbrake.setHorizontalAlignment(SwingConstants.CENTER);
		txtHandbrake.setForeground(Color.WHITE);
		txtHandbrake.setFont(new Font("Arial", Font.PLAIN, 20));
		txtHandbrake.setColumns(10);
		txtHandbrake.setBorder(null);
		txtHandbrake.setBackground(Color.GRAY);
		txtHandbrake.setBounds(160, 259, 40, 30);
		pnlDriverInput.add(txtHandbrake);
		
		txtTest = new JTextField();
		txtTest.setText("This is a test data field");
		txtTest.setOpaque(false);
		txtTest.setHorizontalAlignment(SwingConstants.LEFT);
		txtTest.setForeground(Color.WHITE);
		txtTest.setFont(new Font("Arial", Font.PLAIN, 30));
		txtTest.setColumns(10);
		txtTest.setBorder(null);
		txtTest.setBackground(Color.WHITE);
		txtTest.setBounds(79, 371, 431, 40);
		contentPane.add(txtTest);
		
		lineSteer = new LineChart(new Point2D.Double(0, -127),new Point2D.Double(4000, 127), new Color(0, 200, 200), new Color(0, 200, 200, 127));
		lineSteer.setOpaque(false);
		lineSteer.setBounds(554, 322, 700, 100);
		lineSteer.setInverted(true);
		contentPane.add(lineSteer);

		lineAccel = new LineChart(new Point2D.Double(0, 0),new Point2D.Double(4000, 255),new Color(0,200,0), new Color(0,200,0, 127));
		lineAccel.setOpaque(false);
		lineAccel.setBounds(554, 433, 700, 100);
		contentPane.add(lineAccel);

		lineBrake = new LineChart(new Point2D.Double(0, 0),new Point2D.Double(4000, 255), new Color(200, 0, 0), new Color(200, 0, 0, 127));
		lineBrake.setOpaque(false);
		lineBrake.setBounds(554, 544, 700, 100);
		contentPane.add(lineBrake);
		
		lineClutch = new LineChart(new Point2D.Double(0, 0),new Point2D.Double(4000, 255), new Color(200, 200, 0), new Color(200, 200, 0, 127));
		lineClutch.setOpaque(false);
		lineClutch.setBounds(554, 655, 700, 100);
		contentPane.add(lineClutch);
		
		lineHandbrake = new LineChart(new Point2D.Double(0, 0),new Point2D.Double(4000, 255), new Color(0, 0, 200), new Color(0, 0, 200, 127));
		lineHandbrake.setOpaque(false);
		lineHandbrake.setBounds(554, 766, 700, 100);
		contentPane.add(lineHandbrake);
		
		txtGear = new JTextField();
		txtGear.setText("6");
		txtGear.setOpaque(false);
		txtGear.setHorizontalAlignment(SwingConstants.LEFT);
		txtGear.setForeground(Color.WHITE);
		txtGear.setFont(getDseg());
		txtGear.setColumns(10);
		txtGear.setBorder(null);
		txtGear.setBackground(Color.WHITE);
		txtGear.setBounds(643, 74, 35, 40);
		contentPane.add(txtGear);
		
		lineTrackMap = new LineChart(new Color(0, 200, 200), new Color(0, 200, 200, 127));
		lineTrackMap.setOpaque(false);
		lineTrackMap.setBounds(10, 443, 500, 500);
		contentPane.add(lineTrackMap);
		
		tglbtnRecordData = new JToggleButton("Record Data");
		tglbtnRecordData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
		        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
		        tglbtnRecordData.setText(abstractButton.getModel().isSelected() ? "Recording Data" : "Record Data");
			}
		});
		tglbtnRecordData.setBounds(318, 148, 137, 25);
		contentPane.add(tglbtnRecordData);

		scatterGForce = new ScatterChart(new Color(0, 200, 200), new Color(0, 200, 200, 127));
		scatterGForce.setOpaque(false);
		scatterGForce.setBounds(554, 148, 150, 150);
		contentPane.add(scatterGForce);
	}
	/**
	 * Function to update the displayed fields
	 */
    public void updateFields() {
    	super.updateFields();
    	getPlayersReadWriteLock().readLock().lock();
    	try {
	    	DecimalFormat df2 = new DecimalFormat("#.00");
	    	DecimalFormat df3 = new DecimalFormat("#.000");
	    	for (Player currPlayer : super.getPlayers()) {
	    		if(((DefaultComboBoxModel<String>)cboGamertag.getModel()).getIndexOf(currPlayer.getGamertag()) == -1) {
					cboGamertag.addItem(currPlayer.getGamertag());
				}
	    		if (currPlayer == this.getSelectedPlayer() && currPlayer.getTelemetryPacket() != null) {
	    			double finalDrive = 2.5;
			    	this.txtNetworkDetails.setText(currPlayer.getIpAddress());
			        this.txtCarName.setText(Integer.toString(currPlayer.getTelemetryPacket().getCarOrdinal()));
			        this.txtClass.setText(String.valueOf(currPlayer.getTelemetryPacket().getCarClass().toString()));
			        this.txtPerformanceIndex.setText(Integer.toString(currPlayer.getTelemetryPacket().getCarPerformanceIndex()));
			        this.txtDrivetrainType.setText(currPlayer.getTelemetryPacket().getEngine().getDrivetrainType().toString());
			        this.txtNumCylinders.setText(Integer.toString(currPlayer.getTelemetryPacket().getEngine().getNumCylinders()));
			
			        this.txtRpm.setText(df2.format(currPlayer.getTelemetryPacket().getEngine().getCurrentEngineRpm()));
			        this.txtSpeed.setText(df2.format(currPlayer.getTelemetryPacket().getVelocity().getSpeed(Speed.MPH)));
			        this.txtMaxSpeed.setText(df2.format(currPlayer.getMaxSpeed(Speed.MPH)));
	
			        this.txtGearRatio.setText(df3.format(currPlayer.getTelemetryPacket().getGearRatio(finalDrive)));
			
			        this.gaugeRpm.setRpm((double)currPlayer.getTelemetryPacket().getEngine().getCurrentEngineRpm());
			        this.gaugeRpm.repaint();
			        
			        this.drivetrainIcon.setDrivetrain(currPlayer.getTelemetryPacket().getEngine().getDrivetrainType());
			        this.txtCurrentLap.setText(Calc.secondsToTime((currPlayer.getTelemetryPacket().getTrack().getCurrentLap())));
			        this.txtLastLap.setText(Calc.secondsToTime((currPlayer.getTelemetryPacket().getTrack().getLastLap())));
			        this.txtBestLap.setText(Calc.secondsToTime((currPlayer.getTelemetryPacket().getTrack().getBestLap())));
			        this.txtAverageLap.setText(Calc.secondsToTime((currPlayer.getAverageLap())));
			        float lapDelta = currPlayer.getLastLapDelta();
			        Color lapDeltaColor;
			        if (lapDelta > 0) {
			        	lapDeltaColor = Color.RED;
			        } else if (lapDelta < 0) {
			        	lapDeltaColor = Color.GREEN;
			        } else {
			        	lapDeltaColor = Color.WHITE;
			        }
			        this.txtLastLapDelta.setText(Calc.secondsToTime(lapDelta));
			        this.txtLastLap.setForeground(lapDeltaColor);
			        this.txtLastLapDelta.setForeground(lapDeltaColor);
			        
			        this.txtAccel.setText(Short.toString(currPlayer.getTelemetryPacket().getPlayerInput().getAccel()));
			        this.barAccel.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getAccel());
			        this.barAccel.repaint();
			        this.txtBrake.setText(Short.toString(currPlayer.getTelemetryPacket().getPlayerInput().getBrake()));
			        this.barBrake.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getBrake());
			        this.barBrake.repaint();
			        this.txtClutch.setText(Short.toString(currPlayer.getTelemetryPacket().getPlayerInput().getClutch()));
			        this.barClutch.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getClutch());
			        this.barClutch.repaint();
			        this.txtHandbrake.setText(Short.toString(currPlayer.getTelemetryPacket().getPlayerInput().getHandbrake()));
			        this.barHandbrake.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getHandbrake());
			        this.barHandbrake.repaint();
			        this.barSteer.setValue(currPlayer.getTelemetryPacket().getPlayerInput().getSteer());
			        this.barSteer.repaint();
			        
			        this.lineSteer.addValue(new Point2D.Double(currPlayer.getTelemetryPacket().getTrack().getDistanceTraveled(), currPlayer.getTelemetryPacket().getPlayerInput().getSteer()));
			        this.lineSteer.repaint();
			        this.lineAccel.addValue(new Point2D.Double(currPlayer.getTelemetryPacket().getTrack().getDistanceTraveled(), currPlayer.getTelemetryPacket().getPlayerInput().getAccel()));
			        this.lineAccel.repaint();
			        this.lineBrake.addValue(new Point2D.Double(currPlayer.getTelemetryPacket().getTrack().getDistanceTraveled(), currPlayer.getTelemetryPacket().getPlayerInput().getBrake()));
			        this.lineBrake.repaint();
			        this.lineClutch.addValue(new Point2D.Double(currPlayer.getTelemetryPacket().getTrack().getDistanceTraveled(), currPlayer.getTelemetryPacket().getPlayerInput().getClutch()));
			        this.lineClutch.repaint();
			        this.lineHandbrake.addValue(new Point2D.Double(currPlayer.getTelemetryPacket().getTrack().getDistanceTraveled(), currPlayer.getTelemetryPacket().getPlayerInput().getHandbrake()));
			        this.lineHandbrake.repaint();
			        this.lineTrackMap.addValue(new Point2D.Double(currPlayer.getTelemetryPacket().getTrack().getPositionX(), currPlayer.getTelemetryPacket().getTrack().getPositionZ()));
			        this.lineTrackMap.repaint();
			        this.scatterGForce.addValue(new Point2D.Double(currPlayer.getTelemetryPacket().getVelocity().getAccelerationX(), currPlayer.getTelemetryPacket().getVelocity().getAccelerationZ()));
			        this.scatterGForce.repaint();
			        
	
			        this.txtGear.setText(Short.toString(currPlayer.getTelemetryPacket().getEngine().getGear()));
			        getSelectedPlayer().setRecording(this.tglbtnRecordData.isSelected());
	
	    		
			        this.txtTest.setText(Float.toString(currPlayer.getTelemetryPacket().getVelocity().getAccelerationX()));
	    		}
	    	}
    	} finally {
    		getPlayersReadWriteLock().readLock().unlock();
    	}
    }

    
    public void setReceivingTraffic(boolean receiving) {
    	
    }
    
    private Player getSelectedPlayer() {
    	return super.getSelectedPlayer(cboGamertag.getSelectedItem().toString());
    }
    
    public void reset() {
    	super.reset();
    	this.getSelectedPlayer().reset();
    	this.lineSteer.reset();
    	this.lineAccel.reset();
    	this.lineBrake.reset();
    	this.lineClutch.reset();
    	this.lineHandbrake.reset();
    	this.lineTrackMap.reset();
    	this.scatterGForce.reset();
    	
    }
}
