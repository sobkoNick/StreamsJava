package com.epam.lab.shipWithDroids.entity;

import java.io.Serializable;
import java.util.List;

/**
 * General abstract Droid class
 */
public abstract class Droid implements Serializable {
    private String type;
    private int healthLevel;
    private int energyLevel;

    public Droid() {
    }

    public Droid(String type, int healthLevel, int energyLevel) {
        this.type = type;
        this.healthLevel = healthLevel;
        this.energyLevel = energyLevel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "type='" + type + '\'' +
                ", healthLevel=" + healthLevel +
                ", energyLevel=" + energyLevel +
                '}';
    }
}
