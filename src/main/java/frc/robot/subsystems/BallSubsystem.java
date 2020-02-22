/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class BallSubsystem extends SubsystemBase {
  public VictorSPX ballCollect = new VictorSPX(5);

  public VictorSPX ballBeltOne = new VictorSPX(6);
  public VictorSPX ballBeltTwo = new VictorSPX(7);

  public VictorSPX index = new VictorSPX(8);
  public VictorSPX flyWheel = new VictorSPX(9);

  public DigitalInput flywheelA = new DigitalInput(0);
  public DigitalInput flywheelB = new DigitalInput(1);

  public DigitalInput ballBeltA = new DigitalInput(2);
  public DigitalInput ballBeltB = new DigitalInput(3);

  public Encoder flywheelEncoder = new Encoder(flywheelA, flywheelB);
  public Encoder ballBeltEncoder = new Encoder(ballBeltA, ballBeltB);

  public BallSubsystem() {
    flywheelEncoder.reset();
  }

  public void setBallCollectSpeed(double speed){
    ballCollect.set(ControlMode.PercentOutput, speed);
  }

  public void setBallBeltSpeeds(double speed){
    ballBeltOne.set(ControlMode.PercentOutput, speed);
    ballBeltTwo.set(ControlMode.PercentOutput, speed);
  }

  public void setFlywheelSpeed(double speed){
    flyWheel.set(ControlMode.PercentOutput, speed);
  }

  public void setIndexSpeed(double speed){
    index.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    
  }
}
