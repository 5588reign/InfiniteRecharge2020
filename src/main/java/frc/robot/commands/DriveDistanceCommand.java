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
    private final DriveSubsystem m_driveSubsystem;
    private final double m_distance;
    private final double m_speed;
    private double origin;
    private double target;

    // Speed can be negative but distance must be magnitude in inches
    public DriveDistanceCommand(double distance, double speed, DriveSubsystem drive) {
      m_distance = Math.abs(distance);
      m_speed = speed;
      m_driveSubsystem = drive;
      addRequirements(m_driveSubsystem);
    }

    @Override
    public void initialize() {
      origin = m_driveSubsystem.getLeftEncoderDistance();
      target = Math.signum(m_speed) * m_distance + origin;
    }

    @Override
    public void execute() {
      m_driveSubsystem.tankDrive(m_speed, m_speed);
    }

    @Override
    public void end(boolean interrupted) {
      m_driveSubsystem.tankDrive(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
      double current = m_driveSubsystem.getLeftEncoderDistance();
      if (m_speed > 0) {
	  return current >= target;
      } else {
	  return current <= target;
      }
    }
}
