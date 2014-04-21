/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Tech
 */
public class PressurePlate extends Subsystem {
    
        Solenoid pressurePlate;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
     public PressurePlate() {
            
            pressurePlate = new Solenoid(RobotMap.pressurePlatePort);
        }
             
     public void ActivatePressurePlate() {
         pressurePlate.set(true);
         SmartDashboard.putBoolean("Pressure Plate", true);
     }
     
     public void DeactivatePressurePlate() {
         pressurePlate.set(false);
         SmartDashboard.putBoolean("Pressure Plate", false);
     }
     
     public boolean IsPressurePlateDown() {
         return pressurePlate.get();
     }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
