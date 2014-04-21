package edu.wpi.first.wpilibj.templates.commands;

/**
 * Commands that drives to a distance according to an ultrasonic.
 * @author Robotics
 */
public class DriveToDistance extends CommandBase {
    private static final double DISTANCE_TO_DRIVE_TO = 15;
    private static final double SPEED_OF_DRIVE = .5;
    
    /**
     * Constructor for the DriveToDistance class.
     */
    public DriveToDistance() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Uses ultrasonics to determine when to stop.
     */
    protected void execute() {
        if (sharedSensors.getFltrdBoth() >= DISTANCE_TO_DRIVE_TO) {
        //    if (sharedSensors.getAverageUltrasonicDistance() >= DISTANCE_TO_DRIVE_TO) {
            drive.setLeftDrive(SPEED_OF_DRIVE, false);
            drive.setRightDrive(SPEED_OF_DRIVE, false);
        } else {
            drive.setLeftDrive(-SPEED_OF_DRIVE, false);
            drive.setLeftDrive(-SPEED_OF_DRIVE, false);
        }
//        System.out.println("[drive] execute : Distance = " + sharedSensors.getAverageUltrasonicDistance());
   }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !(sharedSensors.getAverageUltrasonicDistance() >= DISTANCE_TO_DRIVE_TO);
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.setLeftDrive(0, false);
        drive.setRightDrive(0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
