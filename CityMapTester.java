import static org.junit.Assert.*;

import org.junit.Test;

public class CityMapTester {

	@Test
	public void getNeighborsTest() {
		CityMap map = new CityMap();
		
		assertEquals(true, map.getNeighbors("Hotel").contains("Library"));
		
	}
	
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
	@Test
	public void streetTest(){
		CityMap Pitt = new CityMap();
		System.out.print(Pitt.getStreet("OC", "College"));
		assertEquals("Fifth Avenue", Pitt.getStreet("OC", "College"));
	}
	}


