package application;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.FileNotFoundException;

public class ReadJSONExample {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(System.getProperty("user.dir")); // Use this to see where to paste the JSON file
		JSONParser parser = new JSONParser(); // JSON Parser instance to parse JSON file
		try (Reader reader = new FileReader("test.json")) { // read JSOn file and pass it to JSON Parser
			JSONObject jsonObject = (JSONObject) parser.parse(reader); // print JSON object
			System.out.println(jsonObject);
			
		} catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
}
	

