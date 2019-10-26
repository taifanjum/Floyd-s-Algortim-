

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Used to get String information from the user.
 */
public abstract class InputHelper {

	private static BufferedReader b;

	/**
	 * Gets input from the user using a prompt.
	 * 
	 * @param prompt To inform the user of what they are inputting. (1 space is
	 *               included afterward)
	 * @return The input gathered from the user.
	 */
	public static String getInput(String prompt) {
		String input = "";
		try {
			System.out.print(prompt + " ");
			b = new BufferedReader(new InputStreamReader(System.in));
			input = b.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

}
