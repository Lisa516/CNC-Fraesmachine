package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/*
 * @author Lisa
 */

public class FileReader {

	//A json file (Settings or Commands) is read in via the external library gson
	public static JsonObject readIn(String file) throws FileNotFoundException {
		Gson gson = new Gson();
		FileInputStream input = new FileInputStream("src/application/" + file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		JsonObject json = gson.fromJson(reader, JsonObject.class);

		return json;
	}
}