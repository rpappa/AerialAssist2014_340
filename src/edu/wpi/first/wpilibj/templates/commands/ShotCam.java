/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author grr340
 */
public class ShotCam extends CommandGroup {
    
    public ShotCam() {
        RobotMap.shotnumber += 1;
        //step 1
        addSequential(new ShooterPullBackWithEncoder());
        addSequential(new BallIntakeHoldBall());
        //Step 2
        addSequential(new ShootPrepareBall(RobotMap.SHOOTER_AUTO_DEBOUNCE_TIME));
        addParallel(new ShootNow());
        RobotMap.picnumber += 1;
        addSequential(new TakeImage(), .2);
        //Step 3
        addSequential(new ManualBallIntakeGoToMid(), 1.0);
        RobotMap.picnumber += 1;
        addParallel(new TakeImage());
        addSequential(new ShooterPullBackWithEncoder());
        RobotMap.picnumber += 1;
        addParallel(new TakeImage(), .2);
        addSequential(new ManualBallIntakeRetract(), .1);
        RobotMap.picnumber += 1;
        addSequential(new TakeImage(), .2);
        RobotMap.picnumber += 1;
        addSequential(new TakeImage(), .2);
        RobotMap.picnumber = 0;
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
