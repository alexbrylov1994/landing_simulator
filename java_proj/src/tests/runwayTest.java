package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import objects.runway;

public class runwayTest {

	@Test
	public void testRunway() {
		runway testRunway = new runway();
		assertEquals(0, testRunway.getTime2Free());
	}

	@Test
	public void testSetTime2Free() {
		runway testRunway = new runway();
		testRunway.setTime2Free(10);
		assertEquals(10, testRunway.getTime2Free());
	}

	@Test
	public void testReduceTime2Free() {
		runway testRunway = new runway();
		testRunway.setTime2Free(10);
		testRunway.reduceTime2Free();
		assertEquals(9, testRunway.getTime2Free());
	}

}
