/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author ADMIN
 */
public class Car implements Comparable<Car> {
    private String carID;
    private Brand brand;
    protected String color;
    protected String frameID;
    protected String engineID;

    public Car() {}

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() { return carID; }
    public String getFrameID() { return frameID; }
    public String getEngineID() { return engineID; }
    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }

    public String toString() {
        return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;
    }

    public String screenString() {
        return brand.toString() + "\n" + carID + ", " + color + ", " + frameID + ", " + engineID;
    }

    public int compareTo(Car c) {
        int d = this.brand.getBrandName().compareTo(c.brand.getBrandName());
        if (d != 0) return d;
        return this.carID.compareTo(c.carID);
    }
}
