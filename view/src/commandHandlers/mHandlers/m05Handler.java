package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Spindle;

/*
 * @author Lisa
 */

public class m05Handler {
	//Spindel Stopp

	public static void execute() {
		Spindle.stopSpindle();
		LogCommands.logCommands("M05");
	}

}
