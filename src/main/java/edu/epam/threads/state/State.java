package edu.epam.threads.state;


import edu.epam.threads.entity.Vehicle;

public interface State {
    public void load(Vehicle vehicle);
    public void run();

}
