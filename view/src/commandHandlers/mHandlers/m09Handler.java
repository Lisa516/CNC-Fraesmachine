package commandHandlers.mHandlers;

import application.Coolant;

public class m09Handler {
	//Kuehlmittel aus
	
	public static void execute() {
		Coolant._setKuehlmittelStatus(false);
	}

}
