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
public class ShootPrepareBallMoveForward extends CommandBase {
    
    public ShootPrepareBallMoveForward(int debounceTime) {
        // Use requires() here to declare subsystem dependencies
        requires(ballIntake);
        requires(drive);
        thresToTriggerDebounce = debounceTime;
    }
    
    int numConsecutiveForDebounce = 0;
    int thresToTriggerDebounce;

    // Called just before this Command runs the first time
    protected void initialize() {
        ballIntake.goToMid();
        //drive.setLeftDrive(0.5);
        //drive.setRightDrive(0.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ballIntake.ballIntakeRollerIn(ballIntake.rollerSpeed *0.1);
        drive.setLimitedLeftDrive(0.5, false);
        drive.setLimitedRightDrive(0.5, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        System.out.println("num hits:" + numConsecutiveForDebounce);
        
        if (ballIntake.isBallInShooter()){
            numConsecutiveForDebounce++;
        }else{
            numConsecutiveForDebounce = 0;
        }
        return numConsecutiveForDebounce>thresToTriggerDebounce;
    }

    // Called once after isFinished returns true
    protected void end() {
        numConsecutiveForDebounce=0;
        ballIntake.ballIntakeRollerStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
