
public class InputFromUser {

	/**
	 * This method does not have a return value.It is the main method of our
	 * program. It prints the input instructions for the user and reads the input
	 * from the user.
	 * 
	 * @param args The usual command line arguments array.
	 */

	public static void main(String[] args) {

		boolean flagEnd = false;
		int i = 0;

		System.out.println("Please input your desired routes below.");
		System.out.println(
				"Each input line should consist of 4 elements that are seperated from each other with a comma");
		System.out.println("Element 1:Starting town of a particular road");
		System.out.println("Element 2:Ending town of a particular road");
		System.out.println("Element 3:Type of road(Either Gravel (G) or Smooth (S))");
		System.out.println("Element 4:The distance of the road.");
		System.out.println(
				"Once you have entered all your desired routes, enter the '!' characther to find the shortest path ");
		System.out.println("A sample entry should look like this > 1,2,G,5");

		boolean validFile = false;
		do {
			try {
				// Get info re: route file
				String fileName = InputHelper.getInput("Please enter a file name for the route: ");
				RouteReader routeReader = new RouteReader(fileName); // read input from a file
				validFile = routeReader.validateFile();
				
				i++;
				System.out.println("Trial #" + Integer.valueOf(i));
				
				// If there is a valid RouteReader file, read from that.
				if (validFile) {
					PoorBiathlon.getRoadInfoFromArray(routeReader.getLines());
				} else {
					System.out.println("Begin manual entry."); // if no input file found, begin enter input manually
					PoorBiathlon.getRoadInfo();
				}
				// displayTimeSpent(); //uncomment when test
				FloydsAlgorithm.searchRoute();
				DisplayTables.displayFastestRoute();

				do {
					System.out.println("Do you want to simulate more?(Y/N)");
					PoorBiathlon.inputLine = PoorBiathlon.input.nextLine();
					if (PoorBiathlon.inputLine.equalsIgnoreCase("y")) {
						// initialize all arrays
						PoorBiathlon.paths = new routeInfo[PoorBiathlon.numTown];
						PoorBiathlon.timeSpent = new float[PoorBiathlon.numTown][PoorBiathlon.numTown];
						PoorBiathlon.fastestRoute = new String[PoorBiathlon.numTown][PoorBiathlon.numTown];
					} else if (!PoorBiathlon.inputLine.equalsIgnoreCase("n")) {
						System.out.println("Enter y or n for yes and no respectively.");
					} else {
						flagEnd = true;
					}
				} while (!PoorBiathlon.inputLine.equalsIgnoreCase("n")
						&& !PoorBiathlon.inputLine.equalsIgnoreCase("y"));
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(
						"You have entered the data incorrectly or entered duplicate data, please re-enter it in the format shown below or enter different data.");
				System.out.println("From location, To location, S(Smooth road)/G(Gravel road), Distance(km)");
				System.out.println("Examples: 's,1,g,12', '2,4,g,18'");
				i--;
			}
		} while (flagEnd == false);
		PoorBiathlon.input.close();

	}

}
