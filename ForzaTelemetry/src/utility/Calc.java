/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

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
}
