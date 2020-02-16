/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  public static DifferentialDrive m_drive;

  private CANSparkMax frontLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax frontRightMotor = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(4, MotorType.kBrushless);

  private CANEncoder m_frontLeftEncoder = new CANEncoder(frontLeftMotor);
  private CANEncoder m_frontRightEncoder = new CANEncoder(frontRightMotor);
  private CANEncoder m_backLeftEncoder = new CANEncoder(backLeftMotor);
  private CANEncoder m_backRightEncoder = new CANEncoder(backRightMotor);

  public DriveSubsystem() {
    frontLeftMotor.setInverted(false);
    frontRightMotor.setInverted(false);
    backLeftMotor.setInverted(false);
    backRightMotor.setInverted(false);
    // ^ FIX: Making sure none of the motors are inverted, change when we figure out WTH is up with the motors lol

    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);

    // ???? Configure encoders here

    m_drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
  }

  public void arcadeDrive(double speed, double rotation) {
    m_drive.arcadeDrive(speed * Constants.k, rotation);
  }
    
  public void tankDrive(double leftSpeed, double rightSpeed){
    // May need invert left
    m_drive.tankDrive(leftSpeed * Constants.k, rightSpeed * Constants.k);
  }

  @Override
  public void periodic() {
    m_drive.feedWatchdog(); // check this
  }

  public void resetEncoders() {
    m_frontLeftEncoder.setPosition(0.0);
    m_frontRightEncoder.setPosition(0.0);
    m_backLeftEncoder.setPosition(0.0);
    m_backRightEncoder.setPosition(0.0);
  }

  public double getMeanEncoderDistance() {
    // currently report leaders only
    return (getLeftEncoderDistance() + getRighttEncoderDistance()) / 2.0;
  }

  public double getLeftEncoderDistance() {
    // currently report leader only
    return m_frontLeftEncoder.getPosition();
  }

  public double getRighttEncoderDistance() {
    // currently report leader only      
    return m_frontRightEncoder.getPosition();
  }

  // May want to try this rather than multiplying by constant scale everywhere
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }
  
}
