package commandHandlers.mHandlers;

import CommandLogging.LogCommands;
import application.Spindle;

public class m03Handler {
	//Spindel Ein: Im Uhrzeigersinn (Rechtslauf)
	
	
	public static void execute() {

		Spindle.startSpindle('r');
		LogCommands.logCommands("M03");

	}

}
