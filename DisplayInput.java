
public class DisplayInput {
	
	//  the method to display the information from user 
	/**
	 * This method displays the input as one of the outputs 
	 */
	static void displayUserInputData() {
		// print all data user input
		System.out.println("----------------- This is input from you --------------");
		System.out.println("From \tTo \tStatus \tDistance \tMeans \tTime Spent");
		for (int i = 0; i <PoorBiathlon.paths.length ; i++) {
			if (PoorBiathlon.paths[i] != null) {
				System.out.println(PoorBiathlon.paths[i].fromTown+"\t"+PoorBiathlon.paths[i].toTown+"\t"+PoorBiathlon.paths[i].status+"\t"+PoorBiathlon.paths[i].distance+"km"+"\t\t"+PoorBiathlon.paths[i].means+"\t"+PoorBiathlon.paths[i].timeSpent+"m");
			}
		}
	}

}
