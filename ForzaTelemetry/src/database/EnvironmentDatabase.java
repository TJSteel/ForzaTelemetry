/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.*;

import forza.Environment;

/**
 *
 * @author Jay
 */
public class EnvironmentDatabase {

    private final ArrayList<Environment> environments;

    public EnvironmentDatabase() {
        environments = new ArrayList<Environment>();
        environments.add(new Environment("Road Atlanta Club", 2849.0f));
    }
    
    public ArrayList<Environment> getEnvironments(){
        return this.environments;
    }
    
    public Environment getEnvironment(String trackName) {
    	for (Environment environment: this.environments) {
    		if (environment.getTrackName().equals(trackName)) return environment;
    	}
    	return null;
    }
    public Environment getEnvironment(float trackLength) {
    	for (Environment environment: this.environments) {
    		if (environment.getTrackLength() > (trackLength - 10) && environment.getTrackLength() < (trackLength + 10)) return environment;
    	}
    	return null;
    }
    
}
