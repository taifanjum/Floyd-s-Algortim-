import java.util.Scanner;

/**
 *         This class creates the arrays for our program and stores the input
 *         into the arrays to calculate and display our results.
 *
 */
public class PoorBiathlon {

	static final int numTown = 10;
	static routeInfo[] paths = new routeInfo[numTown];
	static float[][] timeSpent = new float[numTown][numTown];
	static String[][] fastestRoute = new String[numTown][numTown];
	static Scanner input = new Scanner(System.in);
	static String inputLine = new String();

	// Get data from user and then it build the info arrays
	/**
	 * This method does not have a return value. It takes the input from the user
	 * and stores the information into an array
	 */
	static void getRoadInfo() {

		boolean flagStop = false;

		// Create a string array to store the towns info
		int i = 0;

		while (flagStop == false) {
			String inputLine = InputHelper.getInput(">");
			if (inputLine.equalsIgnoreCase("!")) {
				flagStop = true;
			} else {
				buildRouteTable(i, inputLine);
				i++;
			}
		}

		// ->>>>>>>>>for test>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// String inputLine = "s,1,s,3";
		// buildRouteTable(i, inputLine);
		// i++;
		// inputLine = "s,2,s,7";
		// buildRouteTable(i, inputLine);
		// i++;
		// inputLine = "1,2,s,3";
		// buildRouteTable(i, inputLine);
		// i++;
		// inputLine = "2,3,s,3";
		// buildRouteTable(i, inputLine);
		// i++;
		// inputLine = "3,4,s,3";
		// buildRouteTable(i, inputLine);
		// i++;
		// inputLine = "3,f,s,14";
		// buildRouteTable(i, inputLine);
		// i++;
		// inputLine = "4,f,s,2";
		// buildRouteTable(i, inputLine);
		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<-

	}
	
	/**
	 * This method gathers route info from array of lines from a file.
	 * 
	 * @param lines The lines to process.
	 */
	static void getRoadInfoFromArray(String[] lines) {
		// Create a string array to store the towns info

		for (int i = 0; i < lines.length; i++) {
			String inputLine = lines[i];
			if (inputLine.equalsIgnoreCase("!")) {
				break;
			} else {
				buildRouteTable(i, inputLine);
			}
		}
	}

//	The method to get the time spent using user input data
	/**
	 * This method does not have an return value. It is used to get the time spent
	 * using input values from the user
	 * 
	 * @param index     of the paths array
	 * @param inputLine this parameter takes the input values of which town to start
	 *                  from and which town to finish from the user.
	 */
	static void buildRouteTable(int index, String inputLine) {
		int i = 0;
		int j = 0;

		routeInfo inputData = new routeInfo(inputLine);

		paths[index] = inputData;

		i = inputData.fromTown;
		j = inputData.toTown;

		timeSpent[i][j] = inputData.timeSpent;
		timeSpent[j][i] = inputData.timeSpent;
		fastestRoute[i][j] = Integer.toString(i);
		fastestRoute[j][i] = Integer.toString(j);

	}

	/**
	 * This method checks if there are duplicate values in the input
	 * 
	 * @param inputPaths to check if the inputPath
	 * @return returns true if there is a duplicate value in the input
	 */
	static boolean checkDoubleInput(routeInfo inputPaths) {

		int fromIndex = inputPaths.fromTown;
		int toIndex = inputPaths.toTown;

		for (int i = 0; i < paths.length; i++) {
			if (paths[i] != null) {
				if ((paths[i].fromTown == fromIndex) && (paths[i].toTown == toIndex)) {
					return true;
				}
			}
		}

		return false;
	}

}