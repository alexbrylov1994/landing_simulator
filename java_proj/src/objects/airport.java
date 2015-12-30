package objects;

public class airport {
	private int numberOfRunways;
	private int numberOfParkings;
	private runway[] runways;
	private parking[] parkings;
	
	/*Constructor takes the number of runways and parkings in the airport as well as the time unit used for the simulation.
	 * The constructor also runs functions to create arrays of runways and parkings equal to those given
	 * 
	 */
	public airport(int inputNumberOfRunways, int inputNumberOfParkings){
		numberOfRunways = inputNumberOfRunways;
		numberOfParkings = inputNumberOfParkings;
		runways = makeRunways(numberOfRunways);
		parkings = makeParkings(numberOfParkings);
	}
	/*Creates an array of runways depending on the size given
	 * 
	 */
	private runway[] makeRunways(int numberOfRunways){
		runway[] runways = new runway[numberOfRunways];
		while(numberOfRunways !=0 ){
			runway currentRunway = new runway();
			runways[numberOfRunways-1] = currentRunway;
			numberOfRunways--;
		}
		return runways;
	}
	/*Creates an array of parkings depending on the size given
	 * 
	 */
	private parking[] makeParkings(int numberOfParkings){ 
		parking[] parkings = new parking[numberOfParkings];
		while(numberOfParkings !=0 ){
			parking currentParking = new parking();
			parkings[numberOfParkings-1] = currentParking;
			numberOfParkings--;
		}
		return parkings;
	}
	public runway[] getRunways(){
		return runways;
	}
	public parking[] getParkings(){
		return parkings;
	}
}
