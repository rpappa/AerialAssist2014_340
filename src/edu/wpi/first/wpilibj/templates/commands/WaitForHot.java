/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 *
 * @author grr340
 */
public class WaitForHot extends CommandBase {
    Timer time = new Timer();
    boolean hot = false;
    public WaitForHot() {
        // Use requires() here to declare subsystem dependencies
        requires(noSub);
    }

    // Called just before this Command runs the first time
    private boolean finished = false;
    protected void initialize() {
        time.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            hot = SmartDashboard.getBoolean("IsHotOrNot");
        } catch(TableKeyNotDefinedException e) {
            hot = false;
            //System.err.println(e);
        }
//        if (hot) {
//            time.start();
//        }else{
//            time.reset();
//        }
        System.out.println(hot);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return hot;
    }

    // Called once after isFinished returns true
    protected void end() {
//        time.stop();
        SmartDashboard.putBoolean("IsHotOrNot", true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//        time.stop();
    }
}
