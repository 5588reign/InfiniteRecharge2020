/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HatchGrabber;
import frc.robot.commands.LightSensor;
import frc.robot.commands.EncoderLift;
import frc.robot.commands.GyroscopeTurn;
import frc.robot.commands.RaiseRobot;
import frc.robot.commands.LowerRobot;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private static final int A_BUTTON_XBOX = 1;
  private static final int X_BUTTON_XBOX = 3;
  private static final int Y_BUTTON_XBOX = 4;
  private static final int LEFT_BUMPER_XBOX = 5;
  private static final int RIGHT_BUMPER_XBOX = 6;
  private static final int START_ARROW = 8;
  private static final int BUTTON_6_JOYSTICK = 6;
  private static final int BUTTON_7_JOYSTICK = 7;
  private static final int BUTTON_11_JOYSTICK = 11;
  private static final int BUTTON_2_JOYSTICK = 2;
  private final Joystick driverJoystick = new Joystick(0);
  private final XboxController manipulatorJoystick = new XboxController(1);

  Button hatchGrabberButton = new JoystickButton(manipulatorJoystick, RIGHT_BUMPER_XBOX);
  Button hatchPusherButton = new JoystickButton(manipulatorJoystick, LEFT_BUMPER_XBOX);
  Button lightAlignmentButton = new JoystickButton(manipulatorJoystick, START_ARROW);

  Button firstLevelLift = new JoystickButton(manipulatorJoystick, A_BUTTON_XBOX);
  Button secondLevelLift = new JoystickButton(manipulatorJoystick, X_BUTTON_XBOX);
  Button thirdLevelLift = new JoystickButton(manipulatorJoystick, Y_BUTTON_XBOX);

  Button raiseBothPneumatics = new JoystickButton(driverJoystick, BUTTON_6_JOYSTICK);
  Button lowerFrontPneumatic = new JoystickButton(driverJoystick, BUTTON_7_JOYSTICK);
  Button lowerBackPneumatic = new JoystickButton(driverJoystick, BUTTON_11_JOYSTICK);

  Button turnWithGyroButton = new JoystickButton(driverJoystick, BUTTON_2_JOYSTICK);
 


  public OI() {
    hatchGrabberButton.whenPressed(new HatchGrabber(true));
    hatchPusherButton.whenPressed(new HatchGrabber(false));
    lightAlignmentButton.whileHeld(new LightSensor());
    firstLevelLift.whenPressed(new EncoderLift(0.3,0));
    secondLevelLift.whenPressed(new EncoderLift(0.3,40));
    thirdLevelLift.whenPressed(new EncoderLift(0.3,60));
    lowerFrontPneumatic.whenPressed(new LowerRobot(true));
    lowerBackPneumatic.whenPressed(new LowerRobot(false));
    raiseBothPneumatics.whenPressed(new RaiseRobot());
    turnWithGyroButton.whenPressed(new GyroscopeTurn(10));
  }

  public Joystick getDriverJoystick() {
    return driverJoystick;
  }

  public XboxController getXboxController() {
    return manipulatorJoystick;
  }
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
