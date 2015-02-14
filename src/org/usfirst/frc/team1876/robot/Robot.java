package org.usfirst.frc.team1876.robot;

import org.usfirst.frc.team1876.robot.io.LogitechController;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Compressor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Drivetrain drivetrain;
	LogitechController lc;
	Compressor AIR;
	Lift lift;
	
	private int USB0 = 0;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		AIR = new Compressor();
		drivetrain = new Drivetrain();
		lift = new Lift();
		lc = new LogitechController(USB0);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		// I think we should start the air compressor in the robotInit()
		AIR.start();
		
		double forward = lc.getLeftAxisY();
		double rotation = lc.getRightAxisX();
		double strafe = lc.getThrottle();
		
		drivetrain.FPSDrive(forward, rotation, strafe, true, false);
		
	    lift.setStage(lc.isAButtonPressed(),lc.isBButtonPressed());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{

	}

}
