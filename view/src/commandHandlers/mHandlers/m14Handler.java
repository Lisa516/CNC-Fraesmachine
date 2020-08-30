package commandHandlers.mHandlers;

import CommandLogging.LogCommands;
import application.Coolant;
import application.Spindle;

public class m14Handler {
	//Spindel ein, Linkslauf und Kuehlmittel ein 
	
	public static void execute() {
		Coolant._setCoolantStatus(true);

		Spindle.startSpindle('l');
		LogCommands.logCommands("M14");
	}

}
