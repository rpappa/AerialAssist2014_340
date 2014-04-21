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
public class AutoTwoBallMobility extends CommandGroup {
    
    
    public AutoTwoBallMobility() {
        //addSequential(new WaitForHot(), 2.5);
//        addSequential(new VisionTakeImageForCalibration(), 1.5);
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
        addSequential(new ManualBallIntakeGoToMid(), 0.2);//delay so we dont break things
        addSequential(new ShooterPullBackWithEncoder());
        
        /////////////
        //  load   //
        /////////////
        //GetBallAutonomously
        //addSequential(new BallIntakeEjectBall());
        //addSequential(new ShooterPullBackWithEncoder());        
        addSequential(new BallIntakeGetBallOffFloor(),1.0);
        addSequential(new Delay(), 1);
        addSequential(new BallIntakeLoadShooterMoveForwardWithoutRetract(RobotMap.AUTO_MOVE_SPEED),1.5);
        addSequential(new ManualBallIntakeRetract(), .01);
        //addSequential(new BallIntakeKeepBallOffFloor(), 2.0);
        
        /////////////
        //  shoot  //
        /////////////
        //Step 1
        //addSequential(new ShooterPullBackWithEncoder());
        //addSequential(new BallIntakeHoldBall());
        //Step 2
        addSequential(new WaitCommand(2));
        addSequential(new ShootPrepareBall(RobotMap.SHOOTER_DEBOUNCE_TIME), 1.75);
        addSequential(new ShootNow());
        //Step 3
        addSequential(new ManualBallIntakeGoToMid(), 0.2);
        addParallel(new ShooterPullBackWithEncoder(), 3.40);
//        addSequential(new WaitCommand(.1));
//        addSequential(new ShooterPullBackWithEncoder(), );
        
        addParallel(new DriveFwd(.5), 2);
        
    }
}
