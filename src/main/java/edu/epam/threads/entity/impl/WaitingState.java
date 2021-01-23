package edu.epam.threads.entity.impl;

import edu.epam.threads.entity.Ferry;
import edu.epam.threads.entity.Vehicle;
import edu.epam.threads.entity.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
            ferry.addToQueue(vehicle);
            ferry.changeState(new ReadyState(ferry));
            ferry.run();
        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
