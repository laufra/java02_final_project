/*
        [Class name]
        Author: Frankie
        Date: [date]

        Description
        [Description about the class]
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carDealership;

/**
 *
 * @author Frankie
 */
public class Vehicle {
    

    
    private int year;
    private Make make;
    private String model;
    private double price;
    private String color;

    public Vehicle() {

    }

    public Vehicle(int year, Make make, String model, double price,
            String color) {
        
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    public double getPrice() {
        return this.price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Make getMake() {
        return this.make;
    }
    public void setMake(Make make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "year=" + year + ", make=" + make + ", model=" + model + ", price=" + price + ", color=" + color + '}';
    }

   
    
    

}
