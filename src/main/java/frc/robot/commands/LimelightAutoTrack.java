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
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.subsystems.Limelight;

public class LimelightAutoTrack extends CommandBase {
  /**
   * Creates a new LimelightAutoTrack.
   */
  double leftSpeed = 0.0;
  double rightSpeed = 0.0;

  public LimelightAutoTrack() {
    // Use addRequirements() here to declare subsystem dependencies.
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
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

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
