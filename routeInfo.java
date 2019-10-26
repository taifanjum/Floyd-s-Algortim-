/**
 * This is the class that will get user input and calculate the road status and distance
 * 
 */
class routeInfo {
	int fromTown;			//departure
	int toTown;				//destination
	char status;			//S-Smooth, G-Gravel
	float distance;			//Unit:km
	char means;				//B-Biking, R-Running
	float timeSpent;		//Unit:minutes
	
	static final int numTown = 10;

	
	routeInfo() {
		return;
	}
	/**
	 * This method stores the input values of the user 
	 * @param inputLine the line of input values entered by the user
	 */
	
	routeInfo(String inputLine) {
		String[] line = new String[4];
		
		line = inputLine.split(",");		//split input line the user input into 4 fields by comma
		
		fromTown = getTownNumber('F', line[0].charAt(0));	//From town(S,1~8)
		toTown = getTownNumber('T', line[1].charAt(0));		//To town(F,1~8)
		status = checkStatusValue(line[2].charAt(0));		//road status(G/S)
		distance = Float.parseFloat(line[3]);    			//distance(km)
		means = RunOrBike.getMeans(status);
		timeSpent = calTimeSpent(status, distance);

	}
	
	// this method will check the value of the town code and return the town number from 0 to 9 as an integer
	// S will be 0, F will be 9
	/**
	 * This get method gets the value of the town
	 * @param indTown the town number 
	 * @param charNum the starting point and ending point represented by S and F 
	 * @return number of the town that was selected by then user  
	 */
	int getTownNumber(char indTown, char charNum) {
		int number = 0;
		
		switch (charNum) {
		case 's': case 'S':			//Start town
			number = 0;
			break;
		case 'f': case 'F':			//Finish town
			number = numTown - 1;
			break;
		case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': 
			number = Character.getNumericValue(charNum);	//Convert chart to interger number
			break;
		default:
			switch (indTown) {
			case 'F':
				throw new RuntimeException();
			case 'T':
				throw new RuntimeException();			
			}

		}
		return number;
	}
	
	// this method will check the status code from user and return the code of the road status. 
	/**
	 * 
	 * @param status the condition of the road chosen by the user either Gravel or Smooth 
	 * @return returns the status of the road between Smooth and Gravel 
	 */
	char checkStatusValue(char status) {
		
		switch(status) {
		case 'G': case 'g':			//Gravel
			status = 'G';
			break;
		case 'S': case 's':			//Smooth
			status = 'S';
			break;
		default:
			throw new RuntimeException();
		}
		
		return status;
	}

	
	
	
	// To calculate the expected time according to the road status and the distance.
	// This method returns the expected time.
	/**
	 * 
	 * @param status condition of the the road smooth or gravel 
	 * @param distance between towns chosen by the user 
	 * @return returns the time taken during each journey in minutes  
	 */
	float calTimeSpent(char status, float distance) {
		float expectedTime;

		// getSpeed gets the average speed according to the road status
		expectedTime = distance / GetSpeed.getSpeed(status) * 60f ;    //Minutes
		return expectedTime;
	}
	

    // To get the average speed according to the road status.
	// if the road's status is smooth, it will take the average speed of the biking.
	// if the road's status is gravel, it will take the average speed of the running.
	// This method returns the the quickest speed.
	/**
	 * 
	 * @param status checks the status of road to choose the more optimal means of transportation 
	 * @return returns the speed according to the road status and method of transportation 
	 */
	
	
}