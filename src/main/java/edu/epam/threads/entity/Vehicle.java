package edu.epam.threads.entity;

import java.util.concurrent.Callable;

public interface Vehicle extends Callable<Vehicle> {

    public double getArea();
    public double getWeight();
}
