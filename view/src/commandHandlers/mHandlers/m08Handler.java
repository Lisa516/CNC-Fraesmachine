package commandHandlers.mHandlers;

import application.Coolant;

public class m08Handler {
	//Kuehlmittel Ein
	
	public static void execute() {
		Coolant._setCoolantStatus(true);
	}

}
