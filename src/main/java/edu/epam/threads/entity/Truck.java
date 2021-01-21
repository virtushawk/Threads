package edu.epam.threads.entity;

public class Truck implements Vehicle {
    private double area;
    private double weight;

    public Truck(double area, double weight) {
        this.area = area;
        this.weight = weight;
    }

    @Override
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Truck call() throws Exception {
        return null;
    }
}
