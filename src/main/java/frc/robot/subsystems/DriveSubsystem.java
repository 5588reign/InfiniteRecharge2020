/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

public class DriveSubsystem extends SubsystemBase {

  public static DifferentialDrive m_drive;

  private CANSparkMax frontLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax frontRightMotor = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(4, MotorType.kBrushless);

  private CANEncoder frontLeftEncoder = new CANEncoder(frontLeftMotor);
  private CANEncoder frontRightEncoder = new CANEncoder(frontRightMotor);
  private CANEncoder backLeftEncoder = new CANEncoder(backLeftMotor);
  private CANEncoder backRightEncoder = new CANEncoder(backRightMotor);


  public DriveSubsystem() {
    frontLeftMotor.setInverted(false);
    frontRightMotor.setInverted(false);
    backLeftMotor.setInverted(false);
    backRightMotor.setInverted(false);
    // ^ FIX: Making sure none of the motors are inverted, change when we figure out WTH is up with the motors lol

    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);

    m_drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    m_drive.tankDrive(leftSpeed * Constants.k, rightSpeed * Constants.k);
  }

  @Override
  public void periodic() {
    m_drive.feedWatchdog(); // keep safety happy
  }
}