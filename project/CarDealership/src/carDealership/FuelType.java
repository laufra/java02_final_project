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
public enum FuelType {
    
    AUTOMATIC("Automatic"),
    MANUAL("Manual");
    
    private String fuelType;
    
    private FuelType(String fuelType){
        this.fuelType = fuelType;
    }
    
    public String getFuelType(){
        return fuelType;
    }
    
    
    
}
