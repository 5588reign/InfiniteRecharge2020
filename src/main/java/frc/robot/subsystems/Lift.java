/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftCommand;
import frc.robot.*;


/**
 * Add your docs here.
 */
public class Lift extends Subsystem implements MotherSystem {
  //distance per pulse = pi * the wheel diameter in inches / pulse per revolution * fudge factor
  private final Encoder lifterEncoder = new Encoder(RobotMap.LIFTER_ENCODER_SOURCE_A, RobotMap.LIFTER_ENCODER_SOURCE_B);
  private static final double DISTANCE_PER_PULSE_INCHES = (Math.PI * 1.25) / 1024 * 1;

  //TalonSRX liftMotor = new TalonSRX(0);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Lift () {
    //liftMotor.configFactoryDefault();
    //liftMotor.setInverted(false);
    lifterEncoder.setDistancePerPulse(DISTANCE_PER_PULSE_INCHES);
  }

  public void setSpeed(double percentSpeed) {
    //liftMotor.set(ControlMode.PercentOutput, percentSpeed);
  }

  public void setSpeedWithDirection(double percentSpeed, double distance){
    if(distance > this.getLifterEncoderDistance()){
      this.setSpeed(percentSpeed);
    }
    else if(distance < this.getLifterEncoderDistance()){
      this.setSpeed(-percentSpeed);
    }
  }

  public double deadZone(double speed) {
    if (Math.abs(speed) < .05) {
      return 0;
    }
    else {
      return speed;
    }
  }

  public double squareSpeed(double speed) {
    if (speed < 0) {
      speed = -(speed * speed);
    }
    else {
      speed = speed * speed;
    }
    return speed;
  }

  public double interpretSpeed(double speed) {
    speed = squareSpeed(speed);
    speed = deadZone(speed);
    return speed;
  }

  public void liftToggleXbox(XboxController joystick) {
    double speed = interpretSpeed(-joystick.getRawAxis(1));
    setSpeed(speed);
  }

  public void resetEncoder() {
    lifterEncoder.reset();
  }

  public double getLifterEncoderDistance() {
    return lifterEncoder.getDistance();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LiftCommand());
  }
}
