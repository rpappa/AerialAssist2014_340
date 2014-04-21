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
 * @author Tech
 */
public class AutoTwoBallMobilityOld extends CommandGroup {
    
    
    public AutoTwoBallMobilityOld() {
        /////////////
        //  shoot  //
        /////////////
        //Step 1
        //addSequential(new ShooterPullBackWithEncoder());
        //addSequential(new BallIntakeHoldBall());
        //Step 2
        addSequential(new ShootPrepareBall(RobotMap.SHOOTER_DEBOUNCE_TIME_LONG), 3.0);
        addSequential(new ShootNow());
        //Step 3
        addSequential(new ManualBallIntakeGoToMid(), 0.2);//delay so we dont break things
        addSequential(new ShooterPullBackWithEncoder());
        addSequential(new WaitCommand(0.2));
        addSequential(new ShooterPullAllTheWayBack());

        
        /////////////
        //  load   //
        /////////////
        //GetBallAutonomously
        //addSequential(new BallIntakeEjectBall());
        //addSequential(new ShooterPullBackWithEncoder());        
        addSequential(new BallIntakeGetBallOffFloor(),1.0);
        addSequential(new Delay(), 0.45);
        addSequential(new BallIntakeLoadShooterMoveForward(RobotMap.AUTO_MOVE_SPEED),1.5);
        //addSequential(new BallIntakeKeepBallOffFloor(), 2.0);
        
        /////////////
        //  shoot  //
        /////////////
        //Step 1
        //addSequential(new ShooterPullBackWithEncoder());
        //addSequential(new BallIntakeHoldBall());
        //Step 2
        addSequential(new ShootPrepareBall(RobotMap.SHOOTER_DEBOUNCE_TIME));
        addSequential(new ShootNow());
        //Step 3
        addSequential(new ManualBallIntakeGoToMid(), 0.2);
        addSequential(new ShooterPullBackWithEncoder(), 1);
        addSequential(new ShootPrepareBall(RobotMap.SHOOTER_DEBOUNCE_TIME_LONG), 3.0);
        addSequential(new ShootNow(), 0.2);
        
        ///////////////////////
        //  Mobility Points  //
        ///////////////////////
        addSequential(new DriveFwd(.4), 1.25);
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
