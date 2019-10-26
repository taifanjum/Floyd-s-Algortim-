
public class GetDistance {
	static final int numTown = 10;

	static routeInfo[] paths = new routeInfo[numTown];
	
//  the method to calculate the total distance from the start to the end
	/**
	 * This method calculates the total distance taken from start to finish 	
	 * @param fromIndex the town from which the journey starts
	 * @param toIndex the town where the journey ends 
	 * @return total distance from from start to finish 
	 */
	static float getDistance(int fromIndex, int toIndex) {
		
		float routeDistance = ' ';
		
		for (int i = 0; i < paths.length; i++ ) {
			if (paths[i] != null) {
				if ((paths[i].fromTown == fromIndex) && (paths[i].toTown == toIndex)) {
					routeDistance = paths[i].distance;
					break;
				} else {
					routeDistance = 0.0f;
				}
			}
		}
		
		return routeDistance;
	}	
}
