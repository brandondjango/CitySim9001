
public class CitySim9001 {
	
	public CitySim9001(){
		
	}

	public static void main(String [] args){
		CitySim9001 sim = new CitySim9001();
		Integer integer = Integer.parseInt(args[0]);
		
		//arg error check
		String error = sim.errorArgsCheck(args);
		if(error.contains("Error")){
			System.out.print(error);
			System.exit(0);
		}
		
		//driver loop
		for(int i = 0; i < 5; i++){
			Driver driver = new Driver(i, integer);
			driver.start();
			driver.print();
			//while driver is not in philidelphia or cleveland, drive
			while(!driver.curr.equals("philidelphia") || !driver.curr.equals("cleveland")){
				driver.drive();
				driver.print();
			}
			driver.print();
		}
		
		
		
		
	}
	
	
	//
	public String errorArgsCheck(String [] args1){
		String error = "";
		if(args1.length != 1)
			 error = "Error: 1";
		return error;
	}//argcheck end
	
}
