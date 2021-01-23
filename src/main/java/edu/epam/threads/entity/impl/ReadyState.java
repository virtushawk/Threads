package edu.epam.threads.entity.impl;

import edu.epam.threads.entity.Ferry;
import edu.epam.threads.entity.Vehicle;
import edu.epam.threads.entity.State;

public class ReadyState implements State {
    private Ferry ferry;

    public ReadyState(Ferry ferry) {
        this.ferry = ferry;
    }

    @Override
    public void load(Vehicle vehicle) {
        ferry.addToQueue(vehicle);
    }

    @Override
    public void run() {
        ferry.changeState(new RunningState(ferry));
        ferry.run();
    }
}
