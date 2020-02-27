/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.commands.TurnInplaceCommand;
import frc.robot.commands.LimelightDistanceCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

/**
 * A complex auto command that drives forward, releases a hatch, and then drives backward.
 */
public class SequentialDriveExampleCommand extends SequentialCommandGroup {
  private static final double FORWARD_DISTANCE = 5;
  private static final double FORWARD_SPEED = 0.25;
  private static final double TURN_DISTANCE = 24;
  public SequentialDriveExampleCommand(DriveSubsystem drive, LimelightSubsystem limelight) {
      // Drive forward some distance and turn in place
      addCommands(
      new DriveDistanceCommand(FORWARD_DISTANCE, FORWARD_SPEED,  drive),
      new DriveDistanceCommand(FORWARD_DISTANCE, -FORWARD_SPEED,  drive),
      new LimelightDistanceCommand(limelight, drive)
      //new TurnInplaceCommand(TURN_DISTANCE, FORWARD_SPEED,  drive)
		  );
    }

}
