package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static final int SHOOTER_DEBOUNCE_TIME_LONG = 50;
    public static final int SHOOTER_DEBOUNCE_TIME = 30;
    public static final int SHOOTER_AUTO_DEBOUNCE_TIME = 20;
    
    public static final double AUTO_MOVE_SPEED = 0.3;
    public static final double AUTO_MOVE_SPEED_THREE_BALL = 0.5;
    
    // PWM Port Maps
    public static final int leftMtr1Port = 1;
    public static final int leftMtr2Port = 2;
    public static final int leftMtr3Port = 3;
    public static final int rightMtr1Port = 4;
    public static final int rightMtr2Port = 5;
    public static final int rightMtr3Port = 6;
    public static final int intakeRollerPort = 9;
    public static final int winchPort = 7;
    public static final int winchPort2 = 8;
    // public static final int dummyPort3 = 9;
    // public static final int dummyPort4 = 10;
    
    // Relay Port Maps
    public static final int compressorRelay = 2;
    
    //Analog input Port Maps
    public static final int leftUltraPort = 7;
    public static final int leftBannerPort = 8;
    public static final int armPositionPort = 1;
    public static final int rightBannerPort = 2;
    public static final int rightUltraPort = 5;
    // public static final int dummyPort4 = 7;
    // public static final int dummyPort5 = 8;
    // public static final int dummyPort6 = 9;
    
    //Digital Port Maps
    public static final int isArmDownReedSwitch = 1; //reed switch
    public static final int checkIntakePort = 2;     //the banner in the intake
    public static final int isArmDownLimit1 = 3;     // beefy limit switch
    public static final int isArmDownLimit2 = 4;     //wimpy limit switch
    //don't use 5. 5 is dead.
    public static final int ballDetectorPort = 7;    //IR to see ball
    public static final int isBallShotSensorPort = 6;//the banner below the reed
    public static final int encoderPort1 = 12;
    public static final int encoderPort2 = 13;

    public static final int ballDetectorPortRight = 6;//IR to see ball Right
    public static final int ballDetectorPortLeft = 7;    //IR to see ball Left
    
    
    public static final int pressureSwitchPort = 14; //

    //
    //
    
    
    
    //Solenoid Port Maps
    public static final int mechanismDeployer1FwdPort = 5;
    public static final int mechanismDeployer1RevPort = 6;
    public static final int mechanismDeployer2FwdPort = 4;
    public static final int mechanismDeployer2RevPort = 3;
    //
    public static final int winchReleasePort = 2;
    
    public static final int pressurePlatePort = 1;
    //Solenoid Ports for LEDs
    //public static final int redLEDPort = 7;
    public static final int greenLEDPort = 7;
    public static final int shooterPistonPort = 8;
    public static int shotnumber = 0;
    public static int picnumber = 0;
}
