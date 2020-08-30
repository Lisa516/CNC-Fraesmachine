package commandHandlers.mHandlers;

import CommandLogging.LogCommands;
import application.Spindle;

public class m05Handler {
	//Spindel Stopp

	public static void execute() {
		Spindle.stopSpindle();
		LogCommands.logCommands("M05");
	}

}
