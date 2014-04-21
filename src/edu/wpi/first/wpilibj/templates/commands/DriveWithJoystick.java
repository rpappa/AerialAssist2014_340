package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStation;



/**
 * Command that allows the robot to be driven with joysticks.
 * @author grr340
 */
public class DriveWithJoystick extends CommandBase {

    /**
     * Constructor for the DriveWithJoystick class.
     */
    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Takes user input and sets motors.
     */
    protected void execute() 
    {
        //System.out.print(sharedSensors.getAverageFilteredUltrasonic());
        //if (oi.getDriveMove() + oi.getDriveRotate() > 0) {
        if (DriverStation.getInstance().getBatteryVoltage() > 8) {
        drive.arcadeDrive(oi.getDriveMove(), oi.getDriveRotate(),true, oi.getUnrestrictedDrive(), false);
        } else {
            drive.arcadeDrive(oi.getDriveMove(), oi.getDriveRotate(),true, oi.getUnrestrictedDrive(), true);
        }
        //DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser6, 1,""+oi.leftTrig2.get()+"   "+oi.rightTrig2.get());
        //}
     //   System.out.println("drive left:" + drive.leftMotorSpeed);
     //   System.out.println("drive right:" + drive.rightMotorSpeed);
     //   System.out.println("Ultrasonic Average:" + sharedSensors.getAverageUltrasonicDistance());
     //   System.out.println("Ultrasonic left:" + sharedSensors.getLeftUltrasonicDistance());
     //   System.out.println("Ultrasonic right:" + sharedSensors.getRightUltrasonicDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
