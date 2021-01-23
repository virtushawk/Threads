package edu.epam.threads.parser;

import edu.epam.threads.entity.Vehicle;
import edu.epam.threads.entity.VehicleType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleParser {
    private static final Logger logger = LogManager.getLogger(VehicleParser.class);
    private static final String DELIMITER = "\\s+";

    public Vehicle parseVehicle(String line) {
        List<String> data = Stream.of(line.split(DELIMITER)).collect(Collectors.toList());
        double area = Double.parseDouble(data.get(0));
        double weight = Double.parseDouble(data.get(1));
        VehicleType vehicleType = VehicleType.valueOf(data.get(2));
        Vehicle vehicle = new Vehicle(area,weight,vehicleType);
        return vehicle;
    }
}
