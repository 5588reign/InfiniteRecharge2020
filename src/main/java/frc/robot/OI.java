/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.BallCollect;
import frc.robot.commands.EncoderDrive;
import frc.robot.commands.GyroscopeTurn;
//import frc.robot.commands.SwitchCamera;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private static final int A_BUTTON_XBOX = 1;
  private static final int B_BUTTON_XBOX = 2;
  private static final int X_BUTTON_XBOX = 3;
  private static final int Y_BUTTON_XBOX = 4;
  private static final int LEFT_BUMPER_XBOX = 5;
  private static final int RIGHT_BUMPER_XBOX = 6;
  private static final int BACK_ARROW = 7;
  private static final int START_ARROW = 8;
  private static final int JOYSTICK_RIGHT_CLICK = 10;
  private static final int JOYSTICK_LEFT_CLICK = 9;

  private final XboxController driverXBox = new XboxController(1);
  private final XboxController controllerXBox = new XboxController(2);

  //Button ballCollectButtonBackward = new JoystickButton(controllerXBox, A_BUTTON_XBOX);


  Button hatchGrabberButton = new JoystickButton(controllerXBox, B_BUTTON_XBOX);
  Button hatchPusherButton = new JoystickButton(controllerXBox, A_BUTTON_XBOX);
  //Button lightAlignmentButton = new JoystickButton(manipulatorJoystick, START_ARROW);

  //Button visionAlignmentButton = new JoystickButton(driverXBox, BUTTON_12_JOYSTICK);
  Button turnRightButton = new JoystickButton(driverXBox,RIGHT_BUMPER_XBOX);
  Button turnLeftButton = new JoystickButton(driverXBox,LEFT_BUMPER_XBOX);
  //Button turnRight90Button = new JoystickButton(driverXBox, BUTTON_5_JOYSTICK);
  //Button turnLeft90Button = new JoystickButton(driverXBox, BUTTON_6_JOYSTICK);

  Button justDanceButton = new JoystickButton(driverXBox, A_BUTTON_XBOX);
  //Button secondLevelLift = new JoystickButton(manipulatorJoystick, X_BUTTON_XBOX);
  //Button thirdLevelLift = new JoystickButton(manipulatorJoystick, Y_BUTTON_XBOX);

  Button extendBothPneumatics = new JoystickButton(controllerXBox, START_ARROW);
  Button retractBothPneumatics = new JoystickButton(driverXBox, BACK_ARROW);
  Button retractFrontPneumatic = new JoystickButton(controllerXBox, LEFT_BUMPER_XBOX);
  Button retractBackPneumatic = new JoystickButton(controllerXBox, RIGHT_BUMPER_XBOX);
  
  //Button driveOffHab = new JoystickButton(manipulatorJoystick, LEFT_BUMPER_XBOX);
  //Button driveOntoHab = new JoystickButton(manipulatorJoystick, X_BUTTON_XBOX);

  //Button switchCamera = new JoystickButton(driverXBox, JOYSTICK_RIGHT_CLICK);
  
  Button autoReverse = new JoystickButton(controllerXBox, Y_BUTTON_XBOX);

  //Button lockLift = new JoystickButton(manipulatorJoystick, RIGHT_BUMPER_XBOX);

  //Button lightSensor = new JoystickButton(driverXBox, BUTTON_9_JOYSTICK);


  public OI() {
    turnRightButton.whenPressed(new GyroscopeTurn(3));
    turnLeftButton.whenPressed(new GyroscopeTurn(-3));

    justDanceButton.whenPressed(new EncoderDrive(200,0.5));


    //turnRight90Button.whenPressed(new GyroscopeTurn(-90));
    //turnLeft90Button.whenPressed(new GyroscopeTurn(90));
  

    //switchCamera.whenPressed(new SwitchCamera());

    //driveOffHab.whenPressed(new RightCargoAuto());
    //driveOntoHab.whenPressed(new DriveHABMotor());

    //lockLift.whenPressed(new LockLift(RobotMap.LOCK_LIFT_SPEED)); //THIS IS A HOLDER VALUE, FIGURE OUT WHAT SPEED THE LIFT DRIFTS DOWN AT!!! please
    
    //lightSensor.whenPressed(new LightSensor(100));
    

  }

  public XboxController getDriverXBox() {
    return driverXBox;
  }

  public XboxController getControllerXBox() {
    return controllerXBox;
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
