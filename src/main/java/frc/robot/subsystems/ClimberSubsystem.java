/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//IMPORTANT: No idea what is up with the climber, change this subsystem as things happen plz :)
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ClimberSubsystem extends SubsystemBase {
  public VictorSPX climberRight = new VictorSPX(10);
  public VictorSPX climberLeft = new VictorSPX(11);
  // ^ FIX: Holder values in here

  public ClimberSubsystem() {

  }

  @Override
  public void periodic() {

  }
}
