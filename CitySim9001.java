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
		if(error.contains("Error")){
			System.out.print(error);
			System.exit(0);
		}
			
		
		//parse string argument into an integer and use its absolute value
		Integer integer = Integer.parseInt(args[0]);
		integer = Math.abs(integer);
		
		//driver loop
		for(int i = 0; i < counter; i++){
			Driver driver = new Driver(i, integer);
			driver.start();
			System.out.println("");
			driver.print();
			//if driver is in phili or cleveland, print he has gone there. 
			//needed in case the driver is smart and drives to phili or cleveland upon start
			if(sim.isDriverGone(driver)){
				System.out.print(sim.printDriverGone(driver));
				break;
			}
			
			//while driver is not in philidelphia or cleveland, drive to next location
			while(!sim.isDriverGone(driver)){
				driver.drive();
				driver.print();
				
				//if driver is in phili or cleveland, print he has gone there
				if(sim.isDriverGone(driver)){
					System.out.print(sim.printDriverGone(driver));
					break;
				}//end if
			}//end while
			
		}//end for
				
		
	}//end main
	
	public boolean isDriverGone(Driver d){
		if(d.nextLoc.equals("philidelphia") || d.nextLoc.equals("cleveland"))
			return true;
		return false;
	}
	
	public String printDriverGone(Driver d){
		return ("Driver " + d.id + " has gone to " + d.nextLoc + "! \n "
				+ "--------------------------------------");
	}
	
	
	//check the parameter contains only one argument. if it does not, return error
	public String errorArgsCheck(String [] args1){
		String error = "";
		
		if(args1.length != 1)
			 error = "Error: 1";
		return error;
	}//argcheck end
	
}
