package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TurnInplaceCommand extends CommandBase {
    private static final double POSITION_PER_REV = 7.0 / 30.0; // depends on PCF
    private final DriveSubsystem m_driveSubsystem;
    private final double m_rotation;
    private final double m_speed;
    private double origin;
    private double target;

    // rotation should be signed degrees, positve counter clockwise, speed should be positive
    public TurnInplaceCommand(double rotation, double speed, DriveSubsystem drive) {
      m_rotation = rotation * POSITION_PER_REV;
      m_speed = Math.abs(speed);
      m_driveSubsystem = drive;
      addRequirements(m_driveSubsystem);
    }

    @Override
    public void initialize() {
	origin = m_driveSubsystem.getLeftEncoderDistance();
	target = Math.signum(m_rotation) * m_speed + origin;
    }

    @Override
    public void execute() {
      m_driveSubsystem.tankDrive(m_speed, -m_speed);
    }

    @Override
    public void end(boolean interrupted) {
      m_driveSubsystem.tankDrive(0.0, 0.0);
    }

    @Override
    public boolean isFinished() {
      double current = m_driveSubsystem.getLeftEncoderDistance();
      if (m_rotation > 0) {
	      return current >= target;
      } else {
	      return current <= target;
      }
    }
}
