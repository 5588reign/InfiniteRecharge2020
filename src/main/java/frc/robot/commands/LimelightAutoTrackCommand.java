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
import frc.robot.subsystems.LimelightSubsystem;

public class LimelightAutoTrackCommand extends CommandBase {

  double leftSpeed = 0.0;
  double rightSpeed = 0.0;

  public LimelightAutoTrackCommand() {
  
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (!RobotContainer.m_limelight.hasTarget()){
      leftSpeed = 0.0;
      rightSpeed = 0.0;
    }
    else{
        System.out.print(RobotContainer.m_limelight.getX());
        double speed = RobotContainer.m_limelight.getX() * Constants.K_TURN;
        speed = MathUtil.clamp(speed, -1.0 * Constants.MAX_SPEED, Constants.MAX_SPEED);
        leftSpeed = speed;
        rightSpeed = -speed;
    }
    SmartDashboard.putNumber("Left Speed", leftSpeed);    
    SmartDashboard.putNumber("Right Speed", rightSpeed);    
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
