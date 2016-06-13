import java.util.*;

public class CitySim9001 {
	
	public static int counter;
	
	public CitySim9001(){
		counter = 5;
	}

	public static void main(String [] args){
		CitySim9001 sim = new CitySim9001();
		
		//argument error check
		String error = sim.errorArgsCheck(args);
		
		//parse string argument into an integer and use its absolute value
		Integer integer = Integer.parseInt(args[0]);
		integer = Math.abs(integer);
		
		//driver loop
		for(int i = 0; counter < 5; i++){
			Driver driver = new Driver(i, integer);
			driver.start();
			driver.print();
			
			//while driver is not in philidelphia or cleveland, drive to next location
			while(!driver.nextLoc.equals("philidelphia") && !driver.nextLoc.equals("cleveland")){
				driver.drive();
				driver.print();
				
				//if driver is in phili or cleveland, print he has gone there
				if(driver.nextLoc.equals("philidelphia") || driver.nextLoc.equals("cleveland")){
					System.out.println("Driver " + i + " has gone to " + driver.nextLoc + "!");
					System.out.println("--------------------------------------");
					break;
				}
			}
			
		}
		
		
		
		
	}
	
	
	
	
	//check the parameter contains only one argument. if it does not, return error
	public String errorArgsCheck(String [] args1){
		String error = "";
		
		if(args1.length != 1)
			 error = "Error: 1";
		return error;
	}//argcheck end
	
}
