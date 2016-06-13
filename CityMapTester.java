import static org.junit.Assert.*;

import org.junit.Test;

public class CityMapTester {
	
	/////////////////////////////////////
	//CityMap tests
	/////////////////////////////////////

	//Test checks for location library in the CityMap 
	//It should be there(test should pass)
	@Test
	public void libraryTest() {
		CityMap map = new CityMap();
		assertEquals(true, map.getCities().contains("library"));		
	}
	
	//Test checks for location library in the CityMap 
	//It should be there(test should pass)
	@Test
	public void hotelTest() {
		CityMap map = new CityMap();
		assertEquals(true, map.getCities().contains("hotel"));		
	}
	
	//Test checks for location library in the CityMap 
	//It should be there(test should pass)
	@Test
	public void dinerTest() {
		CityMap map = new CityMap();
		assertEquals(true, map.getCities().contains("diner"));		
	}
		
	//Test checks for location library in the CityMap 
	//It should be there(test should pass)
	@Test
	public void collegeTest() {
		CityMap map = new CityMap();
		assertEquals(true, map.getCities().contains("college"));		
	}
	
	//Test checks for location outside city(oc) in the CityMap 
	//It should be there(test should pass)
	@Test
	public void ocTest() {
		CityMap map = new CityMap();
		assertEquals(true, map.getCities().contains("oc"));		
	}
	
	//Test checks for all locations within same instance of object, getCities test
	//It should be there(test should pass)
	@Test
	public void getCitiesTest() {
		CityMap map = new CityMap();
		assertEquals(true, map.getCities().contains("library"));
		assertEquals(true, map.getCities().contains("hotel"));
		assertEquals(true, map.getCities().contains("college"));
		assertEquals(true, map.getCities().contains("diner"));
		assertEquals(true, map.getCities().contains("oc"));
		
	}
	
	//checks that hotel has neighbors library and diner
	@Test
	public void getNeighborsHotelTest() {
		CityMap map = new CityMap();
		assertEquals(true, map.getNeighbors("hotel").contains("library"));
		assertEquals(true, map.getNeighbors("hotel").contains("diner"));
	}
	
	//checks that library has neighbors hotel and Cleveland
	@Test
	public void getNeighborsLibraryTest() {
		CityMap map = new CityMap();
		assertEquals(true, map.getNeighbors("library").contains("hotel"));
		assertEquals(true, map.getNeighbors("library").contains("cleveland"));
	}
	
	//checks OC has neighbor hotel and college
	@Test
	public void getNeighborsOCTest() {
		CityMap map = new CityMap();
		assertEquals(true, map.getNeighbors("oc").contains("college"));
		assertEquals(true, map.getNeighbors("oc").contains("hotel"));
	}
	//Checks Fifth Avenue connects outside city(oc) and college
	@Test
	public void streetTest(){
		CityMap Pitt = new CityMap();
		assertEquals("Fifth Avenue", Pitt.getStreet("oc", "college"));
	}
	
	//////////////////////////////////////
	//Driver Tests
	//////////////////////////////////////
	
	//Driver double test. Tests driver has an attribute curr that does not rely on CityMap
	//it does this by using a test double, the doubleClass, that sets curr without using CityMap methods
	@Test
	public void driverCurrDoubleTest() {
		Driver driver = new Driver(1, 9);
    	doubleClass d= new doubleClass();
    	
    	driver = d.getCurr(driver, "hotel");
    	    	
    	assertEquals(true, driver.curr.equals("hotel"));
		
	}
	
	//Driver double test. Tests driver has an attribute nextLoc that does not rely on CityMap
	//it does this by using a test double, the doubleClass, that sets nextLoc without using CityMap methods
	@Test
	public void driverNextLocDoubleTest() {
		Driver driver = new Driver(1, 9);
	   	doubleClass d= new doubleClass();
	    	
	   	driver = d.getNextLoc(driver, "diner");
	    	    	
	   	assertEquals(true, driver.nextLoc.equals("diner"));
			
		}
	
	//Driver double test. Tests driver has an attribute street that does not rely on CityMap
	//it does this by using a test double, the doubleClass, that sets street without using CityMap methods
	@Test
	public void driverStreetDoubleTest() {
		Driver driver = new Driver(1, 9);
	   	doubleClass d= new doubleClass();
		    	
	   	driver = d.getStreet(driver, "Parkview Avenue");
		    	    	
	   	assertEquals(true, driver.street.equals("Parkview Avenue"));
				
		}
	
	//For this test we have specifically created a DriverStub class for stub tests.
	//This Stub test specifically has in place method overrides for two cases.
	//This test will test Driver start method, which randomly selects the start point.
	//We are stubbing in this case because we have not yet developed the random algorithm for setCurr
	@Test
	public void driverStartStubTest() {
		Driver driver = new DriverStub( 1, 2);
	   				    	
	   	driver.start();
	   		   				    	    	
	   	assertEquals(true, (driver.nextLoc.equals("library") || driver.nextLoc.equals("diner") ));
					
		}
	//This stub test will be used test for street accuracy in the drive method.
	//In the stub we have given predetermined values and expect driver.street to return "Fourth Avenue"
	//in the stub conditions.
	@Test
	public void driverDriveStreetStubTest() {
		Driver driver = new DriverStub( 1, 1);
	   				    	
	   	driver.drive();
	   		   				    	    	
	   	assertEquals(true, (driver.street.equals("Fourth Avenue")));
					
		}
	//Quick stub to check the toString method works in controlled conditions
	//Should return "Driver 1 is driving from Pittsburgh to Philly via 376"
	@Test
	public void driverToStringStubTest() {
		Driver driver = new DriverStub( 1, 1);
	   	assertEquals(true, (driver.toString().equals("Driver 1 is driving from Pittsburgh to Philly via 376")));
					
		}
	
	
	
	
	//This test checks that a randomly generated current location in the driver class must have
	//a nextLoc that must ALWAYS be a neighbor of curr. It depends on our hardcode implementation of
	//CityMap in this case. Performs it with 3 different seed values
	@Test
	public void driverTest() {
		//Seed: 9
		Driver brandon = new Driver(1, 9);
    	brandon.setCurr();
    	brandon.setNextLoc();
    	assertEquals(true, brandon.map.getNeighbors(brandon.curr).contains(brandon.nextLoc));
    	/////////Seed 21321
    	brandon = new Driver(1, 21321);
    	brandon.setCurr();
    	brandon.setNextLoc();
    	assertEquals(true, brandon.map.getNeighbors(brandon.curr).contains(brandon.nextLoc));
    	//////////Seed: 76
    	brandon = new Driver(1, 76);
    	brandon.setCurr();
    	brandon.setNextLoc();
    	assertEquals(true, brandon.map.getNeighbors(brandon.curr).contains(brandon.nextLoc));
    	//////////Seed: 76
    	brandon = new Driver(1, 76);
    	brandon.setCurr();
  		brandon.setNextLoc();
  		assertEquals(true, brandon.map.getNeighbors(brandon.curr).contains(brandon.nextLoc));
		
	}
	
	///////////////////////////////////
	//CitySim9001 tests
	///////////////////////////////////
	
	//CitySim9001.java errorArgsCheck(String []) checks the arguments entered by the user is exactly 1
	//arguement. These tests check it returns an error when this is not the case
	//This test checks when there are 0 arguements(should return error)
	@Test
	public void argsCheckLessThan() {
		CitySim9001 citysim = new CitySim9001();
		
		String [] bdon = {};
		assertEquals(true, citysim.errorArgsCheck(bdon).contains("Error"));
					
		}
	
	//CitySim9001.java errorArgsCheck(String []) checks the arguments entered by the user is exactly 1
	//arguement. These tests check it returns an error when this is not the case
	//This test checks when there are 2 arguments(should return error)
	@Test
	public void argsCheckMoreThan() {
		CitySim9001 citysim = new CitySim9001();
			
		String [] bdon = {"bdon", "json"};
		assertEquals(true, citysim.errorArgsCheck(bdon).contains("Error"));
						
			}
	
	//CitySim9001.java errorArgsCheck(String []) checks the arguments entered by the user is exactly 1
	//arguement. These tests check it returns an error when this is not the case
	//This test checks when there is 1 argument(should return "")
	@Test
	public void argsCheckJustRight() {
		CitySim9001 citysim = new CitySim9001();
			
		String [] bdon = {"bdon"};
		assertEquals(true, citysim.errorArgsCheck(bdon).contains(""));
						
			}
	//with CitySim9001 there is a counter variable initiated in the constructor that must equal 5
	//this number controls the number of drivers output. It should always equal 5,
	//both before and after main
	@Test
	public void CitySimCounter() {
		CitySim9001 citysim = new CitySim9001();
			
		assertEquals(5, citysim.counter);
		String[] args = {"1"};
		//citysim.main(args);
		
		assertEquals(5, citysim.counter);
				
						
		}
	
	//isDriverGone tests whether or not the drivers nextLoc is cleveland or pittsburgh
	//in this test the driver is going to Zainesville, so the function should return false
	@Test
	public void isDriverGoneTest() {
		CitySim9001 citysim = new CitySim9001();
		Driver d = new Driver(4, 4);
		d.nextLoc = "Zainesville";
		assertEquals(false, citysim.isDriverGone(d));
				
						
		}
	
	//isDriverGone tests whether or not the drivers nextLoc is cleveland or pittsburgh
	//in this test the driver is going to philidelphia, so the function should return true
	@Test
	public void isDriverGoneTest2() {
		CitySim9001 citysim = new CitySim9001();
		Driver d = new Driver(4, 4);
		d.nextLoc = "philidelphia";
		assertEquals(true, citysim.isDriverGone(d));
					
							
	}
	
	//isDriverGone tests whether or not the drivers nextLoc is cleveland or pittsburgh
	//in this test the driver is going to philidelphia, so the function should return true
	@Test
	public void isDriverGoneTest3() {
		CitySim9001 citysim = new CitySim9001();
		Driver d = new Driver(4, 4);
		d.nextLoc = "cleveland";
		assertEquals(true, citysim.isDriverGone(d));
					
		}
	
	//printdriverisgone is a method that prints a message when the driver is leaving for cleveland/philly
	//it must contain the correct driver id and correct destination
	//this test will ensure it does both(it should pass
	@Test
	public void printDriverisGoneTest() {
		CitySim9001 citysim = new CitySim9001();
		Driver d = new Driver(4, 4);
		d.nextLoc = "Pittsburgh";
		String message = citysim.printDriverGone(d);
		boolean t = (message.contains("4") && message.contains("Pittsburgh") );
		assertEquals(true, t);
					
		}
	
	
}


