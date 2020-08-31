package application;

import java.io.FileNotFoundException;

public class CommandsQueue {
	/*
	 * @author Lisa
	 */

	// Call Tests for all of the commands
	public static boolean testQueueFromJson(String file) throws FileNotFoundException {
		for (int i = 0; i < CommandReader.contentAsStringArray(file).length; i++) {
			if (TestHandler.callTest(i, file) == false) {
				return false;
			}
		}
		return true;
	}

	// Call all of the commands if the test had a positive result
	public static void QueueFromJSON(String file) throws FileNotFoundException {
	/*	if (testQueueFromJson(file)) {*/
			for (int i = 0; i < CommandReader.contentAsStringArray(file).length; i++) {
				CommandHandler.callCommand(CommandHandler.getCommand(i, file), i, file);
			}
		//}
	}

	public void run() throws FileNotFoundException {
		CommandsQueue.QueueFromJSON("Befehlscode.json");
	}
}
