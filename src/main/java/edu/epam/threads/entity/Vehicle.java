package edu.epam.threads.entity;

import java.util.concurrent.Callable;

public class Vehicle implements Callable<Vehicle> {

    private double area;
    private double weight;
    private VehicleType vehicleType;

    public Vehicle(double area, double weight, VehicleType vehicleType) {
        this.area = area;
        this.weight = weight;
        this.vehicleType = vehicleType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public Vehicle call() throws Exception {
        Ferry ferry = Ferry.getInstance();
        ferry.load(this);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.area, area) == 0 && Double.compare(vehicle.weight, weight) == 0
                && vehicleType == vehicle.vehicleType;
    }

    @Override
    public int hashCode() {
        int hashcode = Double.hashCode(area);
        hashcode = hashcode * 31 + Double.hashCode(weight);
        hashcode = hashcode * 31 + ((vehicleType == null) ? 0 : vehicleType.hashCode());
        return hashcode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("area=").append(area);
        sb.append(", weight=").append(weight);
        sb.append(", vehicleType=").append(vehicleType);
        sb.append('}');
        return sb.toString();
    }
}
