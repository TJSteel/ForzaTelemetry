/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tjsteel.forzaTelemetry.database;

import java.util.*;

import com.tjsteel.forzaTelemetry.car.CarType;

/**
 *
 * @author Jay
 */
public class CarTypeDatabase {

    private final ArrayList<CarType> carTypes;

    public CarTypeDatabase() {
    	carTypes = new ArrayList<CarType>();
    	carTypes.add(new CarType(2422, 2014, "HSV", "Limited Edition GEN-F FTS Maloo"));
    	carTypes.add(new CarType(2671, 1997, "BMW", "M3 Forza Edition"));
    	carTypes.add(new CarType(2331, 2015, "Mercedes-Benz", "#9 Erebus Motorsport E63 AMG V8 Supercar"));
    }
    
    public ArrayList<CarType> getCarTypes(){
        return this.carTypes;
    }
}
