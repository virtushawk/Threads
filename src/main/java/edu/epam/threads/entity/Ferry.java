package edu.epam.threads.entity;

import edu.epam.threads.state.State;
import edu.epam.threads.state.impl.WaitingState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ferry {
    private static final Logger logger = LogManager.getLogger(Ferry.class);
    private static final Ferry instance = new Ferry();
    private CopyOnWriteArrayList<Vehicle> vehicles;
    private CopyOnWriteArrayList<Vehicle> query;
    private double area;
    private double capacity;
    private State state;

    private Ferry() {
        vehicles = new CopyOnWriteArrayList<>();
        query = new CopyOnWriteArrayList<>();
        area = 100;
        capacity = 100;
        state = new WaitingState(this);
    }

    public static Ferry getInstance() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public double getFreeArea() {
        double occupiedArea = 0;
        for (Vehicle vehicle : vehicles) {
            occupiedArea += vehicle.getArea();
        }
        return area - occupiedArea;
    }

    public double getFreeCapacity(){
        double occupiedCapacity = 0;
        for (Vehicle vehicle : vehicles) {
            occupiedCapacity += vehicle.getWeight();
        }
        return capacity - occupiedCapacity;
    }

    public void changeState(State state) {
        this.state = state;
        logger.info("State changed {}",state.getClass());
    }

    public void load(Vehicle vehicle) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            state.load(vehicle);
        } finally {
            lock.unlock();
        }
    }

    public void run() {
        state.run();
    }

    public void addToVehicles(Vehicle vehicle) {
        vehicles.add(vehicle);
        logger.info("added to vehicles {}, Free space {}", vehicle.getArea(),this.getFreeArea());
    }

    public void addToQuery(Vehicle vehicle) {
        query.add(vehicle);
        logger.info("added to query {}", vehicle.getArea());
    }

    public void clearVehicles() {
        vehicles.clear();
        logger.info("Vehicles cleared");
    }
}
