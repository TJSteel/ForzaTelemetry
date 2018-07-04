/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forza;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import enums.Speed;
import network.TrafficReceiver;
import ui.TelemetryUI;
import utility.CarTypeDatabase;
import utility.FilePrinter;
import utility.PlayerDatabase;

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
        while (true) {
            traffic.receiveTraffic();
            
            boolean playerExists = false;

            for (Player currPlayer : players) {
                if (traffic.getAddress().toString().contains(currPlayer.getIpAddress())) {
                    currPlayer.getCar().processDataPacket(traffic.getDataPack());
                    playerExists = true;
                    if (currPlayer.getCar().isRaceOn()) {
                        //if (currPlayer.getGamertag().equals("HCR TJSteel")) {
                        	//System.out.println(currPlayer.getCar().getEngineMaxRpm());
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
				currPlayer = new Player(traffic.getDataPack().getAddress().toString(), "Driver not in DB!");
                currPlayer.getCar().processDataPacket(traffic.getDataPack());
                //System.out.println(currPlayer.getGamertag() + ", " + currPlayer.getCar());
                players.add(currPlayer);
            }
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
			sb.append(player.getCar().isRaceOn() + ",");
			sb.append(player.getCar().getTimestampMS() + ",");
			sb.append(player.getCar().getEngine().getEngineMaxRpm() + ",");
			sb.append(player.getCar().getEngine().getEngineIdleRpm() + ",");
			sb.append(player.getCar().getEngine().getCurrentEngineRpm() + ",");
			sb.append(player.getCar().getVelocity().getAccelerationX() + ",");
			sb.append(player.getCar().getVelocity().getAccelerationY() + ",");
			sb.append(player.getCar().getVelocity().getAccelerationZ() + ",");
			sb.append(player.getCar().getVelocity().getVelocityX() + ",");
			sb.append(player.getCar().getVelocity().getVelocityY() + ",");
			sb.append(player.getCar().getVelocity().getVelocityZ() + ",");
			sb.append(player.getCar().getVelocity().getAngularVelocityX() + ",");
			sb.append(player.getCar().getVelocity().getAngularVelocityY() + ",");
			sb.append(player.getCar().getVelocity().getAngularVelocityZ() + ",");
			sb.append(player.getCar().getVelocity().getYaw() + ",");
			sb.append(player.getCar().getVelocity().getPitch() + ",");
			sb.append(player.getCar().getVelocity().getRoll() + ",");
			sb.append(player.getCar().getSuspension().getNormalizedSuspensionTravelFrontLeft() + ",");
			sb.append(player.getCar().getSuspension().getNormalizedSuspensionTravelFrontRight() + ",");
			sb.append(player.getCar().getSuspension().getNormalizedSuspensionTravelRearLeft() + ",");
			sb.append(player.getCar().getSuspension().getNormalizedSuspensionTravelRearRight() + ",");
			sb.append(player.getCar().getTyre().getTireSlipRatioFrontLeft() + ",");
			sb.append(player.getCar().getTyre().getTireSlipRatioFrontRight() + ",");
			sb.append(player.getCar().getTyre().getTireSlipRatioRearLeft() + ",");
			sb.append(player.getCar().getTyre().getTireSlipRatioRearRight() + ",");
			sb.append(player.getCar().getWheel().getWheelRotationSpeedFrontLeft() + ",");
			sb.append(player.getCar().getWheel().getWheelRotationSpeedFrontRight() + ",");
			sb.append(player.getCar().getWheel().getWheelRotationSpeedRearLeft() + ",");
			sb.append(player.getCar().getWheel().getWheelRotationSpeedRearRight() + ",");
			sb.append(player.getCar().getWheel().getWheelOnRumbleStripFrontLeft() + ",");
			sb.append(player.getCar().getWheel().getWheelOnRumbleStripFrontRight() + ",");
			sb.append(player.getCar().getWheel().getWheelOnRumbleStripRearLeft() + ",");
			sb.append(player.getCar().getWheel().getWheelOnRumbleStripRearRight() + ",");
			sb.append(player.getCar().getWheel().getWheelInPuddleDepthFrontLeft() + ",");
			sb.append(player.getCar().getWheel().getWheelInPuddleDepthFrontRight() + ",");
			sb.append(player.getCar().getWheel().getWheelInPuddleDepthRearLeft() + ",");
			sb.append(player.getCar().getWheel().getWheelInPuddleDepthRearRight() + ",");
			sb.append(player.getCar().getRumble().getSurfaceRumbleFrontLeft() + ",");
			sb.append(player.getCar().getRumble().getSurfaceRumbleFrontRight() + ",");
			sb.append(player.getCar().getRumble().getSurfaceRumbleRearLeft() + ",");
			sb.append(player.getCar().getRumble().getSurfaceRumbleRearRight() + ",");
			sb.append(player.getCar().getTyre().getTireSlipAngleFrontLeft() + ",");
			sb.append(player.getCar().getTyre().getTireSlipAngleFrontRight() + ",");
			sb.append(player.getCar().getTyre().getTireSlipAngleRearLeft() + ",");
			sb.append(player.getCar().getTyre().getTireSlipAngleRearRight() + ",");
			sb.append(player.getCar().getTyre().getTireCombinedSlipFrontLeft() + ",");
			sb.append(player.getCar().getTyre().getTireCombinedSlipFrontRight() + ",");
			sb.append(player.getCar().getTyre().getTireCombinedSlipRearLeft() + ",");
			sb.append(player.getCar().getTyre().getTireCombinedSlipRearRight() + ",");
			sb.append(player.getCar().getSuspension().getSuspensionTravelMetersFrontLeft() + ",");
			sb.append(player.getCar().getSuspension().getSuspensionTravelMetersFrontRight() + ",");
			sb.append(player.getCar().getSuspension().getSuspensionTravelMetersRearLeft() + ",");
			sb.append(player.getCar().getSuspension().getSuspensionTravelMetersRearRight() + ",");
			sb.append(player.getCar().getCarOrdinal() + ",");
			sb.append(player.getCar().getCarClass() + ",");
			sb.append(player.getCar().getCarPerformanceIndex() + ",");
			sb.append(player.getCar().getEngine().getDrivetrainType() + ",");
			sb.append(player.getCar().getEngine().getNumCylinders() + ",");
			sb.append(player.getCar().getVelocity().getSpeed(Speed.MPS) + ",");
			sb.append(player.getCar().getVelocity().getSpeed(Speed.MPH) + ",");
			sb.append(player.getCar().getVelocity().getSpeed(Speed.KPH) + ",");
			sb.append(player.getCar().getVelocity().getMaxSpeed(Speed.MPS) + ",");
			sb.append(player.getCar().getVelocity().getMaxSpeed(Speed.MPH) + ",");
			sb.append(player.getCar().getVelocity().getMaxSpeed(Speed.KPH) + ",");
			filePrinter.writeToFile(sb.toString());
		}
	}
}
