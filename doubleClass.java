import java.util.*;
//Class to handle test doubles for the CityMap class

public class doubleClass {
	
	public doubleClass(){
		
	}
	
	public Driver getCurr(Driver d,String name){
		d.curr = name;
		return d;
	}
	
	public Driver getNextLoc(Driver d, String name){
		d.nextLoc = name;
		return d;
	}
	
	public Driver getStreet(Driver d, String name){
		d.street = name;
		return d;
	}
	
	

}
