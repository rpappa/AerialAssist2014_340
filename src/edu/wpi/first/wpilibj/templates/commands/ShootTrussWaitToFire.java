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
public class ShootTrussWaitToFire extends CommandBase {
    
    public ShootTrussWaitToFire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        System.out.println("waiting for leftTrig2");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return oi.getTrussFireButton();
    }

    // Called once after isFinished returns true
    protected void end() {
//        System.out.println("fired");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    shooter.ReleaseTrussPiston();
//    System.out.println("interrupted");
    }
}
