package commandHandlers.mHandlers;

import commandLogging.LogCommands;
import components.Coolant;
import ui.UI;

/*
 * @author Lisa
 */

public class m08Handler {
	//Kuehlmittel Ein
	
	public static void execute() {
		Coolant._setCoolantStatus(true);
		LogCommands.logCommands("M08");
		UI.refreshLabel();
	}

}
