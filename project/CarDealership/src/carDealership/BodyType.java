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
public enum BodyType {
    
    SEDAN("Sedan"),
    SUV("SUV"),
    COUPE("Coupe"),
    TRUCK("Truck"),
    CONVERTIBLE("Convertible");
    
    
    
    private String bodyType;
    
    private BodyType(String bodyType){
        this.bodyType = bodyType;
    }
    
    public String getBodyType(){
        return this.bodyType;
    }
    
    public void setBodyType(String bodyType){
        this.bodyType = bodyType;
    }
    

}
