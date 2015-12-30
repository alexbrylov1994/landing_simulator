package objects;

public class runway {
	private int time2Free;
	/*Constructor sets a newly created runway to be free by having time2Free be 0
	 * 
	 */
	public runway(){
		time2Free = 0;
	}
	public int getTime2Free(){
		return time2Free;
	}
	public void setTime2Free(int planeTaxiTime){
		time2Free = planeTaxiTime;
	}
	public void reduceTime2Free(){
		time2Free--;
	}
}
