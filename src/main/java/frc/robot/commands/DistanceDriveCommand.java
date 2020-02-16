/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DistanceCommandDrive extends CommandBase {
    private final DriveSubsystem m_driveSubsystem;
    private final double m_distance;
    private final double m_speed;

    // Distance & encoder scaling must be in meters
    // Speed can be negative but distance must be magnitude
    public DriveDistanceCommand(double distance, double speed, DriveSubsystem drive) {
    	m_distance = Math.abs(distance); // must be _magnitude_ in meters
	    m_speed = speed;
	    m_driveSubsystem = drive;
    }

    @Override
    public void initialize() {
      m_driveSubsystem.resetEncoders();
      m_driveSubsystem.tankDrive(m_speed, m_speed);
    }

    @Override
    public void end(boolean interrupted) {
      m_driveSubsystem.tankDrive(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
      return Math.abs(m_driveSubsystem.getMeanEncoderDistance()) >= m_distance;
    }
}