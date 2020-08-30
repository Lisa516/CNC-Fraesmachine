package commandHandlers.mHandlers;

import application.MillingCutter;
import CommandLogging.LogCommands;
import application.Coolant;
import application.Spindle;

public class m02Handler {
	//Programm Ende
	
	public static void execute() {
		//TODO

		Spindle.stopSpindle();

		Coolant._setCoolantStatus(false);
		if (MillingCutter._getMillingStatus() == true) {
			MillingCutter.stopMilling();
		}
		LogCommands.logCommands("M02");
	}

}
