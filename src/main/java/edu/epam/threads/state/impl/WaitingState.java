package edu.epam.threads.state.impl;

import edu.epam.threads.entity.Ferry;
import edu.epam.threads.entity.Vehicle;
import edu.epam.threads.state.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitingState implements State {
    private static final Logger logger = LogManager.getLogger(WaitingState.class);
    private Ferry ferry;

    public WaitingState(Ferry ferry) {
        this.ferry = ferry;
    }

    @Override
    public void load(Vehicle vehicle) {
        if (ferry.getFreeArea() >= vehicle.getArea() && ferry.getFreeCapacity() >= vehicle.getWeight()) {
            ferry.addToVehicles(vehicle);
        } else {
            ferry.addToQuery(vehicle);
            ferry.changeState(new ReadyState());
            ferry.run();
        }
    }

    @Override
    public void run() {

    }
}
