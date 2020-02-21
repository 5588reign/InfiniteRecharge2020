/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveDistanceCommand extends CommandBase {
    private final DriveSubsystem m_robotDrive;
    private final double m_distance;
    private final double m_speed;

    // Distance & encoder scaling must be in meters
    // Speed can be negative but distance must be magnitude
    public DriveDistanceCommand(double distance, double speed, DriveSubsystem drive) {
    	m_distance = Math.abs(distance); // must be _magnitude_ in meters
	    m_speed = speed;
      m_robotDrive = drive;
      addRequirements(m_robotDrive);
    }

    @Override
    public void initialize() {
      m_robotDrive.resetEncoders();
      m_robotDrive.tankDrive(m_speed, m_speed);
      System.out.println("In DriveDistance init");
    }

    @Override
    public void end(boolean interrupted) {
      m_robotDrive.tankDrive(0.0, 0.0);
      m_robotDrive.resetEncoders();
    }

    @Override
    public boolean isFinished() {
      //System.out.println("Drive Distance Command: isFinished");
      return Math.abs(m_robotDrive.getLeftEncoderDistance()) >= m_distance;
    }
}
