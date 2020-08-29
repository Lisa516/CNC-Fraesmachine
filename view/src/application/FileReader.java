package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class FileReader {

	public static JsonObject readIn(String file) throws FileNotFoundException {
		Gson gson = new Gson();
		// Datei file über einen Stream einlesen
		FileInputStream input = new FileInputStream("src/application/" + file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		// Datei als JSON-Objekt einlesen
		JsonObject json = gson.fromJson(reader, JsonObject.class);

		return json;
	}

}