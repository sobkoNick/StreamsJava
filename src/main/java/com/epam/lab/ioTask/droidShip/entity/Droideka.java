package com.epam.lab.ioTask.droidShip.entity;

import java.io.Serializable;

/**
 *
 */
public class Droideka extends Droid implements DroidActions, Serializable {
    private int shieldHealth;
    private transient BlusterGun blusterGun;
    public Droideka(int healthLevel, int energyLevel, int shieldHealth, BlusterGun blusterGun) {
        super("Droideka", healthLevel, energyLevel);
        this.shieldHealth = shieldHealth;
        this.blusterGun = blusterGun;
    }

    public String move() {
        return "Droideka rolls the fastest";
    }

    public String doSomething() {
        return "Shoot from 4 blusters";
    }
}
