package commandHandlers.gHandlers;

import commandLogging.LogCommands;
import components.MillingCutter;
import errorHandler.ErrorHandling;

/*
 * @author Lisa
 */

public class g03Handler {
	//Vorschub mit Kreisbogen, gegen den Uhrzeigersinn
	
	public static boolean test() {
		if (MillingCutter._getMillingStatus() == true) {
			return true;
		}
		ErrorHandling.commandImpossibleMillingMachineOff();
		return false;
	}
	
	public static void execute(double x, double y, double i, double j) {
		if (test() == false) {
			return;
		}	
		//TODO
		LogCommands.logCommands("G03", x, y, i, j);
	}

}
