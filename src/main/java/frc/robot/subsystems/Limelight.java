/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.networktables.*;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry xFromCrosshair = table.getEntry("tx");
  NetworkTableEntry yFromCrosshair = table.getEntry("ty");
  NetworkTableEntry areaOfObject = table.getEntry("ta");

  //read values periodically
  // double x = xFromCrosshair.getDouble(0.0);


  public Limelight(){

  }

  public double getLimelightX(){
    double x = xFromCrosshair.getDouble(0.0);
    return x;
  }

  public double getLimelightY(){
    double y = yFromCrosshair.getDouble(0.0);
    return y; 
  }

  public double getLimelightArea(){
    double area = areaOfObject.getDouble(0.0);
    return area; 
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
