/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Tech
 */
public class BallIntakeKeepBallOffFloor extends CommandBase {
    
    public BallIntakeKeepBallOffFloor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        sharedSensors.ActivateGreenLED();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        System.out.println("[BallIntakeKeepBallOffFloor]:executing:");
        if (ballIntake.isBallInShooter()){
            ballIntake.ballIntakeRollerStop();
        }
        else if(!ballIntake.isBallInIntake()) {
            ballIntake.ballIntakeRollerIn(ballIntake.rollerSpeed);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        ballIntake.ballIntakeRollerStop();
//        System.out.println("[BallIntakeKeepBallOffFloor]:end:");
        sharedSensors.DeactivateLEDs();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
