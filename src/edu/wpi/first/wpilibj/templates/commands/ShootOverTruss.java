/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author grr340
 */
public class ShootOverTruss extends CommandGroup {
    
    public ShootOverTruss() {
        //step 1
        addSequential(new KillVisionProcessing());
        addSequential(new ShooterPullBackWithEncoder());
        addSequential(new BallIntakeHoldBall());
        //Step 2
        addSequential(new ShootPrepareBallTruss());
        //Step 3
        addSequential(new ShootTrussWaitToFire());
        addSequential(new ShootNow());
        //Step 4
        addSequential(new WaitCommand(0.75));
        addSequential(new ShooterPullBackWithEncoder());
    }
}