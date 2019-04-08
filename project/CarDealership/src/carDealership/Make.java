package carDealership;

import java.util.*;

public enum Make {
	Toyota("Toyota"),
	Honda("Honda"),
	Audi("Audi"),
	BMW("BMW"),
	Tesla("Tesla"),
	Mazda("Mazda"),
	Hyundai("Hyundai"),
	Nissan("Nissan"),
	Ford("Ford"),
	MercedesBenz("Mercedes-Benz"),
	Chevrolet("Chevrolet"),
	Volkswagen("Volkswagen"),
	Subaru("Subaru");

	private String name;
        
        private Make(String name){
            
        }

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}