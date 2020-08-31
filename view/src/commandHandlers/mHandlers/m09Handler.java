package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Coolant;

/*
 * @author Lisa
 */

public class m09Handler {
	//Kuehlmittel aus
	
	public static void execute() {
		Coolant._setCoolantStatus(false);
		LogCommands.logCommands("M09");
	}

}
