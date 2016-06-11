import static org.junit.Assert.*;

import org.junit.Test;

public class CityMapTester {

	@Test
	public void getNeighborsTest() {
		CityMap map = new CityMap();
		
		assertEquals(true, map.getNeighbors("hotel").contains("library"));
		
	}
	
	@Test
	public void getCitiesTest() {
		CityMap map = new CityMap();
		//System.out.print(map.getCities());
		assertEquals(true, map.getCities().contains("library"));
		assertEquals(true, map.getCities().contains("hotel"));
		assertEquals(true, map.getCities().contains("college"));
		assertEquals(true, map.getCities().contains("diner"));
		assertEquals(true, map.getCities().contains("oc"));
		
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
		System.out.print(Pitt.getStreet("oc", "College"));
		assertEquals("Fifth Avenue", Pitt.getStreet("oc", "College"));
	}
	}


