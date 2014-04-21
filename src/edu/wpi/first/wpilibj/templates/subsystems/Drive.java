package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;

/**
 * Subsystem for the Drive.
 * @author Tyler Pawlaczyk
 */
public class Drive extends Subsystem {
    
    Talon leftDrive1; 
    Talon leftDrive2; 
    Talon leftDrive3;
    Talon rightDrive1;
    Talon rightDrive2;
    Talon rightDrive3;
    public double leftMotorSpeed;
    public double rightMotorSpeed;
    public final double MAX_DELTA;
    public double delta;
    public double change;
    public double speed1;
    public double speed2;
    /**
     * Constructor for the Drive class.
     */
    public Drive()
    {
        leftDrive1 = new Talon(RobotMap.leftMtr1Port);
        leftDrive2 = new Talon(RobotMap.leftMtr2Port);
        leftDrive3 = new Talon(RobotMap.leftMtr3Port);
        
        rightDrive1 = new Talon(RobotMap.rightMtr1Port);
        rightDrive2 = new Talon(RobotMap.rightMtr2Port);
        rightDrive3 = new Talon(RobotMap.rightMtr3Port);           
        MAX_DELTA = .25;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new DriveWithJoystick());
    }

    /**
     * Sets the speed for the left drive.
     * @param double speed 
     */
    public void setLeftDrive(double speed, boolean twoCIM)
    {  
        if (speed>1) {
            speed = 1;
        } else if (speed < -1) {
            speed = -1;
        }
        if (!twoCIM){
        leftDrive1.set(speed);
        }
        leftDrive2.set(speed);
        leftDrive3.set(speed);
//        System.out.println("\tactual motor speed: " + speed);
        
//        SmartDashboard.putNumber("Left Drive Speed", speed);
    }
    
    /**
     * Sets the speed for the right drive.
     * @param double speed 
     */
    public void setRightDrive(double speed, boolean twoCIM)
    {
        if (speed>1) {
            speed = 1;
        } else if (speed < -1) {
            speed = -1;
        }
        if (!twoCIM){
        rightDrive1.set(-speed);
        }
        rightDrive2.set(-speed);
        rightDrive3.set(-speed);
//        SmartDashboard.putNumber("Right Drive Speed", speed);
    }   
    
    /**
     * Sets the speed for both sides.
     * @param double leftOutput
     * @param double rightOutput 
     */
    private void setLeftRightMotorOutputs(double leftOutput, double rightOutput, boolean twoCIM) {
        this.setLeftDrive(leftOutput, twoCIM);
        this.setRightDrive(rightOutput, twoCIM);
//        SmartDashboard.putNumber("Left Drive Speed", leftOutput);
//        SmartDashboard.putNumber("Right Drive Speed", rightOutput);
    }
    
    public double LeftMotorSpeed() {
        return leftDrive2.get();
    }
    
    public double RightMotorSpeed() {
        return rightDrive2.get();
    }
    
    public void setLimitedLeftDrive(double speed, boolean twoCIM)
    {
        double speed1, delta, change;
        speed1 = LeftMotorSpeed();
        delta = speed - speed1;
        if(Math.abs(delta)>MAX_DELTA) {
            if (delta > 0) {
               change=MAX_DELTA;
            } else {
               change=-MAX_DELTA;
            }
        } else {
            change = delta;
        }
        //System.out.println("left delta: "+ delta + " input speed: "+speed+" current left speed: "+speed1 +"change: "+change);

        this.setLeftDrive(speed1  + change, twoCIM);
    }
    public void setLimitedRightDrive(double speed, boolean twoCIM)
    {
        double speed2, delta, change;
        speed2 = -RightMotorSpeed();
        delta = speed - speed2;
        if(Math.abs(delta)>MAX_DELTA) {
            if (delta > 0) {
                change=MAX_DELTA;
            } else {
                change=-MAX_DELTA;
            }
        } else {
            change = delta;
        }
//        System.out.println("right delta: "+ delta + " input speed: "+speed+" current right speed: "+speed2 +"change: "+change);
        this.setRightDrive(speed2 + change, twoCIM);
    }
    public void killCIMOnEachSide() {
        rightDrive1.set(0);
        leftDrive1.set(0);
    }
    /**
     * Allows for the driver to control the robot with arcade drive.
     * @param double moveValue
     * @param double rotateValue
     * @param boolean squaredInputs 
     */
     public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs, boolean driveClassic, boolean useTwoCIM) 
     {
        if (squaredInputs) 
        {
            // square the inputs (while preserving the sign) to increase fine control while permitting full power       
            if (moveValue >= 0.0) 
            {
                moveValue = (moveValue * moveValue);
            } 
            
            else 
            {
                moveValue = -(moveValue * moveValue);
            }
            
            if (rotateValue >= 0.0)
            {
                rotateValue = (rotateValue * rotateValue);
            }
            
            else
            {
                rotateValue = -(rotateValue * rotateValue);
            }
            
            if (moveValue > 0.0) 
            {
            
                if (rotateValue > 0.0) 
                {
                    leftMotorSpeed = moveValue - rotateValue;
                    rightMotorSpeed = Math.max(moveValue, rotateValue);
//                    SmartDashboard.putNumber("Left Drive Speed", leftMotorSpeed);
//                    SmartDashboard.putNumber("Right Drive Speed", rightMotorSpeed);
                } 
            
                else 
                {
                    leftMotorSpeed = Math.max(moveValue, -rotateValue);
                    rightMotorSpeed = moveValue + rotateValue;
//                    SmartDashboard.putNumber("Left Drive Speed", leftMotorSpeed);
//                    SmartDashboard.putNumber("Right Drive Speed", rightMotorSpeed);
                }
            }
            
            else 
            {
                if (rotateValue > 0.0) 
                {
                    leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                    rightMotorSpeed = moveValue + rotateValue;
//                    SmartDashboard.putNumber("Left Drive Speed", leftMotorSpeed);
//                    SmartDashboard.putNumber("Right Drive Speed", rightMotorSpeed);
                } 
                else {
                    leftMotorSpeed = moveValue - rotateValue;
                    rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
//                    SmartDashboard.putNumber("Left Drive Speed", leftMotorSpeed);
//                    SmartDashboard.putNumber("Right Drive Speed", rightMotorSpeed);
                }
            }
//     false       this.setLimitedLeftDrive(leftMotorSpeed);
//            this.setLimitedRightDrive(-rightMotorSpeed);
            if (driveClassic) {
                this.setLeftRightMotorOutputs(leftMotorSpeed, -rightMotorSpeed, useTwoCIM); //rightMotorSpeed negated.
            } else {
                this.setLimitedLeftDrive(leftMotorSpeed, useTwoCIM);
                this.setLimitedRightDrive(-rightMotorSpeed, useTwoCIM);
            }
        }
    }
}
