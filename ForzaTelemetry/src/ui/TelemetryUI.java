package ui;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import forza.Player;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class TelemetryUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GaugeRpm gaugeRpm;
	private JTextField txtGamertag;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelemetryUI frame = new TelemetryUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public TelemetryUI() {
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
		
		lblRpm = new JLabel("Rpm:");
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

		txtGamertag = new JTextField();
		txtGamertag.setBounds(170, 11, 120, 20);
		contentPane.add(txtGamertag);
		txtGamertag.setColumns(10);
		
		txtNetworkDetails = new JTextField();
		txtNetworkDetails.setColumns(10);
		txtNetworkDetails.setBounds(170, 36, 120, 20);
		contentPane.add(txtNetworkDetails);
		
		txtCarName = new JTextField();
		txtCarName.setColumns(10);
		txtCarName.setBounds(170, 64, 120, 20);
		contentPane.add(txtCarName);
		
		txtClass = new JTextField();
		txtClass.setColumns(10);
		txtClass.setBounds(170, 92, 120, 20);
		contentPane.add(txtClass);
		
		txtPerformanceIndex = new JTextField();
		txtPerformanceIndex.setColumns(10);
		txtPerformanceIndex.setBounds(170, 120, 120, 20);
		contentPane.add(txtPerformanceIndex);
		
		txtDrivetrainType = new JTextField();
		txtDrivetrainType.setColumns(10);
		txtDrivetrainType.setBounds(170, 148, 120, 20);
		contentPane.add(txtDrivetrainType);
		
		txtNumCylinders = new JTextField();
		txtNumCylinders.setColumns(10);
		txtNumCylinders.setBounds(170, 176, 120, 20);
		contentPane.add(txtNumCylinders);

		txtRpm = new JTextField();
		txtRpm.setColumns(10);
		txtRpm.setBounds(170, 201, 120, 20);
		contentPane.add(txtRpm);
		
		txtSpeed = new JTextField();
		txtSpeed.setColumns(10);
		txtSpeed.setBounds(170, 226, 120, 20);
		contentPane.add(txtSpeed);
		
		txtMaxSpeed = new JTextField();
		txtMaxSpeed.setColumns(10);
		txtMaxSpeed.setBounds(170, 254, 120, 20);
		contentPane.add(txtMaxSpeed);
		
		gaugeRpm = new GaugeRpm();
		gaugeRpm.setBounds(312, 11, 128, 128);
		contentPane.add(gaugeRpm);
		
		txtGearRatio = new JTextField();
		txtGearRatio.setColumns(10);
		txtGearRatio.setBounds(170, 279, 120, 20);
		contentPane.add(txtGearRatio);
		
		JLabel lblGearRatio = new JLabel("Gear Ratio:");
		lblGearRatio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGearRatio.setBounds(10, 279, 150, 14);
		contentPane.add(lblGearRatio);
	}
	
	/**
	 * Function to update the fields when a player is passed to it
	 */
    public void updateFields(Player currPlayer) {

    	double finalDrive = 2.5;
    	this.txtGamertag.setText(currPlayer.getGamertag());
        this.txtNetworkDetails.setText(currPlayer.getIpAddress());
        this.txtCarName.setText(Integer.toString(currPlayer.getCar().getCarOrdinal()));
        this.txtClass.setText(String.valueOf(currPlayer.getCar().getCarClass()));
        this.txtPerformanceIndex.setText(Integer.toString(currPlayer.getCar().getCarPerformanceIndex()));
        this.txtDrivetrainType.setText(currPlayer.getCar().getEngine().getDrivetrainType());
        this.txtNumCylinders.setText(Integer.toString(currPlayer.getCar().getEngine().getNumCylinders()));

        this.txtRpm.setText(Double.toString(Math.round(currPlayer.getCar().getEngine().getCurrentEngineRpm()*100)/100d));
        this.txtSpeed.setText(Double.toString(Math.round(currPlayer.getCar().getVelocity().getSpeed("MPH")*100)/100d));
        this.txtMaxSpeed.setText(Double.toString(Math.round(currPlayer.getCar().getVelocity().getMaxSpeed("MPH")*100)/100d));

        this.gaugeRpm.setRpm((double)currPlayer.getCar().getEngine().getCurrentEngineRpm());
        this.gaugeRpm.repaint();
        
        this.txtGearRatio.setText(Double.toString(Math.round(currPlayer.getCar().getGearRatio(finalDrive)*1000)/1000d));
    }	
}
