package edu.epam.threads.entity;

public class Car implements Vehicle {
    private double area;
    private double weight;

    public Car(double area,double weight) {
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
    public Car call() throws Exception {
        Ferry ferry = Ferry.getInstance();
        ferry.load(this);
        return this;
    }
}
