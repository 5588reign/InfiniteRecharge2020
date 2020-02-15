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
//import sun.nio.ch.Net;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  private final NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");

  public Limelight(int pipeline) {

    limelight.getEntry("pipeline").setNumber(pipeline);

  }

  public Limelight(){
    this(0);
  }

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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
