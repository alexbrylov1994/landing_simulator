package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.CommandTower;
import objects.*;
public class CommandTowerTest {
	@Test
	public void AllContitionsMetTest(){
		airport testAirport = new airport(1, 1);
		CommandTower tower = new CommandTower(testAirport);
		int[] input = {1,50,2,2,2,2};
		airplane testplane = new airplane(input,1);
		
		String result = tower.addPlane(testplane);
		assertEquals(testplane.getID() + " LANDED AT "+ 1 + " WITH "+ testplane.getFuelRemaining() + " REMAINING.",result);
	}
	@Test
	public void RunwaysOccupiedTest(){
		airport testAirport = new airport(1, 1);
		CommandTower tower = new CommandTower(testAirport);
		int[] input = {1,150,2,2,50,2};
		airplane testplane = new airplane(input,1);
		tower.addPlane(testplane);
		int[] input2 = {1,50,2,2,2,2};
		airplane testplane2 = new airplane(input2,1);
		String result2 = tower.addPlane(testplane2);
		
		assertEquals("IMPOSSIBLE", result2);
	}
	@Test
	public void ParkingOccupiedTest(){
		airport testAirport = new airport(1, 1);
		CommandTower tower = new CommandTower(testAirport);
		
		int[] input = {1,150,2,2,2,350};
		airplane testplane = new airplane(input,1);
		tower.addPlane(testplane);
		
		int[] input2 = {1,50,2,2,2,2};
		airplane testplane2 = new airplane(input2,1);
		String result2 = tower.addPlane(testplane2);
		
		assertEquals("IMPOSSIBLE", result2);
	}
	@Test
	public void RunwayAndParkingOccupied(){
		airport testAirport = new airport(1, 1);
		CommandTower tower = new CommandTower(testAirport);
		
		int[] input = {1,150,2,2,2,150};
		airplane testplane = new airplane(input,1);
		tower.addPlane(testplane);
		
		int[] input2 = {1,1000,2,2,200,2};
		airplane testplane2 = new airplane(input2,1);
		tower.addPlane(testplane2);
		
		int[] input3 = {1,50,2,2,2,2};
		airplane testplane3 = new airplane(input3,1);
		
		String result3 = tower.addPlane(testplane3);
		
		assertEquals("IMPOSSIBLE", result3);
	}
	@Test
	public void BothOpenButLowerFuelTest(){
		airport testAirport = new airport(1, 1);
		CommandTower tower = new CommandTower(testAirport);
		int[] input = {1,50,5,15,2,2};
		airplane testplane = new airplane(input,1);
		
		String result = tower.addPlane(testplane);
		assertEquals("IMPOSSIBLE",result);
	}
	
	@Test
	public void InitParkingFullButClearsUpTest(){
		airport testAirport = new airport(1, 1);
		CommandTower tower = new CommandTower(testAirport);
		int[] input = {1,200,2,2,2,30};
		airplane testplane = new airplane(input,1);
		String result = tower.addPlane(testplane);
		int[] input2 = {1,500,2,2,2,30};
		airplane testplane2 = new airplane(input2, 1);
		String result2 = result + "\n" + tower.addPlane(testplane2);
		
		assertEquals(testplane.getID() + " LANDED AT "+ 1 + " WITH "+ testplane.getFuelRemaining() + " REMAINING." + 
		"\n" + testplane2.getID() + " LANDED AT "+ 1 + " WITH "+ testplane2.getFuelRemaining() + " REMAINING.", result2);
	}
	


}
