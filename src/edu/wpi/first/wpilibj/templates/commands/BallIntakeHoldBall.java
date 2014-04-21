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
public class BallIntakeHoldBall extends CommandBase {

    public BallIntakeHoldBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        System.out.println("[ballIntakeHoldBall] intializes");
        shooter.ReleaseTrussPiston();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        System.out.println("[ballIntakeHoldBall] executing" + (ballIntake.isBallInShooter() && ballIntake.isBallInIntake()));
        if (ballIntake.isBallInIntake() || ballIntake.isBallInShooter()) {
            ballIntake.goToMid();
            ballIntake.ballIntakeRollerIn(ballIntake.rollerSpeed * 0.5);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ballIntake.isBallInShooter() && ballIntake.isBallInIntake();
    }

    // Called once after isFinished returns true
    protected void end() {
//        System.out.println("[ballIntakeHoldBall] ends");
        ballIntake.ballIntakeRollerStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
