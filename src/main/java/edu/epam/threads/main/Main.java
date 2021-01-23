package edu.epam.threads.main;

import edu.epam.threads.entity.Vehicle;
import edu.epam.threads.exception.VehicleReaderException;
import edu.epam.threads.parser.VehicleParser;
import edu.epam.threads.reader.VehicleReader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws VehicleReaderException {
        String path = "file/test.txt";
        VehicleReader vehicleReader = new VehicleReader();
        VehicleParser vehicleParser = new VehicleParser();
        List<String> lines = vehicleReader.readFromFile(path);
        int size = lines.size();
        ExecutorService executor;
        executor = Executors.newFixedThreadPool(size);
        List<Future<Vehicle>> futures = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Vehicle car = vehicleParser.parseVehicle(lines.get(i));
            Future<Vehicle> future = executor.submit(car);
            futures.add(future);
        }
    }
}
