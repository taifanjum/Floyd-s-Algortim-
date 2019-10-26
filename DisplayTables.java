public class DisplayTables {
	
	
	/**
	 * This class has three functions that display the time spent, route table and the fastest route 	
	 * 
	 */
		static void displayTimeSpent() {
		
			// print all timeSpent data user input
			System.out.println("----------------- This is the time table for each route --------------");
			System.out.println("\tS \t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \tF");
			for (int i = 0; i < PoorBiathlon.timeSpent.length ; i++) {
				System.out.print(i+"\t");
				for (int j = 0; j < PoorBiathlon.timeSpent[0].length; j++) {
					System.out.print(PoorBiathlon.timeSpent[i][j]+"\t");
				}
				System.out.println();
			}	
		}
	/**
	 * 	
	 */
		static void displayRouteTable() {
		
			// print all route
			System.out.println("----------------- This is route table--------------");
			System.out.println("\tS \t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \tF");
			for (int i = 0; i < PoorBiathlon.fastestRoute.length ; i++) {
				System.out.print(i+"\t");
				if (PoorBiathlon.fastestRoute[i] != null) {
					for (int j = 0; j < PoorBiathlon.fastestRoute[0].length; j++) {
						System.out.print(PoorBiathlon.fastestRoute[i][j]+"\t");
					} 
					System.out.println();
				}
			}
		}
		
	//  The method to print the fastest route
	//  ------------------------------------------------------------------------------------------------	
	//  From below, methods is for displaying the data for checking
	//  This won't display on the screen 
	//  If you want to display this, please uncomment below methods in the method "displayFastestRoute"
	//  ------------------------------------------------------------------------------------------------	
		
		/**
		 * This method prints the fastest route and displays it as output
		 */
		static void displayFastestRoute() {
			
			DisplayInput.displayUserInputData();
			
			//->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			// This is for display the tables to check data step by step 
			//displayTimeSpent();
			//displayRouteTable();
			//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<-
			FastestRoute.displayFinalRoute();
		}


}
