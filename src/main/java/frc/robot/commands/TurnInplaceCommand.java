package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TurnInplaceCommand extends CommandBase {
    private final DriveSubsystem m_robotDrive;
    private final double m_rotation;
    private final double m_speed;

    // rotation should be in degrees
    public TurnInplaceCommand(double rotation, double speed, DriveSubsystem drive) {
	    m_rotation = Math.abs(rotation); // must be _magnitude_ in degrees
	    m_speed = speed;
      m_robotDrive = drive;
      addRequirements(m_robotDrive);
    }

    @Override
    public void initialize() {
      m_robotDrive.tankDrive(-m_speed, m_speed);
      m_robotDrive.resetEncoders();
    }

    @Override
    public void end(boolean interrupted) {
      m_robotDrive.tankDrive(0.0, 0.0);
      m_robotDrive.resetEncoders();
    }

    @Override
    public boolean isFinished() {
      return Math.abs(m_robotDrive.getLeftEncoderDistance()) >= m_rotation;
    }
}
