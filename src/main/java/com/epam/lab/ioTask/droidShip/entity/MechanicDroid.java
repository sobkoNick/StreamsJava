package com.epam.lab.ioTask.droidShip.entity;

import java.io.Serializable;

/**
 *
 */
public class MechanicDroid extends Droid implements DroidActions, Serializable {
    public MechanicDroid(int healthLevel, int energyLevel) {
        super("Mechanic", healthLevel, energyLevel);
    }

    public String move() {
        return "Mechanic droid moves slowly";
    }

    public String doSomething() {
        return "Repair";
    }
}
