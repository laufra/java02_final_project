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
    private String vin;
    private double price;
    private BodyCondition condition;
    private BodyType bodyType;
    private int mileage;
    private FuelType fuelType;
    private int numOfSeats;
    private String color;

    public Vehicle(){
        
    }
    
    public Vehicle(int year, Make make, String model, String vin,
            double price, BodyCondition condition, BodyType bodyType,
            int mileage, FuelType fuelType, int numOfSeats, String color) {

        this.year = year;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.price = price;
        this.condition = condition;
        this.bodyType = bodyType;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.numOfSeats = numOfSeats;
        this.color = color;
    }

    public String getVin() {
        return this.vin;
    }

    /**
     *
     * @param vin
     */
    public void setVin(String vin) {
        this.vin = vin;
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

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return this.year;
    }

    /**
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    public Make getMake() {
        return this.make;
    }

    /**
     *
     * @param make
     */
    public void setMake(Make make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
    
  

    public int getNumOfSeats() {
        return this.numOfSeats;
    }

    /**
     *
     * @param numOfSeats
     */
    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public int getMileage() {
        return this.mileage;
    }

    /**
     *
     * @param mileage
     */
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BodyCondition getCondition() {
        return this.condition;
    }

    /**
     *
     * @param condition
     */
    public void setCondition(BodyCondition condition) {
        this.condition = condition;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

}
