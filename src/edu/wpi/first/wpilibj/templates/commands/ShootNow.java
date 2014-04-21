package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that shoots the ball now.
 * @author grr340
 */
public class ShootNow extends CommandBase {
    int loop = 0;
    /**
     * Constructor for the ShootNow class.
     */
    public ShootNow() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**
     * Shoots the ball.
     */
    protected void execute() {
        shooter.setTriggerOut();
        System.out.println("shot");
        loop++;
    }

   /**
    * Is finished when it is triggered.
    * @return 
    */
    protected boolean isFinished() 
    {
        return ((ballIntake.isBallInShooter() /*&& ballIntake.isBallInIntake()*/) == false) && (shooter.isArmStopped() && (loop>1));
    }

    /**
     * Puts the trigger in.
     */
    protected void end() {
        //I don't think we should do this, due to timing we might stop mid shot -JPL
        //shooter.setTriggerIn();
//        System.out.println("[ShootNow]:Done");
        shooter.ReleaseTrussPiston();
        shooter.resetEncoder();
    }   

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        shooter.ReleaseTrussPiston();
    }
}
