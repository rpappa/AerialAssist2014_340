/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * sets the winch for the shooter to half speed in.
 * @author Robotics
 */
public class ManualShooterWinchIn extends CommandBase {
    
    public ManualShooterWinchIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(shooter.isTriggered())
        {
            shooter.setTriggerIn();
        }
        System.out.println("winch in/button 2");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.setRachetWinch(-.5); //sets the ratchet winch to half speed. Must be Negative!
//        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "Reed"+shooter.isArmDownReed.get()+"");
//        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, "lim1"+shooter.isArmDownLimit1.get()+"");
//        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, "lim2"+shooter.isArmDownLimit2.get()+"");
//        DriverStationLCD.getInstance().updateLCD();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.stopRachetWinch(); //so the winch stops while button is held
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
