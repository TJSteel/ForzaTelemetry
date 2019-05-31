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
import telemetry.TelemetryPacket;
import utility.FilePrinter;

public class Player {

	// {{ Variables
    private String ipAddress = "";
    private String gamertag = "";
    private ArrayList<TelemetryPacket> telemetryPackets;
    private FilePrinter filePrinter;
    private boolean recording;
    // }} Variables

    // {{ Constructors
    public Player(String ipAddress, String gamertag) {
        this.setIpAddress(ipAddress);
        this.setGamertag(gamertag);
        this.telemetryPackets = new  ArrayList<TelemetryPacket>();
    }
    public Player() {
        this.telemetryPackets = new ArrayList<TelemetryPacket>();
    }
    // }} Constructors
    
    // {{ Getters and Setters
    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the gamertag
     */
    public String getGamertag() {
        return gamertag;
    }

    /**
     * @param gamertag the gamertag to set
     */
    public void setGamertag(String gamertag) {
        this.gamertag = gamertag;
    }

    /**
     * @return the telemetryPackets
     */
    public ArrayList<TelemetryPacket> getTelemetryPackets() {
        return telemetryPackets;
    }
    /**
     * @return the telemetryPackets
     */
    public TelemetryPacket getTelemetryPacket() {
        return telemetryPackets.size() > 0 ? telemetryPackets.get(telemetryPackets.size()-1) : null;
    }

    public void addTelemetryPacket() {
    	telemetryPackets.add(new TelemetryPacket());
    }

    public void reset() {
    	this.getTelemetryPackets().clear();
    }

    // }} Getters and Setters
    
    // {{ Print functions
	private FilePrinter getFilePrinter() {
		return filePrinter;
	}
	private void setFilePrinter(FilePrinter filePrinter) {
		this.filePrinter = filePrinter;
	}    
    
    private void printStart() {
    	this.setFilePrinter(new FilePrinter("DataOutCapture-" 
    	+ new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()).toString() 
    	+ ".csv"));
    	this.getFilePrinter().createFile();
    	this.printHeaders();
    }
    
	private void printHeaders() {
		FilePrinter filePrinter = this.getFilePrinter();
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
			sb.append("tyreSlipRatioFrontLeft,");
			sb.append("tyreSlipRatioFrontRight,");
			sb.append("tyreSlipRatioRearLeft,");
			sb.append("tyreSlipRatioRearRight,");
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
			sb.append("tyreSlipAngleFrontLeft,");
			sb.append("tyreSlipAngleFrontRight,");
			sb.append("tyreSlipAngleRearLeft,");
			sb.append("tyreSlipAngleRearRight,");
			sb.append("tyreCombinedSlipFrontLeft,");
			sb.append("tyreCombinedSlipFrontRight,");
			sb.append("tyreCombinedSlipRearLeft,");
			sb.append("tyreCombinedSlipRearRight,");
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
	
	public void printValues()  {
		if (!this.isRecording()){
			return;
		}
		
		FilePrinter filePrinter = this.getFilePrinter();
		if (!filePrinter.isFileOpen()) {
			this.printStart();	
		}
		StringBuilder sb = new StringBuilder();
		sb.append(this.getTelemetryPacket().isRaceOn() + ",");
		sb.append(this.getTelemetryPacket().getTimestampMS() + ",");
		sb.append(this.getTelemetryPacket().getEngine().getEngineMaxRpm() + ",");
		sb.append(this.getTelemetryPacket().getEngine().getEngineIdleRpm() + ",");
		sb.append(this.getTelemetryPacket().getEngine().getCurrentEngineRpm() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getAccelerationX() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getAccelerationY() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getAccelerationZ() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getVelocityX() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getVelocityY() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getVelocityZ() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getAngularVelocityX() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getAngularVelocityY() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getAngularVelocityZ() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getYaw() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getPitch() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getRoll() + ",");
		sb.append(this.getTelemetryPacket().getSuspension().getNormalizedSuspensionTravelFrontLeft() + ",");
		sb.append(this.getTelemetryPacket().getSuspension().getNormalizedSuspensionTravelFrontRight() + ",");
		sb.append(this.getTelemetryPacket().getSuspension().getNormalizedSuspensionTravelRearLeft() + ",");
		sb.append(this.getTelemetryPacket().getSuspension().getNormalizedSuspensionTravelRearRight() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreSlipRatioFrontLeft() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreSlipRatioFrontRight() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreSlipRatioRearLeft() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreSlipRatioRearRight() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelRotationSpeedFrontLeft() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelRotationSpeedFrontRight() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelRotationSpeedRearLeft() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelRotationSpeedRearRight() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelOnRumbleStripFrontLeft() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelOnRumbleStripFrontRight() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelOnRumbleStripRearLeft() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelOnRumbleStripRearRight() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelInPuddleDepthFrontLeft() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelInPuddleDepthFrontRight() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelInPuddleDepthRearLeft() + ",");
		sb.append(this.getTelemetryPacket().getWheel().getWheelInPuddleDepthRearRight() + ",");
		sb.append(this.getTelemetryPacket().getRumble().getSurfaceRumbleFrontLeft() + ",");
		sb.append(this.getTelemetryPacket().getRumble().getSurfaceRumbleFrontRight() + ",");
		sb.append(this.getTelemetryPacket().getRumble().getSurfaceRumbleRearLeft() + ",");
		sb.append(this.getTelemetryPacket().getRumble().getSurfaceRumbleRearRight() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreSlipAngleFrontLeft() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreSlipAngleFrontRight() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreSlipAngleRearLeft() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreSlipAngleRearRight() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreCombinedSlipFrontLeft() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreCombinedSlipFrontRight() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreCombinedSlipRearLeft() + ",");
		sb.append(this.getTelemetryPacket().getTyre().getTyreCombinedSlipRearRight() + ",");
		sb.append(this.getTelemetryPacket().getSuspension().getSuspensionTravelMetersFrontLeft() + ",");
		sb.append(this.getTelemetryPacket().getSuspension().getSuspensionTravelMetersFrontRight() + ",");
		sb.append(this.getTelemetryPacket().getSuspension().getSuspensionTravelMetersRearLeft() + ",");
		sb.append(this.getTelemetryPacket().getSuspension().getSuspensionTravelMetersRearRight() + ",");
		sb.append(this.getTelemetryPacket().getCarOrdinal() + ",");
		sb.append(this.getTelemetryPacket().getCarClass() + ",");
		sb.append(this.getTelemetryPacket().getCarPerformanceIndex() + ",");
		sb.append(this.getTelemetryPacket().getEngine().getDrivetrainType() + ",");
		sb.append(this.getTelemetryPacket().getEngine().getNumCylinders() + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getSpeed(Speed.MPS) + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getSpeed(Speed.MPH) + ",");
		sb.append(this.getTelemetryPacket().getVelocity().getSpeed(Speed.KPH) + ",");
		sb.append(this.getMaxSpeed(Speed.MPS) + ",");
		sb.append(this.getMaxSpeed(Speed.MPH) + ",");
		sb.append(this.getMaxSpeed(Speed.KPH) + ",");
		filePrinter.writeToFile(sb.toString());
	}    
    // }} Print functions
    
    
    
    // {{ Calculated Fields
    
    public ArrayList<Float> getLapTimes(){
    	ArrayList<Float> lapTimes = new ArrayList<Float>();
    	int currentLap = 1;
    	for (TelemetryPacket p : this.getTelemetryPackets()) {
    		if (p.getTrack().getCurrentLap() > currentLap) {
    			lapTimes.add(p.getTrack().getLastLap());
    			currentLap++;
    		}
    	}
    	return lapTimes;
    }
    
    public ArrayList<Float> getBestLapTimes(){
    	ArrayList<Float> lapTimes = new ArrayList<Float>();
    	int currentLap = 1;
    	for (TelemetryPacket p : this.getTelemetryPackets()) {
    		if (p.getTrack().getCurrentLap() > currentLap) {
    			lapTimes.add(p.getTrack().getBestLap());
    			currentLap++;
    		}
    	}
    	return lapTimes;
    }
    
    public float getAverageLap() {
    	ArrayList<Float> lapTimes = this.getLapTimes();
    	float totalTime = 0.0F;
    	
    	for (float lap: lapTimes) {
    		totalTime += lap;
    	}
    	return lapTimes.size() == 0 ? totalTime : totalTime / lapTimes.size();
    }

    public float getLastLapDelta() {
    	float lastLap = this.getTelemetryPacket().getTrack().getLastLap();
    	ArrayList<Float> bestLaps = this.getBestLapTimes();
    	//we can't compare laps until at least 2 have been set
    	//bestLaps.size()-2 is so that we're comparing last lap against the previous best lap, not the current best lap
    	return bestLaps.size() <= 1 ? 0.0F : lastLap - bestLaps.get(bestLaps.size()-2);
    }

    public double getMaxSpeed(Speed units) {
    	ArrayList<TelemetryPacket> telemetryPackets = this.getTelemetryPackets();
    	if (telemetryPackets.size() == 0) return 0;
    	double maxSpeed = 0;
    	for (TelemetryPacket p : telemetryPackets) {
    		if (p.getVelocity().getSpeed(units) > maxSpeed) maxSpeed = p.getVelocity().getSpeed(units);
    	}
    	return maxSpeed;
    }
    public double getMaxSpeed() {
    	return this.getMaxSpeed(Speed.MPS);
    }
	public boolean isRecording() {
		return recording;
	}
	public void setRecording(boolean recording) {
		this.recording = recording;
	}
	public double getFuelLapsRemaining() {
		return 0.0;
	}
    
    // }} Calculated Fields
}
