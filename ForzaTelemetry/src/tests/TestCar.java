package tests;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

import car.Engine;
import enums.Drivetrain;

public class TestCar {
	@Test
	public void testEngine() {
		//test data
		Engine engine = new Engine();
		engine.setDrivetrainType(0);
		assertEquals(Drivetrain.FWD, engine.getDrivetrainType());
		engine.setDrivetrainType(1);
		assertEquals(Drivetrain.RWD, engine.getDrivetrainType());
		engine.setDrivetrainType(2);
		assertEquals(Drivetrain.AWD, engine.getDrivetrainType());
		engine.setDrivetrainType(3);
		assertEquals(Drivetrain.NONE, engine.getDrivetrainType());
		engine.setDrivetrainType(4);
		assertEquals(Drivetrain.NONE, engine.getDrivetrainType());
		engine.setDrivetrainType(-1);
		assertEquals(Drivetrain.NONE, engine.getDrivetrainType());
	}
}
