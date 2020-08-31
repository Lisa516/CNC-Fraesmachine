package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Coolant;
import components.MillingCutter;
import components.Spindle;
import ui.UI;

/*
 * @author Lisa
 */

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
		UI.refreshLabel();
	}

}
