package application;

import java.io.FileNotFoundException;

public class CommandsQueue {

	// Call Tests for all of the commands (Lisa)
	public static boolean testQueueFromJson() throws FileNotFoundException {
		for (int i = 0; i < FileReader.commandsAsStringArray().length; i++) {
			if (TestHandler.aufrufenTest(i) == false) {
				return false;
			}
		}
		return true;
	}

	// Call all of the commands (Lisa)
	public static void QueueFromJSON() throws FileNotFoundException {
		for (int i = 0; i < FileReader.commandsAsStringArray().length; i++) {
			CommandHandler.callCommand(i);
		}
	}

	public void run() throws FileNotFoundException {
		if (testQueueFromJson() == true) {
			QueueFromJSON();
		}
	}

	public void start() {

	}

}
