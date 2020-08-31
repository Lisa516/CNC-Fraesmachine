package application;

import java.io.FileNotFoundException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CommandReader extends FileReader {

	/*
	 * @author Lisa
	 */

	// Creates a JsonArray of the content of the json file
	public static JsonArray createJSArray(String file) throws FileNotFoundException {
		JsonArray commands = readIn(file).getAsJsonArray("commands");
		return commands;
	}

	// turns the JsonArray from createJSArray into a String Array
	public static String[] contentAsStringArray(String file) throws FileNotFoundException {

		JsonArray commands = createJSArray(file);
		String[] commandOrigin = new String[commands.size()];

		for (int i = 0; i < commands.size(); i++) {
			JsonObject command = commands.get(i).getAsJsonObject();

			commandOrigin[i] = command.get("number").getAsString() + "," + command.get("code").getAsString();

			// Parameter je als JsonObject einlesen
			if (command.get("parameters").getAsJsonObject().has("x")) {
				JsonObject parameters = command.get("parameters").getAsJsonObject();
				// Name des parameter ausgeben

				commandOrigin[i] = commandOrigin[i] + ",X" + parameters.get("x").getAsString();
				commandOrigin[i] = commandOrigin[i] + ",Y" + parameters.get("y").getAsString();

				if (command.get("parameters").getAsJsonObject().has("i")) {

					commandOrigin[i] = commandOrigin[i] + ",I" + parameters.get("i").getAsString();
					commandOrigin[i] = commandOrigin[i] + ",J" + parameters.get("j").getAsString();
				}
			}
		}
		return commandOrigin;
	}

	// Sorts the commands of the json file according to their N-codes to execute
	// them in the right order
	public static String[] putCommandsInOrder(String file) throws FileNotFoundException {
		String[] commandsOrigin = contentAsStringArray(file);
		String[] commands = new String[commandsOrigin.length];

		String temp;

		for (int i = 0; i < commands.length; i++) {
			if (Integer.parseInt(String.valueOf(commandsOrigin[i].charAt(3))) == i + 1) {
				commands[i] = commandsOrigin[i];
			} else {
				// Tauschen von aufgerufenem String und dem wo er hingehört
				temp = commandsOrigin[commandsOrigin[i].charAt(3) - 1];
				commandsOrigin[commandsOrigin[i].charAt(3) - 1] = commandsOrigin[i];
				commandsOrigin[i] = temp;
				i = i - 1;
			}
		}
		return commands;
	}

	// Returns a command at a specific index with its parameters as a String Array
	public static String[] _getCommand(int index, String file) throws FileNotFoundException {
		String[] commands = putCommandsInOrder(file);
		String command = commands[index];
		return command.split("\\,");
	}

}
