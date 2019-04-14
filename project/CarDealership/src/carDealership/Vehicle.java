/*
        [Vehicle]
        Author: Frankie
        Date: [April 13, 2019]

        Description
        [A class to model a vehicle]
 */
package carDealership;

/**
 * @author Jose Miguelle Dela Paz <delapajo@sheridancollege.ca>
 * @author Mark Tanglao <tanglao@sheridancollege.ca>
 * @author Frankie Lau <laufra@sheridancollege.ca>
 */
public class Vehicle {
    private int year;
    private Make make;
    private String model;
    private double price;
    private String color;
    
    /**
     * Default constructor for the vehicle class
     */
    public Vehicle() {
    }
    /**
     * Constructor with parameters
     * @param year
     * @param make
     * @param model
     * @param price
     * @param color 
     */
    public Vehicle(int year, Make make, String model, double price,
            String color) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
        this.color = color;
    }
    /**
     * A method to return the price
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * A method to set the price of a vehicle
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * A method to get the color of the vehicle
     * @return 
     */
    public String getColor() {
        return this.color;
    }
    /**
     * A method to set the color of a vehicle
     * @param color 
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * A method to get the year of the vehicle
     * @return 
     */
    public int getYear() {
        return this.year;
    }
    /**
     * A method to set the year of the vehicle
     * @param year 
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * A method to get the make of the vehicle
     * @return 
     */
    public Make getMake() {
        return this.make;
    }
    /**
     * A method to set the make of the vehicle
     * @param make 
     */
    public void setMake(Make make) {
        this.make = make;
    }
    /**
     * A method to get the model of the vehicle
     * @return 
     */
    public String getModel() {
        return this.model;
    }
    /**
     * A method to set the model of the vehicle
     * @param model 
     */
    public void setModel(String model) {
        this.model = model;
    }
    

}
