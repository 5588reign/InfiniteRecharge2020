/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class LimelightAutoTrackCommand extends CommandBase {

  private static final double MAX_HEADING_ABS_ERROR = 0.01;
  private static final double MAX_AREA_ABS_ERROR = 0.001;
  private DriveSubsystem m_robotDrive;
  private LimelightSubsystem m_limelight;

  public LimelightAutoTrackCommand(LimelightSubsystem limelight, DriveSubsystem robotDrive) {
    m_limelight = limelight;
    m_robotDrive = robotDrive;
    addRequirements(m_limelight, m_robotDrive);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double leftSpeed = 0.0;
    double rightSpeed = 0.0;
    if (!m_limelight.hasTarget()){
      leftSpeed = 0.0;
      rightSpeed = 0.0;
    } else {
        System.out.print(m_limelight.getX());
        double speed = m_limelight.getX() * Constants.K_TURN;
        speed = MathUtil.clamp(speed, -Constants.MAX_SPEED, Constants.MAX_SPEED);
        leftSpeed = speed;
        rightSpeed = -speed;
    }
    m_robotDrive.tankDrive(leftSpeed, rightSpeed);    
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return !m_limelight.hasTarget() || Math.abs(m_limelight.getX()) <= MAX_HEADING_ABS_ERROR;
  }
}
