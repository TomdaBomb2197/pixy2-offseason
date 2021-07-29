/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.links.*;

public class PixyCameraExample extends SubsystemBase {
    /**
     * Creates a new PixyCameraExample.
     */

    private static Pixy2 pixy;

    public static void initialize() {
        pixy = Pixy2.createInstance(new SPILink()); // Creates a new Pixy2 camera using SPILink
        pixy.init(); // Initializes the camera and prepares to send/receive data
        pixy.setLamp((byte) 1, (byte) 1); // Turns the LEDs on
        pixy.setLED(200, 30, 255); // Sets the RGB LED to purple
    }
}
