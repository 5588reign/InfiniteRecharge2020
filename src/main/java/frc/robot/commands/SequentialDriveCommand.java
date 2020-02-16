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
import frc.robot.subsystems.DriveSubsystem;

public class SequentialDriveExampleCommand extends SequentialCommandGroup {
  private static final double FORWARD_DISTANCE = 12;
  private static final double FORWARD_SPEED = 1;
  private static final double TURN_DISTANCE = 12;

  public SequentialDriveExampleCommand(DriveSubsystem drive) {
      // Drive forward some distance and turn in place
      addCommands(
		  new DriveDistanceCommand(FORWARD_DISTANCE, FORWARD_SPEED,  drive),
		  new TurnInplaceCommand(TURN_DISTANCE, FORWARD_SPEED,  drive)
		  );
    }

}