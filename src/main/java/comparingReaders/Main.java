package comparingReaders;

import org.apache.log4j.Logger;

import java.io.*;

/**
 *
 */
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);
    private static final String TEXT = "some string that will be written to a file " +
            "and read using both usual and buffered";
    private static final String FILE_NAME_FOR_WRITER = "fileWriter.txt";
    private static final String FILE_NAME_FOR_BUFFERED = "bufferedWriter.txt";

    public static void main(String[] args) {
        LOG.info("main starts");
        writeUsingFileWriter();
        writeUsingBufferedWriter();
        readUsingFileReader();
        readUsingBufferedReader();
        readWithBufferedReaderWithSize();
        LOG.info("main ends");
    }

    private static void readWithBufferedReaderWithSize() {
        readWithBufferedReaderSettingItSize(512);
        readWithBufferedReaderSettingItSize(2048);
        readWithBufferedReaderSettingItSize(4096);
        readWithBufferedReaderSettingItSize(16384);
    }

    private static void readWithBufferedReaderSettingItSize(int size) {
        LOG.info(String.format("readWithBufferedReaderSettingItSize() starts with size %d", size));
        try (BufferedReader bufferedReaderWithSize100 = new BufferedReader(new FileReader(FILE_NAME_FOR_BUFFERED), size)) {
            while (bufferedReaderWithSize100.readLine() != null)
                bufferedReaderWithSize100.readLine();
        } catch (IOException e) {
            LOG.error(e);
        }
        LOG.info(String.format("readWithBufferedReaderSettingItSize() ends with size %d", size));
    }

    private static void readUsingFileReader() {
        LOG.info("readUsingFileReader() starts");
        try (FileReader fileReader = new FileReader(FILE_NAME_FOR_WRITER)) {
            while (fileReader.read() != -1) {
                fileReader.read();
            }
        } catch (IOException e) {
            LOG.error(e);
        }
        LOG.info("readUsingFileReader() ends");
    }

    private static void readUsingBufferedReader() {
        LOG.info("readUsingBufferedReader() starts");
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME_FOR_BUFFERED))) {
            while (br.readLine() != null)
                br.readLine();
        } catch (IOException e) {
            LOG.error(e);
        }
        LOG.info("readUsingBufferedReader() ends");
    }

    private static void writeUsingBufferedWriter() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME_FOR_BUFFERED))) {
            LOG.info("writing text to a file using BufferedWriter");
            for (int i = 0; i < 3000000; i++) {
                bufferedWriter.write(TEXT);
            }
            LOG.info("end of writing using BufferedWriter");
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    private static void writeUsingFileWriter() {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME_FOR_WRITER)) {
            LOG.info("writing text to a file using FileWriter");
            for (int i = 0; i < 3000000; i++) {
                fileWriter.write(TEXT);
            }
            LOG.info("end of writing using FileWriter");
        } catch (IOException e) {
            LOG.error(e);
        }
    }
}
