package com.epam.lab.ioTask.coment;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //Pattern pattern = Pattern.compile("((\\/\\*[\\s\\S]*?\\*\\/|([^:]|^)\\/\\/.*$)|(^/\\*\\**)|(\\*\\/$)|(\\*[\\s\\S]*))");

        Pattern pattern = Pattern.compile("((\\/\\*[\\s\\S]*?\\*\\/|([^:]|^)\\/\\/.*$)|(^/\\*\\**)|(\\*\\/$)|(\\*[\\s\\S]*))");

        List<String> stringList = readUsingBufferedReader();

        for (String string : stringList) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()){
                LOG.info(matcher.group(0));
//                LOG.info(matcher.group(1));
            }
        }
    }

    private static List<String> readUsingBufferedReader() {
        List<String> strings = new ArrayList<>();
        LOG.info("readUsingBufferedReader() starts");
        try (BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\com\\epam\\lab\\" +
                "ioTask\\coment\\ClassWithComents.java"))) {
            String line;
            while ((line = br.readLine()) != null)
                strings.add(line);
        } catch (IOException e) {
            LOG.error(e);
        }
//        strings.forEach(System.out::println);
        LOG.info("readUsingBufferedReader() ends");
        return strings;
    }
}
