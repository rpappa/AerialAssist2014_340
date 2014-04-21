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
public class AutoThreeBallMobility extends CommandGroup {
    
    public AutoThreeBallMobility() {
        //addSequential(new WaitForCameraIsHot(), .5);
        ////////////////
        //  shoot #1  //
        ////////////////
        //Step 1
        addSequential(new ShootPrepareBall(RobotMap.SHOOTER_DEBOUNCE_TIME));
        addSequential(new ShootNow());
        //Step 2
        addSequential(new ManualBallIntakeDeployIntake(), 0.2);
        addSequential(new ShooterPullBackWithEncoder());
        
        ////////////////
        //  load 2nd  //
        ////////////////
        //addSequential(new BallIntakeGetBallOffFloor(),1.0);
        addSequential(new BallIntakeGetBallOffFloorReverse(),1.0);//reverse
        addSequential(new Delay(), .2);
        addSequential(new BallIntakeLoadShooter(),1.5);
        
        ///////////////
        //  shoot #2 //
        ///////////////
        //Step 1
        addSequential(new ShootPrepareBall(RobotMap.SHOOTER_DEBOUNCE_TIME));
        addSequential(new ShootNow());
        //Step 2
        addSequential(new ManualBallIntakeDeployIntake(), 0.2);
        addSequential(new ShooterPullBackWithEncoder());
        
        ////////////////
        //  load 3rd  //
        ////////////////
        addSequential(new BallIntakeGetBallOffFloorReverse(),2.5);//reverse
        addSequential(new Delay(), .2);
        addSequential(new BallIntakeLoadShooterMoveForward(RobotMap.AUTO_MOVE_SPEED_THREE_BALL),1.5);//forward
        
        ///////////////
        //  shoot #3 //
        ///////////////
        //Step 1
        addSequential(new ShootPrepareBallMoveForward(RobotMap.SHOOTER_DEBOUNCE_TIME));
        addSequential(new ShootNow());
        //Step 2
        //addSequential(new ManualBallIntakeGoToMid(), 0.2);
        //addSequential(new ShooterPullBackWithEncoder());
        addSequential(new DriveFwd(1),2.0);
        
        
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
