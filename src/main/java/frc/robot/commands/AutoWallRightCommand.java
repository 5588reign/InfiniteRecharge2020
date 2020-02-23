package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

/**
 * A complex auto command that drives forward, releases a hatch, and then drives backward.
 */
public class AutoWallRightCommand extends SequentialCommandGroup {


  
  public AutoWallRightCommand(DriveSubsystem drive) {
      // Drive forward some distance and turn in place
      addCommands(
		    new DriveDistanceCommand(Constants.AUTO_INIT_FORWARD_DISTANCE, Constants.AUTO_INIT_FORWARD_SPEED,  drive),
		    new LimelightDistanceCommand(RobotContainer.m_limelight, drive),
        new ParallelDeadlineGroup(
          ShootCommand.shootBall(3),
          new FlywheelStartCommand(RobotContainer.m_ballSubsystem)
        )
      );
    }

}


