/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author grr340
 */
public class WaitForCameraIsHot extends CommandBase {
    private boolean cameraFunctioning = false;
    public WaitForCameraIsHot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(visionProcessing);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try{
            cameraFunctioning = SmartDashboard.getBoolean("CameraFunctioning");
        } catch(Exception e){
            
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return cameraFunctioning && isHotOrNot;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
