package edu.wpi.first.wpilibj.templates.commands;

/**
 * Command that stops all processes.
 * @author Tech
 */
public class AllStop extends CommandBase {

    /**
     * Constructor for the AllStop class.
     */
    public AllStop() {
        //requires(gearShift); //requires all subsystems. forces them to stop what they are doing.
        requires(shooter);
        requires(ballIntake);
        requires(pressurePlate);
        requires(visionProcessing);
        requires(drive);
        requires(airCompressor);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("allstop/button 1");
    }

   /**
    * Method that stops all processes.
    */
    protected void execute() {
//        System.out.println("[AllStop]:Executing");
      ballIntake.ballIntakeRollerStop();
      //gearShift.gearLow();
      shooter.stopRachetWinch();
      shooter.setTriggerIn();
      pressurePlate.DeactivatePressurePlate();
      visionProcessing.CameraNullify();
      drive.setRightDrive(0, false);
      drive.setLeftDrive(0, false);
      airCompressor.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
//        System.out.println("[AllStop]:End");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}