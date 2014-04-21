package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that turns the rollers on to get the ball.
 * @author Tech
 */
public class BallIntakeGetBallOffFloorReverse extends CommandBase {
    
    /**
     * Constructor for the GetBall class.
     */
    public BallIntakeGetBallOffFloorReverse() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
        requires(shooter);
        requires(drive);
    }

    /**
     * Method that turns on the rollers.
     */
    protected void initialize() {
        ballIntake.ballIntakeRollerIn( ballIntake.rollerSpeed);
        ballIntake.deployIntake();
        shooter.stopRachetWinch();
        sharedSensors.ActivateYellowLED();
        
    }

    /**
     * Method that deploys intake.
     */
    protected void execute() {
        
            //TODO add try and catchnew ShooterPullBackWithEncoder()()
//        System.out.println("[BallIntakeGetBallOffFloor]: executing :" + ballIntake.isBallInIntake());
        ballIntake.ballIntakeRollerIn( ballIntake.rollerSpeed);
        ballIntake.deployIntake();
        shooter.stopRachetWinch();
        drive.setLeftDrive(-0.5, false);
        drive.setRightDrive(-0.5, false);
    }

    /**
     * Is finished when ball is in mechanism.
     * @return boolean
     */
    protected boolean isFinished() {
        //TODO When the arm has reached the threshold
        return ballIntake.isBallInIntake();
        
   
    }

    /**
     * Stops rollers when finished.
     */
    protected void end() {
        ballIntake.ballIntakeRollerStop();
        sharedSensors.DeactivateLEDs();
        drive.setLeftDrive(0, false);
        drive.setRightDrive(0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
        drive.setLeftDrive(0, false);
        drive.setRightDrive(0, false);
    }
}