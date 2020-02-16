/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;

public class TurnLeftCommand extends CommandBase {
  
  private DriveSubsystem m_driveSubsystem;

  public TurnLeftCommand(DriveSubsystem driveSubsystem) {
    m_driveSubsystem = driveSubsystem;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
