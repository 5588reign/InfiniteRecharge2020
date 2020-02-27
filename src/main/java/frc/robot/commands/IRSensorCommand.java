/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallSubsystem;

public class IRSensorCommand extends CommandBase {
  BallSubsystem m_ballSubsystem;

  public IRSensorCommand(BallSubsystem ballSubsystem) {
    m_ballSubsystem = ballSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //SmartDashboard.putBoolean("Intake got ball",m_ballSubsystem.intakeHasBall());
    System.out.println("IR " +  m_ballSubsystem.intakeHasBall());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //System.out.print("has ball!");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    boolean result = m_ballSubsystem.intakeHasBall();
    return result;
  }
}
