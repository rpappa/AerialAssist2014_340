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
public class AutoHotGoal extends CommandGroup {
    
    public AutoHotGoal() {
//        addSequential(new WaitForCameraIsHot(), 4.5);
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
        addSequential(new ShooterPullBackWithEncoder());
        
        /////////////
        //  load   //
        /////////////
        //GetBallAutonomously
        //addSequential(new BallIntakeEjectBall());
        //addSequential(new ShooterPullBackWithEncoder());        
        addSequential(new BallIntakeGetBallOffFloor(),1.0);        
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
        addSequential(new ShooterPullBackWithEncoder());
        
        //addSequential(new KillVisionProcessing());
        
        
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()addSequential(new );
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
