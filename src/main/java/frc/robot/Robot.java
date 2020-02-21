/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.RobotContainer;
import frc.robot.Robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {

  public RobotContainer m_robotContainer;
  public DriveSubsystem m_robotDrive;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    // ^ Where we make our RobotContainer/DriveSubsystem
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

    SmartDashboard.putBoolean("limelight has target", RobotContainer.m_limelight.hasTarget());
    SmartDashboard.putNumber("Limelight tx", RobotContainer.m_limelight.getX());
    SmartDashboard.putNumber("Limelight ty", RobotContainer.m_limelight.getY());
    SmartDashboard.putNumber("Limelight ta", RobotContainer.m_limelight.getArea());
  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {

  }

  @Override
  public void autonomousInit() {

    /*
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

     schedule the autonomous command (example)
     if (m_autonomousCommand != null) {
       m_autonomousCommand.schedule();
    }
    */
    // ^ This code could come in handy for Autonomous stuff!
  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {

    /*
     if (m_autonomousCommand != null) {
       m_autonomousCommand.cancel();
     }
    */
    // ^ SUPER IMPORTANT!!! You HAVE to cancel Autonomous commands here cuz teleop won't go unless you do!
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
