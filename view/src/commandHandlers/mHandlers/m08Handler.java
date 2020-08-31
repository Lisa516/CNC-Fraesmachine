package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Coolant;

public class m08Handler {
	//Kuehlmittel Ein
	
	public static void execute() {
		Coolant._setCoolantStatus(true);
		LogCommands.logCommands("M08");
	}

}
