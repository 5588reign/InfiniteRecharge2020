/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class BallCollect extends Command {
  private boolean isFront;
  public BallCollect(boolean a) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);
    this.isFront = a;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    double speed = Robot.drive.ballCollectMotor.getMotorOutputPercent();
    if (isFront && speed == 0){
      Robot.drive.ballCollectMotor.set(ControlMode.PercentOutput, 1.0);
    }
    else if (isFront && speed != 0){
      Robot.drive.ballCollectMotor.set(ControlMode.PercentOutput, 0.0);
    }
    else if (!isFront && speed == 0){
      Robot.drive.ballCollectMotor.set(ControlMode.PercentOutput, -1.0);
    }
    else if (!isFront && speed != 0){
      Robot.drive.ballCollectMotor.set(ControlMode.PercentOutput, 0.0);
    }
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
