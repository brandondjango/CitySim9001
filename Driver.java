import java.util.*;

public class Driver {

	int seed;
	int id;
	public String curr = "";
	public String nextLoc = "";
	String street = "";
	public CityMap map = new CityMap();
	
	public Driver(int ids, int randomSeed){
		seed = randomSeed;
		id = ids;
			
	}
	

       
    public void start(){
    	
    	this.setCurr();
    	this.setNextLoc();
    	this.setCurrStreet();
    	    	    	
    }//end start method
    
public void drive(){
    	
    	this.setCurr(nextLoc);
    	this.setNextLoc();
    	this.setCurrStreet();
    	    	    	
    }//end drive method
    
    public void setCurr(){
    	ArrayList<String> arrayList = map.getCities();
    	
    	Random rand = new Random();
    	int randomNumber = rand.nextInt(100000);
    	int start = (randomNumber * seed) % arrayList.size();
    	
    	curr = arrayList.get(start);    	
    	    	
    }
    
    
    public void setCurr(String newCurr){    	
    	curr = newCurr;    	    	
    }
    
    public void setNextLoc(){
    	ArrayList<String> arrayList = map.getNeighbors(curr);
    	
    	Random rand = new Random();
    	int randomNumber = rand.nextInt(100000);
    	int next = (randomNumber * seed) % arrayList.size();
    	
    	nextLoc = arrayList.get(next);    	
    	    	
    }
    
    public void setCurrStreet(){
    	
    	street = map.getStreet(curr, nextLoc);
    	    
    }
    
    public void print(){
    	System.out.println("Driver " + id + " is driving from " + curr + " to " + nextLoc + " via " + street);
    }
    

}