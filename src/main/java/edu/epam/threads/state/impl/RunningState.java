package edu.epam.threads.state.impl;

import edu.epam.threads.entity.Ferry;
import edu.epam.threads.entity.Vehicle;
import edu.epam.threads.state.State;

import java.util.concurrent.TimeUnit;

public class RunningState implements State {
    private Ferry ferry = Ferry.getInstance();

    @Override
    public void load(Vehicle vehicle) {
        ferry.addToQuery(vehicle);
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ferry.clearVehicles();
        ferry.changeState(new WaitingState(ferry));
    }
}
