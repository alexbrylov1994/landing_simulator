package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import objects.airplane;

public class airplaneTest {

	@Test
	public void testReduceTimeInAir() {
		int[] input = {1,50,2,2,2,2};
		airplane testPlane = new airplane(input,1);
		testPlane.reduceTimeInAir();
		assertEquals(24, testPlane.getTimeInAir());
	}

	@Test
	public void testSetLandTimeMili() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateTimeUnitLandTime() {
		int[] input = {1,50,2,2,2,2};
		airplane testPlane = new airplane(input,1);
		assertEquals(25, testPlane.getTimeInAir());
	}

	@Test
	public void testGetFuelRemaining() {
		int[] input = {1,40,2,2,2,2};
		airplane testPlane = new airplane(input,1);
		assertEquals(40, testPlane.getFuelRemaining());
	}

}
