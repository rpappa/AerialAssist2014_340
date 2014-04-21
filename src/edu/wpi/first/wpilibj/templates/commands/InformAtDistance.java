package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.SharedSensors;

/**
 * Command that lights up LED according to how far away you are.
 * @author Robotics
 */
public class InformAtDistance extends CommandBase {
    
    /**
     * Constructor for the InformAtDistance class.
     */
    public InformAtDistance() {
        //We need to require atleast one subsystem so we will require the null subsystem. -JPL
        requires(noSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Lights up LED's according to the distance.
     */
    protected void execute() {
        double Distance = sharedSensors.getAverageUltrasonicDistance();
        
        if (Distance <= 50) {
            sharedSensors.ActivateRedLED();
        }
        if (Distance <= 25) {
            sharedSensors.DeactivateLEDs();
            sharedSensors.ActivateYellowLED();
        }
        if (Distance <= 10) {
            sharedSensors.DeactivateLEDs();
            sharedSensors.ActivateGreenLED();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //TODO: need to intelligently find out when this should be done -JPL
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