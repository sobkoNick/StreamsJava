package com.epam.lab.ioTask.textFormatter;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Main method starts from package com.epam.lab.ioTask.textFormatter;");
        String text = "";
        String textFromFile = "";
        text = readText(text);
        LOG.info("----unformatted text:-----");
        LOG.info(text);
        text = formatByRules(text);
        LOG.info("-----text after formatting------");
        StringBuffer sb = makeUpercaseAfterDot(text);
        writeUsingBufferedWriter("formated.txt",sb.toString());

        LOG.info("main ends");

    }

    private static StringBuffer makeUpercaseAfterDot(String text) {
        Pattern p = Pattern.compile("(\\.\n [a-z])");
        Matcher m = p.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        m.appendTail(sb);
        LOG.info(sb);
        LOG.info("-------------------");
        return sb;
    }

    private static String formatByRules(String text) {
        Pattern patternSpace = Pattern.compile("[ ]{2,}");
        Matcher matcher = patternSpace.matcher(text);
        text = matcher.replaceAll(" ");
        text = text.replaceAll("[.]{1,}", ".\n ");
        text = text.replaceAll("[,]{1,}", ", ");
        text = text.replaceAll("[/]{1,}", " / ");
        return text;
    }

    private static String readText(String text) {
        String textFromFile;
        LOG.info("reading starts");
        try (BufferedReader br = new BufferedReader(new FileReader("unformatted.txt"))) {
            while ((textFromFile = br.readLine()) != null) {
                text = text.concat(textFromFile);
            }
        } catch (IOException e) {
            LOG.error(e);
        }
        return text;
    }

    private static void writeUsingBufferedWriter(String path, String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            LOG.info("writing text to a file using BufferedWriter");
                bufferedWriter.write(text);
            LOG.info("end of writing using BufferedWriter");
        } catch (IOException e) {
            LOG.error(e);
        }
    }

}
