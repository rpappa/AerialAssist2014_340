package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that turns the rollers on to get the ball.
 * @author Tech
 */
public class BallIntakeGetBallOffFloor extends CommandBase {
    
    /**
     * Constructor for the GetBall class.
     */
    public BallIntakeGetBallOffFloor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(ballIntake);
        requires(shooter);
    }

    /**
     * Method that turns on the rollers.
     */
    protected void initialize() {
        ballIntake.ballIntakeRollerIn( ballIntake.rollerSpeed);
        ballIntake.deployIntake();
        shooter.stopRachetWinch();
        //sharedSensors.ActivateYellowLED();
//        System.out.println("Waiting for ball in initialize");
    }

    /**
     * Method that deploys intake.
     */
    protected void execute() {
        
          //TODO add try and catchnew ShooterPullBackWithEncoder()
        ballIntake.ballIntakeRollerIn( ballIntake.rollerSpeed);
        ballIntake.deployIntake();
        shooter.stopRachetWinch();
        System.out.println("Waiting for ball in execute" + ballIntake.isBallInIntake());
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
//        System.out.println("Ball Detected in end");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
