package objects;

public class airplane {
	
	private int fuelBurnRate;
	private int timeInAir;
	private int id;
	private int fuel;
	private int unloadTime;
	private int landingTime;
	private int taxiTime;
	private long landTimeMili;
	private long spawnTime;
	private int timeUnitValue;
	
	
	
	/*The Constructor takes an int array which it then uses to set the private variables of the class. It also takes
	 * the time unit.
	 * The constructor calculates the time in air of the air plane as soon as it is created.
	 * It also makes a time stamp of when the object was created in milliseconds.
	 */
	public airplane(int[] input, int inputTimeUnit){
		fuelBurnRate = input[2];
		id = input[0];
		fuel = input[1];
		unloadTime = input[5];
		landingTime = input[3];
		taxiTime = input[4];
		spawnTime = System.currentTimeMillis();
		timeUnitValue = inputTimeUnit;
		calcualteTimeInAir();
		
	}
	
	private void calcualteTimeInAir(){
		timeInAir = fuel/fuelBurnRate;
	}
	public void reduceTimeInAir(){
		timeInAir--;
	}
	public int getTimeInAir(){
		return timeInAir;
	}
	public int getUnloadTime(){
		return unloadTime;
	}
	public int getLandingTime(){
		return landingTime;
	}
	public int getTaxiTime(){
		return taxiTime;
	}
	public int getID(){
		return id;
	}
	//Makes a time stamp for when the plane lands in milliseconds.
	public void setLandTimeMili(){
		landTimeMili = System.currentTimeMillis();
	}
	//calculates total time it takes to land the plane
	public int calculateTimeUnitLandTime(){
		int timeToLand = (landingTime+ taxiTime)/timeUnitValue;
		return timeToLand;
	}
	public int getFuelRemaining(){
		timeInAir = timeInAir-landingTime-taxiTime;
		
		return timeInAir*fuelBurnRate;
	}
}
