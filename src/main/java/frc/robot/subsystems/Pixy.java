// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.ErrorLogger;
import io.github.pseudoresonance.pixy2api.*;
import io.github.pseudoresonance.pixy2api.links.*;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

public class Pixy extends SubsystemBase {
    private static Pixy2 m_camera;
    // private static ErrorLogger logger = new ErrorLogger();

    /** Creates a new Pixy. */
    public Pixy() {
    }

    public void initialize() {
        m_camera = Pixy2.createInstance(new SPILink()); // Creates a new Pixy2 camera using SPILink

        // System.out.println(m_camera.getVersionInfo().toString());

        m_camera.init(); // Initializes the camera and prepares to send/receive data
    }

    public void setLED(int r, int g, int b) {
        byte code = m_camera.setLamp(byte 1, byte 1); // Turns the LEDs on
        // logger.logErrorIfExists(code);
        code = m_camera.setLED(r, g, b);
        // logger.logErrorIfExists(code);
    }

    public void disableLED() {
        m_camera.setLamp(byte 0, byte 0);
    }

    public int updateBlockCache(byte signature, int blockLimit) {
        return m_camera.getCCC().getBlocks(false, signature, blockLimit);
    }

    /*
    returns the largest block being seen by the Pixy2
    also i wrote this code when errors weren't showing up so there might be a lot of errors i cant tell while writing
    also maybe should go in periodic, idk
    */
    
    public Block getLargestBlock() {
        if (updateBlockCache(byte 1, 1 ) > 0) {
            
            //Test this first! Comment out once working
            System.out.println("Detecting Block!\n");

            /* Test this when the print statement works (beta code, idk if this will work, especially with multiple blocks)
            Block largestBlock = pixy.ccc.blocks[0];

            return largestBlock
            
            */
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}