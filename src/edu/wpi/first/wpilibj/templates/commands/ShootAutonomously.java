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
public class ShootAutonomously extends CommandGroup {
    
    public ShootAutonomously() {
        //step 1
        addSequential(new ShooterPullBackWithEncoder());
        addSequential(new BallIntakeHoldBall());
        //Step 2
        addSequential(new ShootPrepareBall(RobotMap.SHOOTER_AUTO_DEBOUNCE_TIME));
        addSequential(new ShootNow());
        //Step 3
        //addSequential(new ManualBallIntakeGoToMid(), 1.0);
        addSequential(new ManualBallIntakeRetract(),.1);
        addSequential(new ShooterPullBackWithEncoder());
        
    }
}
