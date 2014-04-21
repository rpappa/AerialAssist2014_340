package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
//import edu.wpi.first.wpilibj.Timer;

/**
 * Command that pulls the shooter to goal position.
 *
 * @author grr340
 */
public class ShooterPullAllTheWayBack extends CommandBase {

    //Timer timeA = new Timer();
    private boolean hasSeenReedSwitch = false;

    /**
     * Constructor for the ShooterPullToGoalPos class.
     */
    public ShooterPullAllTheWayBack() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        System.out.println("[ShooterPullAllTheWayBack]: init");
        hasSeenReedSwitch = false;
        shooter.setTriggerIn();
        //timeA.start();
        //timeA.reset();
        sharedSensors.ActivateRedLED();
        shooter.ReleaseTrussPiston();
    }

    /**
     * Pulls back the shooter.
     */
    protected void execute() {
        double speed = 0;
//        System.out.println("[ShooterPullAllTheWayBack]: executing :" + shooter.isArmDown());
        if (shooter.isArmDownReed() == false) {
//            System.out.println("[ShooterPullAllTheWayBack]: stage1");
            //shooter.setRachetWinch(shooter.PULL_SPEED);
            speed = shooter.PULL_SPEED;
//            System.out.println("pulling back");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "Reed" + shooter.isArmDownReed.get() + "");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, "lim1" + shooter.isArmDownLimit1.get() + "");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "lim2" + shooter.isArmDownUSwitch.get() + "");
            DriverStationLCD.getInstance().updateLCD();
            //hasSeenReedSwitch = shooter.isArmDownReed();
        }
        else if (shooter.isArmDownReed() == true /*&& !shooter.isArmDown()**/) {
//            System.out.println("[ShooterPullAllTheWayBack]: stage2");
            //shooter.setRachetWinch(shooter.PULL_SPEED*0.5);
            speed = 0;
            speed = shooter.PULL_SPEED*0.4;
        }
        
        if(!shooter.isArmDown())
        {
            speed = shooter.PULL_SPEED*0.7;  //was *0.375
        }
        
        else if (shooter.isArmDown()) {
//            System.out.println("[ShooterPullAllTheWayBack]: stage3");
            //shooter.stopRachetWinch();
            speed = 0;
        }
//        System.out.println("[ShooterPullAllTheWayBack]: speed:"+speed);
        shooter.setRachetWinch(speed);
    }

    /**
     * Is finished when the shooter is down.
     *
     * @return boolean
     */
    protected boolean isFinished() {
        return shooter.isArmDown();
    }

    /**
     * When finished it stops pulling.
     */
    protected void end() {
        shooter.stopRachetWinch();
//        System.out.println("done");
        //timeA.stop();
        //DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 1, "Time:" + timeA.get() + "                 ");
        DriverStationLCD.getInstance().updateLCD();
        sharedSensors.DeactivateLEDs();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
