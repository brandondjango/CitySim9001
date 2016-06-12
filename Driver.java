/*
 This is the Driver class. Each Driver has a current location, next location, and street name he is using
 to reach the next location. 
 
 A current location may be any location within the city map, but a next location must neighbor the 
 current city, and the street must connect the current city and the neighboring city.
 
  */

import java.util.*;



public class Driver {
	//Global variables
	int seed;
	int id;
	public String curr = "";
	public String nextLoc = "";
	String street = "";
	public CityMap map = new CityMap();
	
	//Constructor
	public Driver(int ids, int randomSeed){
		seed = randomSeed;
		id = ids;
			
	}
	

    //Initialize Driver object with a current city, next location, and street used to go t said location
    public void start(){
    	
    	this.setCurr();
    	this.setNextLoc();
    	this.setCurrStreet();
    	    	    	
    }//end start method
    
    //This method "drives" the driver to the next location, making next location the driver's 
    //current location, and the next location a neighbor. The street connecting these two
    //locations becomes the Driver's street
    public void drive(){
    	
    	this.setCurr(nextLoc);
    	this.setNextLoc();
    	this.setCurrStreet();
    	    	    	
    }//end drive method
    
    //randomly determine the new current location
    public void setCurr(){
    	ArrayList<String> arrayList = map.getCities();
    	
    	Random rand = new Random();
    	int randomNumber = rand.nextInt(100000);
    	int start = (randomNumber * seed) % arrayList.size();
    	
    	curr = arrayList.get(start);    	
    	    	
    }
    
    //set current location to newCurr
    public void setCurr(String newCurr){    	
    	curr = newCurr;    	    	
    }
    
    //randomly select next location if it is a neighbor of curr
    public void setNextLoc(){
    	ArrayList<String> arrayList = map.getNeighbors(curr);
    	
    	Random rand = new Random();
    	int randomNumber = rand.nextInt(100000);
    	int next = (randomNumber * seed) % arrayList.size();
    	
    	nextLoc = arrayList.get(next);    	
    	    	
    }
    
    //set current street to the one connecting curr to nextLoc
    public void setCurrStreet(){
    	//System.out.println(map.getStreet(curr, nextLoc));
    	street = map.getStreet(curr, nextLoc);
    	    
    }
    
    //print pertinent Driver information including id, curr, nextLoc, and street
    public void print(){
    	System.out.println("Driver " + id + " is driving from " + curr + " to " + nextLoc + " via " + street);
    }
    

}