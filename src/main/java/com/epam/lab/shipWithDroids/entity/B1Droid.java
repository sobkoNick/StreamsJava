package com.epam.lab.shipWithDroids.entity;

import java.io.Serializable;

/**
 *
 */
public class B1Droid extends Droid implements DroidActions, Serializable {

    private transient BlusterGun blusterGun;

    public B1Droid(int healthLevel, int energyLevel, BlusterGun blusterGun) {
        super("B1Droid", healthLevel, energyLevel);
        this.blusterGun = blusterGun;
    }

    public String move() {
        return "B1 droid moves";
    }

    public String doSomething() {
        return "shoot using 1 bluster";
    }
}
