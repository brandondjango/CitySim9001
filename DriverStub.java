import java.util.*;

public class DriverStub extends Driver {

	public DriverStub(int ids, int randomSeed) {
		super(ids, randomSeed);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void start(){
        this.curr = "hotel";
        this.setNextLoc();
    	this.setCurrStreet();
    }
	
	//stub for drive method
	@Override
	public void drive(){
    	
		this.curr = "hotel";
    	this.nextLoc = "diner";
    	this.setCurrStreet();
    	    	    	
    }//end drive method
	
	@Override
	public String toString(){
		this.curr = "Pittsburgh";
    	this.nextLoc = "Philly";
    	this.street = "376";
    	return ("Driver " + id + " is driving from " + curr + " to " + nextLoc + " via " + street);
	}
	
}
