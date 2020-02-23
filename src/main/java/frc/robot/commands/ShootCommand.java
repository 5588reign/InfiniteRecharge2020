/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShootCommand extends SequentialCommandGroup {
  public ShootCommand(int numBalls) {
    int m_numBalls = numBalls;
    new ParallelDeadlineGroup(shootBall(m_numBalls), new FlywheelStartCommand(RobotContainer.m_ballSubsystem));
  }

  public static SequentialCommandGroup shootBall(int balls){
    int m_balls = balls;
    SequentialCommandGroup beltIndex = new SequentialCommandGroup();
    for(int i = m_balls; i > 0; i--){
      beltIndex.addCommands(
                new BeltOnlyTesterCommand(RobotContainer.m_ballSubsystem, true).withTimeout(Constants.BACKWARDS_BELT_TIME),
                new OneIndexBallCommand(RobotContainer.m_ballSubsystem).withTimeout(Constants.INDEX_ONE_BALL_TIME)
      );
    }
    return beltIndex;
  }

}
