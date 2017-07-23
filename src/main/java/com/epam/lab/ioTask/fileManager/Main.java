package com.epam.lab.ioTask.fileManager;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 *
 */
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        LOG.info("Main() stats");
        String pathString = "src\\";
        boolean isON = true;
        FileManager fileManager = new FileManager();
        fileManager.controlProgram(pathString, isON);
    }
}
