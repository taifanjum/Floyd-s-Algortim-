
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This object is used to store the location of a text file with routes on each
 * line. This object splits the file and allows RouteInfo to process each line.
 * 
 *
 */
public class RouteReader {

	private File routeFile; // The file with Route data
	private BufferedReader reader; // To read each line of the file
	private String url; // The location of the file
	private ArrayList<String> lines; // The recorded lines

	public RouteReader(String url) {
		this.url = url;
	}

	/**
	 * This function iterates through lines in a text file for them to be input as
	 * the route directions. If a line begins with "//" or "#", it will be ignored
	 * as a comment.
	 * 
	 * @return An ArrayList of Strings of each line of the file.
	 */
	public String[] getLines() {
		lines = new ArrayList<String>();
		try {
			// Open file
			reader = new BufferedReader(new FileReader(url));
			String line = "";

			// Read lines
			while ((line = reader.readLine()) != null) {
				// Skip blank lines
				if (line.equals("") || line.equals("\n")) {
					continue;
				}
				
				System.out.println("\tLine: " + line);
				
				// Format the String
				line = line.trim();
				line = line.replaceAll(" ", "");
				lines.add(line);
			}

			// Close input stream, return data
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] linesArray = new String[lines.size()];
		for (int i = 0; i < lines.size(); i++) {
			linesArray[i] = lines.get(i);
		}
		return linesArray;
	}

	/**
	 * Determines if the entered file exists.
	 * 
	 * @return False if does not exist, true otherwise.
	 */
	public boolean validateFile() {
		try {
			routeFile = new File(url);
			if (!routeFile.exists()) {
				throw new FileNotFoundException();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File \"" + url + "\" not found.");
			return false;
		}
		System.out.println("File \"" + url + "\" found.");
		return true;
	}

	/**
	 * Change the location of the file.
	 * 
	 * @param url The new location of the file.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
