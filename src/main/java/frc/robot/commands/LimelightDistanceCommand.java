/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class LimelightDistanceCommand extends CommandBase {
  
  private static final double TARGET_AREA = 1.89;
  private static final double MAX_AREA_ABS_ERROR = 0.005;

  private DriveSubsystem m_robotDrive;
  private LimelightSubsystem m_limelight;

  public LimelightDistanceCommand(LimelightSubsystem limelight, DriveSubsystem robotDrive) {
    m_limelight = limelight;
    m_robotDrive = robotDrive;
    addRequirements(m_limelight, m_robotDrive);
  }
  @Override
  public void initialize() {
    m_limelight.setOnLed();
  }

  @Override
  public void execute() {
    double minValue = 0.008; //0.001
    double speed = 0.0;
    double heading = 0.0;
    if (!m_limelight.hasTarget()){
      speed = 0.0;
      heading = 0.0;
    } else {
        speed = (TARGET_AREA - m_limelight.getArea()) * 4.00;
        if(speed > 0){
          speed += minValue;
        } else if (speed < 0){
          speed -= minValue;
        }
        
        heading = -m_limelight.getX() * 0.04;
        if (heading > 1){
          heading -= minValue;
          speed += 0.1;
        } else if (heading < -1){
          heading += minValue;
          speed += 0.1;
        }
        speed = MathUtil.clamp(speed, -0.60, 0.60);
        heading = MathUtil.clamp(heading, -1, 1);
        SmartDashboard.putNumber("Heading", heading);
        SmartDashboard.putNumber("Speed", speed);
    }
    m_robotDrive.tankDrive(speed, heading);    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_limelight.setOffLed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return !m_limelight.hasTarget() || Math.abs(TARGET_AREA - m_limelight.getArea()) < MAX_AREA_ABS_ERROR;
  }
}
