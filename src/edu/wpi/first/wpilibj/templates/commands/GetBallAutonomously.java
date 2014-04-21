/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;

/**
 *
 * @author Tech
 */
public class GetBallAutonomously extends CommandGroup {
    
    public GetBallAutonomously() {

        addSequential(new BallIntakeEjectBall());
        addParallel(new PrintCommand("ejected ball"));
        addSequential(new ShooterPullBackWithEncoder());       
        addParallel(new PrintCommand("pulled back"));
        addSequential(new BallIntakeGetBallOffFloor());
        addParallel(new PrintCommand("getting ball off floor"));
        addSequential(new Delay(), .2);
        addParallel(new PrintCommand("delayed"));
        addSequential(new BallIntakeLoadShooter(),2.0);
        addParallel(new PrintCommand("loaded shooter"));
        addSequential(new BallIntakeKeepBallOffFloor(), 2.0);
        addParallel(new PrintCommand("KeepBallOffFloor"));
        addSequential(new PrintCommand("ejected ball"));
        
    }
}
