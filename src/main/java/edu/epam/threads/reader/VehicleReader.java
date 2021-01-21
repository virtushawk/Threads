package edu.epam.threads.reader;

import edu.epam.threads.exception.VehicleReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VehicleReader {
    private static final Logger logger = LogManager.getLogger(VehicleReader.class);

    public String readFromFile(String path) throws VehicleReaderException {
        String text;
        try {
            text = Files.readString(Paths.get(path));
        } catch (IOException e) {
            logger.error("an error occurred while reading the file",e);
            throw new VehicleReaderException("an error occurred while reading the file",e);
        }
        return text;
    }
}
