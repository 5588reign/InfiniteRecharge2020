/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BallSubsystem extends SubsystemBase {
  public VictorSPX ballCollect = new VictorSPX(5);

  public VictorSPX ballBeltOne = new VictorSPX(6);
  public VictorSPX ballBeltTwo = new VictorSPX(7);

  public VictorSPX index = new VictorSPX(8);
  public VictorSPX flyWheel = new VictorSPX(9);

  public BallSubsystem() {

  }

  public void setBallCollectSpeed(double speed){
    ballCollect.set(ControlMode.PercentOutput, speed);
  }

  public void setBallBeltSpeeds(double speed){
    ballBeltOne.set(ControlMode.PercentOutput, speed);
    ballBeltTwo.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    
  }
}
