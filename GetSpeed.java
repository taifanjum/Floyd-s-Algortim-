
/**
	 * This method has a return value speed. This method try to get the average speed of running and biking on smooth and gravel road
	 * 
	 * @return speed
	 */
public class GetSpeed {
	
	static float getSpeed(char status) {
		float speed;
		final float smoothBikingSpeed = 35.00f;		//Average speed of biking on the smooth road
		final float gravelRunningSpeed = 8.00f;     //Average speed of running on the gravel road
		
		switch (status) {
		case 'S':				//Smooth road?
			speed = smoothBikingSpeed;
			break;
		case 'G':				//Gravel road?
			speed = gravelRunningSpeed;
			break;
		default:
			speed = 0;
		}
		return speed;  // return the speed value
	}

}
