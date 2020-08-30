package commandHandlers.mHandlers;

import CommandLogging.LogCommands;
import application.Spindle;

public class m04Handler {
	//Spindel Ein: Gegen den Uhrzeigersinn (Linkslauf)
	
	public static void execute() {

		Spindle.startSpindle('l');
		LogCommands.logCommands("M04");

	}

}
