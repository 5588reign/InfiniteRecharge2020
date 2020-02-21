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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

    // FIX: These are true on chassis?
    frontLeftMotor.setInverted(true);
    frontRightMotor.setInverted(false);
    backLeftMotor.setInverted(true);
    backRightMotor.setInverted(false);
    // ^ FIX: Making sure none of the motors are inverted, change when we figure out WTH is up with the motors lol

    frontLeftMotor.setSmartCurrentLimit(80);
    frontRightMotor.setSmartCurrentLimit(80);
    backLeftMotor.setSmartCurrentLimit(80);
    backRightMotor.setSmartCurrentLimit(80);

    this.resetEncoders();

    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);

    // ???? Configure encoders here
    m_frontLeftEncoder.setPositionConversionFactor(1.77);
    m_frontRightEncoder.setPositionConversionFactor(1.77);
    m_backLeftEncoder.setPositionConversionFactor(1.77);
    m_backRightEncoder.setPositionConversionFactor(1.77);

    m_drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

    m_drive.setMaxOutput(Constants.k);
    m_drive.setRightSideInverted(false);
  }

  public void arcadeDrive(double speed, double rotation) {
    m_drive.arcadeDrive(speed, rotation);
  }
    
  public void tankDrive(double leftSpeed, double rightSpeed){
    // May need invert speed
    m_drive.tankDrive(leftSpeed, rightSpeed);
    SmartDashboard.putNumber("Distance", getLeftEncoderDistance());

  }

  @Override
  public void periodic() {
    m_drive.feedWatchdog(); // check this
  }

  public void resetEncoders() {
    System.out.println("before " + m_frontLeftEncoder.getPosition());
    m_frontLeftEncoder.setPosition(0.0);
    System.out.println("right after " + m_frontLeftEncoder.getPosition());
    m_frontRightEncoder.setPosition(0.0);
    m_backLeftEncoder.setPosition(0.0);
    m_backRightEncoder.setPosition(0.0);

    m_frontLeftEncoder.getPosition();
    m_frontRightEncoder.getPosition();
    m_backLeftEncoder.getPosition();
    m_backRightEncoder.getPosition();

  }

  public double getMeanEncoderDistance() {
    // currently report leaders only
    // FIX: Check that encoders are running in same direction
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
