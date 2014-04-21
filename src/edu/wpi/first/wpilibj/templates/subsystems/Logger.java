/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.io.j2me.file.Protocol;
import edu.wpi.first.wpilibj.DriverStation;
import java.io.*;
import com.sun.squawk.microedition.io.FileConnection;
import javax.microedition.io.Connector;

/**
 *
 * @author grr340
 */
public class Logger
{    
    private static void writeToFile(String filename, String contents)
    {
	String url = "file:///" + filename;
	try {
		FileConnection c = (FileConnection) Connector.open(url);
		PrintStream writer = new PrintStream(c.openOutputStream());
		writer.println(contents);
		c.close();
	}
        catch (IOException e)
        {
		e.printStackTrace();
	}
    }
    
    public static void writeValuesToFile(String[] csvLine)
    {
        String write = "";
        for(int i = 0; i < csvLine.length; i++)
        {
            write += csvLine[i];
        }
        
        writeToFile("" + DriverStation.getInstance().getLocation() + DriverStation.getInstance().getAlliance(), write);
        
    }
}
