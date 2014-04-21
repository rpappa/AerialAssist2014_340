/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

//    Written by Dayle

public class BallIntakeJostleBall extends CommandGroup {
    
    public BallIntakeJostleBall() {
        
        addSequential(new ManualBallIntakeDeployIntake(),1.0);
        addSequential(new BallIntakeGetBallOffFloor());        
        addSequential(new BallIntakeRollerJostle(),1.5);
        addSequential(new BallIntakeKeepBallOffFloor(), 2.0);
        
    }
}
