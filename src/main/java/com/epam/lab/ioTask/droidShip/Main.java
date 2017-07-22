package com.epam.lab.ioTask.droidShip;

import com.epam.lab.ioTask.droidShip.entity.*;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;

/**
 *
 */
public class Main {

    public static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LOG.info("ioTask package");
        LOG.info("Main method starts");

        DroidShip droidShip = new DroidShip();
        droidShip.addDroids(Arrays.asList(new B1Droid(100, 100, new BlusterGun()),
                new Droideka(80, 80, 100, new BlusterGun()),
                new MechanicDroid(100, 50)));
        LOG.info(String.format("Ship before writing %s", droidShip.toString()));
        writeObjectToFile(droidShip);
        DroidShip readShip = readObjectFromFile();
        LOG.info(String.format("Ship after reading from file %s", readShip.toString()));
        LOG.info("Main method ends");
    }

    private static DroidShip readObjectFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ship.dat"));
      DroidShip readShip = (DroidShip) inputStream.readObject();
        inputStream.close();
        return readShip;
    }

    private static void writeObjectToFile(DroidShip droidShip) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("ship.dat"));
        outputStream.writeObject(droidShip);
        outputStream.close();
    }
}
