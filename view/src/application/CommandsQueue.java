package application;

import java.io.FileNotFoundException;

public class CommandsQueue {

	// Call Tests for all of the commands (Lisa)
	public static boolean testQueueFromJson(String file) throws FileNotFoundException {
		for (int i = 0; i < CommandReader.contentAsStringArray(file).length; i++) {
			if (TestHandler.callTest(i, file) == false) {
				return false;
			}
		}
		return true;
	}

	// Call all of the commands (Lisa)
	public static void QueueFromJSON(String file) throws FileNotFoundException {
		for (int i = 0; i < CommandReader.contentAsStringArray(file).length; i++) {
			CommandHandler.callCommand(CommandHandler.getCommand(i, file));
		}
	}

	public void run() throws FileNotFoundException {
		if (testQueueFromJson("Befehlscode.json") == true) {
			QueueFromJSON("Befehlscode.json");
		}
	}

	public void start() {

	}

}
