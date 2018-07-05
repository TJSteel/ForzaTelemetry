package ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Speed;
import forza.Player;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class TelemetryUI extends JFrame {

	/**
	 * 
	 */
	private ArrayList<Player> players;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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

	/**
	 * Create the frame.
	 */
	public TelemetryUI(ArrayList<Player> players) {
		this.players = players;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
				getSelectedPlayer().reset();
				updateFields();
			}
		});
		btnReset.setBounds(170, 309, 120, 20);
		contentPane.add(btnReset);
		
		drivetrainIcon = new DrivetrainIcon();
		drivetrainIcon.setBounds(327, 148, 47, 128);
		contentPane.add(drivetrainIcon);

		updateFields();
	}
	
	/**
	 * Function to update the displayed fields
	 */
    public void updateFields() {

    	for (Player currPlayer : this.players) {
    		if(((DefaultComboBoxModel<String>)cboGamertag.getModel()).getIndexOf(currPlayer.getGamertag()) == -1) {
				cboGamertag.addItem(currPlayer.getGamertag());
			}
    		if (currPlayer == this.getSelectedPlayer()) {
	    		double finalDrive = 2.5;
		    	this.txtNetworkDetails.setText(currPlayer.getIpAddress());
		        this.txtCarName.setText(Integer.toString(currPlayer.getCar().getCarOrdinal()));
		        this.txtClass.setText(String.valueOf(currPlayer.getCar().getCarClass().toString()));
		        this.txtPerformanceIndex.setText(Integer.toString(currPlayer.getCar().getCarPerformanceIndex()));
		        this.txtDrivetrainType.setText(currPlayer.getCar().getEngine().getDrivetrainType().toString());
		        this.txtNumCylinders.setText(Integer.toString(currPlayer.getCar().getEngine().getNumCylinders()));
		
		        this.txtRpm.setText(Double.toString(Math.round(currPlayer.getCar().getEngine().getCurrentEngineRpm()*100)/100d));
		        this.txtSpeed.setText(Double.toString(Math.round(currPlayer.getCar().getVelocity().getSpeed(Speed.MPH)*100)/100d));
		        this.txtMaxSpeed.setText(Double.toString(Math.round(currPlayer.getCar().getVelocity().getMaxSpeed(Speed.MPH)*100)/100d));

		        this.txtGearRatio.setText(Double.toString(Math.round(currPlayer.getCar().getGearRatio(finalDrive)*1000)/1000d));
		
		        this.gaugeRpm.setRpm((double)currPlayer.getCar().getEngine().getCurrentEngineRpm());
		        this.gaugeRpm.repaint();
		        
		        this.drivetrainIcon.setDrivetrain(currPlayer.getCar().getEngine().getDrivetrainType());
    		}
    	}
    }	
    private Player getSelectedPlayer() {
    	Player returnPlayer = new Player();
    	for (Player currPlayer : this.players) {
    		if (cboGamertag.getSelectedItem().toString().equals(currPlayer.getGamertag())) {
    			returnPlayer = currPlayer;
    		}
    	}
    	return returnPlayer;
    }
}
