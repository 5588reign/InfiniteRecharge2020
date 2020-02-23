/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallSubsystem;
import frc.robot.Constants;

public class BallIntakeCommand extends CommandBase {
  private BallSubsystem m_ballSubsystem;
  private boolean m_isIntake;

  public BallIntakeCommand(BallSubsystem ballSubsystem, boolean isIntake) {
    m_ballSubsystem = ballSubsystem;
    m_isIntake = isIntake;
  }

  @Override
  public void initialize() {
    if(m_isIntake){
      m_ballSubsystem.setBallCollectSpeed(Constants.BALL_SYSTEM_SPEED);
    }
    else{
      m_ballSubsystem.setBallCollectSpeed(-Constants.BALL_SYSTEM_SPEED);
    }
    
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    m_ballSubsystem.setBallCollectSpeed(0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
