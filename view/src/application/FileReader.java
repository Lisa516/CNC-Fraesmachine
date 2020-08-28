package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FileReader {
	
	public static JsonArray readIn() throws FileNotFoundException {
		Gson gson = new Gson();
        // Datei "Befehlscode.json" über einen Stream einlesen
        FileInputStream input = new FileInputStream("src/application/Befehlscode.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        
        // Datei als JSON-Objekt einlesen
        JsonObject json = gson.fromJson(reader, JsonObject.class);
        
        // Attribut "commands" als Array lesen
        JsonArray commands = json.getAsJsonArray("commands");
        
        return commands;
	}
	
	public static String[] commandAsAlsStringArray(JsonArray commands) {
		
		String[] commandOrigin = new String[commands.size()];

        for(int i = 0; i < commands.size(); i++){
            JsonObject command = commands.get(i).getAsJsonObject();
            
            commandOrigin[i] = command.get("number").getAsString() + "," + command.get("code").getAsString();
               
            // Parameter je als JsonObject einlesen
            if (command.get("parameters").getAsJsonObject().has("x")) {
            	JsonObject parameters = command.get("parameters").getAsJsonObject(); 
                // Name des parameter ausgeben
            	
            	commandOrigin[i] = commandOrigin[i] + ",X" + parameters.get("x").getAsString();
            	commandOrigin[i] = commandOrigin[i] + ",Y" + parameters.get("y").getAsString();
            	
                if ( command.get("parameters").getAsJsonObject().has("i")) {
                	
                	commandOrigin[i] = commandOrigin[i] + ",I" + parameters.get("i").getAsString();
                	commandOrigin[i] = commandOrigin[i] + ",J" + parameters.get("j").getAsString();
                }
            }
        }
 /**        for(int i = 0; i < befehleUrsprung.length; i++) {
        	 System.out.println(befehleUrsprung[i]);
         }**/
        return commandOrigin;
	}
	
public static String[] commandsAsStringArray() throws FileNotFoundException {
	
		JsonArray commands = readIn();
		String[] commandOrigin = new String[commands.size()];

        for(int i = 0; i < commands.size(); i++){
            JsonObject command = commands.get(i).getAsJsonObject();
            
            commandOrigin[i] = command.get("number").getAsString() + "," + command.get("code").getAsString();
               
            // Parameter je als JsonObject einlesen
            if (command.get("parameters").getAsJsonObject().has("x")) {
            	JsonObject parameters = command.get("parameters").getAsJsonObject(); 
                // Name des parameter ausgeben
            	
            	commandOrigin[i] = commandOrigin[i] + ",X" + parameters.get("x").getAsString();
            	commandOrigin[i] = commandOrigin[i] + ",Y" + parameters.get("y").getAsString();
            	
                if ( command.get("parameters").getAsJsonObject().has("i")) {
                	
                	commandOrigin[i] = commandOrigin[i] + ",I" + parameters.get("i").getAsString();
                	commandOrigin[i] = commandOrigin[i] + ",J" + parameters.get("j").getAsString();
                }
            }
        }
 /**        for(int i = 0; i < befehleUrsprung.length; i++) {
        	 System.out.println(befehleUrsprung[i]);
         }**/
        return commandOrigin;
	}
	
	public static String[] putCommandsInOrder(String[] befehleUrsprung) {
		String[] commands = new String[befehleUrsprung.length];
		
		String temp;
		
		for (int i = 0; i < commands.length; i++) {
			if (Integer.parseInt(String.valueOf(befehleUrsprung[i].charAt(3))) == i + 1) {
				commands[i] = befehleUrsprung[i];
			}
			else {
				//Tauschen von aufgerufenem String und dem wo er hingehört
				temp = befehleUrsprung[befehleUrsprung[i].charAt(3) - 1];
				befehleUrsprung[befehleUrsprung[i].charAt(3) - 1] = befehleUrsprung[i];
				befehleUrsprung[i] = temp;
				i = i - 1;
			}
		}
		/**for (int i = 0; i < befehle.length; i++) {
			System.out.println(befehle[i]);
		}**/
		return commands;
	}
	
	public static String[] putCommandsInOrder() throws FileNotFoundException {
		String[] commandsOrigin = commandsAsStringArray();
		String[] commands = new String[commandsOrigin.length];
		
		String temp;
		
		for (int i = 0; i < commands.length; i++) {
			if (Integer.parseInt(String.valueOf(commandsOrigin[i].charAt(3))) == i + 1) {
				commands[i] = commandsOrigin[i];
			}
			else {
				//Tauschen von aufgerufenem String und dem wo er hingehört
				temp = commandsOrigin[commandsOrigin[i].charAt(3) - 1];
				commandsOrigin[commandsOrigin[i].charAt(3) - 1] = commandsOrigin[i];
				commandsOrigin[i] = temp;
				i = i - 1;
			}
		}
		/**for (int i = 0; i < befehle.length; i++) {
			System.out.println(befehle[i]);
		}**/
		return commands;
	}
		
	public static String[] _getCommand(int position, String[] commands) {
		String command = commands[position];
	/**	for (int i = 0; i < befehl.split("\\,").length; i++) {
			System.out.println(split[i]);
		}**/
		return command.split("\\,");
	}
	
	public static String[] _getCommand(int position) throws FileNotFoundException {
		String[] commands = putCommandsInOrder();
		String command = commands[position];
	/**	for (int i = 0; i < befehl.split("\\,").length; i++) {
			System.out.println(split[i]);
		}**/
		return command.split("\\,");
	}
	
	public static int _getX(int index) throws FileNotFoundException {
		String withX = FileReader._getCommand(index)[2];
		String withoutX = withX.substring(1);
		int x = Integer.parseInt(withoutX);
		return (x + 50);
	}
	
	
	public static int _getY(int index) throws FileNotFoundException {
		String withY = FileReader._getCommand(index)[3];
		String withoutY = withY.substring(1); 
		return (Integer.parseInt(withoutY) + 50);
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
	} 
}