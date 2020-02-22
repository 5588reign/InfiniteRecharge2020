/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSubsystem extends SubsystemBase {

  private final NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");

  public LimelightSubsystem(int pipeline) {
    limelight.getEntry("pipeline").setNumber(pipeline);
  }
  // ^ Sets which pipeline the limelight is working off of

  public LimelightSubsystem(){
    this(1);
  }
  // ^ If no pipeline is entered, this constructor makes it pipeline zero
  // ^ FIX: Depending on how we set it up, we should change this

  public boolean hasTarget() {
    return limelight.getEntry("tv").getDouble(0.0) > 0.0; 
  }

  public double getX() {
    return limelight.getEntry("tx").getDouble(0.0);
  }

  public double getY() {
    return limelight.getEntry("ty").getDouble(0.0);
  }

  public double getArea() {
    return limelight.getEntry("ta").getDouble(0.0);
  }
  // ^ Our epic limelight methods!

  @Override
  public void periodic() {

  }
}
