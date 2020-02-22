/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallSubsystem;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class BallBeltEncoderCommand extends CommandBase {
  /**
   * Creates a new BallBeltEncoderCommand.
   */
  public BallBeltEncoderCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_ballSubsystem.ballBeltOne.set(ControlMode.PercentOutput, Constants.BELT_SPEED);
    RobotContainer.m_ballSubsystem.ballBeltTwo.set(ControlMode.PercentOutput, Constants.BELT_SPEED);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_ballSubsystem.ballBeltOne.set(ControlMode.PercentOutput, 0);
    RobotContainer.m_ballSubsystem.ballBeltTwo.set(ControlMode.PercentOutput, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(RobotContainer.m_ballSubsystem.ballBeltEncoder.get()) >= 5;
  }
}
