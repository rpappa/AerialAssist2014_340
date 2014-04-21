/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author grr340
 */
public class AutoOneBallMobilityHotGoal extends CommandGroup {
    
    public AutoOneBallMobilityHotGoal() {
       addSequential(new DriveFwd(.3), .9);
        addSequential(new WaitForHot(), 4.5);
        ////////////////
        //  shoot     //
        ////////////////
        //Step 1
//        addSequential(new DriveFwd(.3), .9);
        addSequential(new ShootPrepareBall(RobotMap.SHOOTER_DEBOUNCE_TIME_LONG), 5.0);
        addSequential(new WaitCommand(1));
        addSequential(new ShootNow());//Do not put time out
        //Step 2
        addSequential(new WaitCommand(1.0));
        addSequential(new ShooterPullBackWithEncoder());

        addSequential(new WaitCommand(0.5));
        addSequential(new ShooterPullAllTheWayBack(), 1);
        
        ///////////////////////
        //  Mobility Points  //
        ///////////////////////
        addSequential(new DriveFwd(.4), 1.25);
        
         //addSequential(new KillVisionProcessing());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
