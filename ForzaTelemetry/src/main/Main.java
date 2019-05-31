/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Jay
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) {
        RaceManagement forzaTelemetry = new RaceManagement();
        forzaTelemetry.initialize();
        forzaTelemetry.run();
    }
}
