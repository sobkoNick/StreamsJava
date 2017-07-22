package com.epam.lab.ioTask.droidShip.entity;

/**
 *
 */
public class BlusterGun {
    private static int DAMAGE = 10;
    public String shoot(){
        return String.format("shoot with damage %d", DAMAGE);
    }
}
