package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TurnInplaceCommand extends CommandBase {
    private final DriveSubsystem m_driveSubsystem;
    private final double m_rotation;
    private final double m_speed;

    // rotation should be in degrees
    public TurnInplaceCommand(double rotation, double speed, DriveSubsystem drive) {
	    m_rotation = Math.abs(rotation); // must be _magnitude_ in degrees
	    m_speed = speed;
	    m_driveSubsystem = drive;
    }

    @Override
    public void initialize() {
      m_driveSubsystem.resetEncoders();
      m_driveSubsystem.tankDrive(-m_speed, m_speed);
    }

    @Override
    public void end(boolean interrupted) {
      m_driveSubsystem.tankDrive(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
      return Math.abs(m_driveSubsystem.getLeftEncoderDistance()) >= m_rotation;
    }
}
