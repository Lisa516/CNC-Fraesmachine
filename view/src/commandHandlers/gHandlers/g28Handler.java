package commandHandlers.gHandlers;

import application.MillingCutter;
import errorHandler.ErrorHandling;

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
	}

}
