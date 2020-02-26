/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallSubsystem;

public class AutoBeltCommand extends CommandBase {
  
  BallSubsystem m_ballSubsystem;

  public AutoBeltCommand(BallSubsystem ballSubsystem) {
    m_ballSubsystem = ballSubsystem;
    addRequirements(m_ballSubsystem);
  }

  @Override
  public void initialize() {
    
  }

  @Override
  public void execute() {
    if (m_ballSubsystem.intakeHasBall()){
      m_ballSubsystem.setBallBeltSpeeds(.25);
    } else {
      m_ballSubsystem.setBallBeltSpeeds(0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_ballSubsystem.setBallBeltSpeeds(0);
  }

  @Override
  public boolean isFinished() {
    // if intake has ball, we are _not_ done
    return !m_ballSubsystem.intakeHasBall();
  }
}
