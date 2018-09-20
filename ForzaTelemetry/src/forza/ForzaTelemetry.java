/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forza;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import database.CarTypeDatabase;
import database.PlayerDatabase;
import enums.Speed;
import network.TrafficReceiver;
import ui.TelemetryUI;
import utility.Calc;
import utility.FilePrinter;

/**
 * @author Jay
 */
public class ForzaTelemetry {
	// {{ Variables
	private PlayerDatabase playerDB;
	@SuppressWarnings("unused")
	private CarTypeDatabase carTypeDB;
	private ArrayList<Player> players;
	private FilePrinter filePrinter;
	private TrafficReceiver traffic;
	private TelemetryUI ui;
	// }} Variables

    public void initialize() {
    	
        playerDB = new PlayerDatabase();
        carTypeDB = new CarTypeDatabase();
        players = playerDB.getPlayers();
        
        filePrinter = new FilePrinter("DataOutCapture-" 
	        + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()).toString() 
	        + ".csv");
        filePrinter.createFile();

        traffic = new TrafficReceiver();
        traffic.initialize(50000);
        
        ui = new TelemetryUI(this.players);
        ui.setVisible(true);
    }
    
    public void run() {
        printHeaders(filePrinter);
        ui.setReceivingTraffic(false);
        System.out.println(Float.toString(Calc.coordValue(0, 200, 100, 50)));
        while (true) {
            traffic.receiveTraffic();
            
            boolean playerExists = false;

            for (Player currPlayer : players) {
                if (traffic.getAddress().toString().contains(currPlayer.getIpAddress())) {
                	currPlayer.addTelemetryPacket();
                    currPlayer.getTelemetryPacket().processDataPacket(traffic.getDataPack());
                    playerExists = true;
                    if (currPlayer.getTelemetryPacket().isRaceOn()) {
                        //if (currPlayer.getGamertag().equals("HCR TJSteel")) {
                    	/*
                    	StringBuilder returnString = new StringBuilder();
                    	returnString.append("X = ");
                    	returnString.append(currPlayer.getCar().getTrack().getPositionX());
                    	System.out.println(returnString.toString());
						*/
                    	System.out.print(currPlayer.getTelemetryPacket().getEngine().getGear());
                    	ui.updateFields();
                        printValues(currPlayer);
                        //}
                    }
                    break;
                }
            }
            
            //if you've checked all players and they don't exist,
            //create a new player
            if (!playerExists) {
                Player currPlayer;
				currPlayer = new Player(traffic.getDataPack().getAddress().toString(), "Driver " + traffic.getDataPack().getAddress().toString());
                currPlayer.getTelemetryPacket().processDataPacket(traffic.getDataPack());
                //System.out.println(currPlayer.getGamertag() + ", " + currPlayer.getCar());
                players.add(currPlayer);
            }
            ui.setReceivingTraffic(true);
        }

    }
    
	private void printHeaders(FilePrinter filePrinter) {
		if (filePrinter.isFileOpen()) {
			StringBuilder sb = new StringBuilder();
			sb.append("raceOn,");
			sb.append("timestampMS,");
			sb.append("engineMaxRpm,");
			sb.append("engineIdleRpm,");
			sb.append("currentEngineRpm,");
			sb.append("accelerationX,");
			sb.append("accelerationY,");
			sb.append("accelerationZ,");
			sb.append("velocityX,");
			sb.append("velocityY,");
			sb.append("velocityZ,");
			sb.append("angularVelocityX,");
			sb.append("angularVelocityY,");
			sb.append("angularVelocityZ,");
			sb.append("yaw,");
			sb.append("pitch,");
			sb.append("roll,");
			sb.append("normalizedSuspensionTravelFrontLeft,");
			sb.append("normalizedSuspensionTravelFrontRight,");
			sb.append("normalizedSuspensionTravelRearLeft,");
			sb.append("normalizedSuspensionTravelRearRight,");
			sb.append("tireSlipRatioFrontLeft,");
			sb.append("tireSlipRatioFrontRight,");
			sb.append("tireSlipRatioRearLeft,");
			sb.append("tireSlipRatioRearRight,");
			sb.append("wheelRotationSpeedFrontLeft,");
			sb.append("wheelRotationSpeedFrontRight,");
			sb.append("wheelRotationSpeedRearLeft,");
			sb.append("wheelRotationSpeedRearRight,");
			sb.append("wheelOnRumbleStripFrontLeft,");
			sb.append("wheelOnRumbleStripFrontRight,");
			sb.append("wheelOnRumbleStripRearLeft,");
			sb.append("wheelOnRumbleStripRearRight,");
			sb.append("wheelInPuddleDepthFrontLeft,");
			sb.append("wheelInPuddleDepthFrontRight,");
			sb.append("wheelInPuddleDepthRearLeft,");
			sb.append("wheelInPuddleDepthRearRight,");
			sb.append("surfaceRumbleFrontLeft,");
			sb.append("surfaceRumbleFrontRight,");
			sb.append("surfaceRumbleRearLeft,");
			sb.append("surfaceRumbleRearRight,");
			sb.append("tireSlipAngleFrontLeft,");
			sb.append("tireSlipAngleFrontRight,");
			sb.append("tireSlipAngleRearLeft,");
			sb.append("tireSlipAngleRearRight,");
			sb.append("tireCombinedSlipFrontLeft,");
			sb.append("tireCombinedSlipFrontRight,");
			sb.append("tireCombinedSlipRearLeft,");
			sb.append("tireCombinedSlipRearRight,");
			sb.append("suspensionTravelMetersFrontLeft,");
			sb.append("suspensionTravelMetersFrontRight,");
			sb.append("suspensionTravelMetersRearLeft,");
			sb.append("suspensionTravelMetersRearRight,");
			sb.append("carOrdinal,");
			sb.append("carClass,");
			sb.append("carPerformanceIndex,");
			sb.append("drivetrainType,");
			sb.append("numCylinders,");
			sb.append("speedMPS,");
			sb.append("speedMPH,");
			sb.append("speedKPH,");
			sb.append("maxSpeedMPS,");
			sb.append("maxSpeedMPH,");
			sb.append("maxSpeedKPH");
			filePrinter.writeToFile(sb.toString());
		}
	}
	
	private void printValues(Player player)  {
		if (this.filePrinter.isFileOpen()) {
			StringBuilder sb = new StringBuilder();
			sb.append(player.getTelemetryPacket().isRaceOn() + ",");
			sb.append(player.getTelemetryPacket().getTimestampMS() + ",");
			sb.append(player.getTelemetryPacket().getEngine().getEngineMaxRpm() + ",");
			sb.append(player.getTelemetryPacket().getEngine().getEngineIdleRpm() + ",");
			sb.append(player.getTelemetryPacket().getEngine().getCurrentEngineRpm() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getAccelerationX() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getAccelerationY() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getAccelerationZ() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getVelocityX() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getVelocityY() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getVelocityZ() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getAngularVelocityX() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getAngularVelocityY() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getAngularVelocityZ() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getYaw() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getPitch() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getRoll() + ",");
			sb.append(player.getTelemetryPacket().getSuspension().getNormalizedSuspensionTravelFrontLeft() + ",");
			sb.append(player.getTelemetryPacket().getSuspension().getNormalizedSuspensionTravelFrontRight() + ",");
			sb.append(player.getTelemetryPacket().getSuspension().getNormalizedSuspensionTravelRearLeft() + ",");
			sb.append(player.getTelemetryPacket().getSuspension().getNormalizedSuspensionTravelRearRight() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireSlipRatioFrontLeft() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireSlipRatioFrontRight() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireSlipRatioRearLeft() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireSlipRatioRearRight() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelRotationSpeedFrontLeft() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelRotationSpeedFrontRight() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelRotationSpeedRearLeft() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelRotationSpeedRearRight() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelOnRumbleStripFrontLeft() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelOnRumbleStripFrontRight() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelOnRumbleStripRearLeft() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelOnRumbleStripRearRight() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelInPuddleDepthFrontLeft() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelInPuddleDepthFrontRight() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelInPuddleDepthRearLeft() + ",");
			sb.append(player.getTelemetryPacket().getWheel().getWheelInPuddleDepthRearRight() + ",");
			sb.append(player.getTelemetryPacket().getRumble().getSurfaceRumbleFrontLeft() + ",");
			sb.append(player.getTelemetryPacket().getRumble().getSurfaceRumbleFrontRight() + ",");
			sb.append(player.getTelemetryPacket().getRumble().getSurfaceRumbleRearLeft() + ",");
			sb.append(player.getTelemetryPacket().getRumble().getSurfaceRumbleRearRight() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireSlipAngleFrontLeft() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireSlipAngleFrontRight() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireSlipAngleRearLeft() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireSlipAngleRearRight() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireCombinedSlipFrontLeft() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireCombinedSlipFrontRight() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireCombinedSlipRearLeft() + ",");
			sb.append(player.getTelemetryPacket().getTyre().getTireCombinedSlipRearRight() + ",");
			sb.append(player.getTelemetryPacket().getSuspension().getSuspensionTravelMetersFrontLeft() + ",");
			sb.append(player.getTelemetryPacket().getSuspension().getSuspensionTravelMetersFrontRight() + ",");
			sb.append(player.getTelemetryPacket().getSuspension().getSuspensionTravelMetersRearLeft() + ",");
			sb.append(player.getTelemetryPacket().getSuspension().getSuspensionTravelMetersRearRight() + ",");
			sb.append(player.getTelemetryPacket().getCarOrdinal() + ",");
			sb.append(player.getTelemetryPacket().getCarClass() + ",");
			sb.append(player.getTelemetryPacket().getCarPerformanceIndex() + ",");
			sb.append(player.getTelemetryPacket().getEngine().getDrivetrainType() + ",");
			sb.append(player.getTelemetryPacket().getEngine().getNumCylinders() + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getSpeed(Speed.MPS) + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getSpeed(Speed.MPH) + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getSpeed(Speed.KPH) + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getMaxSpeed(Speed.MPS) + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getMaxSpeed(Speed.MPH) + ",");
			sb.append(player.getTelemetryPacket().getVelocity().getMaxSpeed(Speed.KPH) + ",");
			filePrinter.writeToFile(sb.toString());
		}
	}
}
