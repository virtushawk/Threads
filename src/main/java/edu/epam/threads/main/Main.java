package edu.epam.threads.main;

import edu.epam.threads.entity.Car;
import edu.epam.threads.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor;
        executor = Executors.newFixedThreadPool(20);
        List<Future<Vehicle>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Car car = new Car(i,1);
            Future<Vehicle> future = executor.submit(car);
            futures.add(future);
        }
    }
}
