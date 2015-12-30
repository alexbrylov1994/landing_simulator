package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import objects.*;

public class airportTest {

	@Test
	public void testGetRunways() {
		airport testAirport = new airport(1,1);
		assertEquals(1, testAirport.getRunways().length);
	}

	@Test
	public void testGetParkings() {
		airport testAirport = new airport(1,1);
		assertEquals(1, testAirport.getParkings().length);
	}

}
