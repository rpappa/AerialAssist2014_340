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
public class DriveFwd extends CommandBase {
    private double speed;
    public DriveFwd(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drive.setLeftDrive(speed, false);
        drive.setRightDrive(speed, false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.setLeftDrive(speed, false);
        drive.setRightDrive(speed, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.setLeftDrive(0, false);
        drive.setRightDrive(0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drive.setLeftDrive(0, false);
        drive.setRightDrive(0, false);
    }
}