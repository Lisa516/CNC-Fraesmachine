package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Coolant;
import components.MillingCutter;
import components.Spindle;

public class m00Handler {
	//Programmhalt (Spindel, Kuehlmittel, Vorschub aus)
	
	public static void test() {
		
	}
	
	public static void execute() {

		Spindle.stopSpindle();
		Coolant._setCoolantStatus(false);
		MillingCutter.stopMilling();
		LogCommands.logCommands("M00");
	}

}
