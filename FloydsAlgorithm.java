
public class FloydsAlgorithm {
	
//  The method to build the shortest node	
	/**
	 * This method uses floyd's algorithm to find the fastest route.
	 */
	static void searchRoute() {

		float tempTime[][] = new float[PoorBiathlon.numTown][PoorBiathlon.numTown];
		
		tempTime = PoorBiathlon.timeSpent.clone();   //copy timeSpent to tempTime to update the new time

		//If the node is itself, update the time with 0.
		//if the node is not connected, update the time with 999999.99 
		for (int i = 0; i < PoorBiathlon.numTown  ; i++) {
			for (int j = 0; j <PoorBiathlon.numTown ; j++) {
				if ( i == j ) {
					tempTime[i][j] = 0;
				} else {
					if ( tempTime[i][j] == 0.00f ) {
						tempTime[i][j] = 999999.99f;
					} 
				}
			}
		}

		//calculate the fastest time of each node and update the array
		for (int k = 0; k < PoorBiathlon.numTown  ; k++) {
			for (int i = 0; i < PoorBiathlon.numTown  ; i++) {
				for (int j = 0; j <PoorBiathlon.numTown ; j++) {
					if ( tempTime[i][k] + tempTime[k][j] < tempTime[i][j]) {
						tempTime[i][j] = tempTime[i][k] + tempTime[k][j];
						PoorBiathlon.fastestRoute[i][j] = Integer.toString(k);
					} 
				}
			}
		}
	}

}
