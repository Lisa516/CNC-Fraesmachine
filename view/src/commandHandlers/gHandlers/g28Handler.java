package commandHandlers.gHandlers;

import commandLogging.LogCommands;
import components.MillingCutter;
import errorHandler.ErrorHandling;

/*
 * @author Lisa
 */

public class g28Handler{
	//HOME Position anfahren
	
	public static boolean test() {
		if (MillingCutter._getMillingStatus() == false) {
			return true;
		}
		ErrorHandling.commandInvalidMillNotRunning();
		return false;
	}
	
	public static void execute() {
		if (test() == false) {
			return;
		}	
		//TODO
		LogCommands.logCommands("G28");
	}

}
