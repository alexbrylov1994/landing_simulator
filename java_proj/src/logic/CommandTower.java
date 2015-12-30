package logic;
import objects.*;
public class CommandTower {
	
	private int runway2Use = 0;
	private int parking2Use = 0;
	private airport currentAirport;
	
	/*Constructor takes an airport and makes the local airport the taken airport
	 * 
	 */
	public CommandTower(airport inputAirport){
		currentAirport = inputAirport; 
	}
	/*Checks if there is available runways. If not it reduces the time2Free on the occupied runway
	 * 
	 */
	private boolean checkRunways(){
		for(int i = 0; i< currentAirport.getRunways().length; i++){
			if(currentAirport.getRunways()[i].getTime2Free() == 0){
				runway2Use = i;
				return true;
			}
			else{
				currentAirport.getRunways()[i].reduceTime2Free();
			}
		}
		return false;
	}
	/*Checks if there is available parkings. If not it reduces the time2Free on the occupied parking
	 * it also checks to see whether the landing time + taxi time of the airplane asking for permission are long enough
	 * until another parking is free.
	 */
	private boolean checkParkings(airplane plane){
		for (int i = 0; i< currentAirport.getParkings().length; i++){
			if(currentAirport.getParkings()[i].getTime2Free() == 0){
				parking2Use = i;
				return true;
			}
			else if(plane.getTimeInAir()-plane.getLandingTime()-plane.getTaxiTime()>=currentAirport.getParkings()[i].getTime2Free()){
				parking2Use = i;
				return true;
			}
			else{
				currentAirport.getParkings()[i].reduceTime2Free();
			}
		}
		return false;
	}
	/*This function takes a plane and checks to see if the conditions for landing are met
	 * The plane hovers in the air burning fuel if it cannot land yet.
	 * if the plane is granted permission to land it checks if it has enough fuel for a landing and a taxi
	 * If this is the case then we occupy the appropriate runway and parking for the plane. 
	 * in other cases the request returns as impossible. 
	 * If the plane runs out of fuel in the air it returns impossible. 
	 */
	private String checkLanding(airplane plane){
		
		
		boolean runwayEmpty = false;
		boolean parkingEmpty = false;
		boolean firstTime = true;
		
		while(runwayEmpty == false|| parkingEmpty == false){
			if(plane.getTimeInAir()>0){
				runwayEmpty = checkRunways();
				parkingEmpty = checkParkings(plane);
			}
			else{
				return "IMPOSSIBLE";
			}
			if(firstTime){
				firstTime = false;
			}
			else{
				plane.reduceTimeInAir();				
			}
			
		}
		if((plane.getTimeInAir()-plane.getLandingTime()-plane.getTaxiTime())>= 0){
			plane.setLandTimeMili();
			currentAirport.getRunways()[runway2Use].setTime2Free(plane.getTaxiTime());
			currentAirport.getParkings()[parking2Use].setTime2Free(plane.getTaxiTime() + plane.getUnloadTime());
			return plane.getID() + " LANDED AT "+ plane.calculateTimeUnitLandTime() + " WITH "+ plane.getFuelRemaining() + " REMAINING.";
			
		}
		else{
			return "IMPOSSIBLE";
		}
		
	}
	/*Function for clarity purposes. Takes an airplane that has been added(run by the command tower)
	 * 
	 */
	public String addPlane(airplane plane){
		return checkLanding(plane);
	}
}
