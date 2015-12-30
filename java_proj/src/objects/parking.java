package objects;

public class parking {
	private int time2Free;
	/*Constructor sets a newly created parking to be free by having time2Free be 0
	 * 
	 */
	public parking(){
		time2Free = 0;
	}
	public int getTime2Free(){
		return time2Free;
	}
	public void setTime2Free(int planeTime2Dissapear){
		time2Free = planeTime2Dissapear;
	}
	public void reduceTime2Free(){
		time2Free--;
	}
}
