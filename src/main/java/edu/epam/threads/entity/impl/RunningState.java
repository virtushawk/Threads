package edu.epam.threads.entity.impl;

import edu.epam.threads.entity.Ferry;
import edu.epam.threads.entity.Vehicle;
import edu.epam.threads.entity.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class RunningState implements State {
    private static final Logger logger = LogManager.getLogger(RunningState.class);
    private Ferry ferry;

    public RunningState(Ferry ferry) {
        this.ferry = ferry;
    }

    @Override
    public void load(Vehicle vehicle) {
        ferry.addToQueue(vehicle);
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            logger.error("Thread was interrupted",e);
        }
        ferry.clearVehicles();
        ferry.changeState(new WaitingState(ferry));
    }
}
