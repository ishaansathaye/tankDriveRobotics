package org.usfirst.frc.team1351.robot;

import edu.wpi.first.wpilibj.SampleRobot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {
	WPI_TalonSRX talon0, talon1, talon2, talon3;
	Joystick stick0, stick1;

	public Robot() {
	}

	@Override
	public void robotInit() {
		talon0 = new WPI_TalonSRX(0);
		talon1 = new WPI_TalonSRX(1);
		talon2 = new WPI_TalonSRX(2);
		talon3 = new WPI_TalonSRX(3);
		
		stick0 = new Joystick(0);
		stick1 = new Joystick(1);
		
		talon1.set(ControlMode.Follower, 0);
		talon3.set(ControlMode.Follower, 2); 
	}

	@Override
	public void autonomous() {
	}
	@Override
	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			stick0.getY(); 
			//get y value of joystick
			talon0.set(ControlMode.PercentOutput, 0);
			//set value of talon speed
			
			if (stick0.getY() > -0.05 && stick0.getY() < 0.05) {
				talon0.set(ControlMode.PercentOutput, 0);
			}
			if (stick1.getY() > -0.05 && stick0.getY() < 0.05) {
				talon2.set(ControlMode.PercentOutput, 0);
			}
			
			if (stick0.getY() < -0.05 || stick0.getY() > 0.05) {
				talon0.set(ControlMode.PercentOutput, stick0.getY());
			}
			if (stick1.getY() < -0.05 || stick0.getY() > 0.05) {
				talon2.set(ControlMode.PercentOutput, stick1.getY());
			}
			
			Timer.delay(0.005);
		}
	}

	@Override
	public void test() {
	}
}