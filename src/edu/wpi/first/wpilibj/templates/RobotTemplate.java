/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.AutoOneBallMobilityHotGoal;
import edu.wpi.first.wpilibj.templates.commands.AutoThreeBallMobility;
import edu.wpi.first.wpilibj.templates.commands.AutoTwoBallMobility;
import edu.wpi.first.wpilibj.templates.commands.AutoTwoBallMobilitySlow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    Command autonomousCommand1, autonomousCommand2, autonomousCommand3, autonomousCommand4, startVision;
    Timer battTimer = new Timer();
//    Command LEDDisabledFlash;
    double myAverage=0;
    /*public SharedSensors mySnsr = new SharedSensors(
            RobotMap.leftUltraPort,
            RobotMap.rightUltraPort,
            RobotMap.leftBannerPort,
            RobotMap.rightBannerPort
    );*/

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        // vision is out of all auto modes right now.
        // if you want to add it back be sure to set startauto as default
        // command in subsystem or start it at the beginning of auto
        autonomousCommand1 = new AutoOneBallMobilityHotGoal();
        autonomousCommand2 = new AutoTwoBallMobility();
        autonomousCommand3 = new AutoThreeBallMobility();
        autonomousCommand4 = new AutoTwoBallMobilitySlow();
//        LEDDisabledFlash = new LEDDisabledFlash();
//        startVision = new StartVision();
//        startVision.start();
        // Initialize all subsystems
        
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        int autoState;
        try{
            autoState = (int) SmartDashboard.getNumber("autoState");
        } catch(Exception e){
            autoState = 1;
        }
        switch(autoState){
            case 1: 
//                System.out.println("Autonomous 1 running");
                autonomousCommand1.start();
                break;
            case 2: 
//                System.out.println("Autonomous 2 running");
                autonomousCommand2.start();
                break;
            case 3:
//                System.out.println("Autonomous 3 running");
                autonomousCommand3.start();
                break;
            case 4:
//                System.out.println("Autonomous 4 running");
                autonomousCommand4.start();
        }
//        LEDDisabledFlash.cancel();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //edu.wpi.first.wpilibj.templates.commands.CommandBase.sharedSensors.readLeft();
        //edu.wpi.first.wpilibj.templates.commands.CommandBase.sharedSensors.readRight();
        Scheduler.getInstance().run();
//        LEDDisabledFlash.cancel();
        
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand1.cancel();
        autonomousCommand2.cancel();
        autonomousCommand3.cancel();
        autonomousCommand4.cancel();
//        LEDDisabledFlash.cancel();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //edu.wpi.first.wpilibj.templates.commands.CommandBase.sharedSensors.readLeft();
        //edu.wpi.first.wpilibj.templates.commands.CommandBase.sharedSensors.readRight();
        Scheduler.getInstance().run();
//        if (DriverStation.getInstance().getBatteryVoltage() < 6.25){
//            battTimer.start();
//            if (battTimer.get()>4){
//                SmartDashboard.putBoolean("Rumble",true);
//            }
//        }else{
//            battTimer.stop();
//            battTimer.reset();
//            SmartDashboard.putBoolean("Rumble", false);
//        }
//        LEDDisabledFlash.cancel();
      //System.out.print(CommandBase.sharedSensors.getAverageFilteredUltrasonic());
      //System.out.print("a");
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void disabledInit() {
//        System.out.println("Default IterativeRobot.disabledInit() method... We Overloaded!");
//        System.out.println("Default IterativeRobot.disabledPeriodic() method... We Overloaded!");
//        LEDDisabledFlash.start();

    }
    
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
}
