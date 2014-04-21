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
public class BallIntakeEjectBall extends CommandBase {
    
    public BallIntakeEjectBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       shooter.stopRachetWinch();
       sharedSensors.ActivateRedLED();
       shooter.PrepareTrussPiston();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        System.out.println("[BallIntakeEjectBall]:Executing" + ballIntake.isBallInIntake());
        if(!shooter.isArmDown()){
            ballIntake.ballIntakeRollerOut(ballIntake.rollerSpeed);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !ballIntake.isBallInIntake() || shooter.isArmDown();//this way we are sure the ball is out of the robot.
    }

    // Called once after isFinished returns true
    protected void end() {
//        System.out.println("[BallIntakeEjectBall]:End");
        ballIntake.ballIntakeRollerStop();
        sharedSensors.DeactivateLEDs();
        shooter.ReleaseTrussPiston();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
