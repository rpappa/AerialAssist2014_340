/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author grr340
 */
public class LEDDisabledFlash extends CommandBase {
    
    public LEDDisabledFlash() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        setRunWhenDisabled(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        int time = (int)timeSinceInitialized();
        if (time%2 == 1) {
            sharedSensors.ActivateGreenLED();
        }
        if (time%3 == 1) {
            sharedSensors.ActivateRedLED();
        }
        else {
            sharedSensors.ActivateYellowLED();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        sharedSensors.DeactivateLEDs();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        sharedSensors.DeactivateLEDs();
    }
}
