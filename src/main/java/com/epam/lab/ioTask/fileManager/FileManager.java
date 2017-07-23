package com.epam.lab.ioTask.fileManager;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/**
 *
 */
public class FileManager {
    private static final Logger LOG = Logger.getLogger(FileManager.class);
    public static Scanner scanner = new Scanner(System.in);

    public static void controlProgram(String pathString, boolean isON) {
        while (isON) {
            File folder = new File(pathString);
            File[] listOfFiles = folder.listFiles();

            LOG.info(String.format("Current folder %s", folder.getAbsolutePath()));
            LOG.info("Commands: dir - to show files and folders. cd - to change folder. " +
                    "up - to go higher in ierarchy. any other to end");

            String command = scanner.next();
            if (command.equalsIgnoreCase("dir")) {
                showDirectory(listOfFiles);
            } else if (command.equalsIgnoreCase("cd")) {
                pathString = getPathAfterCd(pathString);
            } else if (command.equalsIgnoreCase("up")) { // goes up in ierarchy
                pathString = folder.getAbsolutePath();
                int index = pathString.lastIndexOf("\\");
                if (index != -1) {
                    pathString = pathString.substring(0,index).concat("\\");
                }
            } else {
                isON = false;
            }
        }
    }

    private static String getPathAfterCd(String pathString) {
        LOG.info("Input path");
        String inputedPath = scanner.next();
        if (Files.exists(Paths.get(inputedPath)) && Files.isDirectory(Paths.get(inputedPath), LinkOption.NOFOLLOW_LINKS)){
            //if path is absolute
            pathString = inputedPath;
        } else if (Files.exists(Paths.get(pathString.concat(inputedPath).concat("\\"))) &&
                Files.isDirectory(Paths.get(pathString.concat(inputedPath).concat("\\")), LinkOption.NOFOLLOW_LINKS)){
            //if path is relative on current directory
            pathString = pathString.concat(inputedPath).concat("\\");
        } else {
            LOG.error("No such directory");
        }
        return pathString;
    }

    private static void showDirectory(File[] listOfFiles) {
        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                String filePermisions = getFilePermissionsAndSizeAndDate(file);
                LOG.info(String.format("%s \t\t%s", filePermisions, file.getName()));
            }
        }
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filePermisions = getFilePermissionsAndSizeAndDate(file);
                LOG.info(String.format("%s \t\t%s", filePermisions, file.getName()));
            }
        }
    }

    private static String getFilePermissionsAndSizeAndDate(File file) {
        String filePermisions = "";

        BasicFileAttributes attr;
        try {
            attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            filePermisions = filePermisions.concat(attr.creationTime().toString().substring(0, 10).concat("\t"));
            filePermisions = filePermisions.concat(String.valueOf(attr.size()).concat("\t\t"));
        } catch (IOException e) {
            LOG.error(String.format(e.getMessage()));
        }
        if (Files.isReadable(file.toPath())) {
            filePermisions = filePermisions.concat("r");
        }
        if (Files.isWritable(file.toPath())) {
            filePermisions = filePermisions.concat("-w");
        }
        if (Files.isExecutable(file.toPath())) {
            filePermisions = filePermisions.concat("-x");
        }
        return filePermisions;
    }

}
