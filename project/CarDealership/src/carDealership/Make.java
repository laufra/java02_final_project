package carDealership;

/**
 * A Class to hold the enumerations of the Car makes
 */
import java.util.*;
/**
 * @author Jose Miguelle Dela Paz <delapajo@sheridancollege.ca>
 * @author Mark Tanglao <tanglao@sheridancollege.ca>
 * @author Frankie Lau <laufra@sheridancollege.ca>
 */
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
        /**
         * Private constructor enumerations
         * @param id
         * @param name 
         */
        private Make(int id,String name){
            this.id = id;
            this.name =name;
        }
        
        /**
         * A method to return the name of the enumeration
         * @return 
         */
	public String getName() {
		return this.name;
	}
	/**
	 * A method to set the name of the enumeration
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}