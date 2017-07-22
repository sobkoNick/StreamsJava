package com.epam.lab.shipWithDroids.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DroidShip implements Serializable {
    private List<Droid> droids;

    public List<Droid> getDroids() {
        return droids;
    }

    public void setDroids(List<Droid> droids) {
        this.droids = droids;
    }

    // add all types of droids
    public void addDroids(List<? extends Droid> list) {
        droids = new ArrayList<Droid>();
        droids.addAll(list);
    }

    public void addDroid(Droid droid) {
        droids.add(droid);
    }

    @Override
    public String toString() {
        return "DroidShip{" +
                "droids=" + droids +
                '}';
    }
}
