package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.FlowLayout;

public class DashboardUI extends DefaultUI {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public DashboardUi() {
		setAutoRequestFocus(false);
		setOpacity(0.0f);
		setFont(null);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 200, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		panel.setBackground(Color.BLACK);
		panel.setBounds(279, 11, 706, 659);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setForeground(Color.WHITE);
		panel_13.setBackground(Color.BLACK);
		panel_13.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_13.setBounds(10, 120, 344, 124);
		panel.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("00:00:000");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 29, 343, 93);
		lblNewLabel_2.setLabelFor(panel_13);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 72));
		panel_13.add(lblNewLabel_2);
		
		JPanel Current_Lap_Box_Heading = new JPanel();
		Current_Lap_Box_Heading.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Current_Lap_Box_Heading.setBackground(Color.BLACK);
		Current_Lap_Box_Heading.setBounds(0, 0, 344, 32);
		panel_13.add(Current_Lap_Box_Heading);
		Current_Lap_Box_Heading.setLayout(null);
		
		JLabel Current_Lap_Heading = new JLabel("CURRENT LAP");
		Current_Lap_Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Current_Lap_Heading.setBounds(0, 0, 343, 34);
		Current_Lap_Heading.setFont(new Font("Calibri", Font.BOLD, 19));
		Current_Lap_Heading.setForeground(Color.WHITE);
		Current_Lap_Box_Heading.add(Current_Lap_Heading);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_2.setForeground(Color.YELLOW);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(59, 11, 48, 98);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_3.setForeground(Color.YELLOW);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(108, 11, 48, 98);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_4.setForeground(Color.YELLOW);
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(157, 11, 48, 98);
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_5.setForeground(Color.YELLOW);
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(206, 11, 48, 98);
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_6.setForeground(Color.BLUE);
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(255, 11, 48, 98);
		panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_7.setForeground(Color.BLACK);
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(304, 11, 48, 98);
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_8.setForeground(Color.BLACK);
		panel_8.setBackground(Color.BLACK);
		panel_8.setBounds(353, 11, 48, 98);
		panel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_9.setForeground(Color.BLACK);
		panel_9.setBackground(Color.BLACK);
		panel_9.setBounds(402, 11, 48, 98);
		panel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_10.setForeground(Color.BLACK);
		panel_10.setBackground(Color.BLACK);
		panel_10.setBounds(451, 11, 48, 98);
		panel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_11.setForeground(Color.BLUE);
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(500, 11, 48, 98);
		panel.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_12.setForeground(Color.BLUE);
		panel_12.setBackground(Color.BLACK);
		panel_12.setBounds(549, 11, 48, 98);
		panel.add(panel_12);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_16.setForeground(Color.BLUE);
		panel_16.setBackground(Color.BLACK);
		panel_16.setBounds(598, 11, 48, 98);
		panel.add(panel_16);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_1.setBounds(10, 255, 344, 124);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_4 = new JLabel("00:00:000");
		label_4.setBounds(0, 29, 344, 93);
		label_4.setLabelFor(panel_1);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 72));
		panel_1.add(label_4);
		
		JPanel Best_Lap_Box = new JPanel();
		Best_Lap_Box.setLayout(null);
		Best_Lap_Box.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Best_Lap_Box.setBackground(Color.BLACK);
		Best_Lap_Box.setBounds(0, 0, 344, 32);
		panel_1.add(Best_Lap_Box);
		
		JLabel Best_Lap_Heading = new JLabel("FASTEST LAP");
		Best_Lap_Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Best_Lap_Heading.setForeground(Color.WHITE);
		Best_Lap_Heading.setFont(new Font("Calibri", Font.BOLD, 19));
		Best_Lap_Heading.setBounds(0, 0, 344, 34);
		Best_Lap_Box.add(Best_Lap_Heading);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_14.setBackground(Color.BLACK);
		panel_14.setBounds(10, 390, 124, 124);
		panel.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel label_7 = new JLabel("0");
		label_7.setBounds(0, 29, 124, 93);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 64));
		panel_14.add(label_7);
		
		JPanel Front_Left_Heading_Box = new JPanel();
		Front_Left_Heading_Box.setLayout(null);
		Front_Left_Heading_Box.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Front_Left_Heading_Box.setBackground(Color.BLACK);
		Front_Left_Heading_Box.setBounds(0, 0, 124, 32);
		panel_14.add(Front_Left_Heading_Box);
		
		JLabel Front_Letf_Temp_Heading = new JLabel("FRONT LEFT TEMP");
		Front_Letf_Temp_Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Front_Letf_Temp_Heading.setForeground(Color.WHITE);
		Front_Letf_Temp_Heading.setFont(new Font("Calibri", Font.BOLD, 13));
		Front_Letf_Temp_Heading.setBounds(0, 0, 124, 34);
		Front_Left_Heading_Box.add(Front_Letf_Temp_Heading);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.BLACK);
		panel_15.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_15.setBounds(10, 524, 124, 124);
		panel.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel label_8 = new JLabel("0");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 64));
		label_8.setBounds(0, 29, 124, 93);
		panel_15.add(label_8);
		
		JPanel Rear_Left_Temp_Box_Heading = new JPanel();
		Rear_Left_Temp_Box_Heading.setLayout(null);
		Rear_Left_Temp_Box_Heading.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Rear_Left_Temp_Box_Heading.setBackground(Color.BLACK);
		Rear_Left_Temp_Box_Heading.setBounds(0, 0, 124, 32);
		panel_15.add(Rear_Left_Temp_Box_Heading);
		
		JLabel Rear_Left_Temp_Heading = new JLabel("REAR LEFT TEMP");
		Rear_Left_Temp_Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Rear_Left_Temp_Heading.setForeground(Color.WHITE);
		Rear_Left_Temp_Heading.setFont(new Font("Calibri", Font.BOLD, 13));
		Rear_Left_Temp_Heading.setBounds(0, 0, 124, 34);
		Rear_Left_Temp_Box_Heading.add(Rear_Left_Temp_Heading);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_17.setBackground(Color.BLACK);
		panel_17.setBounds(352, 120, 344, 124);
		panel.add(panel_17);
		panel_17.setLayout(null);
		
		JLabel label_2 = new JLabel("+0");
		label_2.setBounds(0, 31, 343, 93);
		label_2.setLabelFor(panel_17);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 72));
		panel_17.add(label_2);
		
		JPanel Delta_Heading_Box = new JPanel();
		Delta_Heading_Box.setLayout(null);
		Delta_Heading_Box.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Delta_Heading_Box.setBackground(Color.BLACK);
		Delta_Heading_Box.setBounds(0, 0, 344, 32);
		panel_17.add(Delta_Heading_Box);
		
		JLabel Delta_Heading = new JLabel("LAP DELTA");
		Delta_Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Delta_Heading.setForeground(Color.WHITE);
		Delta_Heading.setFont(new Font("Calibri", Font.BOLD, 19));
		Delta_Heading.setBounds(0, 0, 343, 34);
		Delta_Heading_Box.add(Delta_Heading);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_18.setBackground(Color.BLACK);
		panel_18.setBounds(352, 255, 344, 124);
		panel.add(panel_18);
		panel_18.setLayout(null);
		
		JLabel label_3 = new JLabel("00:00:000");
		label_3.setBounds(0, 29, 344, 93);
		label_3.setLabelFor(panel_18);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 72));
		panel_18.add(label_3);
		
		JPanel Race_Time_Box_Heading = new JPanel();
		Race_Time_Box_Heading.setLayout(null);
		Race_Time_Box_Heading.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Race_Time_Box_Heading.setBackground(Color.BLACK);
		Race_Time_Box_Heading.setBounds(0, 0, 344, 32);
		panel_18.add(Race_Time_Box_Heading);
		
		JLabel Race_Time_Heading = new JLabel("RACE TIME");
		Race_Time_Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Race_Time_Heading.setForeground(Color.WHITE);
		Race_Time_Heading.setFont(new Font("Calibri", Font.BOLD, 19));
		Race_Time_Heading.setBounds(0, 0, 344, 34);
		Race_Time_Box_Heading.add(Race_Time_Heading);
		
		JPanel panel_19 = new JPanel();
		panel_19.setForeground(Color.WHITE);
		panel_19.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_19.setBackground(Color.BLACK);
		panel_19.setBounds(452, 390, 244, 124);
		panel.add(panel_19);
		panel_19.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("0");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 96));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setLabelFor(panel_19);
		lblNewLabel_4.setToolTipText("");
		lblNewLabel_4.setBounds(0, 28, 244, 93);
		panel_19.add(lblNewLabel_4);
		
		JPanel panel_30 = new JPanel();
		panel_30.setLayout(null);
		panel_30.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_30.setBackground(Color.BLACK);
		panel_30.setBounds(0, 0, 244, 32);
		panel_19.add(panel_30);
		
		JLabel lblSpeedKmh = new JLabel("SPEED KM/H");
		lblSpeedKmh.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpeedKmh.setForeground(Color.WHITE);
		lblSpeedKmh.setFont(new Font("Calibri", Font.BOLD, 19));
		lblSpeedKmh.setBounds(0, 0, 244, 34);
		panel_30.add(lblSpeedKmh);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_20.setBackground(Color.BLACK);
		panel_20.setBounds(572, 524, 124, 124);
		panel.add(panel_20);
		panel_20.setLayout(null);
		
		JLabel label = new JLabel("100.00");
		label.setBounds(0, 29, 124, 93);
		label.setLabelFor(panel_20);
		panel_20.add(label);
		label.setToolTipText("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		JPanel panel_32 = new JPanel();
		panel_32.setLayout(null);
		panel_32.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_32.setBackground(Color.BLACK);
		panel_32.setBounds(0, 0, 124, 32);
		panel_20.add(panel_32);
		
		JLabel lblFuelPercentage = new JLabel("FUEL PERCENTAGE");
		lblFuelPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelPercentage.setForeground(Color.WHITE);
		lblFuelPercentage.setFont(new Font("Calibri", Font.BOLD, 14));
		lblFuelPercentage.setBounds(0, 0, 124, 34);
		panel_32.add(lblFuelPercentage);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_21.setBackground(Color.BLACK);
		panel_21.setBounds(264, 390, 176, 258);
		panel.add(panel_21);
		panel_21.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("N");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(lblNewLabel_1.getFont().deriveFont(162f));
		lblNewLabel_1.setBounds(0, 31, 176, 227);
		panel_21.add(lblNewLabel_1);
		
		JPanel panel_28 = new JPanel();
		panel_28.setLayout(null);
		panel_28.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_28.setBackground(Color.BLACK);
		panel_28.setBounds(0, 0, 176, 32);
		panel_21.add(panel_28);
		
		JLabel lblGearSelection = new JLabel("GEAR SELECTION");
		lblGearSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblGearSelection.setForeground(Color.WHITE);
		lblGearSelection.setFont(new Font("Calibri", Font.BOLD, 15));
		lblGearSelection.setBounds(0, 0, 176, 34);
		panel_28.add(lblGearSelection);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_22.setBackground(Color.BLACK);
		panel_22.setBounds(130, 390, 124, 124);
		panel.add(panel_22);
		panel_22.setLayout(null);
		
		JLabel label_6 = new JLabel("0");
		label_6.setBounds(3, 29, 121, 93);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 64));
		panel_22.add(label_6);
		
		JPanel Front_Right_Temp_Box_Heading = new JPanel();
		Front_Right_Temp_Box_Heading.setLayout(null);
		Front_Right_Temp_Box_Heading.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Front_Right_Temp_Box_Heading.setBackground(Color.BLACK);
		Front_Right_Temp_Box_Heading.setBounds(0, 0, 124, 32);
		panel_22.add(Front_Right_Temp_Box_Heading);
		
		JLabel lblFrontRightTemp = new JLabel("FRONT RIGHT TEMP");
		lblFrontRightTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrontRightTemp.setForeground(Color.WHITE);
		lblFrontRightTemp.setFont(new Font("Calibri", Font.BOLD, 13));
		lblFrontRightTemp.setBounds(1, 0, 124, 34);
		Front_Right_Temp_Box_Heading.add(lblFrontRightTemp);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_23.setBackground(Color.BLACK);
		panel_23.setBounds(130, 524, 124, 124);
		panel.add(panel_23);
		panel_23.setLayout(null);
		
		JLabel label_5 = new JLabel("0");
		label_5.setBackground(Color.BLACK);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 64));
		label_5.setLabelFor(panel_23);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(3, 29, 120, 93);
		panel_23.add(label_5);
		
		JPanel panel_29 = new JPanel();
		panel_29.setLayout(null);
		panel_29.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_29.setBackground(Color.BLACK);
		panel_29.setBounds(3, 0, 121, 32);
		panel_23.add(panel_29);
		
		JLabel lblRearRightTemp = new JLabel("REAR RIGHT TEMP");
		lblRearRightTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblRearRightTemp.setForeground(Color.WHITE);
		lblRearRightTemp.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRearRightTemp.setBounds(0, 0, 119, 34);
		panel_29.add(lblRearRightTemp);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_25.setBackground(Color.BLACK);
		panel_25.setBounds(452, 524, 124, 124);
		panel.add(panel_25);
		panel_25.setLayout(null);
		
		JLabel lblNa = new JLabel("N/A");
		lblNa.setBounds(0, 29, 121, 93);
		lblNa.setLabelFor(panel_25);
		panel_25.add(lblNa);
		lblNa.setToolTipText("");
		lblNa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNa.setForeground(Color.WHITE);
		lblNa.setFont(new Font("Tahoma", Font.PLAIN, 64));
		
		JPanel panel_31 = new JPanel();
		panel_31.setLayout(null);
		panel_31.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_31.setBackground(Color.BLACK);
		panel_31.setBounds(0, 0, 124, 32);
		panel_25.add(panel_31);
		
		JLabel lblFuelLapsRemaining = new JLabel("FUEL LAPS REMAINING");
		lblFuelLapsRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelLapsRemaining.setForeground(Color.WHITE);
		lblFuelLapsRemaining.setFont(new Font("Calibri", Font.BOLD, 11));
		lblFuelLapsRemaining.setBounds(0, 0, 121, 34);
		panel_31.add(lblFuelLapsRemaining);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_24.setForeground(Color.YELLOW);
		panel_24.setBackground(Color.BLACK);
		panel_24.setBounds(10, 11, 48, 98);
		panel.add(panel_24);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		panel_26.setForeground(Color.BLUE);
		panel_26.setBackground(Color.BLACK);
		panel_26.setBounds(647, 11, 48, 98);
		panel.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(255, 255, 255)));
		panel_27.setBackground(Color.BLACK);
		panel_27.setForeground(Color.BLACK);
		panel_27.setBounds(0, -11, 268, 681);
		contentPane.add(panel_27);
		panel_27.setLayout(null);
		
		JPanel GAMERTAG_Heading = new JPanel();
		GAMERTAG_Heading.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		GAMERTAG_Heading.setBackground(Color.BLACK);
		GAMERTAG_Heading.setLayout(null);
		GAMERTAG_Heading.setBounds(0, 0, 134, 32);
		panel_27.add(GAMERTAG_Heading);
		
		JLabel lblGamertag = new JLabel("GAMERTAG");
		lblGamertag.setForeground(Color.WHITE);
		lblGamertag.setLabelFor(GAMERTAG_Heading);
		lblGamertag.setHorizontalAlignment(SwingConstants.LEFT);
		lblGamertag.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGamertag.setBounds(9, 0, 124, 32);
		GAMERTAG_Heading.add(lblGamertag);
		
		JPanel Gamertag_Username = new JPanel();
		Gamertag_Username.setForeground(new Color(0, 0, 0));
		Gamertag_Username.setBackground(Color.BLACK);
		Gamertag_Username.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(255, 255, 255)));
		Gamertag_Username.setLayout(null);
		Gamertag_Username.setBounds(134, 0, 134, 32);
		panel_27.add(Gamertag_Username);
		
		JLabel lblNewLabel_6 = new JLabel("Evan Mulcahy");
		lblNewLabel_6.setLabelFor(Gamertag_Username);
		lblNewLabel_6.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(15, 0, 119, 32);
		Gamertag_Username.add(lblNewLabel_6);
		
		JPanel NETWORK_Heading = new JPanel();
		NETWORK_Heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		NETWORK_Heading.setBackground(Color.BLACK);
		NETWORK_Heading.setBounds(0, 30, 134, 32);
		panel_27.add(NETWORK_Heading);
		NETWORK_Heading.setLayout(null);
		
		JLabel lblNetwork = new JLabel("NETWORK");
		lblNetwork.setForeground(Color.WHITE);
		lblNetwork.setBounds(9, 0, 124, 32);
		lblNetwork.setLabelFor(NETWORK_Heading);
		lblNetwork.setHorizontalAlignment(SwingConstants.LEFT);
		lblNetwork.setFont(new Font("Tahoma", Font.BOLD, 17));
		NETWORK_Heading.add(lblNetwork);
		
		JPanel Network_IP = new JPanel();
		Network_IP.setBackground(Color.BLACK);
		Network_IP.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		Network_IP.setBounds(134, 30, 134, 32);
		panel_27.add(Network_IP);
		Network_IP.setLayout(null);
		
		JLabel label_10 = new JLabel("192.168.1.93");
		label_10.setLabelFor(Network_IP);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		label_10.setBounds(15, 0, 119, 32);
		Network_IP.add(label_10);
		
		JPanel Vehicle_Name = new JPanel();
		Vehicle_Name.setLayout(null);
		Vehicle_Name.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		Vehicle_Name.setBackground(Color.BLACK);
		Vehicle_Name.setBounds(134, 60, 134, 32);
		panel_27.add(Vehicle_Name);
		
		JLabel lblMclarenP = new JLabel("McLaren P1");
		lblMclarenP.setLabelFor(Vehicle_Name);
		lblMclarenP.setHorizontalAlignment(SwingConstants.CENTER);
		lblMclarenP.setForeground(Color.WHITE);
		lblMclarenP.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblMclarenP.setBounds(15, 0, 119, 32);
		Vehicle_Name.add(lblMclarenP);
		
		JPanel Vehicle_Class = new JPanel();
		Vehicle_Class.setLayout(null);
		Vehicle_Class.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		Vehicle_Class.setBackground(Color.BLACK);
		Vehicle_Class.setBounds(134, 90, 134, 32);
		panel_27.add(Vehicle_Class);
		
		JLabel lblR = new JLabel("R");
		lblR.setLabelFor(Vehicle_Class);
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setForeground(Color.WHITE);
		lblR.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblR.setBounds(15, 0, 119, 32);
		Vehicle_Class.add(lblR);
		
		JPanel Performance_Index_Figure = new JPanel();
		Performance_Index_Figure.setLayout(null);
		Performance_Index_Figure.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		Performance_Index_Figure.setBackground(Color.BLACK);
		Performance_Index_Figure.setBounds(134, 120, 134, 32);
		panel_27.add(Performance_Index_Figure);
		
		JLabel lblR_1 = new JLabel("866");
		lblR_1.setLabelFor(Performance_Index_Figure);
		lblR_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblR_1.setForeground(Color.WHITE);
		lblR_1.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblR_1.setBounds(15, 0, 119, 32);
		Performance_Index_Figure.add(lblR_1);
		
		JPanel VEHICLE_Heading = new JPanel();
		VEHICLE_Heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		VEHICLE_Heading.setBackground(Color.BLACK);
		VEHICLE_Heading.setBounds(0, 60, 134, 32);
		panel_27.add(VEHICLE_Heading);
		VEHICLE_Heading.setLayout(null);
		
		JLabel lblVehicle = new JLabel("VEHICLE");
		lblVehicle.setForeground(Color.WHITE);
		lblVehicle.setBounds(9, 0, 124, 32);
		lblVehicle.setLabelFor(VEHICLE_Heading);
		lblVehicle.setHorizontalAlignment(SwingConstants.LEFT);
		lblVehicle.setFont(new Font("Tahoma", Font.BOLD, 17));
		VEHICLE_Heading.add(lblVehicle);
		
		JPanel CLASS_Heading = new JPanel();
		CLASS_Heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		CLASS_Heading.setBackground(Color.BLACK);
		CLASS_Heading.setBounds(0, 90, 134, 32);
		panel_27.add(CLASS_Heading);
		CLASS_Heading.setLayout(null);
		
		JLabel lblClass = new JLabel("CLASS");
		lblClass.setForeground(Color.WHITE);
		lblClass.setBounds(9, 0, 124, 32);
		lblClass.setLabelFor(CLASS_Heading);
		lblClass.setHorizontalAlignment(SwingConstants.LEFT);
		lblClass.setFont(new Font("Tahoma", Font.BOLD, 17));
		CLASS_Heading.add(lblClass);
		
		JPanel PI_Heading = new JPanel();
		PI_Heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		PI_Heading.setBackground(Color.BLACK);
		PI_Heading.setBounds(0, 120, 134, 32);
		panel_27.add(PI_Heading);
		PI_Heading.setLayout(null);
		
		JLabel lblPi = new JLabel("PI");
		lblPi.setForeground(Color.WHITE);
		lblPi.setBounds(9, 0, 124, 32);
		lblPi.setLabelFor(PI_Heading);
		lblPi.setHorizontalAlignment(SwingConstants.LEFT);
		lblPi.setFont(new Font("Tahoma", Font.BOLD, 17));
		PI_Heading.add(lblPi);
		
		JPanel Drivetrain_Type = new JPanel();
		Drivetrain_Type.setLayout(null);
		Drivetrain_Type.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		Drivetrain_Type.setBackground(Color.BLACK);
		Drivetrain_Type.setBounds(134, 150, 134, 32);
		panel_27.add(Drivetrain_Type);
		
		JLabel lblRwd = new JLabel("RWD");
		lblRwd.setLabelFor(Drivetrain_Type);
		lblRwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblRwd.setForeground(Color.WHITE);
		lblRwd.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblRwd.setBounds(15, 0, 119, 32);
		Drivetrain_Type.add(lblRwd);
		
		JPanel DRIVETRAIN_Heading = new JPanel();
		DRIVETRAIN_Heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		DRIVETRAIN_Heading.setLayout(null);
		DRIVETRAIN_Heading.setBackground(Color.BLACK);
		DRIVETRAIN_Heading.setBounds(0, 150, 134, 32);
		panel_27.add(DRIVETRAIN_Heading);
		
		JLabel lblDrivetrain = new JLabel("DRIVETRAIN");
		lblDrivetrain.setForeground(Color.WHITE);
		lblDrivetrain.setLabelFor(DRIVETRAIN_Heading);
		lblDrivetrain.setHorizontalAlignment(SwingConstants.LEFT);
		lblDrivetrain.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDrivetrain.setBounds(9, 0, 124, 32);
		DRIVETRAIN_Heading.add(lblDrivetrain);
		
		JPanel Number_of_Cylinders_Figure = new JPanel();
		Number_of_Cylinders_Figure.setLayout(null);
		Number_of_Cylinders_Figure.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		Number_of_Cylinders_Figure.setBackground(Color.BLACK);
		Number_of_Cylinders_Figure.setBounds(134, 180, 134, 32);
		panel_27.add(Number_of_Cylinders_Figure);
		
		JLabel label_11 = new JLabel("8");
		label_11.setLabelFor(Number_of_Cylinders_Figure);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		label_11.setBounds(15, 0, 119, 32);
		Number_of_Cylinders_Figure.add(label_11);
		
		JPanel Current_RPM_Figure = new JPanel();
		Current_RPM_Figure.setLayout(null);
		Current_RPM_Figure.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		Current_RPM_Figure.setBackground(Color.BLACK);
		Current_RPM_Figure.setBounds(134, 242, 134, 32);
		panel_27.add(Current_RPM_Figure);
		
		JLabel label_12 = new JLabel("9,000");
		label_12.setLabelFor(Current_RPM_Figure);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		label_12.setBounds(15, 0, 119, 32);
		Current_RPM_Figure.add(label_12);
		
		JPanel Current_Speed_Figure = new JPanel();
		Current_Speed_Figure.setLayout(null);
		Current_Speed_Figure.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		Current_Speed_Figure.setBackground(Color.BLACK);
		Current_Speed_Figure.setBounds(134, 272, 134, 32);
		panel_27.add(Current_Speed_Figure);
		
		JLabel lblMph = new JLabel("165 MPH");
		lblMph.setLabelFor(Current_Speed_Figure);
		lblMph.setHorizontalAlignment(SwingConstants.CENTER);
		lblMph.setForeground(Color.WHITE);
		lblMph.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblMph.setBounds(15, 0, 119, 32);
		Current_Speed_Figure.add(lblMph);
		
		JPanel Maximum_Speed_Figure = new JPanel();
		Maximum_Speed_Figure.setLayout(null);
		Maximum_Speed_Figure.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		Maximum_Speed_Figure.setBackground(Color.BLACK);
		Maximum_Speed_Figure.setBounds(134, 302, 134, 32);
		panel_27.add(Maximum_Speed_Figure);
		
		JLabel lblMph_1 = new JLabel("218 MPH");
		lblMph_1.setLabelFor(Maximum_Speed_Figure);
		lblMph_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMph_1.setForeground(Color.WHITE);
		lblMph_1.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		lblMph_1.setBounds(15, 0, 119, 32);
		Maximum_Speed_Figure.add(lblMph_1);
		
		JPanel CYLINDERS_Heading = new JPanel();
		CYLINDERS_Heading.setLayout(null);
		CYLINDERS_Heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		CYLINDERS_Heading.setBackground(Color.BLACK);
		CYLINDERS_Heading.setBounds(0, 180, 134, 32);
		panel_27.add(CYLINDERS_Heading);
		
		JLabel lblCylinders = new JLabel("CYLINDERS");
		lblCylinders.setForeground(Color.WHITE);
		lblCylinders.setLabelFor(CYLINDERS_Heading);
		lblCylinders.setHorizontalAlignment(SwingConstants.LEFT);
		lblCylinders.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCylinders.setBounds(9, 0, 129, 32);
		CYLINDERS_Heading.add(lblCylinders);
		
		JPanel RPM_Heading = new JPanel();
		RPM_Heading.setLayout(null);
		RPM_Heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		RPM_Heading.setBackground(Color.BLACK);
		RPM_Heading.setBounds(0, 242, 134, 32);
		panel_27.add(RPM_Heading);
		
		JLabel lblRpm = new JLabel("MAX RPM");
		lblRpm.setForeground(Color.WHITE);
		lblRpm.setLabelFor(RPM_Heading);
		lblRpm.setHorizontalAlignment(SwingConstants.LEFT);
		lblRpm.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRpm.setBounds(9, 0, 129, 32);
		RPM_Heading.add(lblRpm);
		
		JPanel SPEED_Heading = new JPanel();
		SPEED_Heading.setLayout(null);
		SPEED_Heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		SPEED_Heading.setBackground(Color.BLACK);
		SPEED_Heading.setBounds(0, 272, 134, 32);
		panel_27.add(SPEED_Heading);
		
		JLabel lblSpeed = new JLabel("SPEED ");
		lblSpeed.setForeground(Color.WHITE);
		lblSpeed.setLabelFor(SPEED_Heading);
		lblSpeed.setHorizontalAlignment(SwingConstants.LEFT);
		lblSpeed.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSpeed.setBounds(9, 0, 124, 32);
		SPEED_Heading.add(lblSpeed);
		
		JPanel MAX_SPEED_Heading = new JPanel();
		MAX_SPEED_Heading.setLayout(null);
		MAX_SPEED_Heading.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		MAX_SPEED_Heading.setBackground(Color.BLACK);
		MAX_SPEED_Heading.setBounds(0, 302, 134, 32);
		panel_27.add(MAX_SPEED_Heading);
		
		JLabel lblMaxSpeed = new JLabel("MAX SPEED");
		lblMaxSpeed.setForeground(Color.WHITE);
		lblMaxSpeed.setLabelFor(MAX_SPEED_Heading);
		lblMaxSpeed.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxSpeed.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMaxSpeed.setBounds(9, 0, 124, 32);
		MAX_SPEED_Heading.add(lblMaxSpeed);
		
		JPanel GEAR_RATIO_Heading = new JPanel();
		GEAR_RATIO_Heading.setLayout(null);
		GEAR_RATIO_Heading.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		GEAR_RATIO_Heading.setBackground(Color.BLACK);
		GEAR_RATIO_Heading.setBounds(0, 333, 134, 32);
		panel_27.add(GEAR_RATIO_Heading);
		
		JLabel lblGearRatio = new JLabel("GEAR RATIO");
		lblGearRatio.setForeground(Color.WHITE);
		lblGearRatio.setLabelFor(GEAR_RATIO_Heading);
		lblGearRatio.setHorizontalAlignment(SwingConstants.LEFT);
		lblGearRatio.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGearRatio.setBounds(9, 0, 124, 32);
		GEAR_RATIO_Heading.add(lblGearRatio);
		
		JPanel Gear_Ratio_Figure = new JPanel();
		Gear_Ratio_Figure.setLayout(null);
		Gear_Ratio_Figure.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(255, 255, 255)));
		Gear_Ratio_Figure.setBackground(Color.BLACK);
		Gear_Ratio_Figure.setBounds(134, 333, 134, 32);
		panel_27.add(Gear_Ratio_Figure);
		
		JLabel label_13 = new JLabel("1.07");
		label_13.setForeground(Color.WHITE);
		label_13.setLabelFor(Gear_Ratio_Figure);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		label_13.setBounds(15, 0, 119, 32);
		Gear_Ratio_Figure.add(label_13);
		
		JPanel panel_33 = new JPanel();
		panel_33.setLayout(null);
		panel_33.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_33.setBackground(Color.BLACK);
		panel_33.setBounds(0, 211, 134, 32);
		panel_27.add(panel_33);
		
		JLabel label_1 = new JLabel("IDEAL RPM");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(9, 0, 129, 32);
		panel_33.add(label_1);
		
		JPanel panel_34 = new JPanel();
		panel_34.setLayout(null);
		panel_34.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.WHITE));
		panel_34.setBackground(Color.BLACK);
		panel_34.setBounds(134, 211, 134, 32);
		panel_27.add(panel_34);
		
		JLabel label_9 = new JLabel("9,000");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		label_9.setBounds(15, 0, 119, 32);
		panel_34.add(label_9);
		
		JPanel Driver_Inputs_Panel = new JPanel();
		Driver_Inputs_Panel.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(255, 255, 255)));
		Driver_Inputs_Panel.setBackground(Color.BLACK);
		Driver_Inputs_Panel.setBounds(996, 0, 268, 362);
		contentPane.add(Driver_Inputs_Panel);
		Driver_Inputs_Panel.setLayout(null);
		
		JPanel Driver_Inputs_Heading = new JPanel();
		Driver_Inputs_Heading.setBorder(new MatteBorder(0, 2, 2, 0, (Color) new Color(255, 255, 255)));
		Driver_Inputs_Heading.setBackground(Color.BLACK);
		Driver_Inputs_Heading.setBounds(0, 0, 268, 32);
		Driver_Inputs_Panel.add(Driver_Inputs_Heading);
		Driver_Inputs_Heading.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Driver Inputs");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBackground(Color.BLACK);
		lblNewLabel_5.setBounds(0, 0, 268, 29);
		lblNewLabel_5.setLabelFor(Driver_Inputs_Heading);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		Driver_Inputs_Heading.add(lblNewLabel_5);
		
		JPanel Brake_Bar = new JPanel();
		Brake_Bar.setBackground(Color.BLACK);
		Brake_Bar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Brake_Bar.setBounds(76, 43, 54, 246);
		Driver_Inputs_Panel.add(Brake_Bar);
		
		JPanel Throttle_Bar = new JPanel();
		Throttle_Bar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Throttle_Bar.setBackground(Color.BLACK);
		Throttle_Bar.setBounds(12, 43, 54, 246);
		Driver_Inputs_Panel.add(Throttle_Bar);
		
		JPanel Clutch_Bar = new JPanel();
		Clutch_Bar.setBackground(Color.BLACK);
		Clutch_Bar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Clutch_Bar.setBounds(140, 43, 54, 246);
		Driver_Inputs_Panel.add(Clutch_Bar);
		
		JPanel Handbrake_Bar = new JPanel();
		Handbrake_Bar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Handbrake_Bar.setBackground(Color.BLACK);
		Handbrake_Bar.setBounds(205, 43, 54, 246);
		Driver_Inputs_Panel.add(Handbrake_Bar);
		
		JPanel Throttle_Value_Box = new JPanel();
		Throttle_Value_Box.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Throttle_Value_Box.setBackground(Color.BLACK);
		Throttle_Value_Box.setBounds(12, 297, 54, 54);
		Driver_Inputs_Panel.add(Throttle_Value_Box);
		
		JLabel Throttle_Percentage = new JLabel("0");
		Throttle_Percentage.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Throttle_Percentage.setBounds(-1, 0, 54, 54);
		Throttle_Percentage.setHorizontalAlignment(SwingConstants.CENTER);
		Throttle_Percentage.setForeground(Color.WHITE);
		Throttle_Percentage.setLabelFor(Throttle_Bar);
		Throttle_Bar.setLayout(null);
		Throttle_Value_Box.setLayout(null);
		Throttle_Value_Box.add(Throttle_Percentage);
		
		JPanel Brake_Value_Box = new JPanel();
		Brake_Value_Box.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Brake_Value_Box.setBackground(Color.BLACK);
		Brake_Value_Box.setBounds(76, 297, 54, 54);
		Driver_Inputs_Panel.add(Brake_Value_Box);
		
		JLabel Brake_Percentage = new JLabel("0");
		Brake_Percentage.setBounds(-1, 0, 54, 54);
		Brake_Percentage.setLabelFor(Brake_Bar);
		Brake_Bar.setLayout(null);
		Brake_Value_Box.setLayout(null);
		Brake_Percentage.setHorizontalAlignment(SwingConstants.CENTER);
		Brake_Percentage.setForeground(Color.WHITE);
		Brake_Percentage.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Brake_Value_Box.add(Brake_Percentage);
		
		JPanel Clutch_Value_Box = new JPanel();
		Clutch_Value_Box.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Clutch_Value_Box.setBackground(Color.BLACK);
		Clutch_Value_Box.setBounds(140, 297, 54, 54);
		Driver_Inputs_Panel.add(Clutch_Value_Box);
		Clutch_Value_Box.setLayout(null);
		
		JLabel Clutch_Percentage = new JLabel("0");
		Clutch_Percentage.setLabelFor(Clutch_Value_Box);
		Clutch_Percentage.setBounds(-1, 0, 54, 54);
		Clutch_Percentage.setHorizontalAlignment(SwingConstants.CENTER);
		Clutch_Percentage.setForeground(Color.WHITE);
		Clutch_Percentage.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Clutch_Value_Box.add(Clutch_Percentage);
		
		JPanel Handbrake_Value_Box = new JPanel();
		Handbrake_Value_Box.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		Handbrake_Value_Box.setBackground(Color.BLACK);
		Handbrake_Value_Box.setBounds(205, 297, 54, 54);
		Driver_Inputs_Panel.add(Handbrake_Value_Box);
		Handbrake_Value_Box.setLayout(null);
		
		JLabel Handbrake_Precentage = new JLabel("0");
		Handbrake_Precentage.setBounds(-1, 0, 54, 54);
		Handbrake_Precentage.setHorizontalAlignment(SwingConstants.CENTER);
		Handbrake_Precentage.setForeground(Color.WHITE);
		Handbrake_Precentage.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Handbrake_Value_Box.add(Handbrake_Precentage);
		
		JPanel Lap_Times_Section = new JPanel();
		Lap_Times_Section.setForeground(Color.WHITE);
		Lap_Times_Section.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(255, 255, 255)));
		Lap_Times_Section.setBackground(Color.BLACK);
		Lap_Times_Section.setBounds(996, 360, 269, 320);
		contentPane.add(Lap_Times_Section);
		Lap_Times_Section.setLayout(null);
		
		JPanel Live_Timing_Heading = new JPanel();
		Live_Timing_Heading.setBorder(new MatteBorder(0, 2, 2, 0, (Color) Color.WHITE));
		Live_Timing_Heading.setBackground(Color.BLACK);
		Live_Timing_Heading.setBounds(0, 0, 269, 40);
		Lap_Times_Section.add(Live_Timing_Heading);
		Live_Timing_Heading.setLayout(null);
		
		JLabel Live_Timing_Label = new JLabel("Live Timing");
		Live_Timing_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Live_Timing_Label.setForeground(Color.WHITE);
		Live_Timing_Label.setLabelFor(Live_Timing_Heading);
		Live_Timing_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		Live_Timing_Label.setBounds(0, 0, 269, 40);
		Live_Timing_Heading.add(Live_Timing_Label);
		
		JLabel Race_Time = new JLabel("LAP 1");
		Race_Time.setFont(new Font("Tahoma", Font.BOLD, 17));
		Race_Time.setForeground(Color.WHITE);
		Race_Time.setLabelFor(Lap_Times_Section);
		Race_Time.setBounds(9, 38, 101, 32);
		Lap_Times_Section.add(Race_Time);
		
		JLabel Current_Lap_ = new JLabel("LAP 2");
		Current_Lap_.setForeground(Color.WHITE);
		Current_Lap_.setFont(new Font("Tahoma", Font.BOLD, 17));
		Current_Lap_.setBounds(9, 70, 116, 32);
		Lap_Times_Section.add(Current_Lap_);
		
		JLabel lblLap = new JLabel("LAP 3");
		lblLap.setForeground(Color.WHITE);
		lblLap.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLap.setBounds(9, 103, 116, 32);
		Lap_Times_Section.add(lblLap);
	}
}
