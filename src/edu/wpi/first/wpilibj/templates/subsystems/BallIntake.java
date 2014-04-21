package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;



/**
 * Subsystem for the BallIntake.
 * @author Ryan Pappa
 */
public class BallIntake extends Subsystem {
    private DoubleSolenoid mechanismDeployer1;
    private DoubleSolenoid mechanismDeployer2;
    private Talon  intakeRoller;
    private DigitalInput ballDetector;
    private DigitalInput ballDetectorLeft;
    private DigitalInput ballDetectorRight;
    private DigitalInput checkIntake;
    public double rollerSpeed = 1;
    public double angleSpeed;
    public double shootPosition;
    public double groundPickUp;
    private double ballInDistance = 15;
    
    
    /**
     * Constructor for the BallIntake class.
     */
    public BallIntake()
    {
        mechanismDeployer1 = new DoubleSolenoid(RobotMap.mechanismDeployer1FwdPort, RobotMap.mechanismDeployer1RevPort);
        mechanismDeployer2 = new DoubleSolenoid(RobotMap.mechanismDeployer2FwdPort, RobotMap.mechanismDeployer2RevPort);
        intakeRoller = new Talon(RobotMap.intakeRollerPort);
        ballDetector = new DigitalInput(RobotMap.ballDetectorPort);
        checkIntake = new DigitalInput(RobotMap.checkIntakePort);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new TestRoller());
    }
    
    /**
     * Method that puts the intake out.
     */
    public void deployIntake()
    {
        mechanismDeployer1.set(DoubleSolenoid.Value.kForward);
        mechanismDeployer2.set(DoubleSolenoid.Value.kForward);
        SmartDashboard.putNumber("Intake State", 1);
    }
    
    /**
     * Method that puts the intake in.
     */
    public void retractIntake()
    {
        mechanismDeployer1.set(DoubleSolenoid.Value.kReverse);
        mechanismDeployer2.set(DoubleSolenoid.Value.kReverse);
        SmartDashboard.putNumber("Intake State", -1);
    }
    
    public void goToMid() {
        mechanismDeployer1.set(DoubleSolenoid.Value.kReverse);
        mechanismDeployer2.set(DoubleSolenoid.Value.kForward);
        SmartDashboard.putNumber("Intake State", 0);
    }

    /**
     * Method that takes the ball in.
     * @param dir - direction 
     */
    public void ballIntakeRollerIn(double dir) {
        intakeRoller.set(-1 * dir);
        SmartDashboard.putNumber("Roller Speed", -dir);
    }
    
    /**
     * Method that takes the ball out.
     * @param dir - direction
     */
    public void ballIntakeRollerOut(double dir) {
        intakeRoller.set(dir);
        SmartDashboard.putNumber("Roller Speed", dir);
    }

    /**
     * Method that determines if a ball is in the mechanism or not.
     * @return boolean
     */
    public boolean isBallInShooter() {
        SmartDashboard.putBoolean("Ball In", !ballDetector.get());
        return !ballDetector.get();
    }
    
    /**
     * Method that determines if a ball is in the Intake mechanism.
     * @return boolean
     */
    public boolean isBallInIntake() { //to do: Change this for the alternate IR sensor
        return checkIntake.get();
    }
    
    /**
     * Method that stops the rollers. 
     */
    public void ballIntakeRollerStop() {
       intakeRoller.set(0);
    }
    
    public boolean isMechanismIn() {
        return mechanismDeployer1.get() == DoubleSolenoid.Value.kReverse && mechanismDeployer2.get() == DoubleSolenoid.Value.kReverse;
    }
    public boolean isMechanismOut() {
        return mechanismDeployer1.get() == DoubleSolenoid.Value.kForward && mechanismDeployer2.get() == DoubleSolenoid.Value.kForward;
    }
    public boolean isMechanismMid() {
        return mechanismDeployer1.get() == DoubleSolenoid.Value.kForward && mechanismDeployer2.get() == DoubleSolenoid.Value.kReverse || mechanismDeployer1.get() == DoubleSolenoid.Value.kReverse && mechanismDeployer2.get() == DoubleSolenoid.Value.kForward;
    }

    public boolean isMechanismWithinThreshold(double shootPosition, double threshold) {
       return false;
    }
    public boolean ballDetectorValue() {
        SmartDashboard.putBoolean("Ball In", ballDetector.get());
        return !ballDetector.get();
    }
}
