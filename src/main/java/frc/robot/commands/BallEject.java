/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallSubsystem;

public class BallEject extends CommandBase {
  private BallSubsystem m_ballSubsystem;

  public BallEject(BallSubsystem ballSubsystem) {
    m_ballSubsystem = ballSubsystem;
  }

  @Override
  public void initialize() {
    m_ballSubsystem.setBallCollecctSpeed(-0.75);
  }

  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ballSubsystem.setBallCollecctSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
