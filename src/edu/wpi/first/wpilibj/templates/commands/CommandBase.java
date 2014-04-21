package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.AirCompressor;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;
import edu.wpi.first.wpilibj.templates.subsystems.Drive;
import edu.wpi.first.wpilibj.templates.subsystems.BallIntake;
import edu.wpi.first.wpilibj.templates.subsystems.NoSub;
import edu.wpi.first.wpilibj.templates.subsystems.PressurePlate;
import edu.wpi.first.wpilibj.templates.subsystems.SharedSensors;
import edu.wpi.first.wpilibj.templates.subsystems.VisionProcessing;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Shooter shooter = new Shooter();
    public static BallIntake ballIntake = new BallIntake();
    public static Drive drive = new Drive();
    public static SharedSensors sharedSensors = new SharedSensors(RobotMap.leftUltraPort, RobotMap.rightUltraPort, RobotMap.leftBannerPort, RobotMap.rightBannerPort);
    public static VisionProcessing visionProcessing = new VisionProcessing();
    public static NoSub noSub = new NoSub();
    public static AirCompressor airCompressor = new AirCompressor(); 
    public static PressurePlate pressurePlate = new PressurePlate();
    public static boolean isHotOrNot = false;
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
//        SmartDashboard.putData(visionProcessing);
        SmartDashboard.putData(shooter);
        SmartDashboard.putData(ballIntake);

    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
