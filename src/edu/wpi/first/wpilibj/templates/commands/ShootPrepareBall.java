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
public class ShootPrepareBall extends CommandBase {
    
    public ShootPrepareBall(int debounceTime) {
        // Use requires() here to declare subsystem dependencies
        requires(ballIntake);
        thresToTriggerDebounce = debounceTime;
    }
    
    int numConsecutiveForDebounce = 0;
    int thresToTriggerDebounce;

    // Called just before this Command runs the first time
    protected void initialize() {
        ballIntake.goToMid();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        ballIntake.ballIntakeRollerIn(ballIntake.rollerSpeed *0.2);
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
