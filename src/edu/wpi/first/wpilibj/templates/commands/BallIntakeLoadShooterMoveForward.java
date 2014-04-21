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
public class BallIntakeLoadShooterMoveForward extends CommandBase {
    
    private final int DISTANCE_TO_WALL = 20;
    
    public BallIntakeLoadShooterMoveForward(double driveSpeed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
        requires(shooter);
        requires(drive);
        movementSpeed = driveSpeed;
    }
    double movementSpeed;

    // Called just before this Command runs the first time
    protected void initialize() {
        ballIntake.ballIntakeRollerIn(ballIntake.rollerSpeed * 0.75);
        ballIntake.retractIntake();
        shooter.stopRachetWinch();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        System.out.println("[BallIntakeLoadShooter]:execute :" + ballIntake.isBallInIntake() + ": :" + ballIntake.isBallInShooter());
        ballIntake.ballIntakeRollerIn(ballIntake.rollerSpeed * 0.5);
        ballIntake.retractIntake();
        shooter.stopRachetWinch();
        //if (sharedSensors.getAverageUltrasonicDistance() > DISTANCE_TO_WALL) {
        //drive.setLeftDrive(movementSpeed);
        //drive.setRightDrive(movementSpeed);
        //}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       return ballIntake.isBallInIntake() && ballIntake.isBallInShooter();
    }

    // Called once after isFinished returns true
    protected void end() {
        ballIntake.ballIntakeRollerStop();
        ballIntake.retractIntake();
        shooter.stopRachetWinch();
        drive.setLeftDrive(0, false);
        drive.setRightDrive(0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        ballIntake.ballIntakeRollerStop();
        ballIntake.retractIntake();
        shooter.stopRachetWinch();
        drive.setLeftDrive(0, false);
        drive.setRightDrive(0, false);
    }
}
