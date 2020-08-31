package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Coolant;
import components.Spindle;
import ui.UI;

/*
 * @author Lisa
 */

public class m13Handler {
	//Spindel Ein, Rechtslauf und Kuehlmittel Ein

	
	public static void execute() {
		Coolant._setCoolantStatus(true);

		Spindle.startSpindle('r');
		LogCommands.logCommands("M13");
		UI.refreshLabel();
	}

}
