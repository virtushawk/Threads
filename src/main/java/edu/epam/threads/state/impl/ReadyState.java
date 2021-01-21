package edu.epam.threads.state.impl;

import edu.epam.threads.entity.Ferry;
import edu.epam.threads.entity.Vehicle;
import edu.epam.threads.state.State;

public class ReadyState implements State {
    private Ferry ferry = Ferry.getInstance();

    @Override
    public void load(Vehicle vehicle) {
        ferry.addToQuery(vehicle);
    }

    @Override
    public void run() {
        ferry.changeState(new RunningState());
        ferry.run();
    }
}
