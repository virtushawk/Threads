package edu.epam.threads.reader;

import edu.epam.threads.exception.VehicleReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleReader {
    private static final Logger logger = LogManager.getLogger(VehicleReader.class);

    public List<String> readFromFile(String path) throws VehicleReaderException {
        List<String> list;
        try(Stream<String> stream = Files.lines(Paths.get(path))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("an error occurred while reading the file",e);
            throw new VehicleReaderException("an error occurred while reading the file",e);
        }
        return list;
    }
}
