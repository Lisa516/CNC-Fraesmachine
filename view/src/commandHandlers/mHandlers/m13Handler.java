package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Coolant;
import components.Spindle;

public class m13Handler {
	//Spindel Ein, Rechtslauf und Kuehlmittel Ein

	
	public static void execute() {
		Coolant._setCoolantStatus(true);

		Spindle.startSpindle('r');
		LogCommands.logCommands("M13");
	}

}
