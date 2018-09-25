/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.text.DecimalFormat;

/**
 *
 * @author Jay
 */
public final class Calc {

    public static double hypotenuse(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    public static double hypotenuse(double a, double b, double c) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
    }
    public static double MPStoMPH(double d) {
        return d * 2.236936;
    }
    public static double MPStoKPH(double d) {
        return d * 3.6;
    }
    public static double getRightTriangleAdjacentLeg(double hypotenuse, double angle){ //used to get the X co-ordinate of the circle
        //cos(angle) = adjacentLeg / hypotenuse
        //adjacentLeg = hypotenuse * cos(angle)
        return Math.cos(angle) * hypotenuse;
    }
    public static double getRightTriangleOppositeLeg(double hypotenuse, double angle){
        //sin(angle) = oppositeLeg / hypotenuse
        //oppositeLeg = hypotenuse * sin(angle)
        return Math.sin(angle) * hypotenuse;
    }
    public static double gearRatio(double speed, double rpm) {
    	return rpm/speed;
    }
    public static float radiansPerSecondToRPM(float radians){
        return radians * 0.159f * 60f;
    }
    public static String secondsToTime(float seconds) {
    	
    	boolean negativeTime = false;
    	DecimalFormat df = new DecimalFormat("00.000");
    	StringBuilder returnString = new StringBuilder();
    	
    	// if the time is negative convert to positive and set negativeTime to true 
    	if (seconds < 0) {
    		negativeTime = true;
    		seconds *= -1;
    	}
    	
    	byte hours = (byte)Math.floor(seconds / 3600);
    	byte minutes = (byte)Math.floor(seconds % 3600 / 60);
    	seconds = seconds % 3600 % 60;

    	if (hours > 0) returnString.append(String.format("%02d", hours) + "h:");
    	returnString.append(String.format("%02d", minutes) + ":");
    	returnString.append(df.format(seconds));

	    return negativeTime == true ? "-" + returnString : returnString.toString();
    }
    
    public static double coordZero(double min, double max, double size, boolean invert) {
        size -= 1; // using full width or height pushes 1 out of bounds 
    	double zeroPercent = (max / (max - min)); //the percentage of how far through the range the centre should be
    	double answer = (size) * zeroPercent;
    	return invert ? (size) - answer : answer;
    }
    public static double coordZero(double min, double max, double size) {
        return coordZero(min, max, size, false);
    }
    
    public static double coordLength(double min, double max, double size, double value, boolean invert) {
        size -= 1; // using full width or height pushes 1 out of bounds 
    	double answer = (size) * (value / (max - min));
    	return invert ? answer*-1 : answer;
    }
    public static double coordLength(double min, double max, double size, double value) {
    	return coordLength(min, max, size, value, false);
    }
    
    public static double coordValue(double min, double max, double size, double value, boolean invert) {
        double answer = coordZero(min, max, size) - coordLength(min, max, size, value);
    	return invert ? size - answer : answer;
    }
    public static double coordValue(double min, double max, double size, double value) {
    	return coordValue(min, max, size, value, false);
    }
}
