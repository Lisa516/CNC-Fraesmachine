package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Coolant;
import components.Spindle;

public class m14Handler {
	//Spindel ein, Linkslauf und Kuehlmittel ein 
	
	public static void execute() {
		Coolant._setCoolantStatus(true);

		Spindle.startSpindle('l');
		LogCommands.logCommands("M14");
	}

}
