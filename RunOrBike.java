
public class RunOrBike {
	
//  The method to get the biking or running info between each town
	/**
	 * This method gets the biking or running info between each town	
	 * @param fromIndex index of the town from which the journey starts
	 * @param toIndex 	index of the town to where the journey ends
	 * @return returns method of transportation between each route
	 */
	static char getMeans(int fromIndex, int toIndex) {
		
		char routeMeans = ' ';
		
		for (int i = 0; i < PoorBiathlon.paths.length; i++ ) {
			if (PoorBiathlon.paths[i] != null) {
				if ((PoorBiathlon.paths[i].fromTown == fromIndex) && (PoorBiathlon.paths[i].toTown == toIndex)) {
					routeMeans = PoorBiathlon.paths[i].means;
					break;
				} else {
					routeMeans = ' ';
				}
			}
		}
		
		return routeMeans;
	}
	
	// to build each info array using the road info data "paths"
		/**
		 * 
		 * @param status stores the method of transportation 
		 * @return returns the method of transportation 
		 */
		static char getMeans(char status) {
			char meansBetweenTown = ' ';
			
			switch (status) {
			case 'S':
				meansBetweenTown = 'B';	//B means Biking
				break;
			case 'G':
				meansBetweenTown = 'R';	// R means Running
				break;			
			}
			 
			return meansBetweenTown;
		}

}
