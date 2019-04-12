package carDealership;

import java.util.*;

public enum Make {
	Toyota(0,"Toyota"),
	Honda(1,"Honda"),
	Audi(2,"Audi"),
	BMW(3,"BMW"),
	Tesla(4,"Tesla"),
	Mazda(5,"Mazda"),
	Hyundai(6,"Hyundai"),
	Nissan(7,"Nissan"),
	Ford(8,"Ford"),
	MercedesBenz(9,"Mercedes-Benz"),
	Chevrolet(10,"Chevrolet"),
	Volkswagen(11,"Volkswagen"),
	Subaru(12,"Subaru");

	private String name;
        private int id;
        private Make(int id,String name){
            this.id = id;
            this.name =name;
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