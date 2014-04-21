/**
 * @author Tyler Pawlaczyk
 * <p>
 * A to contain the sensors required by Drive and Shooter</p>
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class SharedSensors {

    private AnalogChannel leftUltrasonic, rightUltrasonic;
    //private Solenoid greenLED, redLED;
    private Solenoid greenLED;
    private DigitalInput leftBanner, rightBanner;
    private static final double DISTANCE_BETWEEN_ULTRASONICS = 19; //inches
    private static final int SAMPLE_SIZE = 10;
    public double unFltrdLeft[] = new double[SAMPLE_SIZE];
    public double unFltrdRight[] = new double[SAMPLE_SIZE];
    public int loopCntrLeft = 0;
    public int loopCntrRight = 0;
    public int cntrLeft = 0;
    public int cntrRight = 0;
    public double leftTotal = 0;
    public double rightTotal = 0;
    private final boolean LED_ON = true;
    private final boolean LED_OFF = false;

    public SharedSensors(int leftUltraPort, int rightUltraPort, int leftBannerPort, int rightBannerPort) {
//        setMax(unfiltered);
        leftUltrasonic = new AnalogChannel(leftUltraPort);
        rightUltrasonic = new AnalogChannel(rightUltraPort);
        greenLED = new Solenoid(RobotMap.greenLEDPort);
//        redLED = new Solenoid(RobotMap.redLEDPort);
        
                
        //leftBanner = new DigitalInput(leftBannerPort);
        //rightBanner = new DigitalInput(rightBannerPort);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * This method fills an array with readings.
     *
     */
     public void readLeft() {
//        unFltrdLeft[loopCntrLeft] = leftUltrasonic.getValue();
//        loopCntrLeft++;
//        if (loopCntrLeft <= SAMPLE_SIZE) {
//          loopCntrLeft++;
//        }
//        else {
//          loopCntrLeft = 0;  
//        }
//        if (cntrLeft <= SAMPLE_SIZE) {
//          cntrLeft++;
//        }
    }
    
    /**
     * This method fills an array with readings.
     *
     */ 
     public void readRight() {
//        unFltrdRight[loopCntrRight] = rightUltrasonic.getValue();
//        if (loopCntrRight < SAMPLE_SIZE) {
//          loopCntrRight++;
//        }
//        else {
//          loopCntrRight = 0;
//        }
//        if (cntrRight <= SAMPLE_SIZE) {
//           cntrRight++;
//        }
    }
 
    /**
     * This method returns the Filtered Left ultrasonic.
     *
     * @return double
     */
    public double getFltrdLeft() {
       leftTotal = 0;
       for (int i = 0;  i < cntrLeft; i++) {
         leftTotal = leftTotal + unFltrdLeft[i];
       }
       return (leftTotal / cntrLeft / 2);
    }
     
    /**
     * This method returns the Filtered Right ultrasonic.
     *
     * @return double
     */
     public double getFltrdRight() {
       rightTotal = 0;
       for (int i = 0;  i < cntrRight; i++) {
         rightTotal = rightTotal + unFltrdRight[i];
       }
       return (rightTotal / cntrRight / 2);
    }

    /**
     * This method returns the Filtered Average of both ultrasonic.
     *
     * @return double
     */
     public double getFltrdBoth() {
         return ((getFltrdLeft()+getFltrdRight())/2);
     }
    /**
     * This method returns the left ultrasonic.
     *
     * @return double
     */
    public double getLeftUltrasonicDistance() {
        return leftUltrasonic.getValue() / 2;
    }

    /**
     * This method returns the right ultrasonic.
     *
     * @return double
     */
    public double getRightUltrasonicDistance() {
        return rightUltrasonic.getValue() / 2;
    }

    /**
     * This method returns the ultrasonic average.
     *
     * @return double
     */
    public double getAverageUltrasonicDistance() {
        return (getLeftUltrasonicDistance() + getRightUltrasonicDistance()) / 2;
    }

    /**
     * tan^-1(distance between ultras/difference between readings)
     *
     * @return double
     */
    public double inferAngleFromUltrasonics() {
        return MathUtils.atan(DISTANCE_BETWEEN_ULTRASONICS
                / (getRightUltrasonicDistance() - getLeftUltrasonicDistance()));
    }

    /**
     * Turns on the green LED.
     */
    public void ActivateGreenLED() {
        greenLED.set(LED_ON);
//        redLED.set(LED_OFF);
    }

    /**
     * Turns on the red LED.
     */
    public void ActivateRedLED() {
//        redLED.set(LED_ON);
        greenLED.set(LED_OFF);
    }

    /**
     * Turns on the yellow LED.
     */
    public void ActivateYellowLED() {
        greenLED.set(LED_ON);
//        redLED.set(LED_ON);
    }

    /**
     * Turns off the LEDs.
     */
    public void DeactivateLEDs() {
        greenLED.set(LED_OFF);
//        redLED.set(LED_OFF);
    }
    
    public boolean getLeftBanner() {
        return leftBanner.get();
    }
    
    public boolean getRightBanner() {
        return rightBanner.get();
    }

}
