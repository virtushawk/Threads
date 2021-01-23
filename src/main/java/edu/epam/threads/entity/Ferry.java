package edu.epam.threads.entity;

import edu.epam.threads.entity.impl.WaitingState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry {
    private static final Logger logger = LogManager.getLogger(Ferry.class);
    private static final Ferry instance = new Ferry();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Queue<Vehicle> queue = new LinkedList<>();
    private static final double DEFAULT_AREA = 100;
    private static final double DEFAULT_CAPACITY = 100;
    private State state = new WaitingState(this);
    private static final ReentrantLock lock = new ReentrantLock();

    private Ferry() {}

    public static Ferry getInstance() {
        return instance;
    }

    public double getFreeArea() {
        double occupiedArea = 0;
        for (Vehicle vehicle : vehicles) {
            occupiedArea += vehicle.getArea();
        }
        return DEFAULT_AREA - occupiedArea;
    }

    public double getFreeCapacity(){
        double occupiedCapacity = 0;
        for (Vehicle vehicle : vehicles) {
            occupiedCapacity += vehicle.getWeight();
        }
        return DEFAULT_CAPACITY - occupiedCapacity;
    }

    public void changeState(State state) {
        lock.lock();
        try {
            this.state = state;
            logger.info("State changed {}",state.getClass());
        } finally {
            lock.unlock();
        }
    }

    public void load(Vehicle vehicle) {
        lock.lock();
        try {
            state.load(vehicle);
        } finally {
            lock.unlock();
        }
    }

    public void run() {
        lock.lock();
        try {
            state.run();
        } finally {
            lock.unlock();
        }
    }

    public void addToVehicles(Vehicle vehicle) {
        vehicles.add(vehicle);
        logger.info("Added to vehicles {}, Free space {}", vehicle.getArea(),this.getFreeArea());
    }

    public void addToQueue(Vehicle vehicle) {
        queue.add(vehicle);
        logger.info("Added to queue {}", vehicle.getArea());
    }

    public void clearVehicles() {
        vehicles.clear();
        logger.info("Vehicles cleared");
    }

}
