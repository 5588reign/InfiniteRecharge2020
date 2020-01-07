/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.XBoxDrive;
import frc.robot.*;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem implements MotherSystem {
  //distance per pulse = pi * the wheel diameter in inches / pulse per revolution * fudge factor
  private static final double DISTANCE_PER_PULSE_INCHES = (Math.PI * 6) / 28 * 1;

  private CANSparkMax frontLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
  private CANSparkMax frontRightMotor = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(4, MotorType.kBrushless);

  private CANEncoder frontLeftEncoder = new CANEncoder(frontLeftMotor);
  private CANEncoder backLeftEncoder = new CANEncoder(backLeftMotor);
  private CANEncoder frontRightEncoder = new CANEncoder(frontRightMotor);
  private CANEncoder backRightEncoder = new CANEncoder(backRightMotor);


  public Drive() {
    super();
    frontLeftMotor.restoreFactoryDefaults();
    frontRightMotor.restoreFactoryDefaults();
    backLeftMotor.restoreFactoryDefaults();
    backRightMotor.restoreFactoryDefaults();

    frontLeftMotor.setInverted(false);
    backLeftMotor.setInverted(false);
    frontRightMotor.setInverted(true);
    backRightMotor.setInverted(true);

    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);

    frontLeftEncoder.setPositionConversionFactor(DISTANCE_PER_PULSE_INCHES);
    backLeftEncoder.setPositionConversionFactor(DISTANCE_PER_PULSE_INCHES);
    frontRightEncoder.setPositionConversionFactor(DISTANCE_PER_PULSE_INCHES);
    backRightEncoder.setPositionConversionFactor(DISTANCE_PER_PULSE_INCHES);

    frontLeftEncoder.setInverted(true);
    backLeftEncoder.setInverted(true);
    frontRightEncoder.setInverted(false);
    backRightEncoder.setInverted(false);
  } 

  public void resetEncoders() {
    frontLeftEncoder.setPosition(0.0);
    backLeftEncoder.setPosition(0.0);
    frontRightEncoder.setPosition(0.0);
    backRightEncoder.setPosition(0.0);
  }

  public double getRightEncoderDistance() {
    System.out.println("Right Encoder Avg:" + (frontRightEncoder.getPosition() + backRightEncoder.getPosition())/2);
    return (frontRightEncoder.getPosition() + backRightEncoder.getPosition())/2;
  }

  public double getLeftEncoderDistance() {
    System.out.println("Left Encoder Avg:" + (frontLeftEncoder.getPosition() + backLeftEncoder.getPosition())/2);
    return (frontLeftEncoder.getPosition() + backLeftEncoder.getPosition())/2;
  }
  
  public void setSpeed(double leftSpeed, double rightSpeed) {
    frontLeftMotor.set(leftSpeed);
    frontRightMotor.set(rightSpeed);
  }
   
  public void throttleXBoxController(XboxController joystick) {
    double speed = interpretSpeed(-joystick.getRawAxis(5));
    setSpeed(speed, speed);
  }

  public void directionXboxController(XboxController joystick) {
    double speed = interpretSpeed(joystick.getRawAxis(4));
    setSpeed(-speed,speed);
  }

  public double deadZone(double speed) {
    if (Math.abs(speed) < .025) {
      return 0;
    }
    else {
      return speed;
    }
  }

  public double squareSpeed(double speed) {
    if (speed < 0) {
      speed = -(speed * speed);
    }
    else {
      speed = speed * speed;
    }
    return speed;
  }

  public double interpretSpeed(double speed) {
    speed = squareSpeed(speed);
    speed = deadZone(speed);
    return speed;
  }

  public void stop(){
    frontLeftMotor.set(0);
    frontRightMotor.set(0);
  }

  // Put methods for controlling this subsyste here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new XBoxDrive());
  }

}
