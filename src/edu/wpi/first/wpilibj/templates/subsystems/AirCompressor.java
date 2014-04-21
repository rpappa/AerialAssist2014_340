/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CompressorStart;

/**
 *
 * @author Tech
 */
public class AirCompressor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Compressor theCompressor;

    public AirCompressor() {
        theCompressor = new Compressor(RobotMap.pressureSwitchPort,RobotMap.compressorRelay);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CompressorStart());
    }
    public void start(){
        theCompressor.start();
        SmartDashboard.putBoolean("Compressor State", true);
    } 
    public void stop(){
        theCompressor.stop();
        SmartDashboard.putBoolean("Compressor State", false);
    }
}
