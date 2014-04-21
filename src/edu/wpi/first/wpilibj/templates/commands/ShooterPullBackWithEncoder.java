/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author grr340
 */
public class ShooterPullBackWithEncoder extends CommandBase {
    double lastEncoder;
    public ShooterPullBackWithEncoder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
        System.out.println("creating encoder pull back command");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("[ShooterPullAllTheWayBack]: init");
//        hasSeenReedSwitch = false;
        shooter.setTriggerIn();
        //timeA.start();
        //timeA.reset();
        sharedSensors.ActivateRedLED();
        shooter.ReleaseTrussPiston();
        if(shooter.getArmPosition()<0){
            shooter.resetEncoder();
        }
    }

    /**
     * Pulls back the shooter.
     */
    protected void execute() {
        double speed = ((shooter.DESIRED_ARM_POSITION - shooter.getArmPosition()) / shooter.DESIRED_ARM_POSITION);
        System.out.println("[ShooterPullbackEncoder]: is arm down :" + shooter.isArmDown() + ": armposition :" + shooter.getArmPosition() + ":");
        /*if(!shooter.isFirstTimeThisBoot && speed<0){
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "EncoderWiredBackWards!");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, "EncoderWiredBackWards!");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "EncoderWiredBackWards!");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser4, 1, "EncoderWiredBackWards!");
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 1, "EncoderWiredBackWards!");
            DriverStationLCD.getInstance().updateLCD();
            System.out.println("[ShooterPullbackEncoder]: Encoder Backwards!");
            shooter.stopRachetWinch();
        }else*/
        if(shooter.isFirstTimeThisBoot && !shooter.isArmDown()){
            if(shooter.isArmDownReed()){
                speed = .35;
            }else{
                speed = .4;
            }    
            speed = speed * 12.6/DriverStation.getInstance().getBatteryVoltage();
            shooter.setRachetWinch(speed);            
        }else if (!shooter.isFirstTimeThisBoot &&  shooter.isArmDown()== false 
                )//&& !(shooter.getArmPosition() >= (shooter.DESIRED_ARM_POSITION - shooter.ARM_POSITIONING_THRESHOLD))) 
                //|| !(shooter.getArmPosition() <= (shooter.DESIRED_ARM_POSITION + shooter.ARM_POSITIONING_THRESHOLD)))
        {   
            if (speed > 0.15) {
                speed = 1;
            }
            else if (speed < 0.15) {
                speed = 0.5;
            }else{
                speed = speed*4;
            }
            //The Following rescales voltage, so the winch runs at a better speed
            speed = speed * 12.6/DriverStation.getInstance().getBatteryVoltage();
            System.out.println("arm speed:" + speed);
            shooter.setRachetWinch(speed);
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 1, "EncoderWiredBackWards!");
            DriverStationLCD.getInstance().updateLCD();//System.out.println("[ShooterPullBackEncoder]: Arm Speed : " + Math.max(Math.min((1-Math.abs(shooter.DESIRED_ARM_POSITION - shooter.getArmPosition()) / shooter.DESIRED_ARM_POSITION), 1), .2));
            //shooter.setRachetWinch(Math.max(Math.min((1-Math.abs(shooter.getArmPosition() - shooter.DESIRED_ARM_POSITION) / shooter.DESIRED_ARM_POSITION), 1), .2));
        }
        else
        {
            System.out.println("[ShooterPullbackEncoder]: stop winch!");
            shooter.stopRachetWinch();
        }
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser6, 1, "batt: "+DriverStation.getInstance().getBatteryVoltage());
        DriverStationLCD.getInstance().updateLCD();
    }

    /**
     * Is finished when the shooter is down.
     *
     * @return boolean
     */
    protected boolean isFinished() {
        return (shooter.isArmDown()/*||shooter.getArmPosition() >= (shooter.DESIRED_ARM_POSITION - shooter.ARM_POSITIONING_THRESHOLD) || !(shooter.getArmPosition() <= (shooter.DESIRED_ARM_POSITION + shooter.ARM_POSITIONING_THRESHOLD))) ||*/ );
    }

    /**
     * When finished it stops pulling.
     */
    protected void end() {
        shooter.stopRachetWinch();
        System.out.println("[ShooterPullbackEncoder]: End command");
//        System.out.println("done");
        //timeA.stop();
        //DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 1, "Time:" + timeA.get() + "                 ");
        DriverStationLCD.getInstance().updateLCD();
        sharedSensors.DeactivateLEDs();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
