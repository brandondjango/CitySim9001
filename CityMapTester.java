import static org.junit.Assert.*;

import org.junit.Test;

public class CityMapTester {

	@Test
	public void test() {
		CityMap map = new CityMap();
		System.out.print(map.getNeighbors("oc"));
		assertEquals(true, map.getNeighbors("hotel").contains("library"));
		
	}

}
