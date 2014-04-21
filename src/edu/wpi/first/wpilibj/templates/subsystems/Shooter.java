package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Subsystem for the Shooter.
 *
 * @author Ryan Pappa
 */
public class Shooter extends Subsystem {

    public final int TRUSS_POSITION = 42;
    public final int ARM_POSITIONING_THRESHOLD = 0;
    public final double PULL_SPEED = -.75;//always pull negative, otherwise you break the winch
    public final int DESIRED_ARM_POSITION = 49;
    public boolean isFirstTimeThisBoot = true;    
    
    private Solenoid winchRelease;
    private Talon rachetWinch;
    private Talon rachetWinch2;
    private Solenoid shooterPiston;
    public DigitalInput isArmDownReed;
    public DigitalInput isArmDownLimit1;
    public DigitalInput isArmDownUSwitch;
    private static Encoder armEncoder;
    private DigitalInput isBallShotSensor;
    
    /**
     * Constructor for the Shooter class.
     */
    public Shooter() {
        winchRelease = new Solenoid(RobotMap.winchReleasePort);
        rachetWinch = new Talon(RobotMap.winchPort);
        rachetWinch2 = new Talon(RobotMap.winchPort2);
        isArmDownReed = new DigitalInput(RobotMap.isArmDownReedSwitch);
        isArmDownLimit1 = new DigitalInput(RobotMap.isArmDownLimit1);
        isArmDownUSwitch = new DigitalInput(RobotMap.isArmDownLimit2);
//      isBallShotSensor = new DigitalInput(RobotMap.isBallShotSensorPort);
        shooterPiston = new Solenoid(RobotMap.shooterPistonPort);
        armEncoder = new Encoder(RobotMap.encoderPort1, RobotMap.encoderPort2);
        armEncoder.start();
        armEncoder.setMaxPeriod(.1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * Method that pulls back the winchRelease.
     *
     * @param double speed
     */
    public void setRachetWinch(double speed) {
        if (!(speed < 0)) {
            speed *= -1; //if the speed isn't negative, make it negative.
        }

        rachetWinch.set(speed);
        rachetWinch2.set(speed);
        SmartDashboard.putNumber("Winch Speed", speed);
    }

    /**
     * Method that stops pulling the winchRelease.
     */
    public void stopRachetWinch() {
        rachetWinch.set(0);
        rachetWinch2.set(0);
        SmartDashboard.putNumber("Winch Speed", 0);
    }

    /**
     * Determines if the winchRelease is down.
     *
     * @return true when arm is down, false otherwise
     */
    public boolean isArmDown() {
//        System.out.println("\t" + !isArmDownReed.get() + " or " + isArmDownLimit1.get() );
        SmartDashboard.putBoolean("Arm Down", isArmDownLimit1.get());
        return (!isArmDownLimit1.get());// && !isArmDownUSwitch.get()));
    }
    
    public boolean isArmDownReed() {
        return !isArmDownReed.get();
    }

    /**
     * Determines if the winchRelease is down.
     *
     * @return boolean
     */
    public boolean isTriggered() {
        return winchRelease.get();
    }

    /**
     * Sets the winchRelease in.
     */
    public void setTriggerIn() {
        winchRelease.set(false);
        SmartDashboard.putBoolean("Trigger State", false);
    }

    /**
     * Sets the winchRelease out.
     */
    public void setTriggerOut() {
        winchRelease.set(true);
        SmartDashboard.putBoolean("Trigger State", true);
    }

    /**
     * 'Returns the position of the arm.
     *
     * @return int
     */

    public double getArmSpeed() {
        return rachetWinch.getSpeed();
    }

    /**
     * Determines if ball is in shooter
     *
     * @return boolean
    */
    /*
    public boolean isBallShot() {
        return isBallShotSensor.get();
    }
    */
    public void PrepareTrussPiston() {
        shooterPiston.set(true);
        SmartDashboard.putBoolean("Truss Piston", true);
    }
    
    public void ReleaseTrussPiston() {
        shooterPiston.set(false);
        SmartDashboard.putBoolean("Truss Piston", false);
    }
    public double getArmPosition() {
        return armEncoder.get();
    }
    
    public void resetEncoder()
    {
        armEncoder.stop();
        armEncoder.reset();
        armEncoder.start();
        System.out.println("Encoder Reset");
        isFirstTimeThisBoot = false;
    }
    
    public boolean isArmStopped() {
        return armEncoder.getStopped();
    }
}
