package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Joystick xboxDriverController1 = new Joystick(1);
    Button buttonA1 = new JoystickButton(xboxDriverController1, 1);
    Button buttonB1 = new JoystickButton(xboxDriverController1, 2);
    Button buttonX1 = new JoystickButton(xboxDriverController1, 3);
    Button buttonY1 = new JoystickButton(xboxDriverController1, 4);
    Button buttonLB1 = new JoystickButton(xboxDriverController1, 5);
    Button buttonRB1 = new JoystickButton(xboxDriverController1, 6);
    Button buttonBack1 = new JoystickButton(xboxDriverController1, 7);
    Button buttonStart1 = new JoystickButton(xboxDriverController1, 8);
    Button buttonLeftStick1 = new JoystickButton(xboxDriverController1, 9);
    
    public class RightTrig1 extends Button
    {
        public boolean get(){
            return xboxDriverController1.getRawAxis(3) < -.5;
        }
    }
    RightTrig1 rightTrig1 = new RightTrig1();
    
    public class leftTrig1 extends Button{
        public boolean get(){
            return xboxDriverController1.getRawAxis(3) > .5;
        }
    }
     leftTrig1 leftTrig1 = new leftTrig1();
    
    
    Joystick xboxCoDriverController = new Joystick(2);
    Button buttonA2 = new JoystickButton(xboxCoDriverController, 1);
    Button buttonB2 = new JoystickButton(xboxCoDriverController, 2);
    Button buttonX2 = new JoystickButton(xboxCoDriverController, 3);
    Button buttonY2 = new JoystickButton(xboxCoDriverController, 4);
    Button buttonLB2 = new JoystickButton(xboxCoDriverController, 5);
    Button buttonRB2 = new JoystickButton(xboxCoDriverController, 6);
    Button buttonBack2 = new JoystickButton(xboxCoDriverController, 7);
    Button buttonStart2 = new JoystickButton(xboxCoDriverController, 8);
    public class RightTrig2 extends Button{
        public boolean get(){
            return xboxCoDriverController.getRawAxis(3) < -.5;
        }
    }
    public RightTrig2 rightTrig2 = new RightTrig2();
    
    public class leftTrig2 extends Button{
        public boolean get(){
            return xboxCoDriverController.getRawAxis(3) > .5;
        }
    }
    public leftTrig2 leftTrig2 = new leftTrig2();
    
    Joystick manualOveride = new Joystick(3);
    Button button2 = new JoystickButton(manualOveride, 2);
    Button button3 = new JoystickButton(manualOveride, 3);
    Button button4 = new JoystickButton(manualOveride, 4);
    Button button5 = new JoystickButton(manualOveride, 5);
    Button button6 = new JoystickButton(manualOveride, 6);
    Button button7 = new JoystickButton(manualOveride, 7);
    Button button8 = new JoystickButton(manualOveride, 8);
    Button button9 = new JoystickButton(manualOveride, 9);
    Button button10 = new JoystickButton(manualOveride, 10);
    Button button11 = new JoystickButton(manualOveride, 11);
    Button button12 = new JoystickButton(manualOveride, 12);
    Button button1 = new JoystickButton((manualOveride), 1);
    
 
    

    
    /**
     * Constructor for the OI class.
     */
    public OI() {
        //These are the Driver Buttons, denoted by the appended 1
        
        //////////////
        //  Driver  //
        //////////////
        
        buttonA1.whenPressed(new SafePosition());
        buttonB1.whenPressed(new ManualShooterSetTriggerOut());
        buttonX1.whenPressed(new WaitForHot());
        //buttonX1.whenPressed(new ManualShooterPrepareTrussPiston());
        //buttonY1.whenPressed(new ManualShooterReleaseTrussPiston());
        buttonLB1.whenPressed(new ActivatePressurePlate());
        buttonLB1.whenReleased(new DeactivatePressurePlate());
        buttonRB1.whenPressed(new ShooterPullBackWithEncoder());
        //buttonRB1.whenReleased(new PrintCommand("button1 pressed"));
        //buttonBack1.whenPressed(new );
//        buttonBack1.whenPressed(new TakeImageAndFilteredImage());
        //buttonStart1.whenActive(new LEDDisabledFlash());
        //leftTrig1.whenPressed(new );
        //rightTrig1.whenPressed(new );
        
        
        /////////////////
        //  Co-Driver  //
        /////////////////
        
        buttonA2.whenPressed(new SafePosition());
        buttonB2.whenPressed(new GetBallAutonomously());
        buttonX2.whenPressed(new HumanIntake());
        buttonY2.whenPressed(new BallIntakePassBall());
        buttonY2.whenReleased(new ManualBallIntakeRollerStop());
        buttonLB2.whenPressed(new ShootOverTruss());
        //buttonRB2.whenPressed(new BallIntakeBallMine());
//        buttonBack2.whenPressed(new VisionTakeImageForCalibration());
        buttonStart2.whenPressed(new ManualBallIntakeRollerIn());
        buttonStart2.whenReleased(new ManualBallIntakeRollerStop());
        //leftTrig2.whenPressed(new ShootOverTruss());/////Do NOT CHANGE SEE BELOW////////
        rightTrig2.whenPressed(new ShootAutonomously());
        //rightTrig2.whenPressed(new ShotCam());
        
        buttonRB2.whenPressed(new BallIntakeGetBallOffFloor());
        
        /////////////////
        // Arduino uno //
        /////////////////
        
        button12.whenPressed(new ManualBallIntakeRollerOut());
        button12.whenReleased(new ManualBallIntakeRollerStop());
        //button1.whenReleased(new ManualBallIntakeGoToMid());
        button1.whenPressed(new ManualShooterSetTriggerOut());
        button1.whenReleased(new ManualShooterSetTriggerIn());
//        button3.whenReleased(new ManualShooterStopRachetWinch());
        //button3.whenPressed(new AllStop());
        button2.whenPressed(new ManualShooterWinchIn());
        button2.whenReleased(new ManualShooterStopRachetWinch());
//        button4.whenReleased(new ManualShooterSetTriggerIn());
        button3.whenPressed(new ManualBallIntakeRollerIn());
        button3.whenReleased(new ManualBallIntakeRollerStop());
//        button6.whenPressed(new PrintCommand("button1 5"));
//        button6.whenReleased(new ManualBallIntakeGoToMid());
//        button7.whenPressed(new PrintCommand("button1 6"));
//        button7.whenReleased(new ManualBallIntakeGoToMid());
        button8.whenPressed(new ManualBallIntakeRetract());
        button8.whenReleased(new ManualBallIntakeGoToMid());
//        button8.whenReleased(new ManualBallIntakeRollerStop());
       /*button9.whenPressed(new ManualShooterReleaseTrussPiston());
        button10.whenActive();
        button11.whenInactive(new ManualShooterSetTriggerIn());
        button12.whenPressed(new ManualShooterStopRachetWinch());
        button1.whenPressed();
        */
        
//        button9.whenPressed(new PrintCommand("button1 8"));
        button10.whenPressed(new ManualBallIntakeDeployIntake());
        button10.whenReleased(new ManualBallIntakeGoToMid());
//        button11.whenPressed(new PrintCommand("button1 10"));
//        button12.whenPressed(new ManualBallIntakeRollerIn());
//        button12.whenReleased(new ManualBallIntakeRollerStop());
//        button2.wait();
        
        }

    /**
    * Accessor method for the x-axis of the drivers controller.
    * @return the x-axis of the driver controller. 
     */
    public double getDriveMove() {
        return xboxDriverController1.getRawAxis(1); //x-axis
    }

    /**
    * Accessor method for the y-axis of the drivers controller.
    * @return the y-axis of the driver controller. 
    */
    public double getDriveRotate() {
        return xboxDriverController1.getRawAxis(2); //y-axis
    }
    
    public double getRollerMove() {
        return 0;//xboxDriverController1.getRawAxis(3); //x-axis of second joystick
    }
    
    public double getManualMove() {
        return manualOveride.getRawAxis(1);
    }
    
    public double getManualRotate() {
        return manualOveride.getRawAxis(2);
    }
    
    ////// This trigger is used for a human interference for the truss shot//////
    public boolean getTrussFireButton() {
        //System.out.println("trigger left is"+leftTrig2.get());
        return leftTrig2.get();
    }
    
    public boolean getUnrestrictedDrive() {
        return buttonLeftStick1.get();
    }
    public boolean isDriverBannerActivated() {
        return button7.get();
    }
    
    //// CREATING BUTTONS
    // One type of button1 is a joystick button1 which is any button1 on a joystick.
    // You create one by telling it which joystick it's on and which button1
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button1 = new JoystickButton(stick, buttonNumber);
    // Another type of button1 you can create is a DigitalIOButton, which is
    // a button1 or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button1 = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button  you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button1, it's trivial to bind it to a button1 in one of
    // three ways:
    // Start the command when the button1 is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button1.whenPressed(new ExampleCommand());
    // Run the command while the button1 is being held down and interrupt it once
    // the button1 is released.
    // button1.whileHeld(new ExampleCommand());
    // Start the command when the button1 is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button1.whenReleased(new ExampleCommand());
}
