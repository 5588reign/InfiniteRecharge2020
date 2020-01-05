/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
//import frc.robot.commands.JoystickDrive;
import frc.robot.commands.XBoxDrive;
import frc.robot.*;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem implements MotherSystem {
  //distance per pulse = pi * the wheel diameter in inches / pulse per revolution * fudge factor
  private static final double DISTANCE_PER_PULSE_INCHES = (Math.PI * 6) / 256 * 1;

  private VictorSPX frontLeftMotor = new VictorSPX(12);
  private VictorSPX backLeftMotor = new VictorSPX(13);
  private VictorSPX frontRightMotor = new VictorSPX(14);
  private VictorSPX backRightMotor = new VictorSPX(15);

  private final Encoder leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_SOURCE_A, RobotMap.LEFT_ENCODER_SOURCE_B);
  private final Encoder rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_SOURCE_A, RobotMap.RIGHT_ENCODER_SOURCE_B);


  public Drive() {
    super();

    frontLeftMotor.configFactoryDefault();
    frontRightMotor.configFactoryDefault();
    backLeftMotor.configFactoryDefault();
    backRightMotor.configFactoryDefault();

    frontLeftMotor.setInverted(false);
    backLeftMotor.setInverted(false);
    frontRightMotor.setInverted(true);
    backRightMotor.setInverted(true);

    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);

    rightEncoder.setDistancePerPulse(DISTANCE_PER_PULSE_INCHES);
    leftEncoder.setDistancePerPulse(DISTANCE_PER_PULSE_INCHES);
    leftEncoder.setReverseDirection(true);
    rightEncoder.setReverseDirection(false);
  } 

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public double getRightEncoderDistance() {
    System.out.println("encoder right :" + rightEncoder.getDistance());
    return rightEncoder.getDistance();
  }

  public double getLeftEncoderDistance() {
    System.out.println("encoder left :" + leftEncoder.getDistance());
    return leftEncoder.getDistance();
  }
  
  public void setSpeed(double leftSpeed, double rightSpeed) {
    frontLeftMotor.set(ControlMode.PercentOutput, leftSpeed);
    frontRightMotor.set(ControlMode.PercentOutput, rightSpeed);
  }

  // public void driveXBoxController(XboxController joystick) { 
  //   double leftSpeed = interpretSpeed(-joystick.getRawAxis(5)) + interpretSpeed(joystick.getRawAxis(4));
  //   double rightSpeed = interpretSpeed(-joystick.getRawAxis(5)) - interpretSpeed(joystick.getRawAxis(4));
  //   setSpeed(leftSpeed, rightSpeed);
  //   //to code for direction/throttle on different thumbsticks: change axis number 
  // }
 
  //experimental throttle/direction thumbsticks
   
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
    frontLeftMotor.set(ControlMode.PercentOutput, 0);
    frontRightMotor.set(ControlMode.PercentOutput, 0);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new XBoxDrive());
  }

}
