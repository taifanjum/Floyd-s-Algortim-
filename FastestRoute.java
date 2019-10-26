
public class FastestRoute {
	
//  The method to display the result
	/**
	 * This method does not have a return value. It displays the time taken to travel through each route and the fastest route   	
	 */
	static void displayFinalRoute() {
		
		String nodes = new String();
		String means = new String();
		float totalDistance;
		
		//Display the expected time
		System.out.println("The expected fastest time is : " + Float.toString(PoorBiathlon.timeSpent[0][PoorBiathlon.numTown -1]) + " Minutes");
		
		//Display the fastest route
		nodes = "F";
		int j = PoorBiathlon.numTown - 1;
		int i = 0;
		totalDistance = 0.0f;
		
		//Build the route info and the total distance from the start to the end
		
		while (j > 0) {
			if (PoorBiathlon.fastestRoute[0][j] != null) {
				i = Integer.valueOf(PoorBiathlon.fastestRoute[0][j]);
			    if ( Integer.valueOf(PoorBiathlon.fastestRoute[0][j]) == 0 ) {
			    	nodes = "S" + " ---> " + nodes;
			    	means = RunOrBike.getMeans(i,j) + " ---> " + means;
			    	totalDistance = totalDistance + GetDistance.getDistance(i,j);
			    	j = 0;
			    } else {
			    	nodes = PoorBiathlon.fastestRoute[0][j] + " ---> " +  nodes;
				   	means = RunOrBike.getMeans(i,j) + " ---> " + means;
				   	totalDistance = totalDistance + GetDistance.getDistance(i,j);
				   	j = i;
			    }
			    
		   } else {
			   j--;
		   }
		}
		System.out.println("The fastest route is      : " + nodes);
		System.out.println("The means betwen route is : " + means);
		System.out.println("The total distance is     : " + String.valueOf(totalDistance) + " km");
	}

}
