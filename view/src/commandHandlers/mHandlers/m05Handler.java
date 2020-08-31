package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Spindle;

public class m05Handler {
	//Spindel Stopp

	public static void execute() {
		Spindle.stopSpindle();
		LogCommands.logCommands("M05");
	}

}
