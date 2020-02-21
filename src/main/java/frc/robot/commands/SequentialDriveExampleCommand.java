package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.commands.TurnInplaceCommand;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A complex auto command that drives forward, releases a hatch, and then drives backward.
 */
public class SequentialDriveExampleCommand extends SequentialCommandGroup {
  private static final double FORWARD_DISTANCE = 120;
  private static final double FORWARD_SPEED = 0.50;
  private static final double TURN_DISTANCE = 12;
  public SequentialDriveExampleCommand(DriveSubsystem m_drive) {
      // Drive forward some distance and turn in place
      addCommands(
      new DriveDistanceCommand(FORWARD_DISTANCE, FORWARD_SPEED,  m_drive),
      new DriveDistanceCommand(FORWARD_DISTANCE * 2, FORWARD_SPEED,  m_drive)
		  //new TurnInplaceCommand(TURN_DISTANCE, FORWARD_SPEED,  m_drive)
		  );
    }

}
