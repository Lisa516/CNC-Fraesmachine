package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Coolant;
import components.Spindle;
import ui.UI;

/*
 * @author Lisa
 */

public class m14Handler {
	//Spindel ein, Linkslauf und Kuehlmittel ein 
	
	public static void execute() {
		Coolant._setCoolantStatus(true);

		Spindle.startSpindle('l');
		LogCommands.logCommands("M14");
		UI.refreshLabel();
	}

}
