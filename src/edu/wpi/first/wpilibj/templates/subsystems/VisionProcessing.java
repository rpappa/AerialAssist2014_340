package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.templates.commands.StartVision;

/**
 *
 * @author Tyler Pawlaczyk
 */

public class VisionProcessing extends Subsystem
{
    //Camera constants used for distance calculation
    final int Y_IMAGE_RES = 480;		//X Image resolution in pixels, should be 120, 240 or 480
    final double VIEW_ANGLE = 49;		//Axis M1013
    //final double VIEW_ANGLE = 41.7;		//Axis 206 camera
    //final double VIEW_ANGLE = 37.4;  //Axis M1011 camera
    final double PI = 3.141592653;

    //Score limits used for target identification
    final int  RECTANGULARITY_LIMIT = 40;
    final int ASPECT_RATIO_LIMIT = 55;

    //Score limits used for hot target determination
    final int TAPE_WIDTH_LIMIT = 50;
    final int  VERTICAL_SCORE_LIMIT = 50;
    final int LR_SCORE_LIMIT = 50;

    //Minimum area of particles to be considered
    final int AREA_MINIMUM = 150;

    //Maximum number of particles to process
    final int MAX_PARTICLES = 8;
    private AxisCamera camera;
    public VisionProcessing() {
//        System.out.println("Substem started");
//        if(AxisCamera.getInstance("10.3.40.11")==null) {
//            System.out.println("It's null");
//            System.out.println(AxisCamera.getInstance("10.3.40.11").toString());
//            camera = null;
//        } else {
//        camera = null;
        try {
            camera = null;
            
        } catch(Exception e) {
        e.printStackTrace();
        camera = null;
        }
            
//        System.out.println("actually worked");
//        System.out.println(AxisCamera.getInstance("10.3.40.11").toString());
//        }
//        //camera = null;
//        System.out.println("Subsystem ended");
//        System.out.println(AxisCamera.getInstance("10.3.40.11").toString());
    }
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
//        setDefaultCommand(new StartVision());
    }
    
    public void CreateCameraInstance() {
        camera = AxisCamera.getInstance("10.3.40.11");
    }
    
    public void CameraNullify() {
        camera = null;
    }
    
    public ColorImage captureImage()
    {
        try
        {
            return camera.getImage();
        }
        catch(Exception e) {e.printStackTrace();}
        return null;//reference return = null java
    }
    public AxisCamera.ResolutionT resolution() {
        return camera.getResolution();
    }
}