import static org.junit.Assert.*;

import org.junit.Test;

public class CityMapTester {
	
	
	@Test
	public void getNeighborsTest() {
		CityMap map = new CityMap();
		
		assertEquals(true, map.getNeighbors("Hotel").contains("Library"));
		assertEquals(true, map.getNeighbors("OC").contains("College"));
		assertEquals(true, map.getNeighbors("College").contains("Diner"));
		assertEquals(true, map.getNeighbors("Diner").contains("Hotel"));
		assertEquals(true, map.getNeighbors("Library").contains("College"));
		
	}
	
	// tests to make sure all the locations are part of the map
	@Test
	public void getCitiesTest() {
		CityMap map = new CityMap();
		//System.out.print(map.getCities());
		assertEquals(true, map.getCities().contains("Library"));
		assertEquals(true, map.getCities().contains("Hotel"));
		assertEquals(true, map.getCities().contains("College"));
		assertEquals(true, map.getCities().contains("Diner"));
		assertEquals(true, map.getCities().contains("OC"));
		
	}
	
	@Test
	public void driverTest() {
		Driver brandon = new Driver(1, 9);
    	brandon.setCurr();
    	brandon.setNextLoc();
    	//System.out.print( brandon.curr + " " + brandon.nextLoc);
    	assertEquals(true, brandon.map.getNeighbors(brandon.curr).contains(brandon.nextLoc));
		
	}
	
	// Will test to make sure that the getStreet method works correctly
	@Test
	public void streetTest(){
		CityMap Pitt = new CityMap();
		//System.out.print(Pitt.getStreet("OC", "College"));
		assertEquals("Fifth Avenue", Pitt.getStreet("OC", "College"));
		assertEquals("Fourth Avenue", Pitt.getStreet("OC", "Hotel"));
	}


}


