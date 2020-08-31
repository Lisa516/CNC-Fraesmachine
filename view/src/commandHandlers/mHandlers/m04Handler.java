package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Spindle;

public class m04Handler {
	//Spindel Ein: Gegen den Uhrzeigersinn (Linkslauf)
	
	public static void execute() {

		Spindle.startSpindle('l');
		LogCommands.logCommands("M04");

	}

}
