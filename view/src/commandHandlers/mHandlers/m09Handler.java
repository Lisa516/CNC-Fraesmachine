package commandHandlers.mHandlers;

import CommandLogging.LogCommands;
import application.Coolant;

public class m09Handler {
	//Kuehlmittel aus
	
	public static void execute() {
		Coolant._setCoolantStatus(false);
		LogCommands.logCommands("M09");
	}

}
