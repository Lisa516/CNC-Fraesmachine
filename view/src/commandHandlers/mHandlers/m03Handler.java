package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Spindle;

public class m03Handler {
	//Spindel Ein: Im Uhrzeigersinn (Rechtslauf)
	
	
	public static void execute() {

		Spindle.startSpindle('r');
		LogCommands.logCommands("M03");

	}

}
